package me.foca.hyvox.VirtualPlugin.CustomItems.Backpack;

import me.foca.hyvox.Engine.MenuSystem.Menu;
import me.foca.hyvox.Utility.StringUtility;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class BackpackListener implements Listener {

    @EventHandler
    public void OnCloseMenu(InventoryCloseEvent e){
        InventoryHolder holder = e.getInventory().getHolder();

        if (holder instanceof Menu) {

            if (((Menu) holder).getMenuName().equals(StringUtility.addColor(ChatColor.BLACK, "Leather Backpack"))){

                ArrayList<ItemStack> items = new ArrayList<>();

                for (int i=0; i < e.getInventory().getSize(); i++){
                    items.add(e.getInventory().getItem(i));
                }

                Backpack.savePlayerStoredItem((Player) e.getPlayer(), items);

            }

        }
    }


}
