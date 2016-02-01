package me.biiing.killstreak.commands;

import me.biiing.killstreak.KillStreak;

import org.bukkit.ChatColor;
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
				p.sendMessage(ChatColor.GOLD + "You have killed " + ChatColor.DARK_RED + kills + ChatColor.GOLD + " players");
				return true;
			}
		}
		return false;
	}

}
