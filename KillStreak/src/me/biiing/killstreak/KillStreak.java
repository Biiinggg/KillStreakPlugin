package me.biiing.killstreak;

import me.biiing.killstreak.commands.Deaths;
import me.biiing.killstreak.commands.Kills;
import me.biiing.killstreak.listeners.PlayerDeath;
import me.biiing.killstreak.listeners.PlayerJoin;
import me.biiing.killstreak.listeners.PlayerKill;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class KillStreak extends JavaPlugin {
	
	public static KillStreak plugin;
	
	@Override
	public void onDisable() {
		
	}

	@Override
	public void onEnable() {
		plugin = this;
		//Listeners
		getServer().getPluginManager().registerEvents(new PlayerJoin(this), this);
		getServer().getPluginManager().registerEvents(new PlayerKill(this), this);
		getServer().getPluginManager().registerEvents(new PlayerDeath(this), this);
		getCommand("kills").setExecutor(new Kills(this));
		getCommand("deaths").setExecutor(new Deaths(this));
		Bukkit.broadcastMessage("KillStreak Plugin loaded successfully!");
	}
}
