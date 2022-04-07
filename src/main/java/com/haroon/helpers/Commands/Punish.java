package com.haroon.helpers.Commands;

import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Calendar;

public class Punish implements CommandExecutor {

    //            /punish <player name> <kick/ban/tempban>

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;

            if (args.length == 2) {
                if (Bukkit.getPlayer(args[0]) !=null) {
                    Player target = Bukkit.getPlayer(args[0]);

                    switch (args[1].toLowerCase()) {
                        case "kick":
                            p.kickPlayer("You have been kicked");
                            break;
                        case "ban":
                            assert target != null;
                            Bukkit.getBanList(BanList.Type.NAME).addBan(target.getName(), "Being a bad player\nPlease appeal!", null, null);
                            target.kickPlayer("You have been banned!");
                            break;
                        case "tempban":
                            Calendar cal = Calendar.getInstance();
                            cal.add(Calendar.MONTH, 1);
                            assert target != null;
                            Bukkit.getBanList(BanList.Type.NAME).addBan(target.getName(), "Being a bad player\nPlease appeal!", cal.getTime(), null);
                            target.kickPlayer("You have been temporarily banned for one month!");
                            break;
                        default:
                            p.sendMessage(ChatColor.RED + "You did not specify whether to kick, ban, or tempban!");


                    }



                }
            } else {
                p.sendMessage(ChatColor.RED + "Invalid Usage! Use /punish <player name> <kick/ban/tempban>");
            }
        }
        return false;
    }
}
