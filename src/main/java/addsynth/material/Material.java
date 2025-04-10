package addsynth.material;

import addsynth.material.reference.Names;
import addsynth.material.types.*;
import addsynth.material.util.MaterialTag;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/**
 *  <p>Please try to avoid using these! You should be using {@link MaterialTag Tags}
 *  as much as possible, especially if you're checking for input.
 * 
 *  <p>These materials are based on their real-world counterparts, and thus will adhere to
 *  certain rules and properties as best as possible.
 */
public final class Material {

  // Vanilla
  public static final class COAL {
    public static final Item  item  = Items.COAL;
    public static final Block block = Blocks.COAL_BLOCK;
    public static final Block ore   = Blocks.COAL_ORE;
  }

  public static final class IRON {
    public static final Item  nugget = Items.IRON_NUGGET;
    public static final Item  ingot  = Items.IRON_INGOT;
    public static final Item  raw    = Items.RAW_IRON;
    public static final Block block  = Blocks.IRON_BLOCK;
    public static final Block ore    = Blocks.IRON_ORE;
    public static final RegistryObject<Item> plate = RegistryObject.create(Names.IRON_PLATE, ForgeRegistries.ITEMS);
  }

  public static final class COPPER {
    public static final Item  ingot = Items.COPPER_INGOT;
    public static final Item  raw   = Items.RAW_COPPER;
    public static final Block block = Blocks.COPPER_BLOCK;
    public static final Block ore   = Blocks.COPPER_ORE;
    public static final RegistryObject<Item> plate = RegistryObject.create(Names.COPPER_PLATE, ForgeRegistries.ITEMS);
  }

  public static final class GOLD {
    public static final Item  nugget = Items.GOLD_NUGGET;
    public static final Item  ingot  = Items.GOLD_INGOT;
    public static final Item  raw    = Items.RAW_GOLD;
    public static final Block block  = Blocks.GOLD_BLOCK;
    public static final Block ore    = Blocks.GOLD_ORE;
    public static final RegistryObject<Item> plate = RegistryObject.create(Names.GOLD_PLATE, ForgeRegistries.ITEMS);
  }

  public static final class LAPIS_LAZULI {
    public static final Item  item  = Items.LAPIS_LAZULI;
    public static final Block block = Blocks.LAPIS_ORE;
    public static final Block ore   = Blocks.LAPIS_ORE;
  }

  public static final class REDSTONE {
    public static final Item  dust  = Items.REDSTONE;
    public static final Block block = Blocks.REDSTONE_BLOCK;
    public static final Block ore   = Blocks.REDSTONE_ORE;
  }

  public static final class DIAMOND {
    public static final Item  gem   = Items.DIAMOND;
    public static final Block block = Blocks.DIAMOND_BLOCK;
    public static final Block ore   = Blocks.DIAMOND_ORE;
  }

  public static final class EMERALD {
    public static final Item  gem   = Items.EMERALD;
    public static final Block block = Blocks.EMERALD_BLOCK;
    public static final Block ore   = Blocks.EMERALD_ORE;
  }

  public static final class QUARTZ {
    public static final Item  gem   = Items.QUARTZ;
    public static final Block block = Blocks.QUARTZ_BLOCK;
    public static final Block ore   = Blocks.NETHER_QUARTZ_ORE;
  }

  public static final class AMETHYST {
    public static final Item   gem = Items.AMETHYST_SHARD;
    public static final Block block = Blocks.AMETHYST_BLOCK;
    public static final RegistryObject<Block> ore = RegistryObject.create(Names.AMETHYST_ORE, ForgeRegistries.BLOCKS);
  }

  // Gems
  // public static final Gem AMBER       = new Gem("amber",       MaterialColor.COLOR_ORANGE);
  public static final Gem CITRINE     = new Gem("citrine",     MaterialColor.COLOR_YELLOW);
  // public static final Gem MALACHITE   = new Gem("malachite",   MaterialColor.DIAMOND);
  // public static final Gem PERIDOT     = new Gem("peridot",     MaterialColor.GRASS);
  public static final Gem RUBY        = new Gem("ruby",        MaterialColor.FIRE);
  public static final Gem SAPPHIRE    = new Gem("sapphire",    MaterialColor.WATER);
  // public static final Gem TANZANITE   = new Gem("tanzanite",   MaterialColor.COLOR_PURPLE);
  public static final Gem TOPAZ       = new Gem("topaz",       MaterialColor.COLOR_ORANGE);
  public static final SimpleMaterial ROSE_QUARTZ = new SimpleMaterial("rose_quartz", MaterialColor.COLOR_PINK, 3, 7);
  
  // MapColor Quartz is slightly darker than Cloth or Snow
  /* Brightness Scale:
    1 SNOW   = new MapColor(8,  16777215);   (White)
    2 CLOTH  = new MapColor(3,  13092807);
    3 METAL  = new MapColor(6,  10987431);
    4 SILVER = new MapColor(22, 10066329);
    5 STONE  = new MapColor(11,  7368816);
    6 GRAY   = new MapColor(21,  5000268);
  */
  
  // Common Metals
  public static final Metal ALUMINUM = new Metal("aluminum", MaterialColor.ICE);
  // public static final CustomMetal LEAD     = new CustomMetal("lead",     MaterialColor.STONE);
  // public static final CustomMetal NICKEL   = new CustomMetal("nickel",   MaterialColor.METAL);
  public static final Metal TIN      = new Metal("tin",      MaterialColor.METAL);
  // public static final CustomMetal ZINC     = new CustomMetal("zinc",     MaterialColor.METAL);

  // Uncommon Metals
  public static final Metal SILVER   = new Metal("silver",   MaterialColor.WOOL);
  // public static final CustomMetal COBALT   = new CustomMetal("cobalt",   MaterialColor.COLOR_BLUE);

  // Rare Metals
  public static final Metal PLATINUM = new Metal("platinum", MaterialColor.ICE);
  public static final Metal TITANIUM = new Metal("titanium", MaterialColor.SNOW);

  // Metal Alloys
  /** Metal alloy of Copper and Zinc. Generally 2 parts Copper, 1 part Zinc.
   *  Used in applications where corrosion resistance and low friction is required, such as door hinges and gears. */
  // public static final ManufacturedMetal BRASS    = new ManufacturedMetal("brass",  MaterialColor.COLOR_YELLOW);

  /** Metal alloy of Tin and Copper. Stronger and more durable than Copper alone. */
  public static final MetalAlloy BRONZE   = new MetalAlloy("bronze", MaterialColor.COLOR_ORANGE);

  /** Metal alloy of Iron and Nickel. Known for its strong resistance to heat expansion.
   *  Has a simplified Nickel:Iron ratio of 3:5 or 1:2. */
  // public static final ManufacturedMetal INVAR    = new ManufacturedMetal("invar",  MaterialColor.SAND);

  // Now that I have the MaterialsCompat.SteelModAbsent() function, I could prevent registering Steel if I wanted to.
  /** An advanced version of Iron. Metal alloy of Iron with a very small amount of Carbon. */
  public static final MetalAlloy STEEL    = new MetalAlloy("steel",  MaterialColor.COLOR_GRAY);
  
  // Other Materials
  public static final SimpleMaterial SILICON   = new SimpleMaterial("silicon",   MaterialColor.COLOR_GRAY, 0, 0);
  // public static final OreMaterial URANIUM   = new OreMaterial("uranium",   MaterialColor.COLOR_LIGHT_GREEN);

}
