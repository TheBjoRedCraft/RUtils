package dev.thebjoredcraft.rutils.game.language;

import dev.thebjoredcraft.rutils.main.Message;
import dev.thebjoredcraft.rutils.main.PlayerData;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class LanguageCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args){
        if(sender instanceof Player player) {
            if (args.length == 1) {
                Player target = Bukkit.getPlayer(args[0]);
                if (target != null) {
                    if (PlayerData.getB(target, PlayerData.de)) {
                        PlayerData.set(target, PlayerData.de, false);
                        target.sendMessage(PlayerData.getB(target, PlayerData.de) ? Message.LANGUAGE_CHANGED_EN_DE.get() : Message.LANGUAGE_CHANGED_EN_EN.get());
                        player.sendMessage(PlayerData.getB(player, PlayerData.de) ? Message.LANGUAGE_CHANGED_EN_DE.get() : Message.LANGUAGE_CHANGED_EN_EN.get());
                    } else {
                        PlayerData.set(target, PlayerData.de, true);
                        target.sendMessage(PlayerData.getB(target, PlayerData.de) ? Message.LANGUAGE_CHANGED_DE_DE.get() : Message.LANGUAGE_CHANGED_DE_EN.get());
                        player.sendMessage(PlayerData.getB(player, PlayerData.de) ? Message.LANGUAGE_CHANGED_DE_DE.get() : Message.LANGUAGE_CHANGED_DE_EN.get());
                    }
                } else {
                    player.sendMessage(PlayerData.getB(player, PlayerData.de) ? Message.PLAYER_NOT_FOUND_DE.get() : Message.PLAYER_NOT_FOUND_EN.get());
                }
            } else if (args.length == 0) {
                if (PlayerData.getB(player, PlayerData.de)) {
                    PlayerData.set(player, PlayerData.de, false);
                    player.sendMessage(PlayerData.getB(player, PlayerData.de) ? Message.LANGUAGE_CHANGED_EN_DE.get() : Message.LANGUAGE_CHANGED_EN_EN.get());
                } else {
                    PlayerData.set(player, PlayerData.de, true);
                    player.sendMessage(PlayerData.getB(player, PlayerData.de) ? Message.LANGUAGE_CHANGED_DE_DE.get() : Message.LANGUAGE_CHANGED_DE_EN.get());
                }
            }else{
                player.sendMessage(PlayerData.getB(player, PlayerData.de) ? Message.LANGUAGE_COMMAND_USAGE_DE.get() : Message.LANGUAGE_COMMAND_USAGE_EN.get());
            }
        }else{
            sender.sendMessage(Message.NOT_A_PLAYER_DE.get());
        }
        return false;
    }
}
