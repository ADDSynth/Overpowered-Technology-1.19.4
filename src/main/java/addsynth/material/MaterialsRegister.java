package addsynth.material;

import addsynth.material.compat.recipe.BronzeModAbsentCondition;
import addsynth.material.compat.recipe.SteelModAbsentCondition;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
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
      Material.AMETHYST.registerBlocks(registry);
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

}
