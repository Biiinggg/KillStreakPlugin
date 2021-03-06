package me.biiing.killstreak.commands;

import java.util.UUID;

import me.biiing.killstreak.KillStreak;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetDeaths implements CommandExecutor{

	KillStreak plugin;
	public SetDeaths(KillStreak instance) {
		this.plugin = instance;
	}
	
	@SuppressWarnings("deprecation")
	@Override
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("setdeaths")) {
			if (!sender.hasPermission("killstreak.setdeaths")) {
				sender.sendMessage(ChatColor.RED + "You are not permitted to do that!");
				return true;
			}
			// /setkills OR /setkills <player>
			if (args.length == 0 || args.length == 1 || args.length > 2) {
				sender.sendMessage(ChatColor.RED + "Usage: /setdeaths <player> <value>");
				return true;
			}
			
			// /setkills <player> <value>
			if (args.length == 2) {
				Player t = plugin.getServer().getPlayer(args[0]);
				// If player is Offline
				if (t == null) {
					UUID UUID = plugin.getServer().getOfflinePlayer(args[0]).getUniqueId();
					String tUUID = UUID.toString(); 
					if (plugin.getConfig().contains("Players." + tUUID)){ 
						int newdeaths = Integer.parseInt(args[1]);
						plugin.getConfig().set("Players." + tUUID + ".Deaths", newdeaths);
						plugin.saveConfig();
						sender.sendMessage(ChatColor.GOLD + "You have set " + ChatColor.DARK_RED + args[0] + "'s" + ChatColor.GOLD + " deaths to " + ChatColor.DARK_RED + args[1]);
					} else {
						sender.sendMessage(ChatColor.RED + "Player '" + args[0] + "' not found");
					}
					return true;
				} 
				// If Player is Online
				if (t.isOnline()) {
					UUID UUID = plugin.getServer().getPlayer(args[0]).getUniqueId();
					String tUUID = UUID.toString(); 
					if (plugin.getConfig().contains("Players." + tUUID)){ 
						int newdeaths = Integer.parseInt(args[1]);
						plugin.getConfig().set("Players." + tUUID + ".Deaths", newdeaths);
						plugin.saveConfig();
						sender.sendMessage(ChatColor.GOLD + "You have set " + ChatColor.DARK_RED + args[0] + "'s" + ChatColor.GOLD + " deaths to " + ChatColor.DARK_RED + args[1]);
					} else {
						sender.sendMessage(ChatColor.RED + "Player '" + args[0] + "' not found");
					}
					return true;
				}
			}
		}
		
		return false;
	}
}
