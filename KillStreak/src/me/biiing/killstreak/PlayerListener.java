package me.biiing.killstreak;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class PlayerListener implements Listener {
	
	public static KillStreak plugin;
	KillTracker kt = new KillTracker();
	
	@EventHandler
	public void onPlayerKill(EntityDeathEvent e) {
		Player killer = (Player) e.getEntity().getKiller();
		if (killer instanceof Player) {
			kt.setK(+1);
			killer.sendMessage("Win!");
			
		}
	}
				

}
