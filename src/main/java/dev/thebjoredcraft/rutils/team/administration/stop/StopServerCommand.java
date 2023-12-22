package dev.thebjoredcraft.rutils.team.administration.stop;

import dev.thebjoredcraft.rutils.Rutils;
import dev.thebjoredcraft.rutils.main.Message;
import dev.thebjoredcraft.rutils.main.PlayerData;
import dev.thebjoredcraft.rutils.main.RawMessage;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;
import org.jetbrains.annotations.NotNull;

public class StopServerCommand implements CommandExecutor {
    private int status;
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        status = Integer.parseInt(args[0]);
        BukkitRunnable runnable = new BukkitRunnable() {
            @Override
            public void run() {
                status--;
                if (status == 60) {
                    for (Player player : Bukkit.getOnlinePlayers()) {
                        player.sendMessage(PlayerData.getB(player, PlayerData.de) ? MiniMessage.miniMessage().deserialize(RawMessage.STOP_IN_DE.get().replace("%time%", String.valueOf(status))) : MiniMessage.miniMessage().deserialize(RawMessage.STOP_IN_EN.get().replace("%time%", String.valueOf(status))));
                    }
                } else if (status == 3) {
                    for (Player player : Bukkit.getOnlinePlayers()) {
                        player.sendMessage(PlayerData.getB(player, PlayerData.de) ? MiniMessage.miniMessage().deserialize(RawMessage.STOP_IN_DE.get().replace("%time%", String.valueOf(status))) : MiniMessage.miniMessage().deserialize(RawMessage.STOP_IN_EN.get().replace("%time%", String.valueOf(status))));
                    }
                } else if (status == 2) {
                    for (Player player : Bukkit.getOnlinePlayers()) {
                        player.sendMessage(PlayerData.getB(player, PlayerData.de) ? MiniMessage.miniMessage().deserialize(RawMessage.STOP_IN_DE.get().replace("%time%", String.valueOf(status))) : MiniMessage.miniMessage().deserialize(RawMessage.STOP_IN_EN.get().replace("%time%", String.valueOf(status))));
                    }
                } else if (status == 1) {
                    for (Player player : Bukkit.getOnlinePlayers()) {
                        player.sendMessage(PlayerData.getB(player, PlayerData.de) ? MiniMessage.miniMessage().deserialize(RawMessage.STOP_IN_DE.get().replace("%time%", String.valueOf(status))) : MiniMessage.miniMessage().deserialize(RawMessage.STOP_IN_EN.get().replace("%time%", String.valueOf(status))));
                    }
                } else if (status == 0) {
                    for (Player player : Bukkit.getOnlinePlayers()) {
                        player.kick(PlayerData.getB(player, PlayerData.de) ? Message.STOP_MESSAGE_DE.get() : Message.STOP_MESSAGE_EN.get());
                    }
                    Bukkit.getServer().shutdown();
                }
            }
        };
        BukkitTask bukkitTask = runnable.runTaskTimer(Rutils.getInstance(), 0, 20);
        return false;
    }
}
