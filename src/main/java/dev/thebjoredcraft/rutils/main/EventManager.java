package dev.thebjoredcraft.rutils.main;

import dev.thebjoredcraft.rutils.game.tab.TabListManager;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class EventManager implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        TabListManager.updateTablist();
    }

    @EventHandler
    public void onLeft(PlayerQuitEvent event){
        TabListManager.updateTablist();
    }
    @EventHandler
    public void onBuild(BlockPlaceEvent event){
        if(!event.getPlayer().hasPermission(Permission.BUILD.get())){
            event.getPlayer().sendMessage(PlayerData.getB(event.getPlayer(), PlayerData.de) ? Message.CANNOT_BUILD_DE.get() : Message.CANNOT_BUILD_EN.get());
            event.setCancelled(true);
        }
    }
    @EventHandler
    public void onDestroy(BlockBreakEvent event){
        if(!event.getPlayer().hasPermission(Permission.DESTROY.get())){
            event.getPlayer().sendMessage(PlayerData.getB(event.getPlayer(), PlayerData.de) ? Message.CANNOT_DESTROY_DE.get() : Message.CANNOT_DESTROY_EN.get());
            event.setCancelled(true);
        }
    }
    @EventHandler
    public void onEntityByEntityDamage(EntityDamageByEntityEvent event){
        //PLAYER -> PLAYER
        if(event.getDamager() instanceof Player attacker && event.getEntity() instanceof Player target){
            if(!attacker.hasPermission(Permission.ATTACK_PLAYER.get())) {
                attacker.sendMessage(PlayerData.getB(attacker, PlayerData.de) ? Message.CANNOT_ATTACK_PLAYER_DE.get() : Message.CANNOT_ATTACK_PLAYER_EN.get());
                event.setCancelled(true);
            }
            if(!target.hasPermission(Permission.ATTACKED_BY_PLAYER.get())){
                attacker.sendMessage(PlayerData.getB(attacker, PlayerData.de) ? Message.CANNOT_ATTACK_PLAYER_DE.get() : Message.CANNOT_ATTACK_PLAYER_EN.get());
                event.setCancelled(true);
            }
        }
    }
    @EventHandler
    public void onChat(AsyncPlayerChatEvent event){
        if(PlayerData.getB(event.getPlayer(), PlayerData.muted)){
            event.getPlayer().sendMessage("muted");
            event.setCancelled(true);
        }
    }
}
