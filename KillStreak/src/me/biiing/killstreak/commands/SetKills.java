package me.biiing.killstreak.commands;

import me.biiing.killstreak.KillStreak;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetKills implements CommandExecutor {

	KillStreak plugin;
	public SetKills(KillStreak instance) {
		this.plugin = instance;
	}
	
	@SuppressWarnings("deprecation")
	@Override
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("setkills")) {
			if (!sender.hasPermission("killstreak.setkills")) {
				sender.sendMessage(ChatColor.RED + "You are not permitted to do that!");
				return true;
			}
			// /setkills OR /setkills <player>
			if (args.length == 0 || args.length == 1) {
				sender.sendMessage(ChatColor.RED + "Usage: /setkills <player> <value>");
				return true;
			}
			
			// /setkills <player> <value>
			if (args.length == 2) { 
				Player t = Bukkit.getServer().getPlayer(args[0]);
				String tUUID = t.getUniqueId().toString();
				if (plugin.getConfig().contains("Players." + tUUID + ".Kills")) {
					int newkills = Integer.parseInt(args[1]);
					plugin.getConfig().set("Players." + tUUID + ".Kills", newkills);
					plugin.saveConfig();
					return true;
				}
				if (!plugin.getConfig().contains(tUUID)) {
					sender.sendMessage(ChatColor.RED + "Player not found");
					return true;
				}
			}
		}
		
		return false;
	}

}
