package me.foca.hyvox.Engine.CommandsManager;

import org.bukkit.entity.Player;

public abstract class SubCommands {

    public abstract String getName();

    public abstract String getDescription();

    public abstract String getUsage();

    public abstract void execute(Player sender, String[] args);

}
