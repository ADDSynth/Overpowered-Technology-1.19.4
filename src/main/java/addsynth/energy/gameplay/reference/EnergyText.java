package addsynth.energy.gameplay.reference;

import net.minecraft.network.chat.Component;

/** The TextReference class should only be used for common words
 *  or commonly used text that can be used in multiple projects.
 *  Text that is only used in one place, should be defined there.
 *  
 *  Also, keep in mind that just because a word has multiple
 *  meanings in my language, does not mean it has the same meanings
 *  in other languages. */
public final class EnergyText {

  public static final Component null_energy_reference = Component.literal("[Error: Null Energy Reference]");

  // Common
  public static final Component energy_text           = Component.translatable("gui.addsynth_energy.common.energy");
  public static final Component energy_usage_text     = Component.translatable("gui.addsynth_energy.common.energy_usage");
  public static final Component tick_text             = Component.translatable("gui.addsynth_energy.common.tick");
  public static final Component efficiency_text       = Component.translatable("gui.addsynth_energy.common.efficiency");
  public static final Component max_extract_text      = Component.translatable("gui.addsynth_energy.common.max_extract");
  public static final Component extraction_text       = Component.translatable("gui.addsynth_energy.common.extraction");
  public static final Component status_text           = Component.translatable("gui.addsynth_energy.common.status");
  public static final Component time_left_text        = Component.translatable("gui.addsynth_energy.common.time_remaining");
  public static final Component charge_remaining_text = Component.translatable("gui.addsynth_energy.common.charge_time_remaining");
  public static final Component full_charge_time_text = Component.translatable("gui.addsynth_energy.common.time_to_full_charge");
  public static final Component no_energy_change_text = Component.translatable("gui.addsynth_energy.common.no_energy_change");
  public static final Component energy_stored_text    = Component.translatable("gui.addsynth_energy.common.energy_stored");
  public static final Component input_text            = Component.translatable("gui.addsynth_energy.generator.input");
  public static final Component mode_text             = Component.translatable("gui.addsynth_energy.common.mode");

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

  // Machines
  public static final Component selected_text = Component.translatable("gui.addsynth_energy.common.selected");
  public static final Component total         = Component.translatable("gui.addsynth_energy.common.total");

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
