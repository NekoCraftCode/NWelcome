package com.nekocraft.nwelcome;

import com.nekocraft.nwelcome.*;
import org.bukkit.Bukkit;

import java.util.ArrayList;

public class Messages {
    public static String plugin_header;
    public static String plugin_footer;

    static {
        Messages.plugin_header = "&b«--------[&e&l&oNWelcome&b]--------»";
        Messages.plugin_header = "&b«------------------------------»";
    }

    public static String plugin_header(){
        return Util.Color(Messages.plugin_header);
    }
    public static String plugin_footer(){
        return Util.Color(Messages.plugin_footer);
    }

    public static String No_Console() {
        return Util.Color(Center.messages.getString("No-Console"));
    }

    public static String No_Perm() {
        return Center.messages.getString("No-Perm");
    }

    public static String joinMessage() {
        return String.valueOf(Center.config.getStringList("joinMessage"));
    }

    public static String playerJoin() {
        return Center.config.getString("playerJoinMsg");
    }

    public static String playerLeave() {
        return Center.config.getString("playerLeaveMsg");
    }

    public static String Help_Command() {
        return Center.config.getString("playerLeaveMsg");
    }
}
