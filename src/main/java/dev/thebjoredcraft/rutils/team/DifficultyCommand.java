package dev.thebjoredcraft.rutils.team;

import org.bukkit.Difficulty;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.util.StringUtil;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DifficultyCommand implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player player) {
            if (args.length == 0) {
            }else if(args[0].equalsIgnoreCase("hard")){
                player.getWorld().setDifficulty(Difficulty.HARD);
            }else if(args[0].equalsIgnoreCase("easy")){
                player.getWorld().setDifficulty(Difficulty.EASY);
            }else if(args[0].equalsIgnoreCase("peaceful")){
                player.getWorld().setDifficulty(Difficulty.PEACEFUL);
            }else if(args[0].equalsIgnoreCase("normal")){
                player.getWorld().setDifficulty(Difficulty.NORMAL);
            }else{

            }
        }
        return false;
    }

    private final String[] subcommands = new String[]{"hard", "easy", "peaceful", "normal"};

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        List<String> completions = new ArrayList<>();
        if(args.length <= 1) {
            StringUtil.copyPartialMatches(args[0], Arrays.asList(subcommands), completions);
        }
        Collections.sort(completions);
        return completions;
    }
}
