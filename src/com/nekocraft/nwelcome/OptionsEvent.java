package com.nekocraft.nwelcome;

import net.md_5.bungee.api.chat.*;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;

public class OptionsEvent implements Listener {

    public static Plugin plugin;

    public OptionsEvent(Center center) {
        this.plugin = plugin;
    }

    /*@EventHandler
    public void PlayerJoin(final PlayerJoinEvent playerJoinEvent) {
        final Player p = playerJoinEvent.getPlayer();
        p.sendMessage(Util.Color(Messages.plugin_header()));
        p.sendMessage("&f");
        p.sendMessage("&f");
        p.sendMessage("&f");
        p.sendMessage("&f");
        p.sendMessage("&f");
        p.sendMessage("&6          Welcome to &4&k!!&9&lYourServerName&4&k!!");
        p.sendMessage("&f");
        p.sendMessage("&e                Links:");
        p.sendMessage("&f");
        p.sendMessage(Util.Color(Messages.plugin_footer()));
    }*/

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
      Player player = (Player)event.getPlayer();
      if(Center.config.getBoolean("joinBroadcast")){
          //event.setJoinMessage(Util.Color(Center.config.getString("playerJoinMsg").replace("%p", (CharSequence) event.getPlayer())));
          String playerJoinMsg = Center.config.getString("playerJoinMsg");

          playerJoinMsg = playerJoinMsg.replace("%playername%", player.getDisplayName());

          Bukkit.broadcastMessage(Util.Color(playerJoinMsg));

      }

      player.sendMessage(Util.Color(Messages.joinMessage()));

      TextComponent joinMessageRaw = new TextComponent(Util.Color("&6              &lWebsite:"));
        String web = "false";
      if(!(Center.config.getString("clickEvents.click-open-website") == web)) {
            joinMessageRaw.setClickEvent( new ClickEvent( ClickEvent.Action.OPEN_URL, Center.config.getConfigurationSection("clickEvents").getString("click-open-website")));
            //joinMessageRaw.setClickEvent( new ClickEvent( ClickEvent.Action.OPEN_URL, Center.config.getString("clickEvents.click-open-website") ) );
      }
      joinMessageRaw.setHoverEvent( new HoverEvent( HoverEvent.Action.SHOW_TEXT, new ComponentBuilder( Center.config.getString("hoverTooltip") ).create() ) );
      player.spigot().sendMessage(joinMessageRaw);

    }
}