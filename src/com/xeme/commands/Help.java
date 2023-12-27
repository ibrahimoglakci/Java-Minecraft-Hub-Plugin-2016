package com.xeme.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Help implements CommandExecutor{
	
	String prefix = "§8[§3Xeme§8]";
	
	 public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	  {
		 Player p = (Player) sender;
		 if(cmd.getName().equalsIgnoreCase("help")) {
			 if(args.length == 0) {
				 p.sendMessage(prefix + " &8&m------------&3 HyperWalkMC Commands &8&m------------".replace("&", "§"));
				 if(p.hasPermission("hyperwalk.admin") || p.hasPermission("hyperwalk.srmderator") || p.hasPermission("hyperwalk.moderator")) {
					 p.sendMessage(prefix + " &6Ban&8: &4/ban <player> [time spec] [reason - evidence]".replace("&", "§"));
					 p.sendMessage(prefix + " &6Gamemaster&8: &4/goto <player>".replace("&", "§"));
					 p.sendMessage(prefix + " &6Mute&8: &4/mute <player> [time spec] [reason - evidence]".replace("&", "§"));
					 p.sendMessage(prefix + " &6Lookup&8: &4/lookup <player>".replace("&", "§"));
					 p.sendMessage(prefix + " &6Chatcolor&8: &f/chatcolor <ColorCode:OFF>".replace("&", "§"));
					 p.sendMessage(prefix + " &6Fly&8: &f/fly <on,off>".replace("&", "§"));
					 p.sendMessage(prefix + " &6Disguise&8: &f/disguise , /undisguise".replace("&", "§"));
					 p.sendMessage(prefix + " &6List&8: &f/list".replace("&", "§"));
					 p.sendMessage(prefix + " &6Ping&8: &f/ping".replace("&", "§"));
					 p.sendMessage(prefix + " &6Report&8: &f/report <player>".replace("&", "§"));
					 p.sendMessage(prefix + " &6Apply&8: &f/apply".replace("&", "§"));
				 }else if(p.hasPermission("hyperwalk.srmderator") || p.hasPermission("hyperwalk.moderator") || p.hasPermission("hyperwalk.host") || p.hasPermission("hyperwalk.walk") || p.hasPermission("hyperwalk.hyper") || p.hasPermission("hyperwalk.donator")) {
					 p.sendMessage(prefix + " &6Chatcolor&8: &f/chatcolor <ColorCode:OFF>".replace("&", "§"));
					 p.sendMessage(prefix + " &6Fly&8: &f/fly <on,off>".replace("&", "§"));
					 p.sendMessage(prefix + " &6Disguise&8: &f/disguise , /undisguise".replace("&", "§"));
					 p.sendMessage(prefix + " &6Chatcolor&8: &f/chatcolor <ColorCode:OFF>".replace("&", "§"));
					 p.sendMessage(prefix + " &6List&8: &f/list".replace("&", "§"));
					 p.sendMessage(prefix + " &6Ping&8: &f/ping".replace("&", "§"));
					 p.sendMessage(prefix + " &6Report&8: &f/report <player>".replace("&", "§"));
					 p.sendMessage(prefix + " &6Apply&8: &f/apply".replace("&", "§"));
				 }else {
					 p.sendMessage(prefix + " &6List&8: &f/list".replace("&", "§"));
					 p.sendMessage(prefix + " &6Ping&8: &f/ping".replace("&", "§"));
					 p.sendMessage(prefix + " &6Report&8: &f/report <player>".replace("&", "§"));
					 p.sendMessage(prefix + " &6Apply&8: &f/apply".replace("&", "§"));
				 }
				 
					 
				 
			 }
		 }
		 
		 return false;
	  }

}
