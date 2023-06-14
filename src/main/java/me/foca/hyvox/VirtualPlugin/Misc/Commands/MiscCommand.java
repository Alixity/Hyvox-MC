package me.foca.hyvox.VirtualPlugin.Misc.Commands;

import me.foca.hyvox.Hyvox;
import me.foca.hyvox.VirtualPlugin.Misc.Menu.MiscMenu;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MiscCommand implements CommandExecutor {

    public Hyvox plugin;

    public MiscCommand(Hyvox plugin) {
        this.plugin = plugin;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if (sender instanceof Player p){

            new MiscMenu(Hyvox.getPlayerMenuUtility(p)).open();
        }


        return true;
    }
}
