package addsynth.overpoweredmod.assets;

import addsynth.overpoweredmod.OverpoweredTechnology;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageType;
import net.minecraftforge.registries.RegistryObject;

public final class DamageTypes {

  // public static final ResourceKey<DamageType> LASER = ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation(OverpoweredTechnology.MOD_ID, "laser"));
  public static final RegistryObject<DamageType> LASER = RegistryObject.create(new ResourceLocation(OverpoweredTechnology.MOD_ID, "laser"), Registries.DAMAGE_TYPE, OverpoweredTechnology.MOD_ID);

}
