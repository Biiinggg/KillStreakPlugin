package me.biiing.killstreak.commands;

import java.util.UUID;

import me.biiing.killstreak.KillStreak;

import org.bukkit.ChatColor;
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
			if (args.length == 0){
				if (cmd.getName().equalsIgnoreCase("streak")) {
					String uuid = p.getUniqueId().toString();
					int streak = plugin.getConfig().getInt("Players." + uuid + ".Streak");
					p.sendMessage(ChatColor.GOLD + "You are currently on a " + ChatColor.DARK_RED + streak + ChatColor.GOLD + " kill streak");
					return true;
				}
			}
			if (args.length == 1) {
				if (args.length == 1) {
					@SuppressWarnings("deprecation")
					Player t = plugin.getServer().getPlayer(args[0]);
					// If player is Offline
					if (t == null) {
						@SuppressWarnings("deprecation")
						UUID UUID = plugin.getServer().getOfflinePlayer(args[0]).getUniqueId();
						String tUUID = UUID.toString(); 
						if (plugin.getConfig().contains("Players." + tUUID)){
							int streak = plugin.getConfig().getInt("Players." + tUUID + ".Streak");
							sender.sendMessage(ChatColor.DARK_RED + args[0] + ChatColor.GOLD + " has a streak of " + ChatColor.DARK_RED + streak);
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
							int streak = plugin.getConfig().getInt("Players." + tUUID + ".Streak");
							sender.sendMessage(ChatColor.DARK_RED + args[0] + ChatColor.GOLD + " has a streak of " + ChatColor.DARK_RED + streak);
						} else {
							sender.sendMessage(ChatColor.RED + "Player '" + args[0] + "' not found");
						}
						return true;
					}
				}
			}
			if (args.length > 1) {
				sender.sendMessage(ChatColor.RED + "Usage: /streak OR /streak <player>");
				return true;
			}
		}
		return false;
	}
}
