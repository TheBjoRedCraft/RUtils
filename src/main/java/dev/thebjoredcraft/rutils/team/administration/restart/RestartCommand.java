package dev.thebjoredcraft.rutils.team.administration.restart;

import dev.thebjoredcraft.rutils.Rutils;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;
import org.jetbrains.annotations.NotNull;

public class RestartCommand implements CommandExecutor {
    private BukkitRunnable runnable;
    private int status;
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        try {
            status = Integer.parseInt(args[0]);
            Bukkit.broadcastMessage("restart in" + status);
            runnable = new BukkitRunnable() {
                @Override
                public void run() {
                    status--;
                    if (status == 60) {
                        Bukkit.broadcastMessage("restart in " + status);
                    }else if(status == 3){
                        Bukkit.broadcastMessage("restart in " + status);
                    }else if(status == 2){
                        Bukkit.broadcastMessage("restart in " + status);
                    }else if(status == 1){
                        Bukkit.broadcastMessage("restart in " + status);
                    }else if(status == 0){
                        Bukkit.spigot().restart();
                    }
                }
            };
            BukkitTask bukkitTask = runnable.runTaskTimer(Rutils.getInstance(), 0, 20);
        }catch (NumberFormatException e){
            sender.sendMessage("incorrect countdown");
        }
        return false;
    }
}
