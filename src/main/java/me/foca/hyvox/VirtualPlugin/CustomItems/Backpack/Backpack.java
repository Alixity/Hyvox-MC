package me.foca.hyvox.VirtualPlugin.CustomItems.Backpack;

import me.foca.hyvox.Engine.Log.Log;
import me.foca.hyvox.Utility.Path;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Backpack {

    public static File file;
    public static FileConfiguration backpackStorage;

    // find or generate backpackStorage File
    public static void setup(){
        file = new File(Path.getDataFolder(), "BackpackStorage.yml");

        if (!file.exists()){
            try{
                file.createNewFile();
            }catch (IOException ex){
                // porcoddio
            }
        }

        backpackStorage = YamlConfiguration.loadConfiguration(file);
    }

    public static FileConfiguration get(){
        return backpackStorage;
    }

    public static void save(){
        try{
            backpackStorage.save(file);
        }catch (IOException e){
            Log.error("Impossibile salvare backpack storage file: " + e);
        }
    }

    public static void reload(){
        backpackStorage = YamlConfiguration.loadConfiguration(file);
    }

    public static List<ItemStack> getPlayerStoredItem(Player player){

        List<ItemStack> items = null;

        String uniqueId = String.valueOf(player.getUniqueId());

        if (get().contains(uniqueId)){
            items = (List<ItemStack>) get().getItemStack(uniqueId);
        }


        return items;
    }

    public static void savePlayerStoredItem(Player player, ArrayList<ItemStack> items){
        get().set(String.valueOf(player.getUniqueId()), items);

        save();
    }
}
