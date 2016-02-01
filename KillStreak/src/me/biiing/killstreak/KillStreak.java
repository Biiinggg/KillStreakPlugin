package me.biiing.killstreak;

import me.biiing.killstreak.commands.Streak;
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
		getServer().getPluginManager().registerEvents(new PlayerJoin(this), this);
		getServer().getPluginManager().registerEvents(new PlayerKill(this), this);
		getCommand("streak").setExecutor(new Streak(this));
		Bukkit.broadcastMessage("KillStreak Plugin loaded successfully!");
	}
}
