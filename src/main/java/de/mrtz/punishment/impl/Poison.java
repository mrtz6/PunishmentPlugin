package de.mrtz.punishment.impl;

import de.mrtz.punishment.Punishment;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Poison extends Punishment
{
    @Override
    public String getName()
    {
        return "Poison";
    }

    @Override
    public String getDescription()
    {
        return "Poisons the player.";
    }

    @Override
    public Material getIconMaterial()
    {
        return Material.SPIDER_EYE;
    }

    @Override
    public void punish(Player player)
    {
        player.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 20 * 15, 0));
    }
}
