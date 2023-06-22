package me.foca.hyvox.VirtualPlugin.PrivateCommands;

import me.foca.hyvox.Engine.CommandsManager.Interfaces.CommandsInterface;
import me.foca.hyvox.Engine.CommandsManager.SubCommands;
import me.foca.hyvox.VirtualPlugin.PrivateCommands.SubCommands.BypassCreativeCommands;
import me.foca.hyvox.VirtualPlugin.PrivateCommands.SubCommands.FocaKitCommand;
import me.foca.hyvox.VirtualPlugin.PrivateCommands.SubCommands.GetItemOnHeadCommands;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class PrivateCommandsManager implements CommandExecutor, CommandsInterface {

    private ArrayList<SubCommands> subCommands = new ArrayList<>();

    public PrivateCommandsManager(){
        subCommands.add(new BypassCreativeCommands());
        subCommands.add(new FocaKitCommand());
        subCommands.add(new GetItemOnHeadCommands());
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {


        if (sender instanceof Player player){

            // /priv

            if (strings.length > 0){
                for (int i = 0; i < getSubcommands().size(); i++){
                    if (strings[0].equalsIgnoreCase(getSubcommands().get(i).getName())){
                        getSubcommands().get(i).execute(player, strings);
                    }
                }
            }
        }


        return true;
    }

    @Override
    public ArrayList<SubCommands> getSubcommands() {
        return subCommands;
    }
}
