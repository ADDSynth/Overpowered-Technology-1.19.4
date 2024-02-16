package addsynth.material.types.gem;

import addsynth.material.ADDSynthMaterials;
import addsynth.material.blocks.GemBlock;
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

/** This is a standard Gem material. It has a gem item, storage block, ore block, and a gem shard. */
public final class CustomGem extends Gem {

  private final MaterialColor color;
  private final int min_experience;
  private final int max_experience;

  private final RegistryObject<Item> gem;
  private final RegistryObject<Block> block;
  private final RegistryObject<Block> ore;

  public CustomGem(final String name, final MaterialColor color, final int min_experience, final int max_experience){
    super(name);
    this.color = color;
    this.min_experience = min_experience;
    this.max_experience = max_experience;
      gem = RegistryObject.create(new ResourceLocation(ADDSynthMaterials.MOD_ID, name),          ForgeRegistries.ITEMS);
    block = RegistryObject.create(new ResourceLocation(ADDSynthMaterials.MOD_ID, name+"_block"), ForgeRegistries.BLOCKS);
      ore = RegistryObject.create(new ResourceLocation(ADDSynthMaterials.MOD_ID, name+"_ore"),   ForgeRegistries.BLOCKS);
  }
  
  public final void registerBlocks(final IForgeRegistry<Block> registry){
    registry.register(block.getId(), new GemBlock(color));
    registry.register(ore.getId(),   new OreBlock(min_experience, max_experience));
  }
  
  public final void registerItems(final IForgeRegistry<Item> registry){
    registry.register(gem.getId(),   new Item(new Item.Properties()));
    registry.register(block.getId(), new BlockItem(block.get(), new Item.Properties()));
    registry.register(ore.getId(),   new BlockItem(ore.get(), new Item.Properties()));
    registry.register(shard.getId(), new Item(new Item.Properties())); // REMOVE shards
  }

  public final void setCreativeTab(final CreativeModeTab.Output output){
    output.accept(gem.get());
    output.accept(block.get());
    output.accept(ore.get());
    output.accept(shard.get());
  }

  @Override
  public final Item getGem(){
    return gem.get();
  }
  
  public final Block getBlock(){
    return block.get();
  }
  
  @Override
  public final Block getOre(){
    return ore.get();
  }
  
}
