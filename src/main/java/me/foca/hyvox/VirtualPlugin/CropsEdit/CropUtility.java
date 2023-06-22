package me.foca.hyvox.VirtualPlugin.CropsEdit;

import me.foca.hyvox.Hyvox;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.Ageable;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class CropUtility {

    public static boolean isFullyGrown(Block block){
        Ageable ageable = (Ageable) block.getBlockData();

        int maxAge = ageable.getMaximumAge();

        return ageable.getAge() == ageable.getMaximumAge();
    }

    public static Material getSeedMaterial(Material cropBlockType){
        switch (cropBlockType) {
            case WHEAT -> {
                return Material.WHEAT_SEEDS;
            }
            case BEETROOT -> {
                return Material.BEETROOT_SEEDS;
            }
            case POTATO -> {
                return Material.POTATO;
            }
            case CARROT -> {
                return Material.CARROT;
            }
        }

        return null;
    }

    public static boolean isSeedInInventory(Player player, Material cropByBlockType){
        PlayerInventory playerInventory = player.getInventory();
        Material seed = getSeedMaterial(cropByBlockType);

        return playerInventory.contains(seed);
    }

    public static void removeSeed(Player player, Material seedType){
        if (isSeedInInventory(player, seedType)){
        }
    }

    public static void replantCrop(Location location, Material cropByType){
        Bukkit.getScheduler().runTaskLater(Hyvox.instance, () -> {
            location.getBlock().setType(cropByType);
        }, 20);
    }
}
