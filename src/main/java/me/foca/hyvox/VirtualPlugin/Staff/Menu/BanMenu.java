package me.foca.hyvox.VirtualPlugin.Staff.Menu;

import me.foca.hyvox.Engine.MenuSystem.Menu;
import me.foca.hyvox.Engine.MenuSystem.PlayerMenuUtility;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import static me.foca.hyvox.Utility.StringUtility.*;
import static me.foca.hyvox.Utility.StringUtility.addBold;

public class BanMenu extends Menu {

    public Player SelectedPlayer;

    public Player StaffPlayer;
    public BanMenu(PlayerMenuUtility playerMenuUtility, Player selectedPlayer) {
        super(playerMenuUtility);
        SelectedPlayer = selectedPlayer;
        StaffPlayer = playerMenuUtility.GetOwner();
    }

    @Override
    public String getMenuName() {
        return ChatColor.RED + "Ban Menu";
    }

    @Override
    public int getSlots() {
        return 9;
    }

    @Override
    public void handleMenu(InventoryClickEvent ev) {

        switch (ev.getCurrentItem().getType()){
            case GREEN_WOOL -> {
                StaffPlayer.closeInventory();
                SelectedPlayer.isBanned();
            }
            case RED_WOOL -> {
                StaffPlayer.closeInventory();
            }
        }

    }

    @Override
    public void setMenuItems() {
        inventory.setItem(3, CreateItem(ChatColor.GREEN + "Conferma", Material.GREEN_WOOL, 1, addConfirmLore(true)));
        inventory.setItem(5, CreateItem(ChatColor.RED + "Annulla", Material.RED_WOOL, 1, addConfirmLore(false)));
    }

    public String addConfirmLore(Boolean state){

        if (state){
            return addColor(ChatColor.GREEN, addBold("Clicca per confermare"));
        }else{
            return  addColor(ChatColor.RED, addBold("Clicca per Annullare"));
        }
    }
}
