package me.foca.hyvox.VirtualPlugin.CustomItems.Tools.FocaTools;

import me.foca.hyvox.Engine.CustomItems.CustomTool;
import me.foca.hyvox.Utility.StringUtility;
import org.bukkit.ChatColor;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;

public class FocaShovel extends CustomTool{
    public FocaShovel(ItemStack base) {
        super(base);
    }

    @Override
    public String getName() {
        return StringUtility.addColor(ChatColor.DARK_PURPLE, StringUtility.addBold("Foca Shovel"));
    }

    @Override
    public String getKey() {
        return "foca_shovel";
    }

    @Override
    public ArrayList<String> addLore() {
        ArrayList<String> temp = new ArrayList<>();

        temp.add("Billy gay");
        temp.add("Sua madre pure");

        return temp;
    }

    @Override
    public ArrayList<ItemFlag> addItemFlag() {

        return null;
    }

    @Override
    public void registerCustomRecipe() {

    }

    @Override
    public boolean isUnbreakable() {
        return true;
    }

    @Override
    public HashMap<Enchantment, Integer> addEnchant() {
        HashMap<Enchantment,Integer> temp = new HashMap<>();

        temp.put(Enchantment.PROTECTION_FIRE, 1000);

        return temp;

    }

    @Override
    public boolean preventFromDropping() {
        return false;
    }
}
