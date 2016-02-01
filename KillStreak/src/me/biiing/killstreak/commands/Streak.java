package me.biiing.killstreak.commands;

import me.biiing.killstreak.KillStreak;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Streak implements CommandExecutor {

	KillStreak plugin;
	public Streak(KillStreak instance) {
		this.plugin = instance;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (cmd.getName().equalsIgnoreCase("streak")) {
				String uuid = p.getUniqueId().toString();
				int streak = plugin.getConfig().getInt("Players." + uuid + ".Streak");
				p.sendMessage("You are on a " + streak + " kill streak");
				return true;
			}
		}
		return false;
	}
}
