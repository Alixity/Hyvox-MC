package me.foca.hyvox.VirtualPlugin.Misc.Menu;

import me.foca.hyvox.Engine.MenuSystem.Menu;
import me.foca.hyvox.Engine.MenuSystem.PlayerMenuUtility;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.ArrayList;

public class ConfirmSuicideMenu extends Menu {

    public ConfirmSuicideMenu(PlayerMenuUtility playerMenuUtility) {
        super(playerMenuUtility);
    }

    @Override
    public String getMenuName() {
        return ChatColor.RED + "Suicide Menu";
    }

    @Override
    public int getSlots() {
        return 9;
    }

    @Override
    public void handleMenu(InventoryClickEvent ev) {
        Player player = (Player) ev.getWhoClicked();

        switch (ev.getCurrentItem().getType()){
            case GREEN_WOOL -> {
                player.closeInventory();
                player.setHealth(0.0);
                player.sendMessage(ChatColor.RED + "Ti sei Suicidato " + ChatColor.YELLOW + "" +ChatColor.BOLD + player.getDisplayName() + ChatColor.RED + " :(((");
                player.playSound(player, Sound.ENTITY_GENERIC_EXPLODE, 1.0f, 1.0f);
            }
            case RED_WOOL -> {
                player.closeInventory();
            }
        }
    }

    @Override
    public void setMenuItems() {
        inventory.setItem(3, CreateItem(ChatColor.GREEN + "" + ChatColor.BOLD + "Si", Material.GREEN_WOOL, 1, new ArrayList<>()));
        inventory.setItem(5, CreateItem(ChatColor.RED + "" + ChatColor.BOLD + "No", Material.RED_WOOL, 1, new ArrayList<>()));
    }
}
