package me.foca.hyvox.VirtualPlugin.CustomItems.Tools.FocaTools;

import me.foca.hyvox.Engine.CustomItems.CustomTool;
import me.foca.hyvox.Utility.StringUtility;
import org.bukkit.ChatColor;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;

public class FocaPickaxe extends CustomTool {
    public FocaPickaxe(ItemStack base) {
        super(base);
    }

    @Override
    public boolean isUnbreakable() {
        return true;
    }

    @Override
    public String getName() {
        return StringUtility.addColor(ChatColor.DARK_PURPLE, StringUtility.addBold("Foca Pickaxe"));
    }

    @Override
    public String getKey() {
        return "foca_pickaxe";
    }

    @Override
    public HashMap<Enchantment, Integer> addEnchant() {

        HashMap<Enchantment, Integer> temp = new HashMap<>();

        temp.put(Enchantment.LOOT_BONUS_BLOCKS, 5);
        temp.put(Enchantment.DIG_SPEED, 4);
        temp.put(Enchantment.VANISHING_CURSE, 1);

        return temp;
    }

    @Override
    public boolean preventFromDropping() {
        return false;
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
    public void registerCustomRecipe() {

    }
}
