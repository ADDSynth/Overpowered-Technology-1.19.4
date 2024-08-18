package addsynth.material;

import java.util.List;
import addsynth.material.blocks.OreBlock;
import addsynth.material.compat.recipe.BronzeModAbsentCondition;
import addsynth.material.compat.recipe.SteelModAbsentCondition;
import addsynth.material.reference.MaterialBlocks;
import addsynth.material.reference.Names;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ForgeRegistries.Keys;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.MissingMappingsEvent;
import net.minecraftforge.registries.MissingMappingsEvent.Mapping;
import net.minecraftforge.registries.RegisterEvent;

@EventBusSubscriber(modid = ADDSynthMaterials.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public final class MaterialsRegister {

  @SubscribeEvent
  public static final void register(final RegisterEvent event){
    final ResourceKey key = event.getRegistryKey();
    if(key.equals(ForgeRegistries.Keys.BLOCKS)){
      final IForgeRegistry<Block> registry = event.getForgeRegistry();
      
      // gems
      Material.RUBY.registerBlocks(registry);
      Material.TOPAZ.registerBlocks(registry);
      Material.CITRINE.registerBlocks(registry);
      Material.SAPPHIRE.registerBlocks(registry);
      registry.register(Names.AMETHYST_ORE, new OreBlock(3, 7));
      Material.ROSE_QUARTZ.registerBlocks(registry);
      
      // metals
      Material.TIN.registerBlocks(registry);
      Material.ALUMINUM.registerBlocks(registry);
      Material.STEEL.registerBlocks(registry);
      Material.BRONZE.registerBlocks(registry);
      Material.SILVER.registerBlocks(registry);
      Material.PLATINUM.registerBlocks(registry);
      Material.TITANIUM.registerBlocks(registry);
      
      // other materials
      Material.SILICON.registerBlocks(registry);
    }
    if(key.equals(ForgeRegistries.Keys.ITEMS)){
      final IForgeRegistry<Item> registry = event.getForgeRegistry();
  
      // gems
      Material.RUBY.registerItems(registry);
      Material.TOPAZ.registerItems(registry);
      Material.CITRINE.registerItems(registry);
      Material.EMERALD.registerItems(registry);
      Material.DIAMOND.registerItems(registry);
      Material.SAPPHIRE.registerItems(registry);
      registry.register(Names.AMETHYST_ORE, new BlockItem(MaterialBlocks.amethyst_ore.get(), new Item.Properties()));
      Material.AMETHYST.registerItems(registry);
      Material.QUARTZ.registerItems(registry);
      Material.ROSE_QUARTZ.registerItems(registry);
  
      // vanilla metals
      Material.IRON.registerItems(registry);
      Material.GOLD.registerItems(registry);
      Material.COPPER.registerItems(registry);
  
      // metals
      Material.TIN.registerItems(registry);
      Material.ALUMINUM.registerItems(registry);
      Material.SILVER.registerItems(registry);
      Material.PLATINUM.registerItems(registry);
      Material.TITANIUM.registerItems(registry);
  
      // manufactured metals
      Material.STEEL.registerItems(registry); // Now that I have the MaterialsCompat.SteelModAbsent() function, I could prevent registering Steel if I wanted to.
      Material.BRONZE.registerItems(registry);
      
      // other material items
      Material.SILICON.registerItems(registry);
    }
    if(key.equals(ForgeRegistries.Keys.RECIPE_SERIALIZERS)){
      CraftingHelper.register(SteelModAbsentCondition.Serializer.INSTANCE);
      CraftingHelper.register(BronzeModAbsentCondition.Serializer.INSTANCE);
    }
  }

  public static final void onMissingEntries(MissingMappingsEvent event){
    // handle blocks
    final List<Mapping<Block>> missing_blocks = event.getMappings(Keys.BLOCKS, ADDSynthMaterials.MOD_ID);
    for(Mapping<Block> map : missing_blocks){
      if(map.getKey().equals(Names.AMETHYST_BLOCK_LEGACY)){
        map.remap(Blocks.AMETHYST_BLOCK);
      }
    }
    
    // handle items
    final List<Mapping<Item>> missing_items = event.getMappings(Keys.ITEMS, ADDSynthMaterials.MOD_ID);
    for(Mapping<Item> map : missing_items){
      if(map.getKey().equals(Names.AMETHYST_BLOCK_LEGACY)){
        map.remap(Items.AMETHYST_BLOCK);
      }
      if(map.getKey().equals(Names.AMETHYST_LEGACY)){
        map.remap(Items.AMETHYST_SHARD);
      }
    }
  }

}
