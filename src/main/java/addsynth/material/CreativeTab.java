package addsynth.material;

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
      builder.icon(() -> new ItemStack(Material.SAPPHIRE.getGem()));
      builder.displayItems((displayParameters, output) -> {
        // Gems
        Material.RUBY.setCreativeTab(output);
        Material.TOPAZ.setCreativeTab(output);
        Material.CITRINE.setCreativeTab(output);
        Material.EMERALD.setCreativeTab(output);
        Material.DIAMOND.setCreativeTab(output);
        Material.SAPPHIRE.setCreativeTab(output);
        Material.AMETHYST.setCreativeTab(output);
        Material.QUARTZ.setCreativeTab(output);
        Material.ROSE_QUARTZ.setCreativeTab(output);
        // Metals
        Material.IRON.setCreativeTab(output);
        Material.GOLD.setCreativeTab(output);
        Material.COPPER.setCreativeTab(output);
        Material.TIN.setCreativeTab(output);
        Material.ALUMINUM.setCreativeTab(output);
        Material.SILVER.setCreativeTab(output);
        Material.PLATINUM.setCreativeTab(output);
        Material.TITANIUM.setCreativeTab(output);
        Material.STEEL.setCreativeTab(output);
        Material.BRONZE.setCreativeTab(output);
        // Other
        Material.SILICON.setCreativeTab(output);
      });
    });
  }

}
