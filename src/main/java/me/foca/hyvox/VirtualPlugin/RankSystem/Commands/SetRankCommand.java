package me.foca.hyvox.VirtualPlugin.RankSystem.Commands;

import static me.foca.hyvox.Utility.StringUtility.*;

import me.foca.hyvox.Utility.StringUtility;
import me.foca.hyvox.VirtualPlugin.RankSystem.Enums.Rank;
import me.foca.hyvox.VirtualPlugin.RankSystem.RankManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import javax.security.auth.kerberos.KerberosTicket;


public class SetRankCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (commandSender instanceof Player player){
            if (strings.length == 2){
                if (Bukkit.getPlayer(strings[0]) != null){
                    Player target = Bukkit.getPlayer(strings[0]);

                    setRankByCommand(strings[1], player, target);

                }else{
                    player.sendMessage(addColor(ChatColor.RED, "Player non trovato"));
                }
            }else{
                player.sendMessage(addColor(ChatColor.RED, "Usa: /setrank <player> <rank>"));
            }
        }

        return true;
    }


    private void setRankByCommand(String value, Player staffPlayer, Player target){
        switch (value){
            case "owner" -> {
                RankManager.setRank(Rank.Owner, target);
                target.sendMessage(showRankAquireMessage(staffPlayer, target));
            }
            case "admin" -> {
                RankManager.setRank(Rank.Admin, target);
                target.sendMessage(showRankAquireMessage(staffPlayer, target));
            }
            case "moderator" -> {
                RankManager.setRank(Rank.Moderator, target);
                target.sendMessage(showRankAquireMessage(staffPlayer, target));
            }
            case "member" -> {
                RankManager.setRank(Rank.Member, target);
                target.sendMessage(showRankAquireMessage(staffPlayer, target));
            }
            default -> {
                staffPlayer.sendMessage(showRankOption());
            }
        }

    }

    private String showRankOption(){
        StringBuilder builder = new StringBuilder(addBold(addColor(ChatColor.RED, "Rank Disponibili:\n")));

        for (Rank rank : Rank.values()){
            builder.append(rank.getPrefix().toLowerCase() + ", ");
        }

        return builder.toString();
    }

    private String showRankAquireMessage(Player staffPlayer, Player target){
        return addColor(ChatColor.GREEN, "ti e' appena stata assegnato il rank \"" + addBold(RankManager.getRank(target).getPrefix()) + addColor(ChatColor.GREEN, "\" da: ") + addBold(staffPlayer.getDisplayName()));
    }
}
