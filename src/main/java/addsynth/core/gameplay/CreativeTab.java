package addsynth.core.gameplay;

import addsynth.core.ADDSynthCore;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber(modid = ADDSynthCore.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public final class CreativeTab {

  @SubscribeEvent
  public static final void buildContents(CreativeModeTabEvent.Register event){
    event.registerCreativeModeTab(new ResourceLocation(ADDSynthCore.MOD_ID, "creative_tab"), builder -> {
      builder.title(Component.literal(ADDSynthCore.NAME));
      builder.icon(() -> new ItemStack(Item.BY_BLOCK.get(Core.caution_block.get()), 1));
      builder.displayItems((displayParameters, output) -> {
        output.accept(Core.caution_block.get());
        output.accept(Core.music_box.get());
        output.accept(Core.music_sheet.get());
        output.accept(Core.team_manager.get());
        output.accept(Trophy.trophy_base.get());
        output.accept(Trophy.bronze.get());
        output.accept(Trophy.silver.get());
        output.accept(Trophy.gold.get());
        output.accept(Trophy.platinum.get());
      });
    });
  }

}
