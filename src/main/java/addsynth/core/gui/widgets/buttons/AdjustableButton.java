package addsynth.core.gui.widgets.buttons;

import javax.annotation.Nonnull;
import addsynth.core.ADDSynthCore;
import addsynth.core.util.java.StringUtil;
import net.minecraft.client.gui.components.AbstractButton;
import net.minecraft.client.gui.narration.NarrationElementOutput;
import net.minecraft.network.chat.Component;

/** Hey! This has a maximum height of 20! So setting it any higher will have no effect. */
@Deprecated
public abstract class AdjustableButton extends AbstractButton {

  private static final int max_width = 200;
  private static final int max_height = 20;

  /**
   * This constructor passes an empty string to the button. Only use this if you intend to
   * change the button text on a per-frame basis, such as responding to changes to a TileEntity.
   * @param x
   * @param y
   * @param width
   * @param height
   */
  public AdjustableButton(int x, int y, int width, int height){
    super(x, y, width, Math.min(height, max_height), Component.empty());
    if(height > max_height){
      ADDSynthCore.log.warn(StringUtil.build("Cannot set height of ", AdjustableButton.class.getSimpleName(), " higher than ", max_height, "."));
    }
  }

  /**
   * Only use this constructor if the button text remains static.
   * @param x
   * @param y
   * @param width
   * @param height
   * @param buttonText
   */
  public AdjustableButton(int x, int y, int width, int height, @Nonnull String buttonText){
    super(x, y, width, Math.min(height, max_height), Component.literal(buttonText));
    if(height > max_height){
      ADDSynthCore.log.warn(StringUtil.build("Cannot set height of ", AdjustableButton.class.getSimpleName(), " higher than ", max_height, "."));
    }
  }

  @Override
  public void updateWidgetNarration(NarrationElementOutput p_169152_){
  }

}
