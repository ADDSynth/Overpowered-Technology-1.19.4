package addsynth.material.types.gem;

import addsynth.material.types.OreMaterial;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.IForgeRegistry;

/** This encapsulates a Vanilla Gem material. Vanilla gems are Diamond,
 *  Emerald, Lapis Lazuli, Nether Quartz, and Amethyst. */
public final class VanillaGem extends Gem implements OreMaterial {

  public final Item gem;
  public final Block block;
  public final Block ore;

  public VanillaGem(final String name, final Item gem, final Block block, final Block ore){
    super(name);
    this.gem = gem;
    this.block = block;
    this.ore = ore;
  }

  public final void registerItems(final IForgeRegistry<Item> registry){
    registry.register(shard.getId(), new Item(new Item.Properties()));
  }

  public final void setCreativeTab(final CreativeModeTab.Output output){
    output.accept(shard.get());
  }

  @Override
  public final Item getGem(){
    return gem;
  }
  
  public final Block getBlock(){
    return block;
  }
  
  @Override
  public final Block getOre(){
    return ore;
  }
  
}
