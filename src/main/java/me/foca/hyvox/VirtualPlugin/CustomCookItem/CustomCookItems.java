package me.foca.hyvox.VirtualPlugin.CustomCookItem;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.SmokingRecipe;
import org.bukkit.inventory.recipe.CookingBookCategory;

public final class CustomCookItems {

    public static void start(){
        makeLeather();
        makeCoal();
    }

    public static void makeLeather(){
        ItemStack item = new ItemStack(Material.LEATHER);

        FurnaceRecipe smelt = new FurnaceRecipe(NamespacedKey.minecraft("leather_smelt"), item, Material.ROTTEN_FLESH, 1.0f, 30);

        smelt.setCategory(CookingBookCategory.MISC);

        Bukkit.getServer().addRecipe(smelt);
    }

    public static void makeCoal(){
        ItemStack item = new ItemStack(Material.COAL_BLOCK, 1);

        SmokingRecipe smelt = new SmokingRecipe(NamespacedKey.minecraft("coal_smelt"), item, Material.RAW_COPPER, 1.0f, 60);

        smelt.setCategory(CookingBookCategory.BLOCKS);

        Bukkit.getServer().addRecipe(smelt);
    }

}
