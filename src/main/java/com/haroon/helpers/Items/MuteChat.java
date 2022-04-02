package com.haroon.helpers.Items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


@SuppressWarnings("ALL")
public class MuteChat implements CommandExecutor, Listener {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            // The Item
            ItemStack muter = new ItemStack(Material.NETHER_STAR);
            ItemMeta meta = muter.getItemMeta();
            meta.setDisplayName(ChatColor.WHITE + "Mute Chat");
            muter.setItemMeta(meta);

            // The Command
            Player p = (Player) sender;
            p.getInventory().addItem(muter);



        }
        return false;

    }

    private boolean enabled = true;

    @EventHandler
    public void onClick(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        ItemStack muter = new ItemStack(Material.NETHER_STAR);
        ItemMeta meta = muter.getItemMeta();
        meta.setDisplayName(ChatColor.WHITE + "Chat Muter");
        muter.setItemMeta(meta);
    if (e.getHand().equals(EquipmentSlot.HAND)) {
        if (p.getInventory().getItemInMainHand() != null && p.getInventory().getItemInMainHand().getType().equals(Material.NETHER_STAR)) {
            if (enabled) {
                enabled = false;
                p.sendMessage("Chat is disabled!");

            } else {
                enabled = true;
                p.sendMessage("Chat is enabled!");
            }

        }
    }

    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        if (!enabled) {
            e.setCancelled(true);
            e.getPlayer().sendMessage("Chat is disabled right now!");
        }
    }
}

