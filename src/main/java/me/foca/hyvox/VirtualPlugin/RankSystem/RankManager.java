package me.foca.hyvox.VirtualPlugin.RankSystem;

import me.foca.hyvox.Engine.ConfigSystem.CustomConfig;
import me.foca.hyvox.Hyvox;
import me.foca.hyvox.VirtualPlugin.RankSystem.Enums.Rank;
import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionAttachment;

public class RankManager {

    public static void setRank(Rank rank, Player player){
        CustomConfig.getRankConfig().set(player.getUniqueId().toString(), rank.name());
        CustomConfig.saveRankConfig();

        if (CustomConfig.getRankConfig().contains(player.getUniqueId().toString()))
            removePermissions(player);

        setPermissions(player);
        NameTagManager.setNametag(player);
        NameTagManager.newTag(player);
    }

    public static Rank getRank(Player player){
        return Rank.valueOf(CustomConfig.getRankConfig().getString(player.getUniqueId().toString()));
    }

    public static void setPermissions(Player player){
        PermissionAttachment attachment = player.addAttachment(Hyvox.instance);
        if (!Hyvox.getPerm().containsKey(player.getUniqueId()))
            Hyvox.getPerm().put(player.getUniqueId(), attachment);

        var rank = getRank(player);

        for (String perm : rank.getPermission()){
            attachment.setPermission(perm, true);
        }
    }

    public static void removePermissions(Player player){
        var rank = getRank(player);

        for (String perm : rank.getPermission()){
            if (Hyvox.getPerm().containsKey(player.getUniqueId()))
                Hyvox.getPerm().get(player.getUniqueId()).unsetPermission(perm);
        }
    }
}
