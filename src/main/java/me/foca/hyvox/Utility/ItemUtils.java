package me.foca.hyvox.Utility;

import me.foca.hyvox.Engine.MenuSystem.Menu;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemUtils {

    public static boolean CheckItemByName(ItemStack itemStack, String name){
        return itemStack.getItemMeta().getDisplayName().equalsIgnoreCase(name);
    }

    public static ItemStack createGodModeChestplate(Player player){

        ItemStack armor;

        if (player.isInvulnerable()){
            armor = new ItemStack(Material.NETHERITE_CHESTPLATE, 1);
        }else{
            armor = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
        }
        ItemMeta armorMeta = armor.getItemMeta();
        armorMeta.removeItemFlags();


        if (player.isInvulnerable()){
            armorMeta.setDisplayName(ChatColor.RED + "Disable GodMode");
        }else{
            armorMeta.setDisplayName(ChatColor.GREEN + "Enable GodMode");
        }

        armor.setItemMeta(armorMeta);

        return  armor;
    }
}
