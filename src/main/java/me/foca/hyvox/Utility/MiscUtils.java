package me.foca.hyvox.Utility;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class MiscUtils {


    public static void OpenMiscMenu(Player player){
        if (player.hasPermission("hyvox.misc")){
            Inventory inventory = Bukkit.createInventory(player, 18, ChatColor.AQUA + "Misc Menu");

            inventory.setItem(0, CreateTeleportBow());
            inventory.setItem(1, CreateSuicideTnT());

            player.openInventory(inventory);
        }
        else{
            StringUtility.SendCommandError(player, "misc");
        }
    }
    public static ItemStack CreateTeleportBow(){

        ItemStack bow = new ItemStack(Material.BOW, 1);
        ItemMeta bowMeta = bow.getItemMeta();
        bowMeta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Teleport Bow");

        List<String> lore = new ArrayList<>();
        lore.add("Scocca una freccia dove vuoi");
        bowMeta.setLore(lore);
        bowMeta.addEnchant(Enchantment.ARROW_INFINITE, 1, false);
        bowMeta.setUnbreakable(true);
        bow.setItemMeta(bowMeta);

        return bow;
    }

    public static ItemStack CreateTeleportArrow(){
        ItemStack arrow = new ItemStack(Material.ARROW, 1);
        ItemMeta arrowMeta = arrow.getItemMeta();
        arrowMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "Teleport Arrow");
        arrowMeta.addEnchant(Enchantment.VANISHING_CURSE, 1, false);
        arrow.setItemMeta(arrowMeta);

        return arrow;
    }

    public static ItemStack CreateSuicideTnT(){
        ItemStack tnt = new ItemStack(Material.TNT, 1);
        ItemMeta tntMeta = tnt.getItemMeta();

        tntMeta.setDisplayName(ChatColor.RED + "Suicidati");

        tnt.setItemMeta(tntMeta);

        return tnt;
    }
}
