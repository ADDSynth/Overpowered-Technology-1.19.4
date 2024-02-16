package addsynth.energy.gameplay;

import addsynth.energy.ADDSynthEnergy;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber(modid = ADDSynthEnergy.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public final class CreativeTab {

  @SubscribeEvent
  public static final void buildContents(CreativeModeTabEvent.Register event){
    event.registerCreativeModeTab(new ResourceLocation(ADDSynthEnergy.MOD_ID, "creative_tab"), builder -> {
      builder.title(Component.literal(ADDSynthEnergy.MOD_NAME));
      builder.icon(() -> new ItemStack(Item.BY_BLOCK.get(EnergyBlocks.wire.get())));
      builder.displayItems((displayParameters, output) -> {
        output.accept(EnergyBlocks.wire.get());
        output.accept(EnergyBlocks.generator.get());
        output.accept(EnergyBlocks.energy_storage.get());
        output.accept(EnergyBlocks.compressor.get());
        output.accept(EnergyBlocks.electric_furnace.get());
        output.accept(EnergyBlocks.circuit_fabricator.get());
        output.accept(EnergyBlocks.universal_energy_machine.get());
        output.accept(EnergyBlocks.energy_diagnostics_block.get());
        output.accept(EnergyItems.power_core.get());
        output.accept(EnergyItems.advanced_power_core.get());
        output.accept(EnergyItems.power_regulator.get());
        output.accept(EnergyItems.circuit_tier_1.get());
        output.accept(EnergyItems.circuit_tier_2.get());
        output.accept(EnergyItems.circuit_tier_3.get());
        output.accept(EnergyItems.circuit_tier_4.get());
        output.accept(EnergyItems.circuit_tier_5.get());
        output.accept(EnergyItems.circuit_tier_6.get());
        output.accept(EnergyItems.circuit_tier_7.get());
        output.accept(EnergyItems.circuit_tier_8.get());
        output.accept(EnergyItems.circuit_tier_9.get());
      });
    });
  }

}
