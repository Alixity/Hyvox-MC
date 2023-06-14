package me.foca.hyvox.VirtualPlugin.Staff.Commands;

import me.foca.hyvox.Hyvox;
import me.foca.hyvox.Utility.StringUtility;
import me.foca.hyvox.VirtualPlugin.Staff.Menu.StaffMenu;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StaffMenuCommands implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if (sender instanceof Player player){
            if (player.hasPermission("staffmenu")){
                new StaffMenu(Hyvox.getPlayerMenuUtility(player)).open();
            }
            else{
                StringUtility.SendCommandError(player, "staffmenu");
            }
        }
        return true;
    }
}
