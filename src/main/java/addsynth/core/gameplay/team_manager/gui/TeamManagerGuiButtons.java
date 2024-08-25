package addsynth.core.gameplay.team_manager.gui;

import addsynth.core.gameplay.NetworkHandler;
import addsynth.core.gameplay.reference.GuiReference;
import addsynth.core.gameplay.team_manager.network_messages.TeamManagerCommand;
import addsynth.core.gui.widgets.WidgetUtil;
import addsynth.core.gui.widgets.buttons.AdjustableButton;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.AbstractButton;
import net.minecraft.client.gui.narration.NarrationElementOutput;
import net.minecraft.network.chat.Component;

public final class TeamManagerGuiButtons {

  private static final Component add            = Component.translatable("gui.addsynthcore.team_manager.common.add");
  private static final Component edit           = Component.translatable("gui.addsynthcore.team_manager.common.edit");
  private static final Component delete         = Component.translatable("gui.addsynthcore.team_manager.common.delete");
  private static final Component done           = Component.translatable("gui.addsynthcore.team_manager.common.done");
  private static final Component cancel         = Component.translatable("gui.addsynthcore.team_manager.common.cancel");
  private static final Component add_score      = Component.translatable("gui.addsynthcore.team_manager.score.add");
  private static final Component subtract_score = Component.translatable("gui.addsynthcore.team_manager.score.subtract");
  private static final Component set_score      = Component.translatable("gui.addsynthcore.team_manager.score.set");
  private static final Component reset          = Component.translatable("gui.addsynthcore.team_manager.score.reset");
  private static final Component assign         = Component.translatable("gui.addsynthcore.team_manager.display_slot.assign");
  private static final Component clear          = Component.translatable("gui.addsynthcore.team_manager.display_slot.clear");

  private static final Minecraft minecraft = Minecraft.getInstance(); // TEST: probably not a good idea
  public final static int player_button_size = 20;
  public final static int display_slot_button_width = 50;
  public final static int display_slot_button_height = 14;

  public static final class AddTeamButton extends AdjustableButton {
    public AddTeamButton(int x, int y, int width, int height){
      super(x, y, width, height, add);
    }
    @Override
    public void onPress(){
      minecraft.setScreen(new TeamManagerTeamEditGui(true));
    }
  }

  public static final class EditTeamButton extends AdjustableButton {
    public EditTeamButton(int x, int y, int width, int height){
      super(x, y, width, height, edit);
    }
    @Override
    public void onPress(){
      minecraft.setScreen(new TeamManagerTeamEditGui(false));
    }
  }

  public static final class DeleteTeamButton extends AdjustableButton {
    public DeleteTeamButton(int x, int y, int width, int height){
      super(x, y, width, height, delete);
    }
    @Override
    public void onPress(){
      NetworkHandler.INSTANCE.sendToServer(new TeamManagerCommand.DeleteTeam(TeamManagerGui.getTeamSelected()));
      TeamManagerGui.unSelectTeam();
    }
  }

  public static final class MovePlayerToTeamButton extends AbstractButton {

    private final int texture_x = 20;
    private final int texture_y = 184;

    public MovePlayerToTeamButton(int xIn, int yIn){
      super(xIn, yIn, player_button_size, player_button_size, Component.empty());
    }

    @Override
    public final void renderWidget(PoseStack matrix, int mouse_x, int mouse_y, float partial_ticks){
      WidgetUtil.renderButton(matrix, this, GuiReference.widgets, texture_x, isHovered ? texture_y + player_button_size : texture_y, player_button_size, player_button_size);
    }

    @Override
    public final void onPress(){
      NetworkHandler.INSTANCE.sendToServer(new TeamManagerCommand.AddPlayerToTeam(TeamManagerGui.getPlayerSelected(), TeamManagerGui.getTeamSelected()));
    }

    @Override
    public void updateWidgetNarration(NarrationElementOutput p_169152_){
    }
  
  }
  
  public static final class RemovePlayerFromTeamButton extends AbstractButton {

    private final int texture_x = 0;
    private final int texture_y = 184;

    public RemovePlayerFromTeamButton(int xIn, int yIn){
      super(xIn, yIn, player_button_size, player_button_size, Component.empty());
    }

    @Override
    public final void renderWidget(PoseStack matrix, int mouse_x, int mouse_y, float partial_ticks){
      WidgetUtil.renderButton(matrix, this, GuiReference.widgets, texture_x, isHovered ? texture_y + player_button_size : texture_y, player_button_size, player_button_size);
    }

