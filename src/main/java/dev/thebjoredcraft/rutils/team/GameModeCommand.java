package dev.thebjoredcraft.rutils.team;

import dev.thebjoredcraft.rutils.main.Message;
import dev.thebjoredcraft.rutils.main.Permission;

import dev.thebjoredcraft.rutils.main.PlayerData;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import org.jetbrains.annotations.NotNull;

public class GameModeCommand implements CommandExecutor {
    String ph = "placeholder";
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player player) {
            if (args.length < 1) {
                player.sendMessage(ph);
            }else if(args[0].equalsIgnoreCase("creative") || args[0].equalsIgnoreCase("1")){
                if(args.length == 1) {
                    if(player.hasPermission(Permission.GAMEMODE_SELF_CREATIVE.get())) {
                        player.setGameMode(GameMode.CREATIVE);
                        player.sendMessage(ph);
                    }else{
                        player.sendMessage(ph);
                        player.sendMessage(ph);
                    }
                }else if(args.length == 2){
                    Player target = Bukkit.getPlayer(args[1]);
                    if(target == null){
                        player.sendMessage(ph);
                    }else{
                        if(player.hasPermission(Permission.GAMEMODE_OTHER_CREATIVE.get())) {
                            target.setGameMode(GameMode.CREATIVE);

                            player.sendMessage(ph);
                            target.sendMessage(ph);
                        }else{
                            player.sendMessage(ph);
                        }
                    }

                }else{
                    player.sendMessage(ph);
                }
            }else if(args[0].equalsIgnoreCase("survival") || args[0].equalsIgnoreCase("0")){
                if(args.length == 1) {
                    if(player.hasPermission(Permission.GAMEMODE_SELF_SURVIVAL.get())) {
                        player.setGameMode(GameMode.SURVIVAL);

                        player.sendMessage(ph);
                    }else{
                        player.sendMessage(ph);
                    }
                }else if(args.length == 2){
                    Player target = Bukkit.getPlayer(args[1]);
                    if(target == null){
                        player.sendMessage(ph);
                    }else{
                        if(player.hasPermission(Permission.GAMEMODE_OTHER_SURVIVAL.get())) {
                            target.setGameMode(GameMode.SURVIVAL);
                            player.sendMessage(ph);
                            target.sendMessage(ph);
                        }else{
                            player.sendMessage(ph);
                        }
                    }

                }else{
                    player.sendMessage("Incorrect Usage");
                }
            }else if(args[0].equalsIgnoreCase("spectator") || args[0].equalsIgnoreCase("3")){
                if(args.length == 1) {
                    if(player.hasPermission(Permission.GAMEMODE_SELF_SPECTATOR.get())) {
                        player.setGameMode(GameMode.SPECTATOR);

                        player.sendMessage(ph);
                    }else{
                        player.sendMessage(ph);
                    }
                }else if(args.length == 2){
                    Player target = Bukkit.getPlayer(args[1]);
                    if(target == null){
                        player.sendMessage(ph);
                    }else{
                        if(player.hasPermission(Permission.GAMEMODE_OTHER_SPECTATOR.get())) {
                            target.setGameMode(GameMode.SPECTATOR);
                            player.sendMessage(ph);
                            target.sendMessage(ph);
                        }else{
                            player.sendMessage(ph);
                        }
                    }

                }else{
                    player.sendMessage(ph);
                }
            }else if(args[0].equalsIgnoreCase("adventure") || args[0].equalsIgnoreCase("2")){
                if(args.length == 1) {
                    if(player.hasPermission(Permission.GAMEMODE_SELF_ADVENTURE.get())) {
                        player.setGameMode(GameMode.ADVENTURE);

                        player.sendMessage(ph);
                    }else{
                        player.sendMessage(ph);
                    }
                }else if(args.length == 2){
                    Player target = Bukkit.getPlayer(args[1]);
                    if(target == null){
                        player.sendMessage(ph);
                    }else{
                        if(player.hasPermission(Permission.GAMEMODE_OTHER_ADVENTURE.get())) {
                            target.setGameMode(GameMode.ADVENTURE);
                            player.sendMessage(ph);
                            target.sendMessage(ph);
                        }else{
                            player.sendMessage(ph);
                        }
                    }

                }else{
                    player.sendMessage(ph);
                }
            }
        }else{
            sender.sendMessage(Message.NOT_A_PLAYER_EN.get());
        }
        return false;
    }
}
