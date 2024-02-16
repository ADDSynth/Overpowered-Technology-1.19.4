package addsynth.core.gameplay.music_box.gui;

import addsynth.core.gameplay.Config;
import addsynth.core.gameplay.NetworkHandler;
import addsynth.core.gameplay.music_box.TileMusicBox;
import addsynth.core.gameplay.music_box.network_messages.NoteMessage;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.narration.NarrationElementOutput;
import net.minecraft.network.chat.Component;

public final class NoteButton extends AbstractWidget {
  
  public static final String[] note = new String[] {                                "F#3","G3","G#3","A3","A#3","B3",
                                                    "C4","C#4","D4","D#4","E4","F4","F#4","G4","G#4","A4","A#4","B4",
                                                    "C5","C#5","D5","D#5","E5","F5","F#5"};

  private static final int center_x = Math.round((float)GuiMusicBox.note_button_width / 2);
  private static final int text_draw_y = Math.round((float)GuiMusicBox.note_button_height / 2) - 4;

  private final TileMusicBox tile;
  private final byte track;
  private final byte frame;

  public NoteButton(int x_position, int y_position, byte track, byte frame, TileMusicBox tile){
    super(x_position, y_position , GuiMusicBox.note_button_width, GuiMusicBox.note_button_height, Component.literal(note[tile.get_note(frame, track)]));
    this.tile = tile;
    this.track = (byte)track;
    this.frame = (byte)frame;
  }

  @Override
  public void render(PoseStack matrix, int p_render_1_, int p_render_2_, float p_render_3_){
    visible = tile.note_exists(track, frame);
    if(visible){
      setMessage(Component.literal(note[tile.get_note(frame, track)])); // OPTIMIZE: Find everywhere we're setting the widget message each tick, and don't creat new TextComponents, have them already defined as static somewhere.
    }
    super.render(matrix, p_render_1_, p_render_2_, p_render_3_);
  }

  @Override
  public final void renderWidget(PoseStack matrix, final int mouseX, final int mouseY, final float partial){
    final String note = getMessage().getString();
    if(note != null){
      @SuppressWarnings("resource")
      final Minecraft mc = Minecraft.getInstance();
      mc.font.draw(matrix, note, getX() + center_x - (mc.font.width(note) / 2), getY() + text_draw_y, 4210752);
    }
  }

  @Override
  public boolean mouseClicked(double mouse_x, double mouse_y, int button){ // overriden so it doesn't play the button sound?
    if(active){
      if(clicked(mouse_x, mouse_y)){
        boolean flag = false;
        final boolean left_hand = Config.enable_left_hand.get();
        switch(button){
        case 0: // left mouse button
          if(left_hand){
            delete_note();
          }
          else{
            set_note();
          }
          flag = true;
          break;
        case 1: // right mouse button
          if(left_hand){
            set_note();
          }
          else{
            delete_note();
          }
          flag = true;
          break;
        }
        return flag;
      }
    }
    return false;
  }

  @Override
  protected boolean clicked(double mouse_x, double mouse_y){
    final double x = (double)getX();
    final double y = (double)getY();
    return this.active &&
      mouse_x >= x              && mouse_y >= y &&
      mouse_x <  x + this.width && mouse_y <  y + this.height;
  }

  private final void set_note(){
    NetworkHandler.INSTANCE.sendToServer(new NoteMessage(tile.getBlockPos(), frame, track, GuiMusicBox.note_selected, 1.0f));
  }

  private final void delete_note(){
    if(visible == true){
      NetworkHandler.INSTANCE.sendToServer(new NoteMessage(tile.getBlockPos(), frame, track));
    }
  }

  @Override
  public void updateWidgetNarration(NarrationElementOutput p_169152_){
  }

}
