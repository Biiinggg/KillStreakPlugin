package me.biiing.killstreak.commands;

import java.util.UUID;

import me.biiing.killstreak.KillStreak;

import org.bukkit.ChatColor;
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
			if (args.length == 0) {
				if (cmd.getName().equalsIgnoreCase("highstreak")) {
					String uuid = p.getUniqueId().toString();
					int higheststreak = plugin.getConfig().getInt("Players." + uuid + ".HighestStreak");
					p.sendMessage(ChatColor.GOLD + "Your highest kill streak is " + ChatColor.DARK_RED + higheststreak + ChatColor.GOLD + " kills");
					return true;
					}
				}
				if (args.length == 1) {
					@SuppressWarnings("deprecation")
					Player t = plugin.getServer().getPlayer(args[0]);
					// If player is Offline
					if (t == null) {
						@SuppressWarnings("deprecation")
						UUID UUID = plugin.getServer().getOfflinePlayer(args[0]).getUniqueId();
						String tUUID = UUID.toString(); 
						if (plugin.getConfig().contains("Players." + tUUID)){
							int highstreak = plugin.getConfig().getInt("Players." + tUUID + ".HighestStreak");
							sender.sendMessage(ChatColor.DARK_RED + args[0] + "'s" + ChatColor.GOLD + " highest kill streak is " + ChatColor.DARK_RED + highstreak);
						} else {
							sender.sendMessage(ChatColor.RED + "Player '" + args[0] + "' not found");
						}
						return true;
					} 
					// If Player is Online
					if (t.isOnline()) {
						@SuppressWarnings("deprecation")
						UUID UUID = plugin.getServer().getPlayer(args[0]).getUniqueId();
						String tUUID = UUID.toString(); 
						if (plugin.getConfig().contains("Players." + tUUID)){ 
							int highstreak = plugin.getConfig().getInt("Players." + tUUID + ".HighestStreak");
							sender.sendMessage(ChatColor.DARK_RED + args[0] + "'s" + ChatColor.GOLD + " highest kill streak is " + ChatColor.DARK_RED + highstreak);
						} else {
							sender.sendMessage(ChatColor.RED + "Player '" + args[0] + "' not found");
						}
						return true;
					}
							
				}
				if (args.length > 1) {
					sender.sendMessage(ChatColor.RED + "Usage: /highstreak OR /highstreak <player>");
					return true;
				}
			}
		return false;
	}
}
