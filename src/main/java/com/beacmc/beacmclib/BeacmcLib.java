package com.beacmc.beacmclib;

import org.bukkit.plugin.java.JavaPlugin;

public final class BeacmcLib extends JavaPlugin {

    private static BeacmcLib instance;

    @Override
    public void onEnable() {
        instance = this;
    }

    @Override
    public void onDisable() {
        instance = null;
    }

    public static BeacmcLib getInstance() {
        return instance;
    }
}
