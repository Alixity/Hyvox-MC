package me.foca.hyvox.Engine.MenuSystem;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.InventoryHolder;

public class MenuListener implements Listener {

    @EventHandler
    public void onMenuClick(InventoryClickEvent e){
        InventoryHolder holder = e.getInventory().getHolder();

        if (holder instanceof Menu && e.getCurrentItem() != null) {

            if (((Menu) holder).preventFromTakeItem())
                e.setCancelled(true);
            ((Menu) holder).handleMenu(e);
        }
    }
}
