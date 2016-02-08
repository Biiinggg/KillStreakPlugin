package me.biiing.killstreak.commands;

import java.util.UUID;

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
				if (args.length == 0) {
					String uuid = p.getUniqueId().toString();
					int kills = plugin.getConfig().getInt("Players." + uuid + ".Kills");
					p.sendMessage(ChatColor.GOLD + "You have killed " + ChatColor.DARK_RED + kills + ChatColor.GOLD + " players");
					return true;
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
							int kills = plugin.getConfig().getInt("Players." + tUUID + ".Kills");
							sender.sendMessage(ChatColor.DARK_RED + args[0] + ChatColor.GOLD + " has " + ChatColor.DARK_RED + kills + ChatColor.GOLD + " kills" );
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
							int kills = plugin.getConfig().getInt("Players." + tUUID + ".Kills");
							sender.sendMessage(ChatColor.DARK_RED + args[0] + ChatColor.GOLD + " has " + ChatColor.DARK_RED + kills + ChatColor.GOLD + " kills" );
						} else {
							sender.sendMessage(ChatColor.RED + "Player '" + args[0] + "' not found");
						}
						return true;
					}
				}
			}
		}
		return false;
	}

}
