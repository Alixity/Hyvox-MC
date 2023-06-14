package me.foca.hyvox.VirtualPlugin.Misc.Menu;

import me.foca.hyvox.Hyvox;
import me.foca.hyvox.Engine.MenuSystem.Menu;
import me.foca.hyvox.Engine.MenuSystem.PlayerMenuUtility;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.*;

public class MiscMenu extends Menu {
    public MiscMenu(PlayerMenuUtility playerMenuUtility) {
        super(playerMenuUtility);
    }


    public static List<String> ItemTracker = new ArrayList<>();

    public static String Bow = ChatColor.GREEN + "" + ChatColor.BOLD + "Teleport Bow";
    public static String Arrow = ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "Teleport Arrow";


    @Override
    public String getMenuName() {
        return ChatColor.AQUA + "Misc Menu";
    }

    @Override
    public int getSlots() {
        return 9;
    }

    @Override
    public void handleMenu(InventoryClickEvent ev) {

        Player player = (Player) ev.getWhoClicked();

        switch (ev.getCurrentItem().getType()) {
            case BOW -> {
                player.closeInventory();
                player.getInventory().addItem(CreateTeleportBow());
                player.getInventory().addItem(CreateItem(Arrow, Material.ARROW, 1, new ArrayList<>()));
            }
            case TNT -> {
                player.closeInventory();
                new ConfirmSuicideMenu(Hyvox.getPlayerMenuUtility(player)).open();
            }
        }
    }

    @Override
    public void setMenuItems() {
        inventory.setItem(3, CreateTeleportBow());
        inventory.setItem(5, CreateSuicideTnT());
    }

    public static ItemStack CreateTeleportBow(){

        ItemStack bow = new ItemStack(Material.BOW, 1);
        ItemMeta bowMeta = bow.getItemMeta();
        bowMeta.setDisplayName(Bow);

        List<String> lore = new ArrayList<>();
        lore.add("Scocca una freccia dove vuoi");
        bowMeta.setLore(lore);
        bowMeta.addEnchant(Enchantment.ARROW_INFINITE, 1, false);
        bowMeta.setUnbreakable(true);
        bow.setItemMeta(bowMeta);

        if (!ItemTracker.contains(Bow))
            ItemTracker.add(Bow);

        return bow;
    }


    public static ItemStack CreateSuicideTnT(){
        ItemStack tnt = new ItemStack(Material.TNT, 1);
        ItemMeta tntMeta = tnt.getItemMeta();

        tntMeta.setDisplayName(ChatColor.RED + "Suicidati");

        tnt.setItemMeta(tntMeta);

        return tnt;
    }
}
