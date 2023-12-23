package dev.thebjoredcraft.rutils.team.moderation;

import dev.thebjoredcraft.rutils.Rutils;
import dev.thebjoredcraft.rutils.main.PlayerData;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class InfoGuiCommand implements CommandExecutor {
    public static void open(Player player) {
        Inventory gui = Bukkit.createInventory(null, 54, MiniMessage.miniMessage().deserialize(PlayerData.getB(player, PlayerData.de) ? Rutils.getInstance().getConfig().getString("PLAYER_INFO_GUI_NAME_DE", "") : Rutils.getInstance().getConfig().getString("PLAYER_INFO_GUI_NAME_EN", "")));
        int slot = 0;

        for (Player target : Bukkit.getOnlinePlayers()) {
            ItemStack head = new ItemStack(Material.PLAYER_HEAD);
            SkullMeta meta = (SkullMeta) head.getItemMeta();
            List<Component> lore = new ArrayList<>();

            lore.add(MiniMessage.miniMessage().deserialize("<color:" + Rutils.getInstance().getConfig().getString("PLAYER_INFO_GUI_TEXT_COLOR", "") + ">" + player.getUniqueId()));
            lore.add(MiniMessage.miniMessage().deserialize("<color:" + Rutils.getInstance().getConfig().getString("PLAYER_INFO_GUI_TEXT_COLOR", "") + ">" + player.getLocation().getWorld().getName()));
            lore.add(MiniMessage.miniMessage().deserialize("<color:" + Rutils.getInstance().getConfig().getString("PLAYER_INFO_GUI_TEXT_COLOR", "") + ">" + player.getLocation().getX() + ", " + player.getLocation().getY() + ", " + player.getLocation().getZ()));
            meta.setOwningPlayer(target);
            meta.displayName(MiniMessage.miniMessage().deserialize("<color:" + Rutils.getInstance().getConfig().getString("PLAYER_INFO_GUI_TEXT_COLOR", "") + ">" + player.getName()));
            meta.lore(lore);
            head.setItemMeta(meta);
            gui.setItem(slot, head);

            slot++;
            player.openInventory(gui);
        }
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player player){
            open(player);
        }
        return false;
    }
}
