package addsynth.core.gameplay.reference;

import addsynth.core.gameplay.Core;
import addsynth.core.util.command.PermissionLevel;
import net.minecraft.network.chat.Component;

public final class TextReference {

  // Team Manager
  public static final Component team_manager  = Component.translatable(Core.team_manager.get().getDescriptionId());
  public static final Component objective_gui = Component.translatable("gui.addsynthcore.team_manager.objective_edit.gui_title");
  public static final Component team_gui      = Component.translatable("gui.addsynthcore.team_manager.team_edit.gui_title");
  public static final Component you_dont_have_permission = Component.translatable("gui.addsynthcore.team_manager.message.you_do_not_have_permission", PermissionLevel.COMMANDS);

  // public static final TranslatableComponent music_box = new TranslatableComponent(Core.music_box.getDescriptionId());

  // a lot of commands also take in string arguments. I decided to leave them all alone.

  // Music Sheet:
  public static final Component music_sheet_clear    = Component.translatable("gui.addsynthcore.music_sheet.clear");
  public static final Component music_sheet_paste    = Component.translatable("gui.addsynthcore.music_sheet.paste");
  public static final Component music_sheet_copy     = Component.translatable("gui.addsynthcore.music_sheet.copy");
  public static final Component music_sheet_no_data  = Component.translatable("gui.addsynthcore.music_sheet.no_data");
  public static final Component music_sheet_has_data = Component.translatable("gui.addsynthcore.music_sheet.has_data");
  
  // Descriptions:
  public static final Component    music_box_description = Component.translatable("gui.addsynthcore.jei_description.music_box");
  public static final Component  music_sheet_description = Component.translatable("gui.addsynthcore.jei_description.music_sheet");
  public static final Component team_manager_description = Component.translatable("gui.addsynthcore.jei_description.team_manager");

  // also missing the TileEntity encountered an error message in TileEntityUtil, but it's because that also uses arguments.

}
