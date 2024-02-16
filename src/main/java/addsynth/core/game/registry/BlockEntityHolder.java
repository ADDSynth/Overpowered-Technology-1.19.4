package addsynth.core.game.registry;

import addsynth.core.ADDSynthCore;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryObject;

public class BlockEntityHolder <T extends BlockEntity> {

  private final ResourceLocation name;
  private final RegistryObject<BlockEntityType<T>> holder;
  private final BlockEntityType.BlockEntitySupplier<T> constructor;
  private final RegistryObject<Block> block;

  public BlockEntityHolder(ResourceLocation name, BlockEntityType.BlockEntitySupplier<T> constructor){
    this(name, constructor, null);
  }

  /** Default constructor. */
  public BlockEntityHolder(ResourceLocation name, BlockEntityType.BlockEntitySupplier<T> constructor, RegistryObject<Block> block){
    this.name = name;
    this.holder = RegistryObject.create(name, ForgeRegistries.BLOCK_ENTITY_TYPES);
    this.constructor = constructor;
    this.block = block;
  }

  public final BlockEntityType<T> get(){
    return holder.get();
  }

  public final void register(final IForgeRegistry<BlockEntityType> registry){
    if(block != null){
      registry.register(name, BlockEntityType.Builder.of(constructor, block.get()).build(null));
      return;
    }
    ADDSynthCore.log.error(
      new NullPointerException("Failed to register TileEntity Type because you did not add a RegistryObject<Block> "+
      "block holder to the "+BlockEntityHolder.class.getSimpleName()+" constructor. If you intend to apply this "+
      "TileEntity Type to more than one block, then use the other register function.")
    );
  }

  public final void register(final IForgeRegistry<BlockEntityType> registry, final Block ... blocks){
    registry.register(name, BlockEntityType.Builder.of(constructor, blocks).build(null));
  }

}
