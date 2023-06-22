package me.foca.hyvox.Engine.CustomMob;

import com.google.common.reflect.Reflection;
import com.google.j2objc.annotations.ReflectionSupport;
import me.foca.hyvox.Hyvox;
import org.bukkit.Location;
import org.bukkit.attribute.Attributable;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.*;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Set;

public abstract class CustomMob {

    public abstract String getMobName();

    public abstract EntityType getMobType();

    public abstract ItemStack getMainHandItem();

    public abstract ArrayList<ItemStack> getArmor();

    public abstract boolean isBaby();

    public abstract void setAttribute(Mob mob);
    public abstract void MobChange(Mob mob);

    public abstract void Coroutine(Mob mob);

    public void spawn(Location location){
        Mob spawn_mob = (Mob) location.getWorld().spawnEntity(location, getMobType());

        if (getMobName() != null) {
            spawn_mob.setCustomName(getMobName());
            spawn_mob.setCustomNameVisible(true);
        }

        spawn_mob.setGlowing(true);

        if (getArmor() != null){

            spawn_mob.getEquipment().setHelmet(getArmor().get(0));
            spawn_mob.getEquipment().setChestplate(getArmor().get(1));
            spawn_mob.getEquipment().setLeggings(getArmor().get(2));
            spawn_mob.getEquipment().setBoots(getArmor().get(3));
        }

        if (getMainHandItem() != null){
            spawn_mob.getEquipment().setItemInMainHand(getMainHandItem());
        }

        setAttribute(spawn_mob);
        MobChange(spawn_mob);

        Coroutine(spawn_mob);

    }
}
