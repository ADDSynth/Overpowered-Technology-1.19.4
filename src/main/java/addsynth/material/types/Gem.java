package addsynth.material.types;

import addsynth.material.ADDSynthMaterials;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryObject;

public final class Gem {

  private final MaterialColor block_color;
  public final RegistryObject<Item>  shard;
  public final RegistryObject<Item>  gem;
  public final RegistryObject<Block> block;
  public final RegistryObject<Block> ore;
  
  public Gem(final String name, final MaterialColor block_color){
    this.block_color = block_color;
    shard = RegistryObject.create(new ResourceLocation(ADDSynthMaterials.MOD_ID, name+"_shard"), ForgeRegistries.ITEMS);
      gem = RegistryObject.create(new ResourceLocation(ADDSynthMaterials.MOD_ID, name), ForgeRegistries.ITEMS);
    block = RegistryObject.create(new ResourceLocation(ADDSynthMaterials.MOD_ID, name+"_block"), ForgeRegistries.BLOCKS);
      ore = RegistryObject.create(new ResourceLocation(ADDSynthMaterials.MOD_ID, name+"_ore"), ForgeRegistries.BLOCKS);
  }

  public final void registerShard(final IForgeRegistry<Item> registry){
    registry.register(shard.getId(), new Item(new Item.Properties()));
  }

  public final void registerGem(final IForgeRegistry<Item> registry){
    registry.register(gem.getId(), new Item(new Item.Properties()));
  }

  public final void registerBlock(final IForgeRegistry<Block> registry){
    registry.register(block.getId(), new Block(BlockBehaviour.Properties.of(Material.METAL, block_color).requiresCorrectToolForDrops().strength(5.0f, 6.0f).sound(SoundType.METAL)));
  }

  public final void registerBlockItem(final IForgeRegistry<Item> registry){
    registry.register(block.getId(), new BlockItem(block.get(), new Item.Properties()));
  }

  public final void registerOre(final IForgeRegistry<Block> registry){
    registry.register(ore.getId(), getOreBlock());
  }

  public final void registerOreItem(final IForgeRegistry<Item> registry){
    registry.register(ore.getId(), new BlockItem(ore.get(), new Item.Properties()));
  }

  public static final Block getOreBlock(){
    return new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(3.0f, 3.0f), UniformInt.of(3, 7));
  }

}
