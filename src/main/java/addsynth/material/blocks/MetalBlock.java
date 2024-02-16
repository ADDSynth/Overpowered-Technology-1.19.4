package addsynth.material.blocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

/** All Metal Blocks will have the same MapColor as Vanilla Iron Block,
 *  unless you specify a color yourself.
 */
public final class MetalBlock extends Block {

  public MetalBlock(){
    this(MaterialColor.METAL);
  }

  public MetalBlock(final MaterialColor color){
    super(Block.Properties.of(Material.METAL, color).strength(5.0f, 6.0f));
  }

}
