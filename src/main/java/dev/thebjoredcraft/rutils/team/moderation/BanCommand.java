package dev.thebjoredcraft.rutils.team.moderation;

import dev.thebjoredcraft.rutils.main.Message;
import dev.thebjoredcraft.rutils.main.PlayerData;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class BanCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Player target = Bukkit.getPlayer(args[0]);
        if(target != null){
            sender.sendMessage("player banned");
            target.banPlayer("bann msg");
        }else{
            if(sender instanceof Player player){
                player.sendMessage(PlayerData.getB(player, PlayerData.de) ? Message.PLAYER_NOT_FOUND_DE.get() : Message.PLAYER_NOT_FOUND_EN.get());
            }else{
                sender.sendMessage(Message.NOT_A_PLAYER_EN.get());
            }
        }
        return false;
    }
}
