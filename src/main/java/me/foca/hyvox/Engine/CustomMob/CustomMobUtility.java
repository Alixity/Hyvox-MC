package me.foca.hyvox.Engine.CustomMob;

import jdk.jfr.consumer.RecordedThread;
import me.foca.hyvox.Utility.StringUtility;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.lang.reflect.Array;
import java.util.Arrays;

public class CustomMobUtility {


    public static void giveCustomMobSpawnEgg(Player player, CustomMob customMob){
        ItemStack egg = setCustomEgg(customMob.getMobType());
        ItemMeta eggMeta = egg.getItemMeta();

        eggMeta.setDisplayName(customMob.getMobName() + StringUtility.addColor(ChatColor.RED, "Spawn Egg"));
        eggMeta.setLore(Arrays.asList("Spawn Egg for: " + StringUtility.addColor(ChatColor.RED, customMob.getMobName())));
        egg.setItemMeta(eggMeta);

        player.getInventory().addItem(egg);
    }

    private static ItemStack setCustomEgg(EntityType entityType){

        ItemStack egg;

        switch (entityType){
            case ZOMBIE -> {
                egg = new ItemStack(Material.ZOMBIE_SPAWN_EGG);
                return egg;
            }
            case SKELETON -> {
                egg = new ItemStack(Material.SKELETON_SPAWN_EGG);
                return egg;
            }
            case PIG -> {
                egg = new ItemStack(Material.PIG_SPAWN_EGG);
                return egg;
            }
        }
        
        return null;
    }
}
