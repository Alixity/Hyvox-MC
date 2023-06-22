package me.foca.hyvox.Engine.CustomItems;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public abstract class CustomBlock extends CustomItem {

    public CustomBlock(ItemStack base) {
        super(base);
    }


    public abstract boolean preventBlockBePlaced();
    public void onBlockPlace(BlockPlaceEvent e){

        if (preventBlockBePlaced()){
            e.setCancelled(true);
        }
    }



}
