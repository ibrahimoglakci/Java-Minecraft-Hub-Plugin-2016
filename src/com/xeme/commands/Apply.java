package com.xeme.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Apply implements CommandExecutor{
	
	
	 public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	  {
	    Player p = (Player) sender;
	    if(cmd.getName().equalsIgnoreCase("apply")) {
	    	if(args.length == 0) {
	    		p.sendMessage("§8[§3Xeme§8] §6§lAuraGamer is Hiring!");
	    		p.sendMessage("§8[§3Xeme§8] §6We're looking for people willing to help us moderate the servers and remove rule breakers!");
	    		p.sendMessage("§8[§3Xeme§8] §6If you feel like you could help out, apply at:");
	    		p.sendMessage("§8[§3Xeme§8] §ehttps://apply.auragamer.net");
	    		
	    	} 
	    }
	    
	    
	   return false; 
	  }

}
