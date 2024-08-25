package addsynth.energy.gameplay.machines.universal_energy_interface;

import net.minecraft.network.chat.Component;

public enum TRANSFER_MODE {

  BI_DIRECTIONAL(true,  true,  "gui.addsynth_energy.transfer_mode.bi_directional"),
  RECEIVE(       true,  false, "gui.addsynth_energy.transfer_mode.receive"),
  EXTRACT(       false, true,  "gui.addsynth_energy.transfer_mode.extract"),
  // TODO: reimplement TRANSFER_MODE External and Internal?
  // EXTERNAL(      true,  true,  false, "gui.addsynth_energy.transfer_mode.external"),
  // INTERNAL(      false, false, true,  "gui.addsynth_energy.transfer_mode.internal"),
  NO_TRANSFER(   false, false, "gui.addsynth_energy.transfer_mode.no_transfer");
  
  /** Allow external machines to give Energy to us. */
  public final boolean canReceive;
  /** Allow external machines to extract Energy from us. */
  public final boolean canExtract;

  public final Component title;

  private TRANSFER_MODE(final boolean receive, final boolean extract, final String translation_key){
    this.canReceive = receive;
    this.canExtract = extract;
    this.title = Component.translatable(translation_key);
  }
  
}
