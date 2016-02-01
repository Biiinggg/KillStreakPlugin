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
		Player k = e.getEntity().getKiller();
		if (k instanceof Player) {
			if (e.getEntity() instanceof Player) {
				String pUUID = k.getUniqueId().toString();
				int kills = plugin.getConfig().getInt("Players." + pUUID + ".Kills");
				int streak = plugin.getConfig().getInt("Players." + pUUID + ".Streak");
				int highstreak = plugin.getConfig().getInt("Players." + pUUID + ".HighestStreak");
				int newstreak = streak + 1;
				plugin.getConfig().set("Players." + pUUID + ".Kills", kills +1);
				plugin.getConfig().set("Players." + pUUID + ".Streak", newstreak);
				if (newstreak > highstreak) {
					plugin.getConfig().set("Players." + pUUID + ".HighestStreak", newstreak);
					k.sendMessage("You have a new highest killstreak of " + newstreak);
					plugin.saveConfig();
				}
				plugin.saveConfig();
			}
		}
	}
}
