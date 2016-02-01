package me.biiing.killstreak.commands;

import me.biiing.killstreak.KillStreak;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commands implements CommandExecutor {
	
	@SuppressWarnings("unused")
	private KillStreak plugin;
	public Commands(KillStreak plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (cmd.getName().equalsIgnoreCase("streak")) {
//				p.sendMessage("You have " +  + " kills");
				return true;
			}
		}
		return false;
	}

}
