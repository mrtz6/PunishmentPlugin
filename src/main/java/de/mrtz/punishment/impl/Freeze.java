package de.mrtz.punishment.impl;

import de.mrtz.punishment.Punishment;
import de.mrtz.punishment.PunishmentPlugin;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.ArrayList;

public class Freeze extends Punishment implements Listener
{
    private final ArrayList<Player> players = new ArrayList<>();

    public Freeze()
    {
        Bukkit.getPluginManager().registerEvents(this, PunishmentPlugin.getInstance());
    }

    @EventHandler
    public void onMove(PlayerMoveEvent event)
    {
        if (!players.contains(event.getPlayer()))
            return;

        Location from = event.getFrom();
        Location to = event.getTo();

        to.setX(from.getX());
        to.setY(from.getY());
        to.setZ(from.getZ());
    }

    @Override
    public String getName()
    {
        return "Freeze";
    }

    @Override
    public String getDescription()
    {
        return "Freezes/Unfreezes the player.";
    }

    @Override
    public Material getIconMaterial()
    {
        return Material.ICE;
    }

    @Override
    public void punish(Player player)
    {
        if (!players.remove(player))
            players.add(player);
    }
}
