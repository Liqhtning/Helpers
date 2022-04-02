package com.haroon.helpers;

import com.haroon.helpers.Commands.Banner;
import com.haroon.helpers.Commands.BannerHelmet;
import com.haroon.helpers.Commands.Vanish;
import com.haroon.helpers.Items.MuteChat;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("Haroon's Helpers have been released!");
        // Events
        Bukkit.getPluginManager().registerEvents(new MuteChat(), this);

        // Commands
        Bukkit.getPluginCommand("MuteChat").setExecutor(new MuteChat());
        Bukkit.getPluginCommand("vanish").setExecutor(new Vanish());
        Bukkit.getPluginCommand("banner").setExecutor(new Banner());
        Bukkit.getPluginCommand("bannerhelmet").setExecutor(new BannerHelmet());

    }

    @Override
    public void onDisable() {
        System.out.println("Haroon's Helpers are going home");
    }
}
