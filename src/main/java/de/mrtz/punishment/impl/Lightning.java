package de.mrtz.punishment.impl;

import de.mrtz.punishment.Punishment;
import org.bukkit.Material;
import org.bukkit.entity.LightningStrike;
import org.bukkit.entity.Player;

public class Lightning extends Punishment
{
    @Override
    public String getName()
    {
        return "Lightning";
    }

    @Override
    public String getDescription()
    {
        return "Spawns a lightning-bolt at the player's position.";
    }

    @Override
    public Material getIconMaterial()
    {
        return Material.LIGHTNING_ROD;
    }

    @Override
    public void punish(Player player)
    {
        player.getWorld().spawn(player.getLocation(), LightningStrike.class);
    }
}
