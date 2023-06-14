package me.foca.hyvox.VirtualPlugin.Misc;

import com.google.errorprone.annotations.Var;
import me.foca.hyvox.Hyvox;
import me.foca.hyvox.Utility.ItemUtils;
import me.foca.hyvox.Utility.MiscUtils;
import me.foca.hyvox.VirtualPlugin.Misc.Menu.MiscMenu;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class MiscListener implements Listener {


    @EventHandler
    public void OnTeleportArrowLand(ProjectileHitEvent ev){
        if (ev.getEntity().getType() == EntityType.ARROW && ev.getEntity().getShooter() instanceof Player player){
            ItemStack itemInMainHand = player.getInventory().getItemInMainHand();

            if (ItemUtils.CheckItemByName(itemInMainHand, ChatColor.GREEN + "" + ChatColor.BOLD + "Teleport Bow") ||
                    player.getInventory().contains(MiscUtils.CreateTeleportArrow())){

                player.teleport(ev.getEntity().getLocation());
                ev.getEntity().remove();
                player.playSound(player, Sound.ENTITY_DRAGON_FIREBALL_EXPLODE, 1.0f, 1.0f);
                player.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "Tua madre troia");
            }
        }
    }

    @EventHandler
    public void OnPlayerDrop(PlayerDropItemEvent ev){
        Item item = ev.getItemDrop();

        if (ItemUtils.CheckItemByName(item.getItemStack(), MiscMenu.Bow) || ItemUtils.CheckItemByName(item.getItemStack(), MiscMenu.Arrow)){
            item.remove();
        }
    }
}
