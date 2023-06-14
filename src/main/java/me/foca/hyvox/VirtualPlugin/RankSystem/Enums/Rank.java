package me.foca.hyvox.VirtualPlugin.RankSystem.Enums;
import org.bukkit.ChatColor;

import static me.foca.hyvox.Utility.StringUtility.*;

public enum Rank {

    Owner(addColor(ChatColor.RED, "Owner"), new String[]{addPermission("*")}),
    Admin(addColor(ChatColor.AQUA, "Admin"), new String[]{addPermission("admin")}),
    Moderator(addColor(ChatColor.GREEN, "Moderator"), new String[]{addPermission("moderator")}),
    Member(addColor(ChatColor.GRAY, "Membro"), new String[]{addPermission("user")});

    private String prefix;
    private String[] permission;

    Rank(String prefix, String[] permission){
        this.prefix = prefix;
        this.permission = permission;
    }

    public String getPrefix(){
        return prefix;
    }

    public String[] getPermission(){
        return  permission;
    }
}
