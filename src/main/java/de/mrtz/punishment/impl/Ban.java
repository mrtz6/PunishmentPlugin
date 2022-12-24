package de.mrtz.punishment.impl;

import de.mrtz.punishment.Punishment;
import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.util.Date;

public class Ban extends Punishment
{
    @Override
    public String getName()
    {
        return "Ban";
    }

    @Override
    public String getDescription()
    {
        return "Bans the player.";
    }

    @Override
    public Material getIconMaterial()
    {
        return Material.BARRIER;
    }

    @Override
    public void punish(Player player)
    {
        Bukkit.getServer().getBanList(BanList.Type.NAME).addBan(player.getName(), null, null, null);
        player.kickPlayer("You have been banned!");
    }

    @Override
    public boolean isEssential()
    {
        return true;
    }
}
