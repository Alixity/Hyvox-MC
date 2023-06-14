package me.foca.hyvox.VirtualPlugin.ServerUtility.Listener;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class ServerListener implements Listener {

    @EventHandler
    public void OnPlayerJoin(PlayerJoinEvent ev){
        Player pl = ev.getPlayer();

        if (pl.hasPlayedBefore()) {
            ev.setJoinMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + pl.getDisplayName() + ChatColor.GREEN + " e' entrato nel server :3");
        }
    }

    @EventHandler
    public void OnPlayerQuit(PlayerQuitEvent ev){
        Player pl = ev.getPlayer();

        ev.setQuitMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + pl.getDisplayName() + ChatColor.RED + " e' uscito dal server, speriamo di rivederlo presto");
    }
}
