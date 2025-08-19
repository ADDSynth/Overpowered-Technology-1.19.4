package addsynth.overpoweredmod.blocks;

import addsynth.overpoweredmod.machines.data_cable.DataCable;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

public final class IronFrameBlock extends Block {

  public IronFrameBlock(){
    super(Block.Properties.of(Material.METAL, MaterialColor.WOOL).strength(0.5f, 6.0f));
    DataCable.addAttachableBlock(this);
  }

}
