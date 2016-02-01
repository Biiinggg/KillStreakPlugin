package me.biiing.killstreak.listeners;

import me.biiing.killstreak.KillStreak;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerListener implements Listener {
	
	@EventHandler
	public void onPlayerKill(EntityDeathEvent e) {
		Player p = e.getEntity().getKiller();
		if (p instanceof Player) {
			String pUUID = p.getUniqueId().toString();
			int kills = KillStreak.plugin.getConfig().getInt("Players." + pUUID + ".Kills");
			KillStreak.plugin.getConfig().set("Players." + pUUID + ".Kills", kills +1);
			KillStreak.plugin.saveConfig();
			p.sendMessage("Win?!");	
		}
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e){
		Player p = e.getPlayer();
		String uuid = p.getUniqueId().toString();
		if(!KillStreak.plugin.getConfig().contains("Players." + uuid)) { 
			KillStreak.plugin.getConfig().set("Players." + uuid + ".Kills", 0);
			KillStreak.plugin.saveConfig();
		}
	}
}
