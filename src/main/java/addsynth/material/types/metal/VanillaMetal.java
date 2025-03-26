package addsynth.material.types.metal;

import addsynth.core.compat.Compatibility;
import addsynth.material.types.OreMaterial;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.IForgeRegistry;

/** This encapsulates a vanilla Metal. Vanilla metals are Iron, Gold, and Copper. */
public final class VanillaMetal extends Metal implements OreMaterial {

  public final Item  ingot;
  public final Block block;
  public final Block ore;
  public final Item  nugget;

  public VanillaMetal(final String name, final Item ingot, final Block block, final Block ore, final Item nugget){
    super(name);
    this.ingot  = ingot;
    this.block  = block;
    this.ore    = ore;
    this.nugget = nugget;
  }

  public final void registerItems(final IForgeRegistry<Item> registry){
    registry.register(plate.getId(), new Item(new Item.Properties()));
  }

  public final void setCreativeTab(final CreativeModeTab.Output output){
    if(Compatibility.ADDSYNTH_ENERGY.isLoaded()){
      output.accept(plate.get());
    }
  }

  @Override
  public final Item getIngot(){
    return ingot;
  }
  
  @Override
  public final Block getBlock(){
    return block;
  }

  @Override
  public final Block getOre(){
    return ore;
  }
  
  @Override
  public final Item getNugget(){
    return nugget;
  }

}
