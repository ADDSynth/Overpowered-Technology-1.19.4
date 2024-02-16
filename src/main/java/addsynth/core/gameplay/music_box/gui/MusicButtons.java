package addsynth.core.gameplay.music_box.gui;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import addsynth.core.gameplay.NetworkHandler;
import addsynth.core.gameplay.music_box.TileMusicBox;
import addsynth.core.gameplay.music_box.network_messages.ChangeInstrumentMessage;
import addsynth.core.gameplay.music_box.network_messages.MusicBoxMessage;
import addsynth.core.gameplay.reference.GuiReference;
import addsynth.core.gui.widgets.WidgetUtil;
import addsynth.core.gui.widgets.buttons.AdjustableButton;
import addsynth.core.util.java.StringUtil;
import net.minecraft.client.gui.components.AbstractButton;
import net.minecraft.client.gui.narration.NarrationElementOutput;
import net.minecraft.client.sounds.SoundManager;
import net.minecraft.network.chat.Component;

public final class MusicButtons {

  private static final int instrument_texture_size = 64;

  public static final class PlayButton extends AdjustableButton {

    private final TileMusicBox tile;

    public PlayButton(int x, int y, int width, TileMusicBox tile){
      super(x, y, width, 14, StringUtil.translate("gui.addsynthcore.music_box.play"));
      this.tile = tile;
    }

    @Override
    public void onPress(){
      NetworkHandler.INSTANCE.sendToServer(new MusicBoxMessage(tile.getBlockPos(),TileMusicBox.Command.PLAY));
    }
    
    @Override
    public final void playDownSound(final SoundManager p_playDownSound_1_){
    }
  
  }

  public static final class TempoButton extends AdjustableButton {

    private final boolean direction;
    private final TileMusicBox tile;

    public TempoButton(int xIn, int yIn, int widthIn, int heightIn, boolean direction, TileMusicBox tile){
      super(xIn, yIn, widthIn, heightIn, direction ? "<" : ">");
      this.direction = direction;
      this.tile = tile;
    }

    @Override
    public void onPress(){
      NetworkHandler.INSTANCE.sendToServer(new MusicBoxMessage(tile.getBlockPos(),TileMusicBox.Command.CHANGE_TEMPO,direction ? 0 : 1));
    }
  }

  public static final class NextDirectionButton extends AdjustableButton {

    private final TileMusicBox tile;
    private final String[] face = new String[] {
      StringUtil.translate("gui.addsynthcore.direction.down"),
      StringUtil.translate("gui.addsynthcore.direction.up"),
      StringUtil.translate("gui.addsynthcore.direction.north"),
      StringUtil.translate("gui.addsynthcore.direction.south"),
      StringUtil.translate("gui.addsynthcore.direction.west"),
      StringUtil.translate("gui.addsynthcore.direction.east")
    };
  
    public NextDirectionButton(int xIn, int yIn, int widthIn, TileMusicBox tile){
      super(xIn, yIn, widthIn, 14);
      this.tile = tile;
    }

    @Override
    public void renderWidget(PoseStack matrix, int p_renderButton_1_, int p_renderButton_2_, float p_renderButton_3_){
      setMessage(Component.literal(face[tile.get_next_direction()])); // stays up-to-date MAYBE need to simplify this now, should not create things every frame
      super.renderWidget(matrix, p_renderButton_1_, p_renderButton_2_, p_renderButton_3_);
    }

    @Override
    public void onPress(){
      NetworkHandler.INSTANCE.sendToServer(new MusicBoxMessage(tile.getBlockPos(),TileMusicBox.Command.CYCLE_NEXT_DIRECTION));
    }
  }

  public static final class MuteButton extends AbstractButton {
  
    private static final int button_size = 12;
    private static final int texture_size = 24;
    private static final int texture_x = 64;
    private static final int texture_y = 32;
  
    private final TileMusicBox tile;
    private boolean mute;
    private final byte track;

    public MuteButton(final int x, final int y, final byte track, final TileMusicBox tile){
      super(x, y, button_size, button_size, Component.empty());
      this.tile = tile;
      this.track = track;
    }
  
    @Override
    public final void renderWidget(PoseStack matrix, final int mouseX, final int mouseY, final float partial_ticks){
      mute = tile.get_mute(track);
      WidgetUtil.common_button_render_setup(GuiReference.widgets);
      blit(matrix, getX(), getY(), button_size, button_size, mute ? texture_x + texture_size : texture_x, texture_y, texture_size, texture_size, 256, 256);
    }
  
