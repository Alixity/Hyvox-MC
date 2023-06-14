package me.foca.hyvox.VirtualPlugin.Utility.Menu;

import me.foca.hyvox.Engine.MenuSystem.Menu;
import me.foca.hyvox.Engine.MenuSystem.PlayerMenuUtility;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;

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
            case CHICKEN -> {
                player.closeInventory();
                player.setFoodLevel(20);
            }
        }
    }

    @Override
    public void setMenuItems() {

    }
}
