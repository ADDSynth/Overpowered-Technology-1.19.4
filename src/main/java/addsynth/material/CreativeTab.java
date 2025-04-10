package addsynth.material;

import addsynth.core.compat.Compatibility;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber(modid = ADDSynthMaterials.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public final class CreativeTab {

  @SubscribeEvent
  public static final void buildContents(CreativeModeTabEvent.Register event){
    event.registerCreativeModeTab(new ResourceLocation(ADDSynthMaterials.MOD_ID, "creative_tab"), builder -> {
      builder.title(Component.literal(ADDSynthMaterials.MOD_NAME));
      builder.icon(() -> new ItemStack(Material.SAPPHIRE.gem.get()));
      builder.displayItems((displayParameters, output) -> {
        // ingots
        output.accept(Material.IRON.ingot);
        output.accept(Material.COPPER.ingot);
        output.accept(Material.GOLD.ingot);
        output.accept(Material.TIN.ingot.get());
        output.accept(Material.ALUMINUM.ingot.get());
        output.accept(Material.SILVER.ingot.get());
        output.accept(Material.PLATINUM.ingot.get());
        output.accept(Material.TITANIUM.ingot.get());
        output.accept(Material.STEEL.ingot.get());
        output.accept(Material.BRONZE.ingot.get());
        // metal blocks
        output.accept(Material.IRON.block);
        output.accept(Material.COPPER.block);
        output.accept(Material.GOLD.block);
        output.accept(Material.TIN.block.get());
        output.accept(Material.ALUMINUM.block.get());
        output.accept(Material.SILVER.block.get());
        output.accept(Material.PLATINUM.block.get());
        output.accept(Material.TITANIUM.block.get());
        output.accept(Material.STEEL.block.get());
        output.accept(Material.BRONZE.block.get());
        // metal ores
        output.accept(Material.TIN.ore.get());
        output.accept(Material.ALUMINUM.ore.get());
        output.accept(Material.SILVER.ore.get());
        output.accept(Material.PLATINUM.ore.get());
        output.accept(Material.TITANIUM.ore.get());
        // metal plates
        if(Compatibility.ADDSYNTH_ENERGY.isLoaded()){
          output.accept(Material.IRON.plate.get());
          output.accept(Material.COPPER.plate.get());
          output.accept(Material.GOLD.plate.get());
          output.accept(Material.TIN.plate.get());
          output.accept(Material.ALUMINUM.plate.get());
          output.accept(Material.SILVER.plate.get());
          output.accept(Material.PLATINUM.plate.get());
          output.accept(Material.TITANIUM.plate.get());
          output.accept(Material.STEEL.plate.get());
          output.accept(Material.BRONZE.plate.get());
        }
        // gems
        output.accept(Material.RUBY.gem.get());
        output.accept(Material.TOPAZ.gem.get());
        output.accept(Material.CITRINE.gem.get());
        output.accept(Material.EMERALD.gem);
        output.accept(Material.DIAMOND.gem);
        output.accept(Material.SAPPHIRE.gem.get());
        output.accept(Material.AMETHYST.gem);
        output.accept(Material.QUARTZ.gem);
        // gem blocks
        output.accept(Material.RUBY.block.get());
        output.accept(Material.TOPAZ.block.get());
        output.accept(Material.CITRINE.block.get());
        output.accept(Material.EMERALD.block);
        output.accept(Material.DIAMOND.block);
        output.accept(Material.SAPPHIRE.block.get());
        output.accept(Material.AMETHYST.block);
        output.accept(Material.QUARTZ.block);
        // gem ores
        output.accept(Material.RUBY.ore.get());
        output.accept(Material.TOPAZ.ore.get());
        output.accept(Material.CITRINE.ore.get());
        output.accept(Material.SAPPHIRE.ore.get());
        output.accept(Material.AMETHYST.ore.get());
        // other materials
        output.accept(Material.SILICON.item.get());
        output.accept(Material.SILICON.ore.get());
        output.accept(Material.ROSE_QUARTZ.item.get());
        output.accept(Material.ROSE_QUARTZ.ore.get());
      });
    });
  }

}
