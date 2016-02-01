package me.biiing.killstreak;

import me.biiing.killstreak.commands.Commands;
import me.biiing.killstreak.listeners.PlayerListener;

import org.bukkit.plugin.java.JavaPlugin;

public class KillStreak extends JavaPlugin {
	
	@Override
	public void onDisable() {
		
	}

	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(new PlayerListener(), this);
		getCommand("streak").setExecutor(new Commands(this));

	}
}
