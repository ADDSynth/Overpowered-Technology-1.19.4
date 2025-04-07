package addsynth.material.types;

import addsynth.material.ADDSynthMaterials;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryObject;

public final class Metal {

  private final MaterialColor block_color;
  public final RegistryObject<Item>  ingot;
  public final RegistryObject<Block> block;
  public final RegistryObject<Block> ore;
  public final RegistryObject<Item>  plate;
  
  public Metal(final String name, final MaterialColor block_color){
    this.block_color = block_color;
    ingot = RegistryObject.create(new ResourceLocation(ADDSynthMaterials.MOD_ID, name+"_ingot"), ForgeRegistries.ITEMS);
    block = RegistryObject.create(new ResourceLocation(ADDSynthMaterials.MOD_ID, name+"_block"), ForgeRegistries.BLOCKS);
      ore = RegistryObject.create(new ResourceLocation(ADDSynthMaterials.MOD_ID, name+"_ore"), ForgeRegistries.BLOCKS);
    plate = RegistryObject.create(new ResourceLocation(ADDSynthMaterials.MOD_ID, name+"_plate"), ForgeRegistries.ITEMS);
  }

  public final void registerIngot(final IForgeRegistry<Item> registry){
    registry.register(ingot.getId(), new Item(new Item.Properties()));
  }

  public final void registerBlock(final IForgeRegistry<Block> registry){
    registry.register(block.getId(), new Block(BlockBehaviour.Properties.of(Material.METAL, block_color).requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL)));
  }

  public final void registerBlockItem(final IForgeRegistry<Item> registry){
    registry.register(block.getId(), new BlockItem(block.get(), new Item.Properties()));
  }

  public final void registerOre(final IForgeRegistry<Block> registry){
    registry.register(ore.getId(), new Block(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(3.0F, 3.0F)));
  }

  public final void registerOreItem(final IForgeRegistry<Item> registry){
    registry.register(ore.getId(), new BlockItem(ore.get(), new Item.Properties()));
  }

  public final void registerPlate(final IForgeRegistry<Item> registry){
    registry.register(plate.getId(), new Item(new Item.Properties()));
  }

}
