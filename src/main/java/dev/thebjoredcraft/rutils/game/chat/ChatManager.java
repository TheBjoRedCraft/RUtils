package dev.thebjoredcraft.rutils.game.chat;

import dev.thebjoredcraft.rutils.Rutils;

import net.kyori.adventure.text.minimessage.MiniMessage;
import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.model.user.User;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatManager implements Listener {
    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        event.setCancelled(true);
        Player player = event.getPlayer();

        User user = LuckPermsProvider.get().getPlayerAdapter(Player.class).getUser(player);
        String prefix = user.getCachedData().getMetaData().getPrefix();
        if(prefix != null) {

            boolean isregistered = player.hasPermission(Rutils.getInstance().getConfig().getString("Permisson", ""));
            String registered = isregistered ? Rutils.getInstance().getConfig().getString("RegFormatOn", "") : Rutils.getInstance().getConfig().getString("RegFormatOff", "");

            boolean isAfk = player.hasPermission(Rutils.getInstance().getConfig().getString("AfkPermisson", ""));
            String afk = isAfk ? Rutils.getInstance().getConfig().getString("TabFormaton", "") : Rutils.getInstance().getConfig().getString("TabFormatoff", "");


            String ChatFormat = Rutils.getInstance().getConfig().getString("ChatFormat", "").replace("%playername%", player.getName());

            String ChatFormat2 = ChatFormat.replace("%luckperms_prefix%", prefix);


            String ChatFormat3 = ChatFormat2.replace("%message%", event.getMessage());

            String ChatFormat4 = ChatFormat3.replace("%registered%", registered);

            String ChatFormat5 = ChatFormat4.replace("%afk%", afk);

            Bukkit.broadcast(MiniMessage.miniMessage().deserialize(ChatFormat5));
        }else{
            player.sendMessage("[Rutils] Der Prefix ist null, bitte erstelle eine LuckPerms-Gruppe mit Prefix um Rutils benutzten zu können!");
        }
    }
}
