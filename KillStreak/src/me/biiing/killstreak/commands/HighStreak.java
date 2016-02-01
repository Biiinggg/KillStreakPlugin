package me.biiing.killstreak.commands;

import me.biiing.killstreak.KillStreak;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HighStreak implements CommandExecutor{

	KillStreak plugin;
	public HighStreak(KillStreak instance) {
		this.plugin = instance;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (cmd.getName().equalsIgnoreCase("highstreak")) {
				String uuid = p.getUniqueId().toString();
				int higheststreak = plugin.getConfig().getInt("Players." + uuid + ".HighestStreak");
				p.sendMessage("You have " + higheststreak + " HighSreak");
				return true;
			}
		}
		return false;
	}
}
