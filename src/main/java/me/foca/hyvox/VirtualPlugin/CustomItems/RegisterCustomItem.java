package me.foca.hyvox.VirtualPlugin.CustomItems;

import me.foca.hyvox.Engine.CustomItems.CustomItem;
import me.foca.hyvox.VirtualPlugin.CustomItems.Backpack.LeatherBackpack.LeatherBackpack;
import me.foca.hyvox.VirtualPlugin.CustomItems.Tools.FocaTools.FocaPickaxe;
import me.foca.hyvox.VirtualPlugin.CustomItems.Tools.FocaTools.FocaSword;
import me.foca.hyvox.VirtualPlugin.CustomItems.Tools.FocaTools.TheGodCarrot;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class RegisterCustomItem {

    public RegisterCustomItem() {
        CustomItem.Registered.add(new TheGodCarrot(new ItemStack(Material.GOLDEN_CARROT)));
        CustomItem.Registered.add(new FocaPickaxe(new ItemStack(Material.NETHERITE_PICKAXE)));
        CustomItem.Registered.add(new FocaSword(new ItemStack(Material.NETHERITE_SWORD)));
        CustomItem.Registered.add(new LeatherBackpack(new ItemStack(Material.CHEST)));
    }
}
