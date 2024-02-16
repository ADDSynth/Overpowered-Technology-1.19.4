package addsynth.material.types.metal;

import addsynth.core.compat.Compatibility;
import addsynth.material.ADDSynthMaterials;
import addsynth.material.blocks.MetalBlock;
import addsynth.material.blocks.OreBlock;
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

/** This is a standard metal material. These metals have an ingot,
 *  storage block, ore block, metal plate, and a nugget. */
public final class CustomMetal extends Metal implements OreMaterial {

  private final MaterialColor color;
  
  private final RegistryObject<Item>  ingot;
  private final RegistryObject<Block> block;
  private final RegistryObject<Block> ore;
  private final RegistryObject<Item>  nugget;
  
  public CustomMetal(final String name, final MaterialColor color){
    super(name);
    this.color = color;
     ingot = RegistryObject.create(new ResourceLocation(ADDSynthMaterials.MOD_ID, name+"_ingot"),  ForgeRegistries.ITEMS);
     block = RegistryObject.create(new ResourceLocation(ADDSynthMaterials.MOD_ID, name+"_block"),  ForgeRegistries.BLOCKS);
       ore = RegistryObject.create(new ResourceLocation(ADDSynthMaterials.MOD_ID, name+"_ore"),    ForgeRegistries.BLOCKS);
    nugget = RegistryObject.create(new ResourceLocation(ADDSynthMaterials.MOD_ID, name+"_nugget"), ForgeRegistries.ITEMS);
  }
  
  public final void registerBlocks(final IForgeRegistry<Block> registry){
    registry.register(block.getId(), new MetalBlock(color));
    registry.register(ore.getId(),   new OreBlock());
  }
  
  public final void registerItems(final IForgeRegistry<Item> registry){
    registry.register(ingot.getId(), new Item(new Item.Properties()));
    registry.register(block.getId(), new BlockItem(block.get(), new Item.Properties()));
    registry.register(ore.getId(),   new BlockItem(ore.get(),   new Item.Properties()));
    registry.register(plate.getId(), new Item(new Item.Properties()));
  }

  public final void setCreativeTab(final CreativeModeTab.Output output){
    output.accept(ingot.get());
    output.accept(block.get());
    output.accept(ore.get());
    if(Compatibility.ADDSYNTH_ENERGY.loaded){
      output.accept(plate.get());
    }
  }

  @Override
  public final Item getIngot(){
    return ingot.get();
  }
  
  @Override
  public final Block getBlock(){
    return block.get();
  }
  
  @Override
  public final Block getOre(){
    return ore.get();
  }
  
  @Override
  public final Item getNugget(){
    return null;
  }

}
