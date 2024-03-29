package addsynth.overpoweredmod.items;

import java.text.NumberFormat;
import java.util.List;
import javax.annotation.Nullable;
import addsynth.overpoweredmod.config.MachineValues;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

public final class EnergyCrystalShards extends Item {

  public EnergyCrystalShards(){
    super(new Item.Properties());
  }

  @Override
  public final void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn){
    final String energy = NumberFormat.getIntegerInstance().format(MachineValues.energy_crystal_shards_energy.get());
    tooltip.add(Component.translatable("gui.addsynth_energy.tooltip.energy", energy).withStyle(ChatFormatting.AQUA));
  }

}
