package addsynth.overpoweredmod.machines.crystal_matter_generator;

import addsynth.core.container.TileEntityContainer;
import addsynth.core.container.slots.OutputSlot;
import addsynth.overpoweredmod.registers.Containers;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;

public final class ContainerCrystalGenerator extends TileEntityContainer<TileCrystalMatterGenerator> {

  public ContainerCrystalGenerator(final int id, final Inventory player_inventory, final TileCrystalMatterGenerator tile){
    super(Containers.CRYSTAL_MATTER_GENERATOR.get(), id, player_inventory, tile);
    common_setup(player_inventory);
  }

  public ContainerCrystalGenerator(final int id, final Inventory player_inventory, final FriendlyByteBuf data){
    super(Containers.CRYSTAL_MATTER_GENERATOR.get(), id, player_inventory, data);
    common_setup(player_inventory);
  }

  private final void common_setup(final Inventory player_inventory){
    make_player_inventory(player_inventory, 11, 110);
    int i;
    for(i = 0; i < 8; i++){
      addSlot(new OutputSlot(tile, i, 20 + (i*18), 54));
    }
  }

}
