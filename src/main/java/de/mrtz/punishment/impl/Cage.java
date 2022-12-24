package de.mrtz.punishment.impl;

import de.mrtz.punishment.Punishment;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class Cage extends Punishment
{
    @Override
    public String getName()
    {
        return "Cage";
    }

    @Override
    public String getDescription()
    {
        return "Traps the player in a cage.";
    }

    @Override
    public Material getIconMaterial()
    {
        return Material.IRON_BARS;
    }

    @Override
    public void punish(Player player)
    {
        Location location = player.getLocation();

        location.clone().add(0, -1, 0).getBlock().setType(Material.BEDROCK);
        location.clone().add(0, 2, 0).getBlock().setType(Material.BEDROCK);
        location.clone().add(1, 1, 0).getBlock().setType(Material.BEDROCK);
        location.clone().add(-1, 1, 0).getBlock().setType(Material.BEDROCK);
        location.clone().add(0, 1, 1).getBlock().setType(Material.BEDROCK);
        location.clone().add(0, 1, -1).getBlock().setType(Material.BEDROCK);
    }
}
