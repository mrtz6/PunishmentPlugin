package de.mrtz.punishment;

import org.bukkit.Material;
import org.bukkit.entity.Player;

public abstract class Punishment
{
    public abstract String getName();
    public abstract String getDescription();
    public abstract Material getIconMaterial();

    public abstract void punish(Player player);

    public boolean isEssential()
    {
        return false;
    }
}
