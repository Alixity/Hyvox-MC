package me.foca.hyvox.Engine.CustomEvents.Events;

import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class DestroySpawnerEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    private Player player;
    private Block spawner;

    public DestroySpawnerEvent(Player player, Block spawner) {
        this.player = player;
        this.spawner = spawner;
    }


    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList(){
        return handlers;
    }

    public Player getPlayer(){
        return player;
    }

    public Block getSpawner(){
        return spawner;
    }
}
