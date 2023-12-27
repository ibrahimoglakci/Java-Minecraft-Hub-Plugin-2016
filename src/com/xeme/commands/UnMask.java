package com.xeme.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.xeme.api.MessageAPI;
import me.xeme.api.RankAPI;


public class UnMask implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player)sender;
	    if ((cmd.getName().equalsIgnoreCase("unmask")) && sender instanceof Player){
	    	if(args.length == 0){
	    		if(p.hasPermission("Xeme.owner") && p.hasPermission("Xeme.Admin") && p.hasPermission("Xeme.Moderator") && p.hasPermission("Xeme.quantum") && p.hasPermission("Xeme.platinum") && p.hasPermission("Xeme.diamond") && p.hasPermission("Xeme.gold")) {
	    			p.sendMessage("§8[§3Xeme§8] §eYou have been unmasked§8!");
		    		RankAPI.playerSetDisplayName(p);
		   		}else {
		   			MessageAPI.noPermission(p);
		   		}
	    	}
	    }
	    return false;
	}
}
