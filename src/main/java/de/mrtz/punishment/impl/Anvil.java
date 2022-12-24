package de.mrtz.punishment.impl;

import de.mrtz.punishment.Punishment;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class Anvil extends Punishment
{
    @Override
    public String getName()
    {
        return "Anvil";
    }

    @Override
    public String getDescription()
    {
        return "Spawns a anvil above the player.";
    }

    @Override
    public Material getIconMaterial()
    {
        return Material.ANVIL;
    }

    @Override
    public void punish(Player player)
    {
        player.getLocation().add(0, 10, 0).getBlock().setType(Material.ANVIL);
    }
}
