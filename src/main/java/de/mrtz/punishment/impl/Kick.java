package de.mrtz.punishment.impl;

import de.mrtz.punishment.Punishment;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class Kick extends Punishment
{
    @Override
    public String getName()
    {
        return "Kick";
    }

    @Override
    public String getDescription()
    {
        return "Kicks the player.";
    }

    @Override
    public Material getIconMaterial()
    {
        return Material.BARRIER;
    }

    @Override
    public void punish(Player player)
    {
        player.kickPlayer("You have been kicked!");
    }

    @Override
    public boolean isEssential()
    {
        return true;
    }
}
