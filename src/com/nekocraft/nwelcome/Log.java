package com.nekocraft.nwelcome;

import org.bukkit.*;

public class Log {
    public static void prefix(final String s) {

        Bukkit.getConsoleSender().sendMessage(Util.Color("&7[&e&l&oNWelcome&7]&b >> &f" + s + "&b"));
    }

    public static void linea(final String s) {

        Bukkit.getConsoleSender().sendMessage(Util.Color("&b" + s + "&b"));
    }
}
