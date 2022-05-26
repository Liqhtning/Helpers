package com.haroon.helpers;

import com.haroon.helpers.Commands.*;
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
        getCommand("mutechat").setExecutor(new MuteChat());
        getCommand("vanish").setExecutor(new Vanish());
        getCommand("banner").setExecutor(new Banner());
        getCommand("bannerhelmet").setExecutor(new BannerHelmet());
        getCommand("punish").setExecutor(new Punish());
        getCommand("enderchest").setExecutor(new EnderChest());
        getCommand("test").setExecutor(new Test());

    }

    @Override
    public void onDisable() {
        System.out.println("Haroon's Helpers are going home");
    }
}
