package de.mrtz.punishment.impl;

import de.mrtz.punishment.Punishment;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class Starve extends Punishment
{
    @Override
    public String getName()
    {
        return "Starve";
    }

    @Override
    public String getDescription()
    {
        return "Makes the player starve.";
    }

    @Override
    public Material getIconMaterial()
    {
        return Material.COOKED_PORKCHOP;
    }

    @Override
    public void punish(Player player)
    {
        player.setFoodLevel(0);
    }
}
