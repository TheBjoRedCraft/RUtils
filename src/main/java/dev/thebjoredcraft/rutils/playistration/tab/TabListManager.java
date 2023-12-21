package dev.thebjoredcraft.rutils.playistration.tab;

import dev.thebjoredcraft.rutils.Rutils;

import net.kyori.adventure.text.minimessage.MiniMessage;
import net.luckperms.api.LuckPermsProvider;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;


public class TabListManager {
    public static Boolean first;
    public static void setupTablist(){
        first = true;
    }
    public static void updateTablist(){
        for (Player player : Bukkit.getOnlinePlayers()){
            String prefix = LuckPermsProvider.get().getPlayerAdapter(Player.class).getUser(player).getCachedData().getMetaData().getPrefix();
            int ping = player.getPing();

            boolean isregistered = player.hasPermission(Rutils.getInstance().getConfig().getString("RegPermisson", ""));
            String registered = isregistered ? Rutils.getInstance().getConfig().getString("RegFormatOn", "") : Rutils.getInstance().getConfig().getString("RegFormatOff", "");

            boolean isAfk = player.hasPermission(Rutils.getInstance().getConfig().getString("AfkPermisson", ""));
            String afk = isAfk ? Rutils.getInstance().getConfig().getString("TabFormaton", "") : Rutils.getInstance().getConfig().getString("TabFormatoff", "");

            boolean animated = Rutils.getInstance().getConfig().getBoolean("AnimatedTablist");

            if(prefix != null) {
                if(animated) {
                    if (first) {
                        String HeaderWithName = Rutils.getInstance().getConfig().getString("FirstTablistHeader", "").replace("%playername%", player.getDisplayName());
                        String HeaderWithPrefix = HeaderWithName.replace("%prefix%", prefix);
                        String HeaderWithRegistered = HeaderWithPrefix.replace("%registered%", registered);
                        String HeaderWithAfk = HeaderWithRegistered.replace("%afk%", afk);

                        player.sendPlayerListHeader(MiniMessage.miniMessage().deserialize(HeaderWithAfk));

                        String PlayerListNameWithName = Rutils.getInstance().getConfig().getString("FirstTablistPlayerName", "").replace("%playername%", player.getDisplayName());
                        String PlayerListNameWithPrefix = PlayerListNameWithName.replace("%prefix%", prefix);
                        String PlayerListNameWithRegistered = PlayerListNameWithPrefix.replace("%registered%", registered);
                        String PlayerListNameWithAfk = PlayerListNameWithRegistered.replace("%afk%", afk);

                        player.playerListName(MiniMessage.miniMessage().deserialize(PlayerListNameWithAfk));

                        String FooterWithName = Rutils.getInstance().getConfig().getString("FirstTablistFooter", "").replace("%playername%", player.getDisplayName());
                        String FooterWithPrefix = FooterWithName.replace("%prefix%", prefix);
                        String FooterWithRegistered = FooterWithPrefix.replace("%registered%", registered);
                        String FooterWithAfk = FooterWithRegistered.replace("%afk%", afk);

                        player.sendPlayerListFooter(MiniMessage.miniMessage().deserialize(FooterWithAfk));
                    }else{
                        String HeaderWithName = Rutils.getInstance().getConfig().getString("SecondTablistHeader", "").replace("%playername%", player.getDisplayName());
                        String HeaderWithPrefix = HeaderWithName.replace("%prefix%", prefix);
                        String HeaderWithRegistered = HeaderWithPrefix.replace("%registered%", registered);
                        String HeaderWithAfk = HeaderWithRegistered.replace("%afk%", afk);

                        player.sendPlayerListHeader(MiniMessage.miniMessage().deserialize(HeaderWithAfk));

                        String PlayerListNameWithName = Rutils.getInstance().getConfig().getString("SecondTablistPlayerName", "").replace("%playername%", player.getDisplayName());
                        String PlayerListNameWithPrefix = PlayerListNameWithName.replace("%prefix%", prefix);
                        String PlayerListNameWithRegistered = PlayerListNameWithPrefix.replace("%registered%", registered);
                        String PlayerListNameWithAfk = PlayerListNameWithRegistered.replace("%afk%", afk);

                        player.playerListName(MiniMessage.miniMessage().deserialize(PlayerListNameWithAfk));

                        String FooterWithName = Rutils.getInstance().getConfig().getString("SecondTablistFooter", "").replace("%playername%", player.getDisplayName());
                        String FooterWithPrefix = FooterWithName.replace("%prefix%", prefix);
                        String FooterWithRegistered = FooterWithPrefix.replace("%registered%", registered);
                        String FooterWithAfk = FooterWithRegistered.replace("%afk%", afk);

                        player.sendPlayerListFooter(MiniMessage.miniMessage().deserialize(FooterWithAfk));
                    }
                }else{
                    String HeaderWithName = Rutils.getInstance().getConfig().getString("FirstTablistHeader", "").replace("%playername%", player.getDisplayName());
                    String HeaderWithPrefix = HeaderWithName.replace("%prefix%", prefix);
                    String HeaderWithRegistered = HeaderWithPrefix.replace("%registered%", registered);
                    String HeaderWithAfk = HeaderWithRegistered.replace("%afk%", afk);

                    player.sendPlayerListHeader(MiniMessage.miniMessage().deserialize(HeaderWithAfk));

                    String PlayerListNameWithName = Rutils.getInstance().getConfig().getString("FirstTablistPlayerName", "").replace("%playername%", player.getDisplayName());
                    String PlayerListNameWithPrefix = PlayerListNameWithName.replace("%prefix%", prefix);
                    String PlayerListNameWithRegistered = PlayerListNameWithPrefix.replace("%registered%", registered);
                    String PlayerListNameWithAfk = PlayerListNameWithRegistered.replace("%afk%", afk);

                    player.playerListName(MiniMessage.miniMessage().deserialize(PlayerListNameWithAfk));

                    String FooterWithName = Rutils.getInstance().getConfig().getString("FirstTablistFooter", "").replace("%playername%", player.getDisplayName());
                    String FooterWithPrefix = FooterWithName.replace("%prefix%", prefix);
                    String FooterWithRegistered = FooterWithPrefix.replace("%registered%", registered);
                    String FooterWithAfk = FooterWithRegistered.replace("%afk%", afk);

                    player.sendPlayerListFooter(MiniMessage.miniMessage().deserialize(FooterWithAfk));
                }
            }else{
                Bukkit.getConsoleSender().sendMessage("[Rutils] Der Prefix ist null, bitte erstelle eine LuckPerms-Gruppe mit Prefix um LuckUtls benutzten zu können! " + player.getName());
            }
        }
    }
    private static BukkitRunnable runnable;
    private static BukkitRunnable runnableOther;

    public static void startTabupdate() {
        try {

            runnable = new BukkitRunnable() {
                @Override
                public void run() {
                    updateTablist();
                }
            };
            BukkitTask bukkitTask = runnable.runTaskTimer(Rutils.getInstance(), 0, Rutils.getInstance().getConfig().getInt("Repeat"));

            runnableOther = new BukkitRunnable() {
                @Override
                public void run() {
                    first = !first;
                }
            };
            BukkitTask bukkitTaskOther = runnableOther.runTaskTimer(Rutils.getInstance(), 0, Rutils.getInstance().getConfig().getInt("SwitchTabList"));
        }catch (NumberFormatException exception){
            Bukkit.getConsoleSender().sendMessage(exception.getMessage());
        }
    }
    public static void stopTabListUpdate(){
        try {
            if(!runnable.isCancelled()) {
                runnable.cancel();
            }
        } catch(Exception exception) {
            Bukkit.getConsoleSender().sendMessage("ERROR in stopTabUpdate");
        }
    }
}
