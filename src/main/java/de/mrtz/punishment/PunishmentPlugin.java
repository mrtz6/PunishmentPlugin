package de.mrtz.punishment;

import de.mrtz.mplugin.command.MCommand;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public final class PunishmentPlugin extends JavaPlugin implements Listener
{
    public static final String INVENTORY_TITLE = "Punishing";

    private static PunishmentPlugin instance;

    private final ArrayList<Punishment> punishments = new ArrayList<>();

    @Override
    public void onEnable()
    {
        instance = this;

        registerPunishments();

        MCommand.registerCommands(this, getClass().getPackage().getName() + ".command");

        getServer().getPluginManager().registerEvents(this, this);
    }

    private void registerPunishments()
    {
        Reflections reflections = new Reflections(getClass().getPackage().getName() + ".impl");

        Set<Class<? extends Punishment>> subTypes = reflections.getSubTypesOf(Punishment.class);

        for (Class<? extends Punishment> subType : subTypes)
        {
            try
            {
                Punishment punishment = subType.getDeclaredConstructor().newInstance();

                punishments.add(punishment);
            }
            catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e)
            {
                throw new RuntimeException(e);
            }
        }
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event)
    {
        if (!(event.getWhoClicked() instanceof Player))
            return;

        Player player = (Player) event.getWhoClicked();

        if (event.getClickedInventory() == null || event.getCurrentItem() == null)
            return;

        Inventory inventory = event.getClickedInventory();
        ItemStack itemStack = event.getCurrentItem();

        if (event.getView().getTitle().startsWith(INVENTORY_TITLE))
            event.setCancelled(true);
        else
            return;

        Player target = getServer().getPlayer(event.getView().getTitle().split(" ")[1]);

        if (target == null)
        {
            player.sendMessage(ChatColor.RED + "The player is not online anymore.");
            player.closeInventory();
            return;
        }

        for (Punishment punishment : punishments)
        {
            ItemMeta itemMeta = itemStack.getItemMeta();

            if (!itemMeta.getDisplayName().equals(ChatColor.YELLOW + punishment.getName()))
                continue;

            punishment.punish(target);
            player.closeInventory();

            player.playSound(player.getLocation(), Sound.ENTITY_ENDER_DRAGON_FLAP, 1, 1f);

            player.sendMessage(ChatColor.GREEN + "The player has been punished!");
        }
    }

    public List<Punishment> getPunishments()
    {
        return punishments;
    }

    public static PunishmentPlugin getInstance()
    {
        return instance;
    }
}
