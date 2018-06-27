package com.nekocraft.nwelcome;

import org.bukkit.configuration.file.*;
import java.io.*;
import org.bukkit.configuration.*;
import java.util.*;

public class ConfigManager {
    public FileConfiguration config;
    public File file;
    public String s;

    public ConfigManager(final String s) {
        this.config = (FileConfiguration)new YamlConfiguration();
        this.file = new File(Center.getInstance().getDataFolder(), String.valueOf(s) + ".yml");
        this.s = s;
    }

    public boolean Exists() {
        return this.file.exists();
    }

    public void Save() {
        Log.prefix("&cThe " + this.s + ".yml file does not exist yet.");
        Log.prefix("&aCreating and loading file " + this.s + ".yml.");
        this.config.options().copyDefaults(true);
        try {
            this.config.save(this.file);
            Log.prefix("&a" + this.s + ".yml Create.");
        }
        catch (IOException ex) {
            Log.prefix("&cError on loaded " + this.s + ".yml.");
        }
    }

    public void RSave() {
        this.config.options().copyDefaults(true);
        try {
            this.config.save(this.file);
            Log.prefix("&a" + this.s + ".yml  save.");
        }
        catch (IOException ex) {
            Log.prefix("&cError on loaded " + this.s + ".yml.");
        }
    }

    public void Load() {
        Log.prefix("&aLoad " + this.s + ".yml");
        try {
            this.config.load(this.file);
            this.config.options().copyDefaults(true);
            this.config.save(this.file);
            Log.prefix("&a" + this.s + ".yml loaded.");
        }
        catch (IOException | InvalidConfigurationException ex) {
            Log.prefix("&cError on loaded " + this.s + ".yml.");
        }
    }
    
    public boolean Existe() {
        return this.file.exists();
    }

    public void add(final String s, final String s2) {
        this.config.addDefault(s, (Object)s2);
    }

    public void add(final String s, final long n) {
        this.config.addDefault(s, (Object)n);
    }

    public void add(final String s, final boolean b) {
        this.config.addDefault(s, (Object)b);
    }

    public void add(final String s, final List<String> list) {
        this.config.addDefault(s, (Object)list);
    }

    public void add(final String s, final int n) {
        this.config.addDefault(s, (Object)n);
    }

    public boolean getBoolean(final String s) {
        return this.config.getBoolean(s);
    }

    public String getString(final String s) {
        return this.config.getString(s);
    }

    public int getInt(final String s) {
        return this.config.getInt(s);
    }

    public List<String> getStringList(final String s) {
        return (List<String>)this.config.getStringList(s);
    }

    public ConfigurationSection getConfigurationSection(final String s) {
        return this.config.getConfigurationSection(s);
    }

    public boolean isSet(final String s) {
        return this.config.isSet(s);
    }

    public Set<String> getKeys(final Boolean b) {
        return (Set<String>)this.config.getKeys((boolean)b);
    }

    public Double getDouble(final String s) {
        return this.config.getDouble(s);
    }

    public void set(final String s, final String s2) {
        this.config.set(s, (Object)s2);
    }

    public void set(final String s, final double n) {
        this.config.set(s, (Object)n);
    }

    public boolean contains(final String s) {
        return this.config.contains(s);
    }
}
