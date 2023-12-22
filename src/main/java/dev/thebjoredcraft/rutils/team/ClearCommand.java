package dev.thebjoredcraft.rutils.team;

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
            }else if(args.length == 1){
                Player target = Bukkit.getPlayer(args[0]);
                if(target == null){

                }else {
                    target.getInventory().clear();
                }
            }
        }
        return false;
    }
}
