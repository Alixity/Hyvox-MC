package me.foca.hyvox.VirtualPlugin.CropsEdit;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import static me.foca.hyvox.VirtualPlugin.CropsEdit.CropUtility.*;

public class CropsListener implements Listener {

    @EventHandler
    public void breakEvent(BlockBreakEvent e){
        Block block = e.getBlock();
        Player player = e.getPlayer();

        Material cropByType = null;

        switch (block.getType()){
            case WHEAT -> {
                cropByType = Material.WHEAT;
            }
            case BEETROOT -> {
                cropByType = Material.BEETROOT;
            }
            case POTATO -> {
                cropByType = Material.POTATO;
            }
        }

        if (cropByType != null && isFullyGrown(block)){
            Material seedType = getSeedMaterial(cropByType);

            if (isSeedInInventory(player, cropByType)){
                removeSeed(player, seedType);
                replantCrop(block.getLocation(), cropByType);
            }

        }

    }



}
