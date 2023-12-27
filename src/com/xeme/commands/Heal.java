package com.xeme.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Heal implements CommandExecutor{
	
	
	
	public boolean onCommand(CommandSender ss, Command cmd, String label, String[] args)
	  {
		Player player = (Player)ss;
	    if (cmd.getName().equalsIgnoreCase("heal"))
	    {
	      if (args.length == 0) {
	    	  player.setHealth(20);
	    	  player.setFoodLevel(20);
	    	  player.sendMessage("&8[&3Xeme&8] &aYou have been Healed".replace("&", "§"));
	      }
	      else if (args.length == 1) {
	    	  Player target = Bukkit.getServer().getPlayer(args[0]);
	    	  target.setHealth(20);
	    	  player.setFoodLevel(20);
	    	  target.sendMessage("&8[&3Xeme&8] &aYou have been Healed".replace("&", "§"));
	      }
	    }
	      return false;
	  }

}
