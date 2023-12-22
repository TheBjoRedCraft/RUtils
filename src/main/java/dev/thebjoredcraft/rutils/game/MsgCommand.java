package dev.thebjoredcraft.rutils.game;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class MsgCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Player target = Bukkit.getPlayer(args[0]);
        if (target == null) {

        }
        String msg = "";

        for (int i = 1; i < args.length; i++) {
            msg = msg + args[i] + " ";
        }
        return false;
    }
}
