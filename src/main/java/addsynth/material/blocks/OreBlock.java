package addsynth.material.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;

public class OreBlock extends Block {

  private final int min_experience;
  private final int max_experience;

  /**
   * Use this constructor if this Ore Block should be mined and smelted in a Furnace. The Furnace gives experience to the player.
   */
  public OreBlock(){
    this(0, 0);
  }

  /**
   * Use this constructor if this Ore Block drops an item, such as Coal, Diamond, Lapis, Redstone, or Quartz.
   * @param min_experience
   * @param max_experience
   */
  public OreBlock(int min_experience, int max_experience){
    super(Block.Properties.of(Material.STONE).strength(3.0f, 6.0f).requiresCorrectToolForDrops());
    // https://minecraft.gamepedia.com/Breaking#Blocks_by_hardness
    this.min_experience = min_experience;
    this.max_experience = max_experience;
  }

  @Override
  public final int getExpDrop(BlockState state, LevelReader level, RandomSource randomSource, BlockPos pos, int fortuneLevel, int silkTouchLevel){
    return silkTouchLevel == 0 ? randomSource.nextIntBetweenInclusive(min_experience, max_experience) : 0;
  }

}
