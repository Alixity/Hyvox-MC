package me.foca.hyvox;

import me.foca.hyvox.Engine.ConfigSystem.CustomConfig;
import me.foca.hyvox.VirtualPlugin.RankSystem.Commands.SetRankCommand;
import me.foca.hyvox.VirtualPlugin.RankSystem.Commands.TestCommand;
import me.foca.hyvox.VirtualPlugin.RankSystem.RankListener;
import me.foca.hyvox.VirtualPlugin.ServerUtility.Listener.ServerListener;
import me.foca.hyvox.VirtualPlugin.Staff.Commands.FlyCommand;
import me.foca.hyvox.VirtualPlugin.Staff.Commands.GodCommand;
import me.foca.hyvox.VirtualPlugin.Misc.Commands.MiscCommand;
import me.foca.hyvox.VirtualPlugin.Staff.Commands.StaffMenuCommands;
import me.foca.hyvox.VirtualPlugin.Utility.Commands.UtilityCommands;
import me.foca.hyvox.VirtualPlugin.Misc.MiscListener;
import me.foca.hyvox.Listeners.PlayerListener;
import me.foca.hyvox.Engine.MenuSystem.MenuListener;
import me.foca.hyvox.Engine.MenuSystem.PlayerMenuUtility;
import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.UUID;

public final class Hyvox extends JavaPlugin {

    private static final HashMap<Player, PlayerMenuUtility> playerMenuUtilityMap = new HashMap<>();
    private static HashMap<UUID, PermissionAttachment> Permissions = new HashMap<>();

    public static Hyvox instance;

    @Override
    public void onEnable() {
        System.out.println("Hyvox - " + getServer().getVersion());
        instance = this;
        RegisterConfigs();

        RegisterListener();
        RegisterCommands();
    }

    @Override
    public void onDisable() {
        System.out.println("Addio");
        instance = null;
        Permissions.clear();
        // Plugin shutdown logic
    }

    public void RegisterConfigs(){
        getConfig().options().copyDefaults();
        saveDefaultConfig();


        CustomConfig.setup();
        CustomConfig.getRankConfig().options().copyDefaults(true);
        CustomConfig.saveRankConfig();
    }


    public void RegisterCommands(){
        System.out.println("Registrazione Comandi");
        getCommand("fly").setExecutor(new FlyCommand(this));
        getCommand("god").setExecutor(new GodCommand());
        getCommand("misc").setExecutor(new MiscCommand(this));
        getCommand("utility").setExecutor(new UtilityCommands());
        getCommand("staff").setExecutor(new StaffMenuCommands());
        getCommand("setrank").setExecutor(new SetRankCommand());
        getCommand("test").setExecutor(new TestCommand());
        System.out.println("Conclusa");

    }

    public void RegisterListener(){
        System.out.println("Registrazione Listener");
        getServer().getPluginManager().registerEvents(new PlayerListener(), this);
        getServer().getPluginManager().registerEvents(new ServerListener(), this);
        getServer().getPluginManager().registerEvents(new MiscListener(), this);
        getServer().getPluginManager().registerEvents(new MenuListener(), this);
        getServer().getPluginManager().registerEvents(new RankListener(), this);
        System.out.println("Conclusa");
    }

    public static PlayerMenuUtility getPlayerMenuUtility(Player p){
        PlayerMenuUtility playerMenuUtility;

        if (playerMenuUtilityMap.containsKey(p)){
            return playerMenuUtilityMap.get(p);
        }else{
            playerMenuUtility = new PlayerMenuUtility(p);
            playerMenuUtilityMap.put(p, playerMenuUtility);
            return playerMenuUtility;
        }
    }

    public static HashMap<UUID, PermissionAttachment> getPerm(){
        return Permissions;
    }
}
