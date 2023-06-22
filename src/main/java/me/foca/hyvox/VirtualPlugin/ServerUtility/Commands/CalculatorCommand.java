package me.foca.hyvox.VirtualPlugin.ServerUtility.Commands;

import me.foca.hyvox.Utility.StringUtility;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Arrays;

public class CalculatorCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {

        if (commandSender instanceof Player player){

            if (args.length >= 2){

                int num1 = transformToInt(args[0]);
                String operator = args[1];
                int num2 = transformToInt(args[2]);
                player.sendMessage(StringUtility.addColor(ChatColor.GREEN, StringUtility.addBold(calculate(num1, operator, num2))));

            }else{
                player.sendMessage("error");
            }
        }

        return true;
    }

    public String calculate(int num1, String operator, int num2){
        int result;

        switch (operator){
            case "+" ->{
                result = num1 + num2;
            }
            case "-" ->{
                result = num1 - num2;
            }
            case "/" ->{
                result = num1 / num2;
            }
            case "*", "x" ->{
                result = num1 * num2;
            }
            default -> {
                result = -0;
            }
        }

        return trasformToString(result);
    }


    public int transformToInt(String value){
        return Integer.parseInt(value);
    }
    public String trasformToString(int value) {
        return String.valueOf(value);
    }
}
