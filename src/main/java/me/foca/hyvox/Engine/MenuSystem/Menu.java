package me.foca.hyvox.Engine.MenuSystem;

import me.foca.hyvox.Hyvox;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class Menu implements InventoryHolder {

    protected Inventory inventory;

    protected PlayerMenuUtility playerMenuUtility;

    protected ItemStack Null_Item = new ItemStack(new ItemStack(Material.BLACK_STAINED_GLASS_PANE, 1));

    public Menu(PlayerMenuUtility playerMenuUtility){
        this.playerMenuUtility = playerMenuUtility;
    }

    public abstract String getMenuName();

    public abstract int getSlots();

    public abstract void handleMenu(InventoryClickEvent ev);

    public abstract void setMenuItems();

    public void open(){
        inventory = Bukkit.createInventory(this, getSlots(), getMenuName());

        this.setMenuItems();
        this.FillWithNullItem();

        playerMenuUtility.GetOwner().openInventory(inventory);
    }

    public void FillWithNullItem(){
        for (int i = 0; i < getSlots(); i++){
            if (inventory.getItem(i) == null)
                inventory.setItem(i, setEmptySlotItem());

        }
    }

    public ItemStack CreateItem(@NonNull String DisplayName, @NonNull Material material, int amount, @Nullable String... lore){

        if (amount < 0)
            amount = 1;
        ItemStack item = new ItemStack(material, amount);
        ItemMeta itemMeta = item.getItemMeta();

        itemMeta.setDisplayName(DisplayName);
        itemMeta.setLore(Arrays.stream(lore).toList());

        item.setItemMeta(itemMeta);
        return item;

    }
    public ItemStack CreateItem(@NonNull String DisplayName, @NonNull Material material, int amount, ArrayList<String> lore){

        if (amount < 0)
            amount = 1;
        ItemStack item = new ItemStack(material, amount);
        ItemMeta itemMeta = item.getItemMeta();

        itemMeta.setDisplayName(DisplayName);
        itemMeta.setLore(lore);

        item.setItemMeta(itemMeta);
        return item;

    }

    @Override
    public Inventory getInventory() {
        return inventory;
    }


    public Boolean isNullItem(ItemStack Item){
        return Item == Null_Item;
    }

    public PlayerMenuUtility getPlayerMenuUtility(Player player){
        return Hyvox.getPlayerMenuUtility(player);
    }

    public ItemStack setEmptySlotItem(){
        ItemStack empty_item = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
        ItemMeta empty_itemMeta = empty_item.getItemMeta();


        empty_itemMeta.setDisplayName(" ");
        empty_item.setItemMeta(empty_itemMeta);

        return  empty_item;
    }
}
