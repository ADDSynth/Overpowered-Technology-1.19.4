package addsynth.material.types;

import addsynth.material.ADDSynthMaterials;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryObject;

public final class SimpleMaterial {

  private final int min_experience;
  private final int max_experience;
  public final RegistryObject<Item> item;
  public final RegistryObject<Block> ore;
  
  public SimpleMaterial(final String name, final MaterialColor block_color, final int min_experience, final int max_experience){
    this.min_experience = min_experience;
    this.max_experience = max_experience;
    item = RegistryObject.create(new ResourceLocation(ADDSynthMaterials.MOD_ID, name), ForgeRegistries.ITEMS);
     ore = RegistryObject.create(new ResourceLocation(ADDSynthMaterials.MOD_ID, name+"_ore"), ForgeRegistries.BLOCKS);
  }

  public final void registerItem(final IForgeRegistry<Item> registry){
    registry.register(item.getId(), new Item(new Item.Properties()));
  }

  public final void registerOre(final IForgeRegistry<Block> registry){
    registry.register(ore.getId(), new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(3.0f, 3.0f), UniformInt.of(min_experience, max_experience)));
  }

  public final void registerOreItem(final IForgeRegistry<Item> registry){
    registry.register(ore.getId(), new BlockItem(ore.get(), new Item.Properties()));
  }

}
