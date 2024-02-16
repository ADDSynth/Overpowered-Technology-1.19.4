package addsynth.material.types.gem;

import addsynth.material.ADDSynthMaterials;
import addsynth.material.blocks.OreBlock;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryObject;

/** Use this class for Gem materials that don't have a storage block
 *  or gem shard, but they do have a gem item and an ore block. */
public final class SimpleGem extends Gem {

  private final MaterialColor color;
  private final int min_experience;
  private final int max_experience;

  private final RegistryObject<Item> gem;
  private final RegistryObject<Block> ore;

  public SimpleGem(final String name, final MaterialColor color, final int min_experience, final int max_experience){
    super(name);
    this.color = color;
    this.min_experience = min_experience;
    this.max_experience = max_experience;
    gem = RegistryObject.create(new ResourceLocation(ADDSynthMaterials.MOD_ID, name),        ForgeRegistries.ITEMS);
    ore = RegistryObject.create(new ResourceLocation(ADDSynthMaterials.MOD_ID, name+"_ore"), ForgeRegistries.BLOCKS);
  }
  
  public final void registerBlocks(final IForgeRegistry<Block> registry){
    registry.register(ore.getId(), new OreBlock(min_experience, max_experience));
  }
  
  public final void registerItems(final IForgeRegistry<Item> registry){
    registry.register(gem.getId(), new Item(new Item.Properties()));
    registry.register(ore.getId(), new BlockItem(ore.get(), new Item.Properties()));
  }

  public final void setCreativeTab(final CreativeModeTab.Output output){
    output.accept(gem.get());
    output.accept(ore.get());
  }

  @Override
  public final Item getGem(){
    return gem.get();
  }
  
  @Override
  public final Block getOre(){
    return ore.get();
  }

}
