package me.foca.hyvox.VirtualPlugin.CustomItems.Backpack.LeatherBackpack;

import me.foca.hyvox.Engine.CustomItems.CustomBlock;
import me.foca.hyvox.Hyvox;
import me.foca.hyvox.Utility.StringUtility;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

import java.util.ArrayList;
import java.util.HashMap;

public class LeatherBackpack extends CustomBlock {

    public LeatherBackpack(ItemStack base) {
        super(base);
    }

    @Override
    public boolean preventBlockBePlaced() {
        return true;
    }

    @Override
    public String getName() {
        return StringUtility.addColor(ChatColor.GOLD, "Backpack");
    }

    @Override
    public String getKey() {
        return "leather_backpack";
    }

    @Override
    public ArrayList<String> addLore() {
        return null;
    }

    @Override
    public ArrayList<ItemFlag> addItemFlag() {
        ArrayList<ItemFlag> itemFlags = new ArrayList<>();

        itemFlags.add(ItemFlag.HIDE_ENCHANTS);
        itemFlags.add(ItemFlag.HIDE_ATTRIBUTES);

        return itemFlags;
    }

    @Override
    public HashMap<Enchantment, Integer> addEnchant() {
        HashMap<Enchantment, Integer> enchant = new HashMap<>();

        enchant.put(Enchantment.KNOCKBACK, 1);

        return enchant;
    }

    @Override
    public boolean preventFromDropping() {
        return false;
    }

    @Override
    public void registerCustomRecipe() {

        ShapedRecipe recipe = new ShapedRecipe(new NamespacedKey(Hyvox.instance, getKey()), base);

        recipe.shape("lll", "lcl", "lll");

        recipe.setIngredient('l', Material.LEATHER);
        recipe.setIngredient('c', Material.CHEST);

        Bukkit.addRecipe(recipe);
    }

    @Override
    public void onBlockPlace(BlockPlaceEvent e) {

        new LeatherBackpackMenu(Hyvox.getPlayerMenuUtility(e.getPlayer())).open();

        super.onBlockPlace(e);
    }
}
