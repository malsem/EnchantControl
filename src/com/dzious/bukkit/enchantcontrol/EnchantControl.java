package com.dzious.bukkit.enchantcontrol;

import com.dzious.bukkit.enchantcontrol.command.CommandManager;
import com.dzious.bukkit.enchantcontrol.utils.ConfigManager;
import com.dzious.bukkit.enchantcontrol.utils.EnchantmentManager;
import org.bukkit.plugin.java.JavaPlugin;
import com.dzious.bukkit.enchantcontrol.utils.LogManager;

import java.util.logging.Logger;

public class EnchantControl extends JavaPlugin {

    private static EnchantControl INSTANCE;
    private LogManager logManager;
    private ConfigManager configManager;
    private CommandManager commandManager;
    private EnchantmentManager enchantmentManager;

    @Override
    public void onLoad() {
        return;
    }

    @Override
    public void onEnable() {
        Logger logger = Logger.getLogger("Minecraft");
        logger.info("Enchant Control starting...");
        INSTANCE = this;
        configManager = new ConfigManager(this);
        logManager = new LogManager(INSTANCE, logger, configManager);
        commandManager = new CommandManager(INSTANCE);
        commandManager.onEnable();
        enchantmentManager = new EnchantmentManager(this);
        logManager.logInfo("Enchant Control started !");
        return;
    }

    @Override
    public void onDisable() {
        logManager.logInfo("Enchant Control stopping...");
        logManager.logInfo("Enchant Control stopped !");
        return;
    }

    public void disablePlugin() {
        logManager.logSevere("This is a fatal error, disabling Enchant Control");
        setEnabled(false);
    }

    public LogManager getLogManager() {
        return (logManager);
    }

    public ConfigManager getConfigManager() {
        return (configManager);
    }

    public EnchantmentManager getEnchantmentManager() {return (enchantmentManager); }

}