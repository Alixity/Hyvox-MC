package me.foca.hyvox.VirtualPlugin.Staff.Menu;

import me.foca.hyvox.Engine.MenuSystem.Menu;
import me.foca.hyvox.Engine.MenuSystem.PlayerMenuUtility;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.ArrayList;

public class PlayerListMenu extends Menu {

    public PlayerListMenu(PlayerMenuUtility playerMenuUtility) {
        super(playerMenuUtility);
    }

    @Override
    public String getMenuName() {
        return ChatColor.AQUA + "Player List";
    }

    @Override
    public int getSlots() {
        return 45;
    }

    @Override
    public void handleMenu(InventoryClickEvent ev) {

        Player staffPlayer = (Player) ev.getWhoClicked();

        switch (ev.getCurrentItem().getType()){
            case PLAYER_HEAD -> {
                staffPlayer.closeInventory();
                new PlayerOptionMenu(getPlayerMenuUtility(staffPlayer), staffPlayer, staffPlayer.getServer().getPlayer(ev.getCurrentItem().getItemMeta().getDisplayName())).open();
            }
        }


    }

    @Override
    public void setMenuItems() {

        ArrayList<Player> playerList = new ArrayList<>(Bukkit.getServer().getOnlinePlayers());

        for (int i = 0; i < playerList.size(); i++){

            var indexPlayer = playerList.get(i);

            inventory.setItem(i, CreateItem(indexPlayer.getDisplayName(), Material.PLAYER_HEAD, 1, setPlayerHeadLore()));
        }
    }

    @Override
    public boolean preventFromTakeItem() {
        return true;
    }

    @Override
    public boolean preventCreatingNullItem() {
        return false;
    }

    public static ArrayList<String> setPlayerHeadLore(){
        ArrayList<String> lore = new ArrayList<>();

        ArrayList<Player> playerList = new ArrayList<>(Bukkit.getServer().getOnlinePlayers());

        for (Player indexPlayer : playerList) {

            lore.add(ChatColor.LIGHT_PURPLE + "Player Health: " + indexPlayer.getHealth());
            lore.add(ChatColor.GREEN + "Exp: " + indexPlayer.getExp());
            lore.add(ChatColor.GOLD + "Ip: " + indexPlayer.getAddress().getAddress());
        }

        return  lore;
    }
}
