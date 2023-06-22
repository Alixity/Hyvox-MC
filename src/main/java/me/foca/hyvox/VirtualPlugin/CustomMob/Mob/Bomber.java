package me.foca.hyvox.VirtualPlugin.CustomMob.Mob;

import me.foca.hyvox.Engine.CustomMob.CustomMob;
import me.foca.hyvox.Engine.MenuSystem.Menu;
import me.foca.hyvox.Hyvox;
import me.foca.hyvox.Utility.ItemUtils;
import me.foca.hyvox.Utility.StringUtility;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.attribute.Attributable;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.block.data.type.TNT;
import org.bukkit.entity.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;

public class Bomber extends CustomMob {

    @Override
    public String getMobName() {
        return StringUtility.addColor(ChatColor.RED, StringUtility.addBold("Bomber"));
    }

    @Override
    public EntityType getMobType() {
        return EntityType.ZOMBIE;
    }

    @Override
    public ItemStack getMainHandItem() {
        return new ItemStack(Material.FLINT_AND_STEEL);
    }

    @Override
    public ArrayList<ItemStack> getArmor() {

        ArrayList<ItemStack> temp = new ArrayList<>();

        temp.add(0, new ItemStack(Material.TNT));
        temp.add(1, new ItemStack(Material.DIAMOND_CHESTPLATE));
        temp.add(2, new ItemStack(Material.DIAMOND_LEGGINGS));
        temp.add(3, new ItemStack(Material.DIAMOND_BOOTS));


        return temp;
    }

    @Override
    public boolean isBaby() {
        return true;
    }

    @Override
    public void setAttribute(Mob mob) {

        Attributable mobAt = mob;

        AttributeInstance attribute = mobAt.getAttribute(Attribute.GENERIC_MAX_HEALTH);
        attribute.setBaseValue(200);
        mob.setHealth(100);

    }

    @Override
    public void MobChange(Mob mob) {
        if (mob instanceof Zombie zombie){
            zombie.setBaby();
            zombie.addScoreboardTag("test");
        }
    }

    @Override
    public void Coroutine(Mob mob) {
        var task = new BukkitRunnable() {
            @Override
            public void run() {

                if (mob.isDead())
                    return;

                if (mob.getTarget() == null)
                    for(Entity entity : mob.getNearbyEntities(10, 10, 10)){
                        if (entity instanceof Player target){

                            if (target.isInvulnerable())
                                continue;
                            mob.setTarget(target);
                        }
                    }

                mob.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 120,2));
                mob.getLocation().getWorld().spawnEntity(mob.getLocation(), EntityType.PRIMED_TNT);




            }
        }.runTaskTimer(Hyvox.instance, 100L, 100L);
    }
}
