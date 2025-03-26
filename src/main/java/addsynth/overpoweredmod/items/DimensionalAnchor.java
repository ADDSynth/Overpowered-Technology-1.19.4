package addsynth.overpoweredmod.items;

import addsynth.core.compat.Compatibility;
import addsynth.overpoweredmod.OverpoweredTechnology;
import addsynth.overpoweredmod.game.reference.OverpoweredItems;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.EntityTravelToDimensionEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import top.theillusivec4.curios.api.CuriosApi;

@EventBusSubscriber(modid = OverpoweredTechnology.MOD_ID, bus = Bus.FORGE)
public final class DimensionalAnchor extends Item {

  private static final Component anchored_in_this_dimension = Component.translatable("gui.overpowered.anchored_in_this_dimension");

  public DimensionalAnchor(){
    super(new Item.Properties().stacksTo(1));
  }

  public static final boolean player_has_dimensional_anchor(final Player player){
    if(Compatibility.CURIOS.isLoaded()){
      if(CuriosApi.getCuriosHelper().findEquippedCurio(OverpoweredItems.dimensional_anchor.get(), player).isPresent()){
        return true;
      }
    }
    final Inventory inventory = player.getInventory();
    return inventory.contains(new ItemStack(OverpoweredItems.dimensional_anchor.get()));
  }

  /* Known dimensions:
  Vanilla: Overworld, The Nether, The End
  Overpowered Technology: The Unknown Dimension
  Galacticraft: Moon, Mars, Asteroids, Venus
  Applied Energistics: Inside a Spatial Storage Drive
  */

  @SubscribeEvent
  public static final void onEntityChangingDimension(final EntityTravelToDimensionEvent event){
    final Entity entity = event.getEntity();
    if(entity instanceof ServerPlayer){
      final ServerPlayer player = (ServerPlayer)entity;
      if(player_has_dimensional_anchor(player)){
        // TODO: should probably check for Galacticraft planets here, and allow the Player to travel to them,
        //       since player travels to that dimension via a Rocket ship.
        event.setCanceled(true);
        player.displayClientMessage(anchored_in_this_dimension, true);
      }
    }
    else if(entity instanceof ItemEntity){
      final ItemEntity item_entity = (ItemEntity)entity;
      final Item item = item_entity.getItem().getItem();
      if(item instanceof DimensionalAnchor){
        event.setCanceled(true);
      }
    }
  }

}
