package addsynth.core.gui.widgets.scrollbar;

import addsynth.core.util.color.Color;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;

public final class ItemListEntry extends AbstractListEntry<ItemStack> {

  private ItemStack item;

  public ItemListEntry(int x, int y, int width, int height){
    super(x, y, width, height);
  }

  @Override
  @SuppressWarnings("resource")
  public final void renderWidget(PoseStack matrix, int p_renderButton_1_, int p_renderButton_2_, float p_renderButton_3_){
    Minecraft minecraft = Minecraft.getInstance();
    ItemRenderer itemRenderer = minecraft.getItemRenderer();
    Font fontrenderer = minecraft.font;
    drawListEntryHighlight(matrix);
    if(item != null){
      itemRenderer.renderGuiItem(matrix, item, getX() + 1, getY() + 1);
    }
    drawString(matrix, fontrenderer, getMessage(), getX() + 18, getY() + 5, Color.WHITE.get());
  }

  @Override
  public final void set(final int entry_id, final ItemStack item){
    this.entry_id = entry_id;
    this.item = item;
    setMessage(item != null ? Component.translatable(item.getDescriptionId()) : Component.empty());
  }

  public final void set(final int entry_id, final ItemStack item, final Component message){
    this.entry_id = entry_id;
    this.item = item;
    setMessage(message);
  }

  @Override
  public final void setNull(){
    super.setNull();
    this.item = null;
  }
}
