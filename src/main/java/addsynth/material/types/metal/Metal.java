package addsynth.material.types.metal;

import javax.annotation.Nullable;
import addsynth.material.ADDSynthMaterials;
import addsynth.material.types.AbstractMaterial;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/** All Metal materials derive from this class.
 *  All Metals have an ingot, storage block, metal plate, and a nugget.
 *  Registering metal plates requires ADDSynth Energy to be loaded. */
public abstract class Metal extends AbstractMaterial {

  protected final RegistryObject<Item> plate;
  // MAYBE dusts?

  public Metal(final String name){
    super(name);
    plate = RegistryObject.create(new ResourceLocation(ADDSynthMaterials.MOD_ID, name+"_plate"), ForgeRegistries.ITEMS);
  }

  public abstract Item getIngot();
  public abstract Block getBlock();

  public final Item getMetalPlate(){
    return plate.get();
  }

  @Nullable
  public abstract Item getNugget();

}
