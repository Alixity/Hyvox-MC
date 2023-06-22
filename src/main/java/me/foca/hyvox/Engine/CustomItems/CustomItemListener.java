package me.foca.hyvox.Engine.CustomItems;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;

public class CustomItemListener implements Listener {

    @EventHandler
    public void onPlayerDropItem(PlayerDropItemEvent ev){

        ItemStack droppedItem = (ItemStack) ev.getItemDrop();

        for (CustomItem item : CustomItem.Registered){
            if (droppedItem.getItemMeta().equals(item.meta)){
                item.whenPlayerDropItem(ev);
                return;
            }
        }
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent ev){

        ItemStack handItem = ev.getItemInHand();

        for (CustomItem item : CustomItem.Registered){
            if (item instanceof CustomBlock block){
                if (handItem.getItemMeta().equals(item.meta)){
                    block.onBlockPlace(ev);
                    if (block.preventBlockBePlaced())
                        ev.setCancelled(true);
                }
            }
        }
    }

}
