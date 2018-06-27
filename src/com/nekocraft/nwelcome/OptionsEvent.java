package com.nekocraft.nwelcome;

import net.md_5.bungee.api.chat.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.Plugin;

public class OptionsEvent implements Listener {

    public static Plugin plugin;

    public OptionsEvent(Center center) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
      Player player = (Player)event.getPlayer();
      if(Center.config.getBoolean("joinBroadcast")){

          String playerJoinMsg = Center.config.getString("playerJoinMsg");

          playerJoinMsg = playerJoinMsg.replace("%playername%", player.getDisplayName());

          event.setJoinMessage(Util.Color(playerJoinMsg));

      }

      player.sendMessage(Util.Color(Messages.joinMessage()));

      TextComponent joinMessageRaw = new TextComponent(Util.Color("&6              &lWebsite:"));
        String web = "false";

      if(!(Center.config.getString("clickEvents.click-open-website") == web)) {
            joinMessageRaw.setClickEvent( new ClickEvent( ClickEvent.Action.OPEN_URL, Center.config.getConfigurationSection("clickEvents").getString("click-open-website")));
      }

      joinMessageRaw.setHoverEvent( new HoverEvent( HoverEvent.Action.SHOW_TEXT, new ComponentBuilder( Center.config.getString("hoverTooltip") ).create() ) );
      player.spigot().sendMessage(joinMessageRaw);

    }
    
    @EventHandler
    public void onPlayerQuit​(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        if(Center.config.getBoolean("joinBroadcast")){

            String playerLeaveMsg = Center.config.getString("playerLeaveMsg");

            playerLeaveMsg = playerLeaveMsg.replace("%playername%", player.getDisplayName());

            event.setQuitMessage(Util.Color(playerLeaveMsg));

        }
    }
}
