package me.foca.hyvox.VirtualPlugin.SpawnerUtility;

import me.foca.hyvox.Engine.CustomEvents.Events.DestroySpawnerEvent;
import org.bukkit.Material;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BlockStateMeta;

public class SpawnerUtilityListener implements Listener {

    @EventHandler
    public void OnPlayerBreakSpawner(DestroySpawnerEvent e){


       /* e.getPlayer().sendMessage( toString()e.getPlayer().getExp());

        if (e.getPlayer().getExp() > 125F){
            CreatureSpawner cs = (CreatureSpawner) e.getSpawner().getState();
            EntityType mob = cs.getSpawnedType();

            ItemStack spawner_to_give = new ItemStack(Material.SPAWNER);
            BlockStateMeta meta = (BlockStateMeta) spawner_to_give.getItemMeta();
            CreatureSpawner css = (CreatureSpawner) meta.getBlockState();

            css.setSpawnedType(cs.getSpawnedType());
            meta.setBlockState(css);
            spawner_to_give.setItemMeta(meta);

            e.getPlayer().getInventory().addItem(spawner_to_give);

            float removeExp = e.getPlayer().getExp() - 125F;

            e.getPlayer().setExp(removeExp);
        }*/

    }

}
