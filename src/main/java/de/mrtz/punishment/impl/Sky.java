package de.mrtz.punishment.impl;

import de.mrtz.punishment.Punishment;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class Sky extends Punishment
{
    @Override
    public String getName()
    {
        return "Sky";
    }

    @Override
    public String getDescription()
    {
        return "Shoots the player to the sky.";
    }

    @Override
    public Material getIconMaterial()
    {
        return Material.FEATHER;
    }

    @Override
    public void punish(Player player)
    {
        player.setVelocity(player.getVelocity().setY(5));
    }
}
