package addsynth.overpoweredmod.machines.black_hole;

import addsynth.overpoweredmod.game.reference.OverpoweredBlocks;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;

public final class BlackHoleItem extends BlockItem {

  private static final Component black_hole_not_allowed = Component.translatable("gui.overpowered.black_hole.not_allowed_in_this_dimension");

  public BlackHoleItem(){
    super(OverpoweredBlocks.black_hole.get(), new Item.Properties().rarity(Rarity.EPIC));
  }

  @Override
  @SuppressWarnings("resource")
  public final InteractionResult place(final BlockPlaceContext context){
    final Level world = context.getLevel();
    if(TileBlackHole.is_black_hole_allowed(world)){
      return super.place(context);
    }
    if(world.isClientSide == false){
      final Player player = context.getPlayer();
      if(player != null){
        player.displayClientMessage(black_hole_not_allowed, true);
      }
    }
    return InteractionResult.FAIL;
  }

}
