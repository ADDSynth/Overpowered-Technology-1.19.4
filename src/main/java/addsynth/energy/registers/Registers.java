package addsynth.energy.registers;

import addsynth.core.game.registry.BlockItemHolder;
import addsynth.core.game.registry.RegistryUtil;
import addsynth.energy.ADDSynthEnergy;
import addsynth.energy.gameplay.EnergyBlocks;
import addsynth.energy.gameplay.machines.circuit_fabricator.CircuitFabricatorBlock;
import addsynth.energy.gameplay.machines.circuit_fabricator.CircuitFabricatorContainer;
import addsynth.energy.gameplay.machines.circuit_fabricator.recipe.CircuitFabricatorRecipeSerializer;
import addsynth.energy.gameplay.machines.compressor.CompressorBlock;
import addsynth.energy.gameplay.machines.compressor.ContainerCompressor;
import addsynth.energy.gameplay.machines.compressor.recipe.CompressorRecipeSerializer;
import addsynth.energy.gameplay.machines.electric_furnace.ContainerElectricFurnace;
import addsynth.energy.gameplay.machines.electric_furnace.ElectricFurnaceBlock;
import addsynth.energy.gameplay.machines.energy_diagnostics.EnergyDiagnosticsBlock;
import addsynth.energy.gameplay.machines.energy_storage.ContainerEnergyStorage;
import addsynth.energy.gameplay.machines.energy_storage.EnergyStorageBlock;
import addsynth.energy.gameplay.machines.energy_wire.EnergyWire;
import addsynth.energy.gameplay.machines.generator.ContainerGenerator;
import addsynth.energy.gameplay.machines.generator.GeneratorBlock;
import addsynth.energy.gameplay.machines.universal_energy_interface.ContainerUniversalEnergyInterface;
import addsynth.energy.gameplay.machines.universal_energy_interface.UniversalEnergyInterfaceBlock;
import addsynth.energy.gameplay.reference.Names;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegisterEvent;

@EventBusSubscriber(modid = ADDSynthEnergy.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public final class Registers {

  @SubscribeEvent
  public static final void register(final RegisterEvent event){
    final ResourceKey key = event.getRegistryKey();
    if(key.equals(ForgeRegistries.Keys.BLOCKS)){
      final IForgeRegistry<Block> registry = event.getForgeRegistry();
      registry.register(Names.ENERGY_WIRE,                new EnergyWire());
      registry.register(Names.GENERATOR,                  new GeneratorBlock());
      registry.register(Names.ENERGY_STORAGE,             new EnergyStorageBlock());
      registry.register(Names.COMPRESSOR,                 new CompressorBlock());
      registry.register(Names.ELECTRIC_FURNACE,           new ElectricFurnaceBlock());
      registry.register(Names.CIRCUIT_FABRICATOR,         new CircuitFabricatorBlock());
      registry.register(Names.UNIVERSAL_ENERGY_INTERFACE, new UniversalEnergyInterfaceBlock());
      registry.register(Names.ENERGY_DIAGNOSTICS_BLOCK,   new EnergyDiagnosticsBlock());
    }
    if(key.equals(ForgeRegistries.Keys.ITEMS)){
      final IForgeRegistry<Item> registry = event.getForgeRegistry();
      BlockItemHolder.register(registry, EnergyBlocks.wire);
      BlockItemHolder.register(registry, EnergyBlocks.generator);
      BlockItemHolder.register(registry, EnergyBlocks.energy_storage);
      BlockItemHolder.register(registry, EnergyBlocks.compressor);
      BlockItemHolder.register(registry, EnergyBlocks.electric_furnace);
      BlockItemHolder.register(registry, EnergyBlocks.circuit_fabricator);
      BlockItemHolder.register(registry, EnergyBlocks.universal_energy_machine);
      BlockItemHolder.register(registry, EnergyBlocks.energy_diagnostics_block);
      
      registry.register(Names.POWER_CORE,          new Item(new Item.Properties()));
      registry.register(Names.ADVANCED_POWER_CORE, new Item(new Item.Properties()));
      registry.register(Names.POWER_REGULATOR,     new Item(new Item.Properties()));
      registry.register(Names.CIRCUIT_TIER_1,      new Item(new Item.Properties()));
      registry.register(Names.CIRCUIT_TIER_2,      new Item(new Item.Properties()));
      registry.register(Names.CIRCUIT_TIER_3,      new Item(new Item.Properties()));
      registry.register(Names.CIRCUIT_TIER_4,      new Item(new Item.Properties()));
      registry.register(Names.CIRCUIT_TIER_5,      new Item(new Item.Properties()));
      registry.register(Names.CIRCUIT_TIER_6,      new Item(new Item.Properties()));
      registry.register(Names.CIRCUIT_TIER_7,      new Item(new Item.Properties()));
      registry.register(Names.CIRCUIT_TIER_8,      new Item(new Item.Properties()));
      registry.register(Names.CIRCUIT_TIER_9,      new Item(new Item.Properties()));
    }
    if(key.equals(ForgeRegistries.Keys.BLOCK_ENTITY_TYPES)){
      final IForgeRegistry<BlockEntityType> registry = event.getForgeRegistry();
      Tiles.ENERGY_WIRE.register(registry);
      Tiles.GENERATOR.register(registry);
      Tiles.ENERGY_CONTAINER.register(registry);
      Tiles.COMPRESSOR.register(registry);
      Tiles.ELECTRIC_FURNACE.register(registry);
      Tiles.CIRCUIT_FABRICATOR.register(registry);
      Tiles.UNIVERSAL_ENERGY_INTERFACE.register(registry);
      Tiles.ENERGY_DIAGNOSTICS_BLOCK.register(registry);
    }
    if(key.equals(ForgeRegistries.Keys.MENU_TYPES)){
      final IForgeRegistry<MenuType> registry = event.getForgeRegistry();
      registry.register(Names.GENERATOR,                  IForgeMenuType.create(ContainerGenerator::new));
      registry.register(Names.ENERGY_STORAGE,             IForgeMenuType.create(ContainerEnergyStorage::new));
      registry.register(Names.COMPRESSOR,                 IForgeMenuType.create(ContainerCompressor::new));
      registry.register(Names.ELECTRIC_FURNACE,           IForgeMenuType.create(ContainerElectricFurnace::new));
      registry.register(Names.CIRCUIT_FABRICATOR,         IForgeMenuType.create(CircuitFabricatorContainer::new));
      registry.register(Names.UNIVERSAL_ENERGY_INTERFACE, IForgeMenuType.create(ContainerUniversalEnergyInterface::new));
    }
    if(key.equals(ForgeRegistries.Keys.RECIPE_TYPES)){
      final IForgeRegistry<RecipeType<?>> registry = event.getForgeRegistry();
      RegistryUtil.registerRecipeType(registry, Names.CIRCUIT_FABRICATOR);
      RegistryUtil.registerRecipeType(registry, Names.COMPRESSOR);
    }
    if(key.equals(ForgeRegistries.Keys.RECIPE_SERIALIZERS)){
      final IForgeRegistry<RecipeSerializer> registry = event.getForgeRegistry();
      registry.register(Names.COMPRESSOR,         new CompressorRecipeSerializer());
      registry.register(Names.CIRCUIT_FABRICATOR, new CircuitFabricatorRecipeSerializer());
    }
  }

}
