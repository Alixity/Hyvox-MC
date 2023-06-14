package me.foca.hyvox.VirtualPlugin.Utility.Commands;

import me.foca.hyvox.Hyvox;
import me.foca.hyvox.VirtualPlugin.Utility.Menu.UtilityMenu;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class UtilityCommands implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if (sender instanceof Player player){
            new UtilityMenu(Hyvox.getPlayerMenuUtility(player)).open();
        }

        return true;
    }
}
