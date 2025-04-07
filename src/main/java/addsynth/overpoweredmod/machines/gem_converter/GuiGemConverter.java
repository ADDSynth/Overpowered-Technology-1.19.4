package addsynth.overpoweredmod.machines.gem_converter;

import addsynth.core.gui.util.GuiUtil;
import addsynth.core.gui.widgets.buttons.ButtonUtil;
import addsynth.energy.lib.gui.GuiEnergyBase;
import addsynth.energy.lib.gui.widgets.WorkProgressBar;
import addsynth.overpoweredmod.config.Config;
import addsynth.overpoweredmod.game.NetworkHandler;
import addsynth.overpoweredmod.game.core.Gems;
import addsynth.overpoweredmod.game.reference.GuiReference;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ItemStack;

public final class GuiGemConverter extends GuiEnergyBase<TileGemConverter, ContainerGemConverter> {

  private int gem_index;
  private ItemStack gem;

  private static final int left_button_x = 57;
  private static final int cycle_button_y = 64;
  private static final int cycle_button_buffer = 3;
  private static final int render_item_x = left_button_x + ButtonUtil.width + cycle_button_buffer;
  private static final int right_button_x = render_item_x + 16 + cycle_button_buffer;
  
  private final WorkProgressBar work_progress_bar = new WorkProgressBar(43, 89, 122, 5, 40, 199);
  
  public GuiGemConverter(final ContainerGemConverter container, final Inventory player_inventory, final Component title){
    super(176, 194, container, player_inventory, title, GuiReference.gem_converter);
  }

  @Override
  protected final void init(){
    super.init();
    gem_index = tile.get_gem_selected();
    gem = Gems.getGem(gem_index);
    addRenderableWidget(ButtonUtil.getLeftArrowButton(this.leftPos + left_button_x, this.topPos + cycle_button_y,
      () -> NetworkHandler.INSTANCE.sendToServer(new CycleGemConverterMessage(tile.getBlockPos(), false))
    ));
    addRenderableWidget(ButtonUtil.getRightArrowButton(this.leftPos + right_button_x, this.topPos + cycle_button_y,
      () -> NetworkHandler.INSTANCE.sendToServer(new CycleGemConverterMessage(tile.getBlockPos(), true))
    ));
  }

  @Override
  protected final void renderBg(PoseStack matrix, final float partialTicks, final int mouseX, final int mouseY){
    draw_background_texture(matrix);
    work_progress_bar.draw(matrix, this, tile);
    if(tile.get_gem_selected() != gem_index){
      gem_index = tile.get_gem_selected();
      gem = Gems.getGem(gem_index);
    }
    itemRenderer.renderGuiItem(matrix, gem, this.leftPos + render_item_x, this.topPos + cycle_button_y);
  }

  @Override
  protected final void renderLabels(PoseStack matrix, final int mouseX, final int mouseY){
    draw_title(matrix);
    draw_energy_usage(matrix);
    draw_status(matrix, tile.getStatus());
    
    final ItemStack s1 = tile.getWorkingInventory().getStackInSlot(0);
    if(Config.blend_working_item.get()){
      final ItemStack s2 = Gems.getGem(tile.getConvertingStack());
      GuiUtil.blendItemStacks(itemRenderer, matrix, s1, s2, 76, 45, work_progress_bar.getWorkTime());
    }
    else{
      itemRenderer.renderGuiItem(matrix, s1, 76, 45);
    }
    
    draw_text_center(matrix, work_progress_bar.getWorkTimeProgress(), 25, 88);
    draw_time_left(matrix, 99);
  }

}
