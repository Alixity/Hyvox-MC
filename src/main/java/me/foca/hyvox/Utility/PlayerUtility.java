package me.foca.hyvox.Utility;

import me.foca.hyvox.Hyvox;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.profile.PlayerProfile;
import org.bukkit.profile.PlayerTextures;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.UUID;

public class PlayerUtility {

    public static void SetGod(Player player){
        if (player.hasPermission("hyvox.god")){

            String onMessage = Hyvox.instance.getConfig().getString("god-on-message");
            String offMessage = Hyvox.instance.getConfig().getString("god-off-message");



            if (!player.isInvulnerable()){
                player.setInvulnerable(true);
                player.setFoodLevel(20);
                player.setHealth(20);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', onMessage));

            }else{
                player.setInvulnerable(false);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', offMessage));
            }
        }else{
            StringUtility.SendCommandError(player, "god");
        }
    }
}
