package me.foca.hyvox.VirtualPlugin.RankSystem;

import me.foca.hyvox.Engine.ConfigSystem.CustomConfig;
import me.foca.hyvox.Utility.StringUtility;
import me.foca.hyvox.VirtualPlugin.RankSystem.Enums.Rank;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class RankListener implements Listener {

    @EventHandler
    public void OnJoin(PlayerJoinEvent ev){
        Player player = ev.getPlayer();


        if (CustomConfig.getRankConfig().contains(player.getUniqueId().toString())){
            RankManager.removePermissions(player);
            RankManager.setPermissions(player);
        } else{
            RankManager.setRank(Rank.Member, player);
        }

        NameTagManager.setNametag(player);
        NameTagManager.newTag(player);
    }

    @EventHandler
    public void OnQuit(PlayerQuitEvent ev){
        NameTagManager.removeTag(ev.getPlayer());
    }

    @EventHandler
    public void OnChat(AsyncPlayerChatEvent ev){
        Player player = ev.getPlayer();
        String message = ev.getMessage();

        ev.setCancelled(true);
        Bukkit.broadcastMessage(RankManager.getRank(player).getPrefix() + StringUtility.addColor(ChatColor.WHITE, " | " + player.getDisplayName() + ": " + StringUtility.addColor(ChatColor.GRAY, message)));
    }

}
