package me.foca.hyvox.VirtualPlugin.Utility.Menu;

import me.foca.hyvox.Engine.MenuSystem.Menu;
import me.foca.hyvox.Engine.MenuSystem.PlayerMenuUtility;
import me.foca.hyvox.Utility.StringUtility;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.time.Duration;

public class UtilityMenu extends Menu {


    public UtilityMenu(PlayerMenuUtility playerMenuUtility) {
        super(playerMenuUtility);
    }

    @Override
    public String getMenuName() {
        return ChatColor.AQUA + "Utility Menu";
    }

    @Override
    public int getSlots() {
        return 9;
    }

    @Override
    public void handleMenu(InventoryClickEvent ev) {
        Player player = (Player) ev.getWhoClicked();

        switch (ev.getCurrentItem().getType()){
            case ENCHANTED_GOLDEN_APPLE -> {
                player.closeInventory();
                player.setFoodLevel(20);
                player.setHealth(20);
            }
            case CAKE -> {
                player.closeInventory();

                if (player.getGameMode().equals(GameMode.SURVIVAL))
                    player.setGameMode(GameMode.CREATIVE);
                else{
                    player.setGameMode(GameMode.SURVIVAL);
                }

            }
        }
    }

    @Override
    public void setMenuItems() {
        inventory.setItem(1, CreateItem(StringUtility.addColor(ChatColor.GREEN, "Resetta Stats"), Material.ENCHANTED_GOLDEN_APPLE, 1, ""));

        inventory.setItem(2, CreateItem(StringUtility.addColor(ChatColor.GREEN, "Enable Creative"), Material.CAKE, 1, ""));

    }

    @Override
    public boolean preventFromTakeItem() {
        return true;
    }

    @Override
    public boolean preventCreatingNullItem() {
        return false;
    }

}
