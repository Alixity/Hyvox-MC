package me.foca.hyvox.VirtualPlugin.RankSystem.Commands;

import me.foca.hyvox.Utility.StringUtility;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TestCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (commandSender instanceof Player player){
            if (player.hasPermission("hyvox.*")){
                for(int i = 0; i < 5; i++){
                    player.sendMessage("test");
                }
            }else{
                StringUtility.SendCommandError(player, "*");
            }
        }

        return true;
    }
}
