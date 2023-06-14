package me.foca.hyvox.VirtualPlugin.Staff.Commands;

import me.foca.hyvox.Hyvox;
import me.foca.hyvox.Utility.StringUtility;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class FlyCommand implements CommandExecutor {

    private Hyvox plugin;
    private ArrayList<Player> Player_With_Fly = new ArrayList<>();


    public FlyCommand(Hyvox plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if (sender instanceof Player pl){
            MakeFly(pl);
        }
        return true;
    }


    private void MakeFly(Player player){
        if (player.hasPermission("hyvox.fly")){

            String onMessage = plugin.getConfig().getString("fly-on-message");
            String offMessage = plugin.getConfig().getString("fly-off-message");

            if (!Player_With_Fly.contains(player)){
                Player_With_Fly.add(player);
                player.setAllowFlight(true);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', onMessage));
            }
            else{
                Player_With_Fly.remove(player);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', offMessage));
                player.setAllowFlight(false);
                player.setArrowsInBody(10);
            }
        }
        else{
            StringUtility.SendCommandError(player, "fly");
        }
    }
}
