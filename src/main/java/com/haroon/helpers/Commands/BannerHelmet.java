package com.haroon.helpers.Commands;

import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.block.banner.Pattern;
import org.bukkit.block.banner.PatternType;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BannerMeta;

import java.util.ArrayList;
import java.util.List;

public class BannerHelmet implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            ItemStack banner = new ItemStack(Material.BLACK_BANNER);
            BannerMeta meta = (BannerMeta) banner.getItemMeta();

            List<Pattern> patterns = new ArrayList<>();
            patterns.add(new Pattern(DyeColor.LIGHT_BLUE, PatternType.RHOMBUS_MIDDLE));
            patterns.add(new Pattern(DyeColor.BLACK, PatternType.SQUARE_TOP_RIGHT));
            patterns.add(new Pattern(DyeColor.BLACK, PatternType.SQUARE_BOTTOM_LEFT));
            patterns.add(new Pattern(DyeColor.BLACK, PatternType.CIRCLE_MIDDLE));

            meta.setPatterns(patterns);
            banner.setItemMeta(meta);
            ((Player) sender).getEquipment().setHelmet(banner);
            sender.sendMessage("What's on your head?");

            return false;
        }
        return false;
    }}
