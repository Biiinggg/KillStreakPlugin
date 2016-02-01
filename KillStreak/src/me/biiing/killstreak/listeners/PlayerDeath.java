package me.biiing.killstreak.listeners;

import me.biiing.killstreak.KillStreak;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerDeath implements Listener {

	KillStreak plugin;
	public PlayerDeath(KillStreak instance) {
		this.plugin = instance;
	}
	
	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent e) {
		Player p = e.getEntity();
		if (p instanceof Player) {
			String pUUID = p.getUniqueId().toString();
			int deaths = plugin.getConfig().getInt("Players." + pUUID + ".Deaths");
			plugin.getConfig().set("Players." + pUUID + ".Deaths", deaths +1);
			plugin.saveConfig();
			p.sendMessage("Dead?!");	
		}
	}
}
