package me.biiing.killstreak;

import me.biiing.killstreak.commands.Commands;
import me.biiing.killstreak.listeners.PlayerListener;

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
		getServer().getPluginManager().registerEvents(new PlayerListener(), this);
		getCommand("streak").setExecutor(new Commands(this));
		Bukkit.broadcastMessage("KillStreak Plugin loaded successfully!");
	}
}
