package me.foca.hyvox.Engine.CustomItems;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public abstract class CustomTool extends CustomItem{
    public CustomTool(ItemStack base) {
        super(base);
    }
    public abstract boolean isUnbreakable();

    @Override
    public void internal_init() {

        if (isUnbreakable())
            meta.setUnbreakable(true);


        base.setItemMeta(meta);
        super.internal_init();
    }
}
