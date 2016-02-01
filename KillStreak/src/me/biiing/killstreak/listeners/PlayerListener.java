package me.biiing.killstreak.listeners;

import me.biiing.killstreak.KillStreak;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class PlayerListener implements Listener {
	
	public static KillStreak plugin;
	
	@EventHandler
	public void onPlayerKill(EntityDeathEvent e) {
		Entity entity = e.getEntity().getKiller();
		if (entity instanceof Player) {
//			kt.setK(10);
			entity.sendMessage("Win!");
			
		}
	}
				

}
