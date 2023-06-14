package me.foca.hyvox.Engine.MenuSystem;

import org.bukkit.entity.Player;

public class PlayerMenuUtility {

    private Player owner;

    public PlayerMenuUtility(Player owner){
        this.owner = owner;
    }

    public Player GetOwner(){
        return owner;
    }

    public void SetOwner(Player owner){
        this.owner = owner;
    }

}
