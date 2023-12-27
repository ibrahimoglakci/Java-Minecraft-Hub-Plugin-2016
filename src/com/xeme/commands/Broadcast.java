package com.xeme.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Broadcast
  implements CommandExecutor
{
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    Player player = (Player) sender;
    if ((cmd.getName().equalsIgnoreCase("alert") || cmd.getName().equalsIgnoreCase("broadcast")) && 
      (player.hasPermission("Xeme.developer"))) {
      if (args.length == 0) {
        player.sendMessage("§8[§3Xeme§8] §cCorrect usage§8: §a/alert <message>");
      }
      else {
	     String message = "";
	     for (int i = 0; i < args.length; i++) {
	    	 message = message + args[i] + " ";
	     }
	     String format = "§8[§3Xeme§8] §f" + message.replace("&", "§");
	        Bukkit.broadcastMessage(format);
      }
    }
    
    return false;
  }
}
