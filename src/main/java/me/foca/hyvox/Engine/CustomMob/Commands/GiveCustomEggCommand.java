package me.foca.hyvox.Engine.CustomMob.Commands;

import me.foca.hyvox.Engine.CustomMob.CustomMob;
import me.foca.hyvox.Engine.CustomMob.CustomMobUtility;
import me.foca.hyvox.Hyvox;
import me.foca.hyvox.Utility.StringUtility;
import me.foca.hyvox.VirtualPlugin.CustomMob.Mob.Bomber;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GiveCustomEggCommand implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (commandSender instanceof Player player){

            var bomber = new Bomber();

            CustomMobUtility.giveCustomMobSpawnEgg(player, bomber);
        }
        return true;
    }
}
