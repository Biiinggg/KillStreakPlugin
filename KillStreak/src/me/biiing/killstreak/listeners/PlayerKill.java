package me.biiing.killstreak.listeners;

import me.biiing.killstreak.KillStreak;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class PlayerKill implements Listener {
	
	KillStreak plugin;
	public PlayerKill(KillStreak instance) {
		this.plugin = instance;
	}
	
	@EventHandler
	public void onPlayerKill(EntityDeathEvent e) {
		Player p = e.getEntity().getKiller();
		if (p instanceof Player) {
			String pUUID = p.getUniqueId().toString();
			int kills = plugin.getConfig().getInt("Players." + pUUID + ".Kills");
			int streak = plugin.getConfig().getInt("Players." + pUUID + ".Streak");
			plugin.getConfig().set("Players." + pUUID + ".Kills", kills +1);
			plugin.getConfig().set("Players." + pUUID + ".Streak", streak +1);
			plugin.saveConfig();
			p.sendMessage("Win?!");	
		}
	}
}
