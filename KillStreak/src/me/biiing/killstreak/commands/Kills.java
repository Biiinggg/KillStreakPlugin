package me.biiing.killstreak.commands;

import me.biiing.killstreak.KillStreak;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Kills implements CommandExecutor{

	KillStreak plugin;
	public Kills(KillStreak instance) {
		this.plugin = instance;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (cmd.getName().equalsIgnoreCase("kills")) {
				String uuid = p.getUniqueId().toString();
				int kills = plugin.getConfig().getInt("Players." + uuid + ".Kills");
				p.sendMessage("You have " + kills + " Kills");
				return true;
			}
		}
		return false;
	}

}
