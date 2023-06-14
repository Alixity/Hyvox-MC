package me.foca.hyvox.Engine.ConfigSystem;

import me.foca.hyvox.Hyvox;
import me.foca.hyvox.Utility.StringUtility;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class CustomConfig {


    private static File rankfile;
    private static FileConfiguration rankConfig;

    public static void setup(){
        rankfile = new File(Bukkit.getServer().getPluginManager().getPlugin(Hyvox.instance.getName()).getDataFolder(), "RankConfig.yml");

        checkIfFileExist(rankfile);

        rankConfig = YamlConfiguration.loadConfiguration(rankfile);
    }


    public static FileConfiguration getRankConfig(){
        return rankConfig;
    }

    public static void saveRankConfig(){
        try{
            rankConfig.save(rankfile);
        } catch (IOException e) {
            System.out.println("Abbiamo rilevato un problema durante il salvataggio del config " + rankfile.getName() + ":\n" + e);
        }
    }

    public static boolean reload(){
        try {

            rankConfig = YamlConfiguration.loadConfiguration(rankfile);

            return true;
        } catch (Exception e) {
            System.out.println("Abbiamo rilevato un problema durante il reload del config " + rankfile.getName() + ":\n" + e);
            return false;
        }
    }

    private static void checkIfFileExist(File file){
        if (file.exists())
            return;
        else {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


}
