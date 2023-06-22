package me.foca.hyvox.VirtualPlugin.CustomItems.Backpack.LeatherBackpack;

import me.foca.hyvox.Engine.MenuSystem.Menu;
import me.foca.hyvox.Engine.MenuSystem.PlayerMenuUtility;
import me.foca.hyvox.Utility.Path;
import me.foca.hyvox.Utility.StringUtility;
import me.foca.hyvox.VirtualPlugin.CustomItems.Backpack.Backpack;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.util.ArrayList;

public class LeatherBackpackMenu extends Menu {



    public LeatherBackpackMenu(PlayerMenuUtility playerMenuUtility) {
        super(playerMenuUtility);


    }

    @Override
    public String getMenuName() {
        return StringUtility.addColor(ChatColor.BLACK, "Leather Backpack");
    }

    @Override
    public int getSlots() {
        return 9;
    }

    @Override
    public void handleMenu(InventoryClickEvent ev) {

    }

    @Override
    public void setMenuItems() {

        var items = Backpack.getPlayerStoredItem(playerMenuUtility.GetOwner());

        if (items != null){
            for (int i=0; i < items.size(); i++){
                for (ItemStack item : items){
                    inventory.setItem(i, item);
                }
            }
        }

    }

    @Override
    public boolean preventFromTakeItem() {
        return false;
    }

    @Override
    public boolean preventCreatingNullItem() {
        return true;
    }
}
