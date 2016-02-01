package me.biiing.killstreak;

import org.bukkit.plugin.java.JavaPlugin;

public class KillStreak extends JavaPlugin {
	
	@Override
	public void onDisable() {
		
	}

	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(new PlayerListener(), this);
//		getCommand("COMMANDHERE").setExecutor(new Commands(this));
	}
}
