package de.mrtz.punishment.impl;

import de.mrtz.punishment.Punishment;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Blind extends Punishment
{
    @Override
    public String getName()
    {
        return "Blind";
    }

    @Override
    public String getDescription()
    {
        return "Makes the player blind.";
    }

    @Override
    public Material getIconMaterial()
    {
        return Material.ENDER_EYE;
    }

    @Override
    public void punish(Player player)
    {
        player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 20 * 60, 1));
    }
}
