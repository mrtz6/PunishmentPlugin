package de.mrtz.punishment.command;

import de.mrtz.mplugin.command.CommandInfo;
import de.mrtz.mplugin.command.MCommand;
import de.mrtz.punishment.Punishment;
import de.mrtz.punishment.PunishmentPlugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

@CommandInfo(name = "punish", permission = "punishment.use", requiresPlayer = true)
public class PunishCommand extends MCommand
{
    public PunishCommand(JavaPlugin plugin)
    {
        super(plugin);
    }

    @Override
    public void execute(Player player, String[] args)
    {
        if (args.length != 1)
        {
            player.sendMessage(ChatColor.RED + "Correct Usage: /punish <player>");
            return;
        }

        Player target = Bukkit.getPlayer(args[0]);

        if (target == null)
        {
            player.sendMessage(ChatColor.RED + args[0] + " is not online!");
            return;
        }

        int essentialCount = 0;
        Inventory inventory = Bukkit.createInventory(null, 9 * 3, PunishmentPlugin.INVENTORY_TITLE + " " + target.getName());
        for (Punishment punishment: PunishmentPlugin.getInstance().getPunishments())
        {
            ItemStack itemStack = new ItemStack(punishment.getIconMaterial());
            ItemMeta itemMeta = itemStack.getItemMeta();

            itemMeta.setDisplayName(ChatColor.YELLOW + punishment.getName());
            itemMeta.addItemFlags(ItemFlag.values());

            ArrayList<String> lore = new ArrayList<>();
            lore.add(ChatColor.GRAY + punishment.getDescription());

            itemMeta.setLore(lore);

            itemStack.setItemMeta(itemMeta);

            if (punishment.isEssential())
            {
                inventory.setItem(inventory.getSize() - 1 - essentialCount, itemStack);
                essentialCount++;
            }
            else
            {
                inventory.addItem(itemStack);
            }
        }

        player.openInventory(inventory);
    }
}
