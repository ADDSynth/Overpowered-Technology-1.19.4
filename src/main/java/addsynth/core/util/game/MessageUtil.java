package addsynth.core.util.game;

import javax.annotation.Nonnull;
import addsynth.core.ADDSynthCore;
import addsynth.core.util.player.PlayerUtil;
import net.minecraft.locale.Language;
import net.minecraft.network.chat.Component;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.players.PlayerList;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.server.command.TextComponentHelper;

public final class MessageUtil {

  /** Sends a SYSTEM type message to the player.<br>
   *  This must be called on the server side. Calling on the client side will only translate to English.
   * @param player
   * @param translation_key
   */
  public static final void send_to_player(final Player player, final String translation_key, final Object ... arguments){
    @SuppressWarnings("resource")
    final MinecraftServer server = player.getServer();
    if(server != null){
      send_to_player(server, player, translation_key, arguments);
    }
  }

  /** Sends a SYSTEM type message to the player.<br>
   *  This must be called on the server side. Calling on the client side will only translate to English.
   * @param player
   * @param translation_key
   */ // TODO: Should all of these be sent FROM the server side? Replace the parameters with their server counterparts.
  public static final void send_to_player(@Nonnull MinecraftServer server, Player player, String translation_key, Object ... arguments){
    if(Language.getInstance().has(translation_key) == false){
      ADDSynthCore.log.warn("Missing translated text for: "+translation_key);
    }
    player.sendSystemMessage(TextComponentHelper.createComponentTranslation(server, translation_key, arguments));
  }

  /** Sends a SYSTEM type message to the player.<br>
   *  It's okay to send a message from server to client, or client to client,<br>
   *  Sending a message from client to server will ONLY translate to English. */
  public static final void send_to_player(Player player, Component message){
    // if(!(player instanceof ServerPlayer)){
    //   ADDSynthCore.log.warn("Sending a message on the client side will only translate to English! Message: "+message.getKey());
    // }
    player.sendSystemMessage(message);
  }

  public static final void send_to_all_players(final Level world, final String translation_key, final Object ... arguments){
    @SuppressWarnings("resource")
    final MinecraftServer server = world.getServer();
    if(server != null){
      send_to_all_players(server, TextComponentHelper.createComponentTranslation(server, translation_key, arguments));
    }
  }

  public static final void send_to_all_players(final Level world, final Component text_component){
    @SuppressWarnings("resource")
    final MinecraftServer server = world.getServer();
    if(server != null){
      send_to_all_players(server, text_component);
    }
  }
  
  private static final void send_to_all_players(final MinecraftServer server, final Component text_component){
    final PlayerList player_list = server.getPlayerList();
    if(player_list != null){
      player_list.broadcastSystemMessage(text_component, false);
       // MAYBE: There's another Task Tag somewhere, but maybe the way I'm sending messages
       // to players should actually be game messages / overlay true? Like the "You may not
       // rest now there are monsters nearby" message.
    }
  }

  public static final void send_to_all_players_in_world(final Level world, final String translation_key, final Object ... arguments){
    @SuppressWarnings("resource")
    final MinecraftServer server = world.getServer();
    if(server != null){
      PlayerUtil.allPlayersInWorld(server, world, (ServerPlayer player) -> {
        player.sendSystemMessage(TextComponentHelper.createComponentTranslation(server, translation_key, arguments));
      });
    }
  }

  public static final void send_to_all_players_in_world(final Level world, final Component text_component){
    @SuppressWarnings("resource")
    final MinecraftServer server = world.getServer();
    if(server != null){
      PlayerUtil.allPlayersInWorld(server, world, (ServerPlayer player) -> {
        player.sendSystemMessage(text_component);
      });
    }
  }

}
