package dev.thebjoredcraft.rutils.main;

import dev.thebjoredcraft.rutils.Rutils;

import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;

import org.bukkit.persistence.PersistentDataType;

public class PlayerData {
    public static NamespacedKey muted = new NamespacedKey(Rutils.getInstance(), "muted");
    public static NamespacedKey de = new NamespacedKey(Rutils.getInstance(), "de");
    public static void set(Player player, NamespacedKey key, Boolean arg){
        player.getPersistentDataContainer().set(key, PersistentDataType.BOOLEAN, arg);
    }
    public static void set(Player player, NamespacedKey key, String arg){
        player.getPersistentDataContainer().set(key, PersistentDataType.STRING, arg);
    }
    public static String getS(Player player, NamespacedKey key) {
        return player.getPersistentDataContainer().get(key, PersistentDataType.STRING);
    }
    public static Boolean getB(Player player, NamespacedKey key) {
        return player.getPersistentDataContainer().get(key, PersistentDataType.BOOLEAN);
    }

}
