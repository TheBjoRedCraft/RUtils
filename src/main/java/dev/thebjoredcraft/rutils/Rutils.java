package dev.thebjoredcraft.rutils;

import dev.thebjoredcraft.rutils.game.language.LanguageCommand;
import dev.thebjoredcraft.rutils.game.tab.TabListManager;

import dev.thebjoredcraft.rutils.main.EventManager;
import dev.thebjoredcraft.rutils.team.ClearCommand;
import dev.thebjoredcraft.rutils.team.GameModeCommand;
import dev.thebjoredcraft.rutils.team.ReNameItemCommand;
import dev.thebjoredcraft.rutils.team.administration.reload.ReloadCommand;
import dev.thebjoredcraft.rutils.team.administration.restart.RestartCommand;
import dev.thebjoredcraft.rutils.team.administration.stop.StopServerCommand;
import dev.thebjoredcraft.rutils.team.moderation.InfoGuiCommand;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.plugin.java.JavaPlugin;

public final class Rutils extends JavaPlugin {
    private static Rutils instance;

    @Override
    public void onLoad() {
        instance = this;
    }
    public static Rutils getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        saveDefaultConfig();
        regCommands();
        regListeners();

        TabListManager.setupTablist();
        TabListManager.startTabupdate();
        // Plugin startup logic

    }
    public void regCommands(){
        getCommand("restart").setExecutor(new RestartCommand());
        getCommand("stop").setExecutor(new StopServerCommand());
        getCommand("language").setExecutor(new LanguageCommand());
        getCommand("gamemode").setExecutor(new GameModeCommand());
        getCommand("clear").setExecutor(new ClearCommand());
        getCommand("info").setExecutor(new InfoGuiCommand());
        getCommand("reload").setExecutor(new ReloadCommand());
    }
    public void regListeners(){
        Bukkit.getPluginManager().registerEvents(new EventManager(), this);
    }

    @Override
    public void onDisable() {
        saveDefaultConfig();
        TabListManager.stopTabListUpdate();
        // Plugin shutdown logic
    }
    public static void setPermission(Player player, String permission, Boolean trueorfalse) {
        PermissionAttachment attachment = player.addAttachment(Rutils.getInstance());
        attachment.setPermission(permission, trueorfalse);

        player.recalculatePermissions();
    }
}
