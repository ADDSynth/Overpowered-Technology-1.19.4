package addsynth.overpoweredmod.machines.laser.machine;

import java.util.List;
import javax.annotation.Nullable;
import addsynth.core.block_network.BlockNetworkUtil;
import addsynth.core.util.game.MinecraftUtility;
import addsynth.core.util.game.tileentity.TileEntityUtil;
import addsynth.energy.lib.blocks.MachineBlock;
import addsynth.overpoweredmod.OverpoweredTechnology;
import addsynth.overpoweredmod.game.reference.TextReference;
import addsynth.overpoweredmod.registers.Tiles;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.network.NetworkHooks;

public final class LaserHousingBlock extends MachineBlock {

  public LaserHousingBlock(){
    super(MaterialColor.SNOW);
  }

  @Override
  public final void appendHoverText(ItemStack stack, @Nullable BlockGetter worldIn, List<Component> tooltip, TooltipFlag flagIn){
    tooltip.add(TextReference.laser_machine);
  }

  @Override
  @Nullable
  public final BlockEntity newBlockEntity(BlockPos position, BlockState blockstate){
    return new TileLaserHousing(position, blockstate);
  }

  @Override
  @Nullable
  public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level world, BlockState blockstate, BlockEntityType<T> type){
    return standardTicker(world, type, Tiles.LASER_MACHINE.get());
  }

  @Override
  @SuppressWarnings("deprecation")
  public final InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand handIn, BlockHitResult hit){
    if(world.isClientSide == false){
      final TileLaserHousing tile = MinecraftUtility.getTileEntity(pos, world, TileLaserHousing.class);
      if(tile != null){
        final LaserNetwork network = tile.getBlockNetwork();
        if(network != null){
          network.updateClient(world);
          NetworkHooks.openScreen((ServerPlayer)player, tile, pos);
        }
        else{
          OverpoweredTechnology.log.error(new NullPointerException("Laser Machine at "+pos.toString()+" has no LaserNetwork!"));
        }
      }
    }
    return InteractionResult.SUCCESS;
  }

  @Override
  public final void onRemove(BlockState state, Level world, BlockPos pos, BlockState newState, boolean isMoving){
    BlockNetworkUtil.onRemove(super::onRemove, TileLaserHousing.class, LaserNetwork::new, state, world, pos, newState, isMoving);
  }

  @Override
  @SuppressWarnings("deprecation")
  public final void neighborChanged(BlockState state, Level world, BlockPos pos, Block blockIn, BlockPos neighbor, boolean isMoving){
    BlockNetworkUtil.neighbor_changed(world, pos, neighbor);
  }

  @Override
  public final void setPlacedBy(Level world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack){
    TileEntityUtil.setOwner(world, placer, pos);
  }

}
