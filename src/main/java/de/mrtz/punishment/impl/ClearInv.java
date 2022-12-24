package de.mrtz.punishment.impl;

import de.mrtz.punishment.Punishment;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class ClearInv extends Punishment
{
    @Override
    public String getName()
    {
        return "ClearInv";
    }

    @Override
    public String getDescription()
    {
        return "Clears the player's inventory.";
    }

    @Override
    public Material getIconMaterial()
    {
        return Material.CHEST;
    }

    @Override
    public void punish(Player player)
    {
        player.getInventory().clear();
    }
}
