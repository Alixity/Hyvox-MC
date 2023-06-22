package me.foca.hyvox.Engine.CustomEvents.Events;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class CustomEventListener implements Listener {

    @EventHandler
    public void OnPlayerBreakSpawner(BlockBreakEvent e){

        if (e.getBlock().getType().equals(Material.SPAWNER)){
            Bukkit.getServer().getPluginManager().callEvent(new DestroySpawnerEvent(e.getPlayer(), e.getBlock()));
        }

    }

}
