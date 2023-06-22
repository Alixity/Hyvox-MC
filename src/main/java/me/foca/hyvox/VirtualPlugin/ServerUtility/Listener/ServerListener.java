package me.foca.hyvox.VirtualPlugin.ServerUtility.Listener;

import me.foca.hyvox.Engine.CustomItems.CustomItem;
import me.foca.hyvox.Utility.StringUtility;
import me.foca.hyvox.VirtualPlugin.PrivateCommands.SubCommands.BypassCreativeCommands;
import me.foca.hyvox.VirtualPlugin.PrivateCommands.SubCommands.FocaKitCommand;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.*;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

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

    @EventHandler
    public void onPlayerChangeGameMode(PlayerGameModeChangeEvent ev){
        Player player = ev.getPlayer();
        GameMode gameMode = ev.getNewGameMode();

        if (BypassCreativeCommands.contaisPlayer(player))
            return;



        if (gameMode.equals(GameMode.CREATIVE) || gameMode.equals(GameMode.ADVENTURE) || gameMode.equals(GameMode.SPECTATOR)){
            ev.setCancelled(true);
            player.sendMessage(StringUtility.addColor(ChatColor.RED, "Hai provato a barare e mo subirai le conseguenze..."));

            double pHealth = player.getHealth();

            if (pHealth > 5){
                player.damage(1);
                player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 100, 1, true, true, true));
                player.setHealth(pHealth);
            }
        }
    }


    @EventHandler
    public void OnPlayerEating(PlayerItemConsumeEvent e){
        Player player = e.getPlayer();
        CustomItem _carrot = CustomItem.getByKey("foca_carrot");

        if (e.getItem().equals(_carrot.base)){
            player.setFoodLevel(20);
            e.setCancelled(true);
        }
    }

}
