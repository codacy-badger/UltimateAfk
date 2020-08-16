package me.stefan923.ultimateafk.listeners;

import me.stefan923.ultimateafk.UltimateAfk;
import me.stefan923.ultimateafk.utils.MessageUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;

public class PlayerToggleSneakListener implements Listener, MessageUtils {

    private final UltimateAfk instance;

    public PlayerToggleSneakListener(UltimateAfk instance) {
        this.instance = instance;
    }

    @EventHandler
    public void onToggleSneak(PlayerToggleSneakEvent event) {
        Player player = event.getPlayer();
        if (instance.isAfk(player.getName())) {
            player.sendMessage(formatAll(instance.getLanguageManager().getConfig().getString("Event.Toggle Sneak Event")));
        }
        instance.getAfkPlayers().replace(player.getName(), System.currentTimeMillis());
    }

}
