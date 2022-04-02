package com.haroon.helpers.Commands;

import com.haroon.helpers.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@SuppressWarnings("NullableProblems")
public class Vanish implements CommandExecutor {

    private List<UUID> vanished = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player p = (Player) sender;

            if (vanished.contains(p.getUniqueId())) { // They are vanished
                vanished.remove(p.getUniqueId());
                for (Player target : Bukkit.getOnlinePlayers()) {
                    target.showPlayer(p);
                }
                p.sendMessage(ChatColor.LIGHT_PURPLE + "You are now unvanished!");
            } else { // They aren't vanished
                vanished.add(p.getUniqueId());
                for (Player target : Bukkit.getOnlinePlayers()) {
                    target.hidePlayer(p);
                }
                p.sendMessage(ChatColor.DARK_PURPLE + "You are now vanished!");

            }


        }

        return false;
    }
}
