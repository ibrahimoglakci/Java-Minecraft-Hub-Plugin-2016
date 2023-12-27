package com.xeme.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Lookup implements CommandExecutor{

	
	String prefix = "§8[§bXeme§8]§r";
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		
		if(cmd.getName().equalsIgnoreCase("lookup")) {
			if(p.hasPermission("Xeme.Owner") || p.hasPermission("Xeme.Admin") || p.hasPermission("Xeme.srmod") || p.hasPermission("Xeme.mod")) {
				if(args.length == 0) {
					p.sendMessage(prefix + " §cUsage: /lookup <player>");
					
				}else if(args.length == 1) {
					Player target = Bukkit.getPlayer(args[0]);
					if(target != null) {
						p.sendMessage("§8§m---------------§r " + p.getDisplayName() + "§e's History§r §8§m---------------");
						p.sendMessage(prefix + " ");
						p.sendMessage(prefix + "  §4§lBAN §7§l» §e0");
					}
				}
			}
		}
		return false;
	}
	
	

}
