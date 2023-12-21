package dev.thebjoredcraft.rutils;

import dev.thebjoredcraft.rutils.main.EventManager;
import dev.thebjoredcraft.rutils.playistration.tab.TabListManager;

import dev.thebjoredcraft.rutils.team.administration.restart.RestartCommand;
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
        regCommands();
        regListeners();

        TabListManager.setupTablist();
        TabListManager.startTabupdate();
        // Plugin startup logic

    }
    public void regCommands(){
        getCommand("restart").setExecutor(new RestartCommand());

    }
    public void regListeners(){
        Bukkit.getPluginManager().registerEvents(new EventManager(), this);
    }

    @Override
    public void onDisable() {
        TabListManager.stopTabListUpdate();
        // Plugin shutdown logic
    }
    public static void setPermission(Player player, String permission, Boolean trueorfalse) {
        PermissionAttachment attachment = player.addAttachment(Rutils.getInstance());
        attachment.setPermission(permission, trueorfalse);

        player.recalculatePermissions();
    }
}
