package me.foca.hyvox.VirtualPlugin.PrivateCommands.SubCommands;

import me.foca.hyvox.Engine.CommandsManager.SubCommands;
import me.foca.hyvox.Engine.CustomItems.CustomItem;
import me.foca.hyvox.Utility.StringUtility;
import me.foca.hyvox.VirtualPlugin.CustomItems.Tools.FocaTools.FocaPickaxe;
import me.foca.hyvox.VirtualPlugin.CustomItems.Tools.FocaTools.TheGodCarrot;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class FocaKitCommand extends SubCommands {

    public ArrayList<CustomItem> items = new ArrayList<>();

    public void init(){
        ArrayList<CustomItem> tempList = new ArrayList<>();

        tempList.add(0, new FocaPickaxe(new ItemStack(Material.NETHERITE_PICKAXE)));
        tempList.add(1,new TheGodCarrot(new ItemStack(Material.GOLDEN_CARROT)));
        /*tempList.add(2,makeFocaShovel());
        tempList.add(3,makeFocaBow());
        tempList.add(4,makeFocaHelmet());
        tempList.add(5,makeFocaChestplate());
        tempList.add(6,makeFocaLeggins());
        tempList.add(7,makeFocaBoots());
        tempList.add(8,new ItemStack(Material.ARROW, 1));
        tempList.add(9, giveFocaFood());*/
        items.addAll(tempList);
    }



    @Override
    public String getName() {
        return "foca";
    }

    @Override
    public String getDescription() {
        return "get foca base-kit";
    }

    @Override
    public String getUsage() {
        return "/<commands> <foca> <type>";
    }

    @Override
    public void execute(Player sender, String[] args) {

        init();

        if (args.length > 1){

            switch (args[1]){
                case "food" ->{
                    CustomItem theGodCarrot = CustomItem.getByKey("foca_carrot");
                    sender.getInventory().addItem(theGodCarrot.base);
                }
                case "armor" ->{
                    sender.getInventory().addItem(makeFocaHelmet());
                    sender.getInventory().addItem(makeFocaChestplate());
                    sender.getInventory().addItem(makeFocaLeggins());
                    sender.getInventory().addItem(makeFocaBoots());
                }
                case "utils" ->{
                    sender.getInventory().addItem(makeFocaPickaxe());
                    sender.getInventory().addItem(makeFocaAxe());
                    sender.getInventory().addItem(makeFocaShovel());
                    sender.getInventory().addItem(makeFocaBow());
                    sender.getInventory().addItem(new ItemStack(Material.ARROW));
                }
                case "pickaxe", "shovel", "axe", "bow", "sword" -> {

                    String choice = "foca_" + args[1];

                    CustomItem customItem = CustomItem.getByKey(choice);
                    sender.getInventory().addItem(customItem.base);

                }
            }
        }else{

            items.forEach(x -> sender.getInventory().addItem(x.base));
        }

    }


    public ItemStack makeFocaHelmet(){
        ItemStack item = new ItemStack(Material.DIAMOND_HELMET);
        ItemMeta meta = item.getItemMeta();

        meta.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 4, true);
        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL,4, true);
        meta.addEnchant(Enchantment.PROTECTION_FIRE, 4, true);
        meta.addEnchant(Enchantment.OXYGEN, 4, true);
        meta.addEnchant(Enchantment.VANISHING_CURSE, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        meta.setUnbreakable(true);
        meta.setDisplayName(StringUtility.addColor(ChatColor.DARK_PURPLE, "NULL"));

        item.setItemMeta(meta);

        return item;
    }

    public ItemStack makeFocaChestplate(){
        ItemStack item = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta meta = item.getItemMeta();

        meta.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 4, true);
        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL,4, true);
        meta.addEnchant(Enchantment.PROTECTION_FIRE, 4, true);
        meta.addEnchant(Enchantment.VANISHING_CURSE, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        meta.setUnbreakable(true);
        meta.setDisplayName(StringUtility.addColor(ChatColor.DARK_PURPLE, "NULL"));

        item.setItemMeta(meta);

        return item;
    }

    public ItemStack makeFocaLeggins(){
        ItemStack item = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemMeta meta = item.getItemMeta();

        meta.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 4, true);
        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL,4, true);
        meta.addEnchant(Enchantment.PROTECTION_FIRE, 4, true);
        meta.addEnchant(Enchantment.VANISHING_CURSE, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        meta.setUnbreakable(true);
        meta.setDisplayName(StringUtility.addColor(ChatColor.DARK_PURPLE, "NULL"));

        item.setItemMeta(meta);

        return item;
    }

    public ItemStack makeFocaBoots(){
        ItemStack item = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta meta = item.getItemMeta();

        meta.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 4, true);
        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL,4, true);
        meta.addEnchant(Enchantment.PROTECTION_FIRE, 4, true);
        meta.addEnchant(Enchantment.PROTECTION_FALL, 4, true);
        meta.addEnchant(Enchantment.VANISHING_CURSE, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        meta.setUnbreakable(true);
        meta.setDisplayName(StringUtility.addColor(ChatColor.DARK_PURPLE, "NULL"));

        item.setItemMeta(meta);

        return item;
    }


    public ItemStack makeFocaShovel(){
        ItemStack item = new ItemStack(Material.DIAMOND_SHOVEL);
        ItemMeta meta = item.getItemMeta();

        meta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 3, true);
        meta.addEnchant(Enchantment.DIG_SPEED, 4, true);
        meta.addEnchant(Enchantment.VANISHING_CURSE, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);

        meta.setUnbreakable(true);
        meta.setDisplayName(StringUtility.addColor(ChatColor.DARK_PURPLE, "NULL"));
        item.setItemMeta(meta);

        return item;
    }

    public ItemStack makeFocaAxe(){
        ItemStack item = new ItemStack(Material.NETHERITE_AXE);
        ItemMeta meta = item.getItemMeta();

        meta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 3, true);
        meta.addEnchant(Enchantment.DIG_SPEED, 4, true);
        meta.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
        meta.addEnchant(Enchantment.LOOT_BONUS_MOBS, 3, true);
        meta.addEnchant(Enchantment.FIRE_ASPECT, 3, true);
        meta.addEnchant(Enchantment.VANISHING_CURSE, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);

        meta.setUnbreakable(true);
        meta.setDisplayName(StringUtility.addColor(ChatColor.DARK_PURPLE, "NULL"));

        item.setItemMeta(meta);

        return item;

    }

    public ItemStack makeFocaBow(){
        ItemStack item = new ItemStack(Material.BOW);

        ItemMeta meta = item.getItemMeta();

        meta.addEnchant(Enchantment.ARROW_INFINITE, 1, false);
        meta.addEnchant(Enchantment.ARROW_FIRE, 1, false);
        meta.addEnchant(Enchantment.DAMAGE_ALL, 2, false);
        meta.addEnchant(Enchantment.VANISHING_CURSE, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta.setDisplayName(StringUtility.addColor(ChatColor.DARK_PURPLE, "NULL"));



        meta.setUnbreakable(true);
        item.setItemMeta(meta);


        return item;
    }

    public ItemStack makeFocaPickaxe(){
        ItemStack item = new ItemStack(Material.NETHERITE_PICKAXE);

        ItemMeta meta = item.getItemMeta();

        meta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 5, true);
        meta.addEnchant(Enchantment.DIG_SPEED, 4, true);
        meta.addEnchant(Enchantment.VANISHING_CURSE, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta.setDisplayName(StringUtility.addColor(ChatColor.DARK_PURPLE, "NULL"));



        meta.setUnbreakable(true);
        item.setItemMeta(meta);


        return item;
    }

    public static ItemStack giveFocaFood(){
        ItemStack item = new ItemStack(Material.GOLDEN_CARROT, 1);

        ItemMeta meta = item.getItemMeta();

        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);

        item.setItemMeta(meta);


        return item;
    }
}
