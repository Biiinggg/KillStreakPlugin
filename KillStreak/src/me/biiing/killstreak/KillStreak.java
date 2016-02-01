package me.biiing.killstreak;

import me.biiing.killstreak.commands.Deaths;
import me.biiing.killstreak.commands.HighStreak;
import me.biiing.killstreak.commands.Kills;
import me.biiing.killstreak.commands.SetDeaths;
import me.biiing.killstreak.commands.SetHighStreak;
import me.biiing.killstreak.commands.SetKills;
import me.biiing.killstreak.commands.SetStreak;
import me.biiing.killstreak.commands.Streak;
import me.biiing.killstreak.listeners.PlayerDeath;
import me.biiing.killstreak.listeners.PlayerJoin;
import me.biiing.killstreak.listeners.PlayerKill;

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
		//Commands
		getCommand("kills").setExecutor(new Kills(this));
		getCommand("deaths").setExecutor(new Deaths(this));
		getCommand("streak").setExecutor(new Streak(this));
		getCommand("setkills").setExecutor(new SetKills(this));
		getCommand("setdeaths").setExecutor(new SetDeaths(this));
		getCommand("setstreak").setExecutor(new SetStreak(this));
		getCommand("highstreak").setExecutor(new HighStreak(this));
		getCommand("sethighstreak").setExecutor(new SetHighStreak(this));
	}
}