    @Override
    public final void onPress(){
      NetworkHandler.INSTANCE.sendToServer(new TeamManagerCommand.RemovePlayerFromTeam(TeamManagerGui.getPlayerSelected(), TeamManagerGui.getTeamSelected()));
    }

    @Override
    public void updateWidgetNarration(NarrationElementOutput p_169152_){
    }
  
  }

  public static final class AddObjectiveButton extends AdjustableButton {
    public AddObjectiveButton(int x, int y, int width, int height){
      super(x, y, width, height, add);
    }
    @Override
    public void onPress(){
      minecraft.setScreen(new TeamManagerObjectiveGui(true));
    }
  }

  public static final class EditObjectiveButton extends AdjustableButton {
    public EditObjectiveButton(int x, int y, int width, int height){
      super(x, y, width, height, edit);
    }
    @Override
    public void onPress(){
      minecraft.setScreen(new TeamManagerObjectiveGui(false));
    }
  }

  public static final class DeleteObjectiveButton extends AdjustableButton {
    public DeleteObjectiveButton(int x, int y, int width, int height){
      super(x, y, width, height, delete);
    }
    @Override
    public void onPress(){
      NetworkHandler.INSTANCE.sendToServer(new TeamManagerCommand.DeleteObjective(TeamManagerGui.getObjectiveSelected()));
      TeamManagerGui.unSelectObjective();
    }
  }

  public static final class FinishButton extends AdjustableButton {

    private final Runnable onClick;

    public FinishButton(int x, int y, int width, int height, Runnable onClick){
      super(x, y, width, height, done);
      this.onClick = onClick;
    }

    @Override
    public void onPress(){
      onClick.run();
      minecraft.setScreen(new TeamManagerGui());
    }
  }

  public static final class CancelButton extends AdjustableButton {

    public CancelButton(int x, int y, int width, int height){
      super(x, y, width, height, cancel);
    }

    @Override
    public void onPress(){
      minecraft.setScreen(new TeamManagerGui());
    }
  }

  public static final class SubtractScoreButton extends AdjustableButton {
  
    private final Runnable onClick;
    
    public SubtractScoreButton(int x, int y, int width, int height, Runnable onClick){
      super(x, y, width, height, subtract_score);
      this.onClick = onClick;
    }
    @Override
    public void onPress(){
      onClick.run();
    }
  }

  public static final class AddScoreButton extends AdjustableButton {
  
    private final Runnable onClick;
    
    public AddScoreButton(int x, int y, int width, int height, Runnable onClick){
      super(x, y, width, height, add_score);
      this.onClick = onClick;
    }
    @Override
    public void onPress(){
      onClick.run();
    }
  }

  public static final class SetScoreButton extends AdjustableButton {
  
    private final Runnable onClick;
    
    public SetScoreButton(int x, int y, int width, int height, Runnable onClick){
      super(x, y, width, height, set_score);
      this.onClick = onClick;
    }
    @Override
    public void onPress(){
      onClick.run();
    }
  }

  public static final class ResetScoreButton extends AdjustableButton {
  
    public ResetScoreButton(int x, int y, int width, int height){
      super(x, y, width, height, reset);
    }
    @Override
    public void onPress(){
      NetworkHandler.INSTANCE.sendToServer(
        new TeamManagerCommand.ResetScore(
          TeamManagerGui.getObjectiveSelected(),
          TeamManagerGui.getPlayerSelected()
        )
      );
    }
  }
  
  public static final class SetDisplaySlotButton extends AdjustableButton {
  
    private final int display_slot;
  
    public SetDisplaySlotButton(int x, int y, int display_slot){
      super(x, y, display_slot_button_width, display_slot_button_height, assign);
      this.display_slot = display_slot;
    }
    @Override
    public void onPress(){
      NetworkHandler.INSTANCE.sendToServer(new TeamManagerCommand.SetDisplaySlot(TeamManagerGui.getObjectiveSelected(), display_slot));
    }
  }
  
  public static final class ClearDisplaySlotButton extends AdjustableButton {
  
    private final int display_slot;
  
    public ClearDisplaySlotButton(int x, int y, int display_slot){
      super(x, y, display_slot_button_width, display_slot_button_height, clear);
      this.display_slot = display_slot;
    }
    @Override
    public void onPress(){
      NetworkHandler.INSTANCE.sendToServer(new TeamManagerCommand.ClearDisplaySlot(display_slot));
    }
  }

}
