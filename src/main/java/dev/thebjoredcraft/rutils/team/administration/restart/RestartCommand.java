package dev.thebjoredcraft.rutils.team.administration.restart;

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

public class RestartCommand implements CommandExecutor {
    private BukkitRunnable runnable;
    private int status;
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        try {
            status = Integer.parseInt(args[0]);
            for(Player player : Bukkit.getOnlinePlayers()){
                player.sendMessage(PlayerData.getB(player, PlayerData.de) ? MiniMessage.miniMessage().deserialize(RawMessage.RESTART_IN_DE.get().replace("%time%", String.valueOf(status))) : MiniMessage.miniMessage().deserialize(RawMessage.RESTART_IN_EN.get().replace("%time%", String.valueOf(status))) );
            }
            runnable = new BukkitRunnable() {
                @Override
                public void run() {
                    status--;
                    for(Player player : Bukkit.getOnlinePlayers()){
                        player.sendActionBar(PlayerData.getB(player, PlayerData.de) ? MiniMessage.miniMessage().deserialize(RawMessage.RESTART_IN_DE.get().replace("%time%", String.valueOf(status))) : MiniMessage.miniMessage().deserialize(RawMessage.RESTART_IN_EN.get().replace("%time%", String.valueOf(status))) );
                    }
                    if (status == 60) {
                        for(Player player : Bukkit.getOnlinePlayers()){
                            player.sendMessage(PlayerData.getB(player, PlayerData.de) ? MiniMessage.miniMessage().deserialize(RawMessage.RESTART_IN_DE.get().replace("%time%", String.valueOf(status))) : MiniMessage.miniMessage().deserialize(RawMessage.RESTART_IN_EN.get().replace("%time%", String.valueOf(status))) );
                        }
                    }else if(status == 3){
                        for(Player player : Bukkit.getOnlinePlayers()){
                            player.sendMessage(PlayerData.getB(player, PlayerData.de) ? MiniMessage.miniMessage().deserialize(RawMessage.RESTART_IN_DE.get().replace("%time%", String.valueOf(status))) : MiniMessage.miniMessage().deserialize(RawMessage.RESTART_IN_EN.get().replace("%time%", String.valueOf(status))) );
                        }
                    }else if(status == 2){
                        for(Player player : Bukkit.getOnlinePlayers()){
                            player.sendMessage(PlayerData.getB(player, PlayerData.de) ? MiniMessage.miniMessage().deserialize(RawMessage.RESTART_IN_DE.get().replace("%time%", String.valueOf(status))) : MiniMessage.miniMessage().deserialize(RawMessage.RESTART_IN_EN.get().replace("%time%", String.valueOf(status))) );
                        }
                    }else if(status == 1){
                        for(Player player : Bukkit.getOnlinePlayers()){
                            player.sendMessage(PlayerData.getB(player, PlayerData.de) ? MiniMessage.miniMessage().deserialize(RawMessage.RESTART_IN_DE.get().replace("%time%", String.valueOf(status))) : MiniMessage.miniMessage().deserialize(RawMessage.RESTART_IN_EN.get().replace("%time%", String.valueOf(status))) );
                        }
                    }else if(status == 0){
                        for (Player player : Bukkit.getOnlinePlayers()) {
                            player.kick(PlayerData.getB(player, PlayerData.de) ? Message.RESTART_MESSAGE_DE.get() : Message.RESTART_MESSAGE_EN.get());
                        }
                        Bukkit.spigot().restart();
                    }
                }
            };
            BukkitTask bukkitTask = runnable.runTaskTimer(Rutils.getInstance(), 0, 20);
        }catch (NumberFormatException e){
            if(sender instanceof Player player){
                player.sendMessage(PlayerData.getB(player, PlayerData.de) ? Message.NUMBERFORMAT_ERROR_DE.get() : Message.NUMBERFORMAT_ERROR_EN.get());
            }else{
                sender.sendMessage(Message.NUMBERFORMAT_ERROR_EN.get());
            }
        }
        return false;
    }
}
