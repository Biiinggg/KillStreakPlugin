package me.biiing.killstreak.commands;

import me.biiing.killstreak.KillStreak;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Deaths implements CommandExecutor{

	KillStreak plugin;
	public Deaths(KillStreak instance) {
		this.plugin = instance;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player){
			Player p = (Player) sender;
			if (cmd.getName().equalsIgnoreCase("deaths")) {
				String uuid = p.getUniqueId().toString();
				int deaths = KillStreak.plugin.getConfig().getInt("Players." + uuid + ".Deaths");
				p.sendMessage("You have " + deaths + " Deaths");
				return true;
			}		
		}
		return false;
	}

}
