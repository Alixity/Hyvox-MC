package me.foca.hyvox.Engine.CustomItems;

import jdk.jfr.Description;
import me.foca.hyvox.Engine.Log.Log;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.PluginLogger;

import java.lang.annotation.Documented;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class CustomItem {

    public static ArrayList<CustomItem> Registered = new ArrayList();

    public CustomItem(ItemStack base) {
        this.base = base;
        meta = base.getItemMeta();

        internal_init();
    }

    public ItemStack base;
    public ItemMeta meta;

    public abstract String getName();

    public abstract String getKey();

    public abstract ArrayList<String> addLore();
    public abstract ArrayList<ItemFlag> addItemFlag();

    public abstract HashMap<Enchantment, Integer> addEnchant();

    public abstract boolean preventFromDropping();

    public void whenPlayerDropItem(PlayerDropItemEvent e){
        if (preventFromDropping()){
            e.setCancelled(true);
        }
    }

    public abstract void registerCustomRecipe();

    public void internal_init(){

        meta.setDisplayName(getName());

        meta.setLore(addLore());



        if (addItemFlag() != null){
            addItemFlag().forEach(x -> meta.addItemFlags(x));
        }

        if (addEnchant() != null){
            addEnchant().forEach((k,v) -> meta.addEnchant(k, v, true));
        }

        base.setItemMeta(meta);

        try{
            registerCustomRecipe();
        } catch (Exception e) {
            Log.error("Impossibile creare i custom recipe per (" + getKey() + ")");
        }

    }


    public static CustomItem getByKey(String key){

        CustomItem _item = null;

        for (CustomItem customItem : Registered){
            if (customItem.getKey().equals(key)){
                _item = customItem;
            }
        }

        return _item;
    }

    public static CustomItem getByType(ItemStack item){

        CustomItem _item = null;

       for (CustomItem customItem : Registered){
           if (customItem.meta.equals(item.getItemMeta()))
               _item = customItem;
       }

        return _item;

    }

    public static CustomItem getByName(String name){
        CustomItem customItem = null;

      for (CustomItem _customItem : Registered){
          if (_customItem.getName().equals(name))
              customItem = _customItem;
      }

      return customItem;
    };
}
