package dev.thebjoredcraft.rutils.team.administration.reload;

import dev.thebjoredcraft.rutils.main.Message;
import dev.thebjoredcraft.rutils.main.PlayerData;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ReloadCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player player){
            player.sendMessage(PlayerData.getB(player, PlayerData.de) ? Message.RELOAD_MESSAGE_DE.get() : Message.RELOAD_MESSAGE_EN.get());
            Bukkit.reload();
        }else{
            sender.sendMessage(Message.RELOAD_MESSAGE_EN.get());
            Bukkit.reload();
        }
        return false;
    }
}
