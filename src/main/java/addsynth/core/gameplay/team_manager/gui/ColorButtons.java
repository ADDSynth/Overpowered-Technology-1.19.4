package addsynth.core.gameplay.team_manager.gui;

import java.util.function.Consumer;
import addsynth.core.gameplay.reference.GuiReference;
import addsynth.core.gui.widgets.WidgetUtil;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.components.AbstractButton;
import net.minecraft.client.gui.narration.NarrationElementOutput;
import net.minecraft.network.chat.Component;

public final class ColorButtons extends AbstractButton {

  public static final int button_gui_size = 16;
  private static final int gui_width = button_gui_size * 8;
  public static final int gui_height = button_gui_size * 2;
  
  private static final int button_texture_size = 24;
  // private static final int texture_width  = button_texture_size * 8;
  // private static final int texture_height = button_texture_size * 2;

  private int color = -1;

  private int render_x;
  private int render_y;
  private int i;
  private int j;
  private int gui_x;
  private int gui_y;
  private int texture_x;
  private int texture_y;

  private final Consumer<Integer> responder;

  public ColorButtons(final int x_position, final int y_position){
    super(x_position, y_position, gui_width, gui_height, Component.empty());
    responder = null;
  }

  public ColorButtons(final int x_position, final int y_position, final Consumer<Integer> responder){
    super(x_position, y_position, gui_width, gui_height, Component.empty());
    this.responder = responder;
  }

  @Override
  public void renderWidget(PoseStack matrix, int p_renderButton_1_, int p_renderButton_2_, float p_renderButton_3_){
    WidgetUtil.common_button_render_setup(GuiReference.color_buttons);
    render_x = color % 8;
    render_y = color / 8;
    for(j = 0; j < 2; j++){
      for(i = 0; i < 8; i++){
        gui_x     = getX() + (i * button_gui_size);
        gui_y     = getY() + (j * button_gui_size);
        texture_x =          (i * button_texture_size);
        texture_y =          (j * button_texture_size);
        if(validColor()){
          texture_y += (i == render_x && j == render_y ? button_texture_size*2 : 0);
        }
        blit(matrix, gui_x, gui_y, button_gui_size, button_gui_size, texture_x, texture_y, button_texture_size, button_texture_size, 256, 256);
      }
    }
  }

  @Override
  public void onClick(double mouse_x, double mouse_y){
    color = WidgetUtil.getMouseInsideCell(getX(), getY(), (int)mouse_x, (int)mouse_y, button_gui_size, 8, 2);
  }

  @Override
  public void onPress(){
    if(responder != null){
      responder.accept(getColor());
    }
  }

  public final boolean validColor(){
    return color >= 0 && color < 16;
  }

  public final int getColor(){
    // White color in the top-left should be color 0, however the colors listed in
    // net.minecraft.util.text.TextFormatting are listed in reverse order.
    return validColor() ? 15 - color : -1;
  }
  
  public final void setColor(int color){
    this.color = (color >= 0 && color < 16) ? 15 - color : -1;
  }

  @Override
  protected void updateWidgetNarration(NarrationElementOutput p_259858_){
  }

}
