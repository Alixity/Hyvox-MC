package me.foca.hyvox.Engine.Models;

import me.foca.hyvox.VirtualPlugin.CustomItems.Backpack.Backpack;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;

public class BackpackData {

    private String uuid;
    private ItemStack[] items;

    public BackpackData(String uuid, ItemStack[] items){
        this.uuid = uuid;
        this.items = items;
    }
}
