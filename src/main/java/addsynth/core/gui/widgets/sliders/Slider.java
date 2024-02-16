package addsynth.core.gui.widgets.sliders;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.narration.NarrationElementOutput;
import net.minecraft.network.chat.Component;

/** 
 *  Using sliders, there will be a button click sound. To solve this, override the onMouseClicked() method,
 *  loop through all the objects in buttonList, get the GuiButton objects, then check if they are an instance
 *  of this Slider class. otherwise call this.actionPerformed() method.
 */
public abstract class Slider extends AbstractWidget {

  private final int min_value;
  private final int max_value;
  private final int default_value;
  private final int current_value;
  protected final int steps;
  
  // private static final int draw_x;
  // private static final int draw_y;

  public Slider(int x, int y, int width, int height, int min_value, int max_value, int default_value){
    super(x, y, width, height, Component.empty());
    this.min_value = min_value;
    this.max_value = max_value;
    this.default_value = default_value;
    this.current_value = default_value;
    this.steps = Math.min(max_value - min_value, this.height);
  }

  @Override
  public void renderWidget(PoseStack matrix, int mouse_x, int mouse_y, float partial_ticks){
  }

  @Override
  protected void onDrag(double p_onDrag_1_, double p_onDrag_3_, double p_onDrag_5_, double p_onDrag_7_){
  }

  public final int get_value(){
    return current_value;
  }

  @Override
  public void updateWidgetNarration(NarrationElementOutput p_169152_){
  }

}
