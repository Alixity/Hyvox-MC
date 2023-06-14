package me.foca.hyvox.Utility;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.text.MessageFormat;

public class StringUtility {

    public static boolean SendCommandError(Player player, String permission){

        player.sendMessage(ChatColor.RED + "Non hai il permesso " + MessageFormat.format("(hyvox.{0})", permission) + " per eseguire questa azione");
        return true;
    }

    public static String addColor(ChatColor color, String string){
        return color + string;
    }

    public static String addBold(String string){
        return addColor(ChatColor.BOLD, string);
    }

    public static String addItalic(String string){
        return addColor(ChatColor.ITALIC, string);
    }

    public static String addPermission(String permissionName){
        return "hyvox." + permissionName;
    }
}
