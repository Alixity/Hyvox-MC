package me.foca.hyvox.VirtualPlugin.Staff.Commands;

import me.foca.hyvox.Hyvox;
import me.foca.hyvox.Utility.StringUtility;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

import static me.foca.hyvox.Utility.PlayerUtility.SetGod;

public class GodCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if (sender instanceof Player pl){
            SetGod(pl);
        }
        return true;
    }
}
