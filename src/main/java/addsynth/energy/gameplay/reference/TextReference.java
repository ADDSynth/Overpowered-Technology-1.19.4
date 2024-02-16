package addsynth.energy.gameplay.reference;

import net.minecraft.network.chat.Component;

public final class TextReference {

  // Tooltip Subtitles:
  public static final Component energy_machine     = Component.translatable("gui.addsynth_energy.tooltip.energy_machine");
  public static final Component energy_source      = Component.translatable("gui.addsynth_energy.tooltip.energy_source");
  public static final Component generator_subtitle = Component.translatable("gui.addsynth_energy.tooltip.generator");
  public static final Component battery_subtitle   = Component.translatable("gui.addsynth_energy.tooltip.battery");
  public static final Component class_1_machine    = Component.translatable("gui.addsynth_energy.tooltip.class_1_machine");
  public static final Component class_2_machine    = Component.translatable("gui.addsynth_energy.tooltip.class_2_machine");
  public static final Component class_3_machine    = Component.translatable("gui.addsynth_energy.tooltip.class_3_machine");
  public static final Component class_4_machine    = Component.translatable("gui.addsynth_energy.tooltip.class_4_machine");
  public static final Component class_5_machine    = Component.translatable("gui.addsynth_energy.tooltip.class_5_machine");

  // Interface Modes:
  public static final class transfer_mode {
    public static final Component bi_directional = Component.translatable("gui.addsynth_energy.transfer_mode.bi_directional");
    public static final Component receive        = Component.translatable("gui.addsynth_energy.transfer_mode.receive");
    public static final Component extract        = Component.translatable("gui.addsynth_energy.transfer_mode.extract");
    public static final Component external       = Component.translatable("gui.addsynth_energy.transfer_mode.external");
    public static final Component internal       = Component.translatable("gui.addsynth_energy.transfer_mode.internal");
    public static final Component none           = Component.translatable("gui.addsynth_energy.transfer_mode.no_transfer");
  }

  // Descriptions:
  public static final Component wire_description               = Component.translatable("gui.addsynth_energy.jei_description.wire");
  public static final Component generator_description          = Component.translatable("gui.addsynth_energy.jei_description.generator");
  public static final Component energy_storage_description     = Component.translatable("gui.addsynth_energy.jei_description.energy_storage");
  public static final Component electric_furnace_description   = Component.translatable("gui.addsynth_energy.jei_description.electric_furnace");
  public static final Component compressor_description         = Component.translatable("gui.addsynth_energy.jei_description.compressor");
  public static final Component circuit_fabricator_description = Component.translatable("gui.addsynth_energy.jei_description.circuit_fabricator");
  public static final Component energy_interface_description   = Component.translatable("gui.addsynth_energy.jei_description.universal_energy_interface");
  public static final Component energy_diagnostics_description = Component.translatable("gui.addsynth_energy.jei_description.energy_diagnostics_block");
  public static final Component power_regulator_description    = Component.translatable("gui.addsynth_energy.jei_description.power_regulator");

}
