package me.foca.hyvox.VirtualPlugin.CustomMob.Mob;

import me.foca.hyvox.Engine.CustomMob.CustomMob;
import me.foca.hyvox.Hyvox;
import me.foca.hyvox.Utility.StringUtility;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.attribute.Attributable;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Mob;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class Bomber extends CustomMob {
    public Bomber(Location location, Hyvox plugin) {
        super(location, plugin);
    }

    @Override
    public String getMobName() {
        return StringUtility.addColor(ChatColor.RED, "LA MAMMA DI BILLY");
    }

    @Override
    public EntityType getMobType() {
        return EntityType.PIG;
    }

    @Override
    public ItemStack getMainHandItem() {
        return null;
    }

    @Override
    public ArrayList<ItemStack> getArmor() {
        return null;
    }

    @Override
    public boolean isBaby() {
        return true;
    }

    @Override
    public void setAttribute(Mob mob) {
    }
}
