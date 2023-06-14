package me.foca.hyvox.Engine.CustomMob.Commands;

import me.foca.hyvox.Engine.CustomMob.CustomMob;
import me.foca.hyvox.Engine.CustomMob.CustomMobUtility;
import me.foca.hyvox.Utility.StringUtility;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GiveCustomEggCommand implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (commandSender instanceof Player player){
            if (strings.length == 1){

            }else{
                player.sendMessage(StringUtility.addColor(ChatColor.RED, "usage: /<command> <CustomMob>"));
                player.sendMessage(getCustomMob());
            }
        }
        return true;
    }

    private String getCustomMob(){
        StringBuilder builder = new StringBuilder("CustomMob Disponibili:\n");

        for (CustomMob mob : CustomMob.AvaiableCustomMob){
            builder.append(mob.getMobName() + ",\n");
        }

        return builder.toString();
    }
}
