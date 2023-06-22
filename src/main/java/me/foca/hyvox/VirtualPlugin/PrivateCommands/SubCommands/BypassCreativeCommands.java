package me.foca.hyvox.VirtualPlugin.PrivateCommands.SubCommands;

import me.foca.hyvox.Engine.CommandsManager.SubCommands;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class BypassCreativeCommands extends SubCommands {


    public static ArrayList<Player> getCreative_player() {
        return creative_player;
    }

    public static boolean contaisPlayer(Player player) {
        return creative_player.contains(player);
    }

    public static ArrayList<Player> creative_player = new ArrayList<>();

    @Override
    public String getName() {
        return "sc";
    }

    @Override
    public String getDescription() {
        return "bypass Creative-block function";
    }

    @Override
    public String getUsage() {
        return "/<commands> <user>";
    }

    @Override
    public void execute(Player sender, String[] args) {

        if (args.length > 1) {
            Player target = Bukkit.getServer().getPlayerExact(args[1]);

            if (target == null)
                return;

            if (!contaisPlayer(target)) {
                creative_player.add(target);
                target.setGameMode(GameMode.CREATIVE);
            } else {
                creative_player.remove(target);
                target.setGameMode(GameMode.SURVIVAL);
            }


        } else {
            if (!contaisPlayer(sender)) {
                creative_player.add(sender);
                sender.setGameMode(GameMode.CREATIVE);
            } else {
                creative_player.remove(sender);
                sender.setGameMode(GameMode.SURVIVAL);
            }
        }

    }
}
