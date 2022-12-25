package de.mrtz.punishment.impl;

import de.mrtz.punishment.Punishment;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class Fire extends Punishment
{
    @Override
    public String getName()
    {
        return "Fire";
    }

    @Override
    public String getDescription()
    {
        return "Sets the player on fire.";
    }

    @Override
    public Material getIconMaterial()
    {
        return Material.FLINT_AND_STEEL;
    }

    @Override
    public void punish(Player player)
    {
        player.setFireTicks(20 * 10);
    }
}
