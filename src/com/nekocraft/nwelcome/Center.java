package com.nekocraft.nwelcome;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.*;
import java.util.*;



public class Center extends JavaPlugin {

    public static Center instance;
    public static ConfigManager messages;
    public static ConfigManager config;
    public static List<String> joinMessage;
    public static List<String> commands;

    static {
        Center.joinMessage = new ArrayList<String>();
        Center.commands = new ArrayList<String>();
    }

    public String version = getDescription().getVersion();

    @Override
    public void onEnable() {
        Center.instance = this;
        //this.getServer().getPluginManager().registerEvents((Listener)new OptionsEvent(), (Plugin)this);
        Log.linea("&9&l&m- - - - - - - - - - - - - - - - - - - -");
        Log.prefix("&aEl plugin esta activado. &7[&bv" + version + "&7]");
        Log.linea("&9&l&m- - - - - - - - - - - - - - - - - - - -");
        this.iniConfig();
        Center.joinMessage = Center.config.getStringList("joinMessage");
        Center.commands = Center.config.getStringList("clickEvents.commands");
        Bukkit.getPluginManager().registerEvents(new OptionsEvent(this), this);
    }

    @Override
    public void onDisable() {
        Log.linea("&9&l&m- - - - - - - - - - - - - - - - - - - -");
        Log.prefix("&cEl plugin esta desactivado. &7[&bv" + version + "&7]");
        Log.linea("&9&l&m- - - - - - - - - - - - - - - - - - - -");
    }


    public void iniConfig() {
        Center.config = new ConfigManager("config");
        if (Center.config.Exists()) {
            this.configdata();
            Center.config.Load();
        }
        else {
            this.configdata();
            Center.config.Save();
        }
    }

    public void configdata() {
        Center.config.add("joinBroadcast", false);
        Center.config.add("playerJoinMsg", "&7[&a+&7] &a %playername% join the game.");
        Center.config.add("playerLeaveMsg","&7[&c-&7] &c %playername% left the game.");
        Center.config.add("joinMessage", Arrays.asList("&f", "&f", "&f", "&f", "&f", "&6           &lWelcome to &9&lYOUR-SERVER-NAME", "&f", "&e                    Redes Sociales:", "&f", "&6              &lWebsite: yourserver.net", "&6            &lStore: &9store.yourserver.net"));
        Center.config.add("hoverTooltip", "Click me!");
        Center.config.add("clickEvents.click-open-website", "yourwebsite.com");
        Center.config.add("clickEvents.commands", Arrays.asList("command 1","command 2"));
    }
    public static Center getInstance() {
        return Center.instance;
    }

}
