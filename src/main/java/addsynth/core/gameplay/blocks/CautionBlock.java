package addsynth.core.gameplay.blocks;

import addsynth.core.util.constants.Constants;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

public final class CautionBlock extends Block {

  public CautionBlock(){
    super(Block.Properties.of(Material.STONE, MaterialColor.COLOR_YELLOW).sound(SoundType.STONE).strength(2.0f, Constants.block_resistance));
  }

}