    @Override
    public void onPress(){
      NetworkHandler.INSTANCE.sendToServer(new MusicBoxMessage(tile.getBlockPos(),TileMusicBox.Command.TOGGLE_MUTE,track));
    }
  
    @Override
    public final void playDownSound(final SoundManager p_playDownSound_1_){
    }
  
    @Override
    public void updateWidgetNarration(NarrationElementOutput p_169152_){
    }
  
  }

  public static final class TrackInstrumentButton extends AbstractButton {

    private static final int button_size = 12;

    private final TileMusicBox tile;
    private final byte track;

    public TrackInstrumentButton(final int x, final int y, final byte track, final TileMusicBox tile){
      super(x, y, button_size, button_size, Component.empty());
      this.track = track;
      this.tile = tile;
    }

    @Override
    public final void renderWidget(PoseStack matrix, final int mouse_x, final int mouse_y, final float partial_ticks){
      final int instrument = tile.get_track_instrument(track);
      final int texture_x = instrument_texture_size * (instrument % 4);
      final int texture_y = instrument_texture_size * (instrument / 4);
    
      RenderSystem.setShaderTexture(0, GuiReference.instruments);
      RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);

      RenderSystem.enableBlend();
      RenderSystem.defaultBlendFunc();
      RenderSystem.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);

      blit(matrix, getX(), getY(), button_size, button_size, texture_x, texture_y, instrument_texture_size, instrument_texture_size, 256, 256);
    }
  
    @Override
    public void onPress(){
      NetworkHandler.INSTANCE.sendToServer(new ChangeInstrumentMessage(tile.getBlockPos(), track, GuiMusicBox.instrument_selected));
    }

    @Override
    public final void playDownSound(final SoundManager p_playDownSound_1_){
    }

    @Override
    public void updateWidgetNarration(NarrationElementOutput p_169152_){
    }
  
  }

  public static final class SelectInstrumentButton extends AbstractButton {
  
    private static final int button_size = 16;

    private final int instrument;
    private final int texture_x;
    private final int texture_y;

    public SelectInstrumentButton(final int x, final int y, final int instrument){
      super(x, y, button_size, button_size, Component.empty());
      this.instrument = instrument;
      texture_x = instrument_texture_size * (instrument % 4);
      texture_y = instrument_texture_size * (instrument / 4);
    }
  
    @Override
    public final void renderWidget(PoseStack matrix, final int mouse_x, final int mouse_y, final float partial_ticks){
      RenderSystem.setShaderTexture(0, GuiReference.instruments);
      RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);

      RenderSystem.enableBlend();
      RenderSystem.defaultBlendFunc();
      RenderSystem.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);

      blit(matrix, getX(), getY(), button_size, button_size, texture_x, texture_y, instrument_texture_size, instrument_texture_size, 256, 256);
    }
  
    @Override
    public void onPress(){
      GuiMusicBox.instrument_selected = (byte)instrument;
    }

    @Override
    public final void playDownSound(final SoundManager p_playDownSound_1_){
    }

    @Override
    public void updateWidgetNarration(NarrationElementOutput p_169152_){
    }
  
  }

  public static final class SwapTrackButton extends AbstractButton {

    private static final int button_width  = 20;
    private static final int button_height = 12;
    private static final int texture_x = 112;
    private static final int texture_y =  80;
    private static final int texture_width  = 40;
    private static final int texture_height = 24;
    private final TileMusicBox tile;
    private final int track;

    public SwapTrackButton(final int x, final int y, final TileMusicBox tile, final int track){
      super(x, y, button_width, button_height, Component.empty());
      this.tile = tile;
      this.track = track;
    }
    
    @Override
    public final void renderWidget(PoseStack matrix, final int mouse_x, final int mouse_y, final float partial_ticks){
      WidgetUtil.renderButton(matrix, this, GuiReference.widgets, texture_x, isHovered ? texture_y + texture_height : texture_y, button_width, button_height, texture_width, texture_height);
    }
    
    @Override
    public void onPress(){
      NetworkHandler.INSTANCE.sendToServer(new MusicBoxMessage(tile.getBlockPos(), TileMusicBox.Command.SWAP_TRACK, track));
    }
    
    @Override
    public void updateWidgetNarration(NarrationElementOutput p_169152_){
    }
  
  }

}
