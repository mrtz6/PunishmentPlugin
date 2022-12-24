package de.mrtz.punishment.impl;

import de.mrtz.punishment.Punishment;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class Creeper extends Punishment
{
    @Override
    public String getName()
    {
        return "Creeper";
    }

    @Override
    public String getDescription()
    {
        return "Spawns a creeper at the player's position.";
    }

    @Override
    public Material getIconMaterial()
    {
        return Material.CREEPER_SPAWN_EGG;
    }

    @Override
    public void punish(Player player)
    {
        player.getWorld().spawnEntity(player.getLocation(), EntityType.CREEPER);
    }
}
