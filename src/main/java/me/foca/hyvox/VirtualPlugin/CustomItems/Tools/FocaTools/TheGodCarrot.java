package me.foca.hyvox.VirtualPlugin.CustomItems.Tools.FocaTools;

import me.foca.hyvox.Engine.CustomItems.CustomItem;
import me.foca.hyvox.Hyvox;
import me.foca.hyvox.Utility.StringUtility;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

import java.util.ArrayList;
import java.util.HashMap;

public class TheGodCarrot extends CustomItem {

    public TheGodCarrot(ItemStack base) {
        super(base);
    }

    @Override
    public String getName() {
        return StringUtility.addColor(ChatColor.GOLD, StringUtility.addBold("The God Carrot"));
    }

    @Override
    public String getKey() {
        return "foca_carrot";
    }

    @Override
    public ArrayList<String> addLore() {
        return null;
    }

    @Override
    public ArrayList<ItemFlag> addItemFlag() {
        ArrayList<ItemFlag> temp = new ArrayList<>();

        temp.add(ItemFlag.HIDE_ATTRIBUTES);

        return temp;
    }

    @Override
    public HashMap<Enchantment, Integer> addEnchant() {
        return null;
    }

    @Override
    public boolean preventFromDropping() {
        return false;
    }

    @Override
    public void registerCustomRecipe() {
        ShapedRecipe recipe = new ShapedRecipe(new NamespacedKey(Hyvox.instance, "the_god_carrot_recipe"), base);

        recipe.shape("ono", "nbn", "ono");

        recipe.setIngredient('o', Material.OBSIDIAN);
        recipe.setIngredient('n', Material.NETHER_STAR);
        recipe.setIngredient('b', Material.BEACON);

        Bukkit.addRecipe(recipe);
    }
}
