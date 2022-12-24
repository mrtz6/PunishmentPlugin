package de.mrtz.punishment.impl;

import de.mrtz.punishment.Punishment;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class Kill extends Punishment
{
    @Override
    public String getName()
    {
        return "Kill";
    }

    @Override
    public String getDescription()
    {
        return "Kills the player.";
    }

    @Override
    public Material getIconMaterial()
    {
        return Material.DIAMOND_SWORD;
    }

    @Override
    public void punish(Player player)
    {
        player.damage(player.getHealth());
    }
}
