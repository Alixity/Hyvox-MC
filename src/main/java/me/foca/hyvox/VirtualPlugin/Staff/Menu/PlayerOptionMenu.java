package me.foca.hyvox.VirtualPlugin.Staff.Menu;

import me.foca.hyvox.Engine.MenuSystem.Menu;
import me.foca.hyvox.Engine.MenuSystem.PlayerMenuUtility;
import me.foca.hyvox.Hyvox;
import me.foca.hyvox.Utility.ItemUtils;
import me.foca.hyvox.Utility.PlayerUtility;
import me.foca.hyvox.Utility.StringUtility;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;

public class PlayerOptionMenu extends Menu {

    public Player StaffPlayer;
    public Player SelectedPlayer;


    public PlayerOptionMenu(PlayerMenuUtility playerMenuUtility, Player staffPlayer, Player selectedPlayer) {
        super(playerMenuUtility);
        StaffPlayer = staffPlayer;
        SelectedPlayer = selectedPlayer;
    }

    @Override
    public String getMenuName() {
        return ChatColor.RED + "Player Options for '" + ChatColor.YELLOW + SelectedPlayer.getDisplayName() + ChatColor.RED + "'";
    }

    @Override
    public int getSlots() {
        return 45;
    }

    @Override
    public void handleMenu(InventoryClickEvent ev) {

        switch (ev.getCurrentItem().getType()){
            case WOODEN_AXE:
                SelectedPlayer.setHealth(0);
                break;
            case COOKED_CHICKEN:
                SelectedPlayer.setFoodLevel(20);
                break;
            case NETHERITE_CHESTPLATE:
            case LEATHER_CHESTPLATE:
                PlayerUtility.SetGod(SelectedPlayer);
                new PlayerOptionMenu(Hyvox.getPlayerMenuUtility(StaffPlayer), StaffPlayer, SelectedPlayer).open();
                break;
            case BARRIER:
                StaffPlayer.closeInventory();
        }

    }

    @Override
    public void setMenuItems() {
        inventory.setItem(12, CreateItem("Ban Menu", Material.WOODEN_AXE, 1, ""));
        inventory.setItem(13, CreateItem(ChatColor.GOLD + "Max " + SelectedPlayer.getDisplayName() + " food level" , Material.COOKED_CHICKEN, 1, ""));
        inventory.setItem(14, ItemUtils.createGodModeChestplate(SelectedPlayer));
        inventory.setItem(44, CreateItem(StringUtility.addColor(ChatColor.RED, "Esci"), Material.BARRIER, 1, ""));
    }
}
