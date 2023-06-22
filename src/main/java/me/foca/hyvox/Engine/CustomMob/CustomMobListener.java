package me.foca.hyvox.Engine.CustomMob;

import me.foca.hyvox.Hyvox;
import me.foca.hyvox.Utility.StringUtility;
import me.foca.hyvox.VirtualPlugin.CustomMob.Mob.Bomber;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;

public class CustomMobListener implements Listener {

    public Hyvox plugin;

    public  CustomMobListener(Hyvox plugin){
        this.plugin = plugin;
    }


    @EventHandler
    public void OnInteract(PlayerInteractEvent e){

        Player player = e.getPlayer();
        Bomber bomber = new Bomber();

        if (e.getAction().equals(Action.RIGHT_CLICK_BLOCK) && e.getHand() != null && e.getHand() == EquipmentSlot.HAND &&
                e.getItem() != null && e.getItem().getItemMeta().getDisplayName().contains(bomber.getMobName())){

            Location spawnLocation;
            if(e.getClickedBlock().isPassable()){
                spawnLocation = e.getClickedBlock().getLocation().add(0.5, 0, 0.5);
            }else{
                spawnLocation = e.getClickedBlock().getRelative(e.getBlockFace()).getLocation().add(0.5, 0, 0.5);
            }

            bomber.spawn(spawnLocation);

            if (!player.getGameMode().equals(GameMode.CREATIVE)){
                e.getItem().setAmount(e.getItem().getAmount() - 1);
            }

            e.setCancelled(true);

        }

    }

}
