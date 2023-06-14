package me.foca.hyvox.Engine.CustomMob;

import com.google.common.reflect.Reflection;
import com.google.j2objc.annotations.ReflectionSupport;
import me.foca.hyvox.Hyvox;
import org.bukkit.Location;
import org.bukkit.attribute.Attributable;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Mob;
import org.bukkit.entity.Zombie;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.reflections.Reflections;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Set;

public abstract class CustomMob {

    public CustomMob getType(){
        return this;
    }

    public static ArrayList<CustomMob> AvaiableCustomMob = new ArrayList<>();

    public static void RegisterCustomMob(){
        Reflections reflections = new Reflections("me.foca.hyvox.VirtualPlugin.CustomMob.Mob");
        Set<Class<? extends CustomMob>> customMobType = reflections.getSubTypesOf(me.foca.hyvox.Engine.CustomMob.CustomMob.class);

        for (Type type : customMobType){

            CustomMob customMob = (CustomMob) customMobType;
            if (customMob.TryRegister()){
                System.out.println(customMob.getMobName() + " Has been Registered");
            }
        }
    }

    private boolean TryRegister(){
        if (!AvaiableCustomMob.contains(this)){
            if (AvaiableCustomMob.stream().anyMatch(x -> x.getMobName() == getMobName())){
                System.out.println(getMobName() + " has register before... return false");
                return false;
            }

            AvaiableCustomMob.add(this);
            return true;
        }
        return false;
    }


    protected Mob mob;

    public CustomMob(Location location, Hyvox plugin){
        Mob spawn_mob = (Mob) location.getWorld().spawnEntity(location, getMobType());

        if (getMobName() != null) {
            spawn_mob.setCustomName(getMobName());
            spawn_mob.setCustomNameVisible(true);
        }

        spawn_mob.setGlowing(true);

        if (spawn_mob instanceof Zombie zombie && isBaby()){
            zombie.isBaby();
        }

        if (getArmor() != null){
            spawn_mob.getEquipment().setArmorContents(getArmor().toArray(new ItemStack[0]));
        }

        setAttribute(spawn_mob);
    }

    public abstract String getMobName();

    public abstract EntityType getMobType();

    public abstract ItemStack getMainHandItem();

    public abstract ArrayList<ItemStack> getArmor();

    public abstract boolean isBaby();

    public abstract void setAttribute(Mob mob);
}
