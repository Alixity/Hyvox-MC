package me.foca.hyvox.VirtualPlugin.Staff.Menu;

import me.foca.hyvox.Engine.MenuSystem.Menu;
import me.foca.hyvox.Engine.MenuSystem.PlayerMenuUtility;
import me.foca.hyvox.Hyvox;
import me.foca.hyvox.Utility.PlayerUtility;
import me.foca.hyvox.Utility.StringUtility;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;

import javax.print.DocFlavor;
import java.util.ArrayList;

public class StaffMenu extends Menu {


    public static ArrayList<Player> Player_With_Fly = new ArrayList<>();


    public StaffMenu(PlayerMenuUtility playerMenuUtility) {
        super(playerMenuUtility);
    }

    @Override
    public String getMenuName() {
        return ChatColor.RED + "" + ChatColor.BOLD + "Staff Menu";
    }

    @Override
    public int getSlots() {
        return 18;
    }

    @Override
    public void handleMenu(InventoryClickEvent ev) {

        Player player = (Player) ev.getWhoClicked();

        switch (ev.getCurrentItem().getType()){
            case PLAYER_HEAD:
                new PlayerListMenu(getPlayerMenuUtility(player)).open();
                break;
            case NETHERITE_CHESTPLATE:
            case LEATHER_CHESTPLATE:
                PlayerUtility.SetGod(player);
                new StaffMenu(Hyvox.getPlayerMenuUtility(player)).open();
                break;
            case BARRIER:
                player.closeInventory();
                break;
            case FEATHER:
            case RED_WOOL:
                PlayerUtility.MakeFly(player);
                new StaffMenu(Hyvox.getPlayerMenuUtility(player)).open();
                break;
        }

    }

    @Override
    public void setMenuItems() {

        Player player = playerMenuUtility.GetOwner();

        inventory.setItem(0, CreateItem(ChatColor.RED + "Player List", Material.PLAYER_HEAD, 1, new ArrayList<>()));
        if (player.isInvulnerable()){
            inventory.setItem(1, CreateItem(ChatColor.RED + "Disable GodMode", Material.NETHERITE_CHESTPLATE, 1, new ArrayList<>()));
        }else {
            inventory.setItem(1, CreateItem(ChatColor.GREEN + "Enable GodMode", Material.LEATHER_CHESTPLATE, 1, new ArrayList<>()));
        }

        if (!Player_With_Fly.contains(player))
            inventory.setItem(2, CreateItem(ChatColor.GREEN + "Enable Fly", Material.FEATHER, 1, new ArrayList<>()));
        else{
            inventory.setItem(2, CreateItem(ChatColor.RED + "Disable Fly", Material.RED_WOOL, 1, new ArrayList<>()));
        }


        inventory.setItem(17, CreateItem(StringUtility.addColor(ChatColor.RED, "EXIT"), Material.BARRIER, 1, new ArrayList<>()));
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
