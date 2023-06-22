package me.foca.hyvox.Utility;

import org.bukkit.Bukkit;

import java.io.File;

public class Path {

    public static File getDataFolder(){
        return Bukkit.getServer().getPluginManager().getPlugin("Hyvox").getDataFolder();
    }

}
