package me.foca.hyvox.VirtualPlugin.PrivateCommands.SubCommands;

import me.foca.hyvox.Engine.CommandsManager.SubCommands;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import javax.swing.*;

public class GetItemOnHeadCommands extends SubCommands {
    @Override
    public String getName() {
        return "gioh";
    }

    @Override
    public String getDescription() {
        return "impost any block u want on your head";
    }

    @Override
    public String getUsage() {
        return "/<command> <subCommand>";
    }

    @Override
    public void execute(Player sender, String[] args) {

        ItemStack item = sender.getItemInHand();

        if (item != null){
            sender.getInventory().setHelmet(item);
        }

    }
}
