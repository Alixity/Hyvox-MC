package me.foca.hyvox.Engine.CommandsManager.Interfaces;

import me.foca.hyvox.Engine.CommandsManager.SubCommands;

import java.util.ArrayList;

public interface CommandsInterface {

    ArrayList<SubCommands> subCommands = new ArrayList<>();

    ArrayList<SubCommands> getSubcommands();
}
