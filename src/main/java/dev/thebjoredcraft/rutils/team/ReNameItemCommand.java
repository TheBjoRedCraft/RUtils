package dev.thebjoredcraft.rutils.team;

import dev.thebjoredcraft.rutils.main.Message;
import dev.thebjoredcraft.rutils.main.PlayerData;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ReNameItemCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player player){
            if(args.length == 1){
                player.getItemInHand().getItemMeta().displayName(MiniMessage.miniMessage().deserialize(args[0]));
                player.sendMessage(PlayerData.getB(player, PlayerData.de) ? Message.ITEM_RENAMED_DE.get() : Message.ITEM_RENAMED_EN.get());
            }else if(args.length == 2){
                Player target = Bukkit.getPlayer(args[1]);
                if(target == null){
                    player.sendMessage(PlayerData.getB(player, PlayerData.de) ? Message.PLAYER_NOT_FOUND_DE.get() : Message.PLAYER_NOT_FOUND_EN.get());
                }else{
                    target.getItemInHand().getItemMeta().displayName(MiniMessage.miniMessage().deserialize(args[0]));
                    target.sendMessage(PlayerData.getB(target, PlayerData.de) ? Message.ITEM_RENAMED_DE.get() : Message.ITEM_RENAMED_EN.get());
                }
            }else{
                player.sendMessage(PlayerData.getB(player, PlayerData.de) ? Message.RENAME_COMMAND_USAGE_DE.get() : Message.RENAME_COMMAND_USAGE_EN.get());
            }
        }else{
            sender.sendMessage(Message.NOT_A_PLAYER_EN.get());
        }
        return false;
    }
}
