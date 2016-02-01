package me.biiing.killstreak.listeners;

import me.biiing.killstreak.KillStreak;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {

	KillStreak plugin;
	public PlayerJoin(KillStreak instance) {
		this.plugin = instance;
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e){
		Player p = e.getPlayer();
		String uuid = p.getUniqueId().toString();
		if(!plugin.getConfig().contains("Players." + uuid)) { 
			plugin.getConfig().set("Players." + uuid + ".Kills", 0);
			plugin.getConfig().set("Players." + uuid + ".Deaths", 0);
			plugin.getConfig().set("Players." + uuid + ".Streak", 0);
			plugin.getConfig().set("Players." + uuid + ".HighestStreak", 0);
			plugin.saveConfig();
		}
	}
}
