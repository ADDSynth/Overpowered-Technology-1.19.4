package addsynth.material.types.basic;

import addsynth.material.ADDSynthMaterials;
import addsynth.material.blocks.OreBlock;
import addsynth.material.types.AbstractMaterial;
import addsynth.material.types.OreMaterial;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryObject;

/** This is a material that just has an item and an ore block. No storage block. */
public final class SimpleOreMaterial extends AbstractMaterial implements OreMaterial {

  private final MaterialColor color;
  private final int min_experience;
  private final int max_experience;

  private final RegistryObject<Item> item;
  private final RegistryObject<Block> ore;
  
  public SimpleOreMaterial(final String name, final MaterialColor color){
    this(name, color, 0, 0);
  }
  
  public SimpleOreMaterial(final String name, final MaterialColor color, final int min_experience, final int max_experience){
    super(name);
    this.color = color;
     item = RegistryObject.create(new ResourceLocation(ADDSynthMaterials.MOD_ID, name),       ForgeRegistries.ITEMS);
      ore = RegistryObject.create(new ResourceLocation(ADDSynthMaterials.MOD_ID, name+"_ore"), ForgeRegistries.BLOCKS);
    this.min_experience = min_experience;
    this.max_experience = max_experience;
  }
  
  public final void registerBlocks(final IForgeRegistry<Block> registry){
    registry.register(ore.getId(), new OreBlock(min_experience, max_experience));
  }
  
  public final void registerItems(final IForgeRegistry<Item> registry){
    registry.register(item.getId(), new Item(new Item.Properties()));
    registry.register(ore.getId(),  new BlockItem(ore.get(), new Item.Properties()));
  }

  public final void setCreativeTab(final CreativeModeTab.Output output){
    output.accept(item.get());
    output.accept(ore.get());
  }

  public final Item getItem(){
    return item.get();
  }
  
  @Override
  public final Block getOre(){
    return ore.get();
  }

}
