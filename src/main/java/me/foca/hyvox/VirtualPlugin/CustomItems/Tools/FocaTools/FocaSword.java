package me.foca.hyvox.VirtualPlugin.CustomItems.Tools.FocaTools;

import me.foca.hyvox.Engine.CustomItems.CustomTool;
import me.foca.hyvox.Hyvox;
import me.foca.hyvox.Utility.StringUtility;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.recipe.CraftingBookCategory;

import java.lang.annotation.Documented;
import java.util.ArrayList;
import java.util.HashMap;

public class FocaSword extends CustomTool {
    public FocaSword(ItemStack base) {
        super(base);
    }

    @Override
    public String getName() {
        return StringUtility.addColor(ChatColor.GOLD, StringUtility.addBold("God's Slayer ☠️☠️ -> La mamma di billy"));
    }

    @Override
    public String getKey() {
        return "foca_sword";
    }

    @Override
    public ArrayList<String> addLore() {
        return null;
    }

    @Override
    public ArrayList<ItemFlag> addItemFlag() {
        ArrayList<ItemFlag> temp = new ArrayList<>();

        temp.add(ItemFlag.HIDE_ENCHANTS);
        temp.add(ItemFlag.HIDE_ATTRIBUTES);
        temp.add(ItemFlag.HIDE_UNBREAKABLE);

        return temp;
    }


    @Override
    public boolean preventFromDropping() {
        return true;
    }

    @Override
    public void whenPlayerDropItem(PlayerDropItemEvent e) {

    }

    @Override
    public void registerCustomRecipe() {
        ShapedRecipe recipe = new ShapedRecipe(new NamespacedKey(Hyvox.instance, "foca_sword_crafting"), base);

        recipe.shape("dof", "cra", " - ");

        recipe.setIngredient('d', Material.DIAMOND);
        recipe.setIngredient('o', Material.GOLD_INGOT);
        recipe.setIngredient('f', Material.IRON_INGOT);
        recipe.setIngredient('c', Material.COAL);
        recipe.setIngredient('r', Material.RAW_COPPER);
        recipe.setIngredient('a', Material.AMETHYST_SHARD);
        recipe.setIngredient('-', Material.STICK);

        recipe.setCategory(CraftingBookCategory.EQUIPMENT);

        Bukkit.addRecipe(recipe);
    }

    @Override
    public boolean isUnbreakable() {
        return true;
    }

    @Override
    public HashMap<Enchantment, Integer> addEnchant() {

        HashMap<Enchantment, Integer> temp = new HashMap<>();

        temp.put(Enchantment.DAMAGE_ALL, 5);
        temp.put(Enchantment.LOOT_BONUS_MOBS, 5);
        temp.put(Enchantment.FIRE_ASPECT, 3);
        temp.put(Enchantment.DAMAGE_ARTHROPODS, 5);
        temp.put(Enchantment.DAMAGE_UNDEAD, 5);
        temp.put(Enchantment.KNOCKBACK, 2);


        return temp;
    }
}
