package me.foca.hyvox.VirtualPlugin.Staff.Commands;

import me.foca.hyvox.Hyvox;
import me.foca.hyvox.Utility.PlayerUtility;
import me.foca.hyvox.Utility.StringUtility;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class FlyCommand implements CommandExecutor {

    private Hyvox plugin;



    public FlyCommand(Hyvox plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if (sender instanceof Player pl){
            PlayerUtility.MakeFly(pl);
        }
        return true;
    }
}
