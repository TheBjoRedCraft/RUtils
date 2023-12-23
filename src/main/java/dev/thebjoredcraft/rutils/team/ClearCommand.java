package dev.thebjoredcraft.rutils.team;

import dev.thebjoredcraft.rutils.main.Message;
import dev.thebjoredcraft.rutils.main.PlayerData;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


import org.jetbrains.annotations.NotNull;

public class ClearCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player player) {
            if(args.length == 0) {
                player.getInventory().clear();
                player.sendMessage(PlayerData.getB(player, PlayerData.de) ? Message.INVENTORY_CLEARED_DE.get() : Message.INVENTORY_CLEARED_EN.get());
            }else if(args.length == 1){
                Player target = Bukkit.getPlayer(args[0]);
                if(target == null){
                    player.sendMessage(PlayerData.getB(player, PlayerData.de) ? Message.PLAYER_NOT_FOUND_DE.get() : Message.PLAYER_NOT_FOUND_EN.get());
                }else {
                    target.sendMessage(PlayerData.getB(target, PlayerData.de) ? Message.INVENTORY_CLEARED_DE.get() : Message.INVENTORY_CLEARED_EN.get());
                    target.getInventory().clear();
                }
            }
        }
        return false;
    }
}
