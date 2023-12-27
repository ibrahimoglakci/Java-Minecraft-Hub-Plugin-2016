package com.xeme.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.xeme.api.MessageAPI;
import xeme.hub.FancyMessage;

public class Mask implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		Player p = (Player) sender;
	    if ((cmd.getName().equalsIgnoreCase("mask")) && ((sender instanceof Player)))
	    {
	    	if(p.hasPermission("Xeme.owner") && p.hasPermission("Xeme.Admin") && p.hasPermission("Xeme.Moderator") && p.hasPermission("Xeme.quantum") && p.hasPermission("Xeme.platinum") && p.hasPermission("Xeme.diamond") && p.hasPermission("Xeme.gold")) {
	    		if (args.length == 0)
	    		{
		  	        if (sender.hasPermission("Xeme.Moderator"))
		  	        {
		  	        	sender.sendMessage("§8[§3Xeme§8] §fYou can mask as the following ranks§8;");
		  	        	new FancyMessage("§8[§3Xeme§8]          [")
		  				.color(ChatColor.DARK_GRAY)
		  				.then("    ✘")
		  				.style(ChatColor.BOLD)
		  				.color(ChatColor.DARK_GREEN)
		  				.command("/mask regular")
		  				.tooltip("§fFollowing Mask to §2Regular")
		  				.then("    ✘")
		  				.style(ChatColor.BOLD)
		  				.color(ChatColor.GOLD)
		  				.command("/mask gold")
		  				.tooltip("§fFollowing Mask to §6Gold")
		  				.then("    ✘")
		  				.style(ChatColor.BOLD)
		  				.color(ChatColor.DARK_AQUA)
		  				.command("/mask diamond")
		  				.tooltip("§fFollowing Mask to §3Diamond")
		  	        	.then("    ✘")
		  				.style(ChatColor.BOLD)
		  				.color(ChatColor.AQUA)
		  				.command("/mask platinum")
		  				.tooltip("§fFollowing Mask to §bPlatinum")
		  	        	.then("    ✘")
		  				.style(ChatColor.BOLD)
		  				.color(ChatColor.GREEN)
		  				.command("/mask quantum")
		  				.tooltip("§fFollowing Mask to §aQuantum")
		  	        	.then(" ]")
		  	        	.style(ChatColor.BOLD)
		  		        .color(ChatColor.DARK_GRAY)
		  		        .then("    [")
		  		        .style(ChatColor.BOLD)
		  		        .color(ChatColor.DARK_GRAY)
		  		        .then("OFF")
		  				.style(ChatColor.BOLD)
		  				.color(ChatColor.WHITE)
		  				.command("/unmask")
		  				.tooltip("§fUnmask")
		  				.then("]")
		  		        .style(ChatColor.BOLD)
		  		        .color(ChatColor.DARK_GRAY)
		  		        .send(p);
		  	          return true;
		  	        }
		  	        if (sender.hasPermission("Xeme.Quantum"))
		  	        {
		  	          sender.sendMessage("§8[§3Xeme§8] §fYou can mask as the following ranks§8;");
		  	          new FancyMessage("§8[§3Xeme§8]          [")
		  				.color(ChatColor.DARK_GRAY)
		  				.then("    ✘")
		  				.style(ChatColor.BOLD)
		  				.color(ChatColor.DARK_GREEN)
		  				.command("/mask regular")
		  				.tooltip("§fFollowing Mask to §2Regular")
		  				.then("    ✘")
		  				.style(ChatColor.BOLD)
		  				.color(ChatColor.GOLD)
		  				.command("/mask gold")
		  				.tooltip("§fFollowing Mask to §6Gold")
		  				.then("    ✘")
		  				.style(ChatColor.BOLD)
		  				.color(ChatColor.DARK_AQUA)
		  				.command("/mask diamond")
		  				.tooltip("§fFollowing Mask to §3Diamond")
		  	        	.then("    ✘")
		  				.style(ChatColor.BOLD)
		  				.color(ChatColor.AQUA)
		  				.command("/mask platinum")
		  				.tooltip("§fFollowing Mask to §bPlatinum")
		  				.then("     [")
		  		        .style(ChatColor.BOLD)
		  		        .color(ChatColor.DARK_GRAY)
		  		        .then(" OFF")
		  				.style(ChatColor.BOLD)
		  				.color(ChatColor.WHITE)
		  				.command("/unmask")
		  				.tooltip("§fUnmask")
		  				.then(" ]")
		  		        .style(ChatColor.BOLD)
		  		        .color(ChatColor.DARK_GRAY)
		  				.then(" ]")
		  	        	.style(ChatColor.BOLD)
		  		        .color(ChatColor.DARK_GRAY)
		  		        .send(p);
		  	          return true;
		  	        }
		  	        if (sender.hasPermission("Xeme.platinum"))
		  	        {
		  	          sender.sendMessage("§8[§3Xeme§8] §fYou can mask as the following ranks§8;");
		  	          new FancyMessage("§8[§3Xeme§8]          [")
		  				.color(ChatColor.DARK_GRAY)
		  				.then("    ✘")
		  				.style(ChatColor.BOLD)
		  				.color(ChatColor.DARK_GREEN)
		  				.command("/mask regular")
		  				.tooltip("§fFollowing Mask to §2Regular")
		  				.then("    ✘")
		  				.style(ChatColor.BOLD)
		  				.color(ChatColor.GOLD)
		  				.command("/mask gold")
		  				.tooltip("§fFollowing Mask to §6Gold")
		  				.then("    ✘")
		  				.style(ChatColor.BOLD)
		  				.color(ChatColor.DARK_AQUA)
		  				.command("/mask diamond")
		  				.tooltip("§fFollowing Mask to §3Diamond")
		  				.then("     [")
		  		        .style(ChatColor.BOLD)
		  		        .color(ChatColor.DARK_GRAY)
		  		        .then(" OFF")
		  				.style(ChatColor.BOLD)
		  				.color(ChatColor.WHITE)
		  				.command("/unmask")
		  				.tooltip("§fUnmask")
		  				.then(" ]")
		  		        .style(ChatColor.BOLD)
		  		        .color(ChatColor.DARK_GRAY)
		  	          	.then(" ]")
		  	        	.style(ChatColor.BOLD)
		  		        .color(ChatColor.DARK_GRAY)
		  		        .send(p);
		  	          return true;
		  	        }
		  	        if (sender.hasPermission("Xeme.diamond"))
		  	        {
		  	          sender.sendMessage("§8[§3Xeme§8] §fYou can mask as the following ranks§8;");
		  	          new FancyMessage("§8[§3Xeme§8]          [")
		  				.color(ChatColor.DARK_GRAY)
		  				.then("    ✘")
		  				.style(ChatColor.BOLD)
		  				.color(ChatColor.DARK_GREEN)
		  				.command("/mask regular")
		  				.tooltip("§fFollowing Mask to §2Regular")
		  				.then("    ✘")
		  				.style(ChatColor.BOLD)
		  				.color(ChatColor.GOLD)
		  				.command("/mask gold")
		  				.tooltip("§fFollowing Mask to §6Gold")
		  				.then("     [")
		  		        .style(ChatColor.BOLD)
		  		        .color(ChatColor.DARK_GRAY)
		  		        .then(" OFF")
		  				.style(ChatColor.BOLD)
		  				.color(ChatColor.WHITE)
		  				.command("/unmask")
		  				.tooltip("§fUnmask")
		  				.then(" ]")
		  		        .style(ChatColor.BOLD)
		  		        .color(ChatColor.DARK_GRAY)
		  				.then(" ]")
		  	        	.style(ChatColor.BOLD)
		  		        .color(ChatColor.DARK_GRAY)
		  		        .send(p);
		  	          return true;
		  	        }
		  	        if (sender.hasPermission("Xeme.gold"))
		  	        {
		  	          sender.sendMessage("§8[§3Xeme§8] §fYou can mask as the following ranks§8;");
		  	          new FancyMessage("§8[§3Xeme§8]          [")
		  				.color(ChatColor.DARK_GRAY)
		  				.then("    ✘")
		  				.style(ChatColor.BOLD)
		  				.color(ChatColor.DARK_GREEN)
		  				.command("/mask regular")
		  				.tooltip("§fFollowing Mask to §2Regular")
		  				.then("     [")
		  		        .style(ChatColor.BOLD)
		  		        .color(ChatColor.DARK_GRAY)
		  		        .then(" OFF")
		  				.style(ChatColor.BOLD)
		  				.color(ChatColor.WHITE)
		  				.command("/unmask")
		  				.tooltip("§fUnmask")
		  				.then(" ]")
		  		        .style(ChatColor.BOLD)
		  		        .color(ChatColor.DARK_GRAY)
		  				.then(" ]")
		  	        	.style(ChatColor.BOLD)
		  		        .color(ChatColor.DARK_GRAY)
		  		        .send(p);
		  	          return true;
		  	        }
		  	        MessageAPI.noPermission(p);
		  	        return true;
		  	      }
	  	      if (args.length == 1)
	  	      {
	  	        if (args[0].equalsIgnoreCase("regular"))
	  	        {
	  	          if (!sender.hasPermission("Xeme.gold"))
	  	          {
	  	           MessageAPI.noPermission(p);
	  	            return true;
	  	          }
	  	          sender.sendMessage("§8[§3Xeme§8] §eYou have been masked as §2Regular§8!");
	  	          p.setDisplayName(ChatColor.DARK_GREEN + p.getName());
	  	          p.setPlayerListName(ChatColor.DARK_GREEN + p.getName());
	  	          return true;
	  	        }
	  	        if (args[0].equalsIgnoreCase("gold"))
	  	        {
	  	          if (!sender.hasPermission("Xeme.diamond"))
	  	          {
	  	           MessageAPI.noPermission(p);
	  	            return true;
	  	          }
	  	          sender.sendMessage("§8[§3Xeme§8] §eYou have been masked as §6Gold§8!");
	  	          p.setDisplayName(ChatColor.GOLD + p.getName());
	  	          p.setPlayerListName(ChatColor.GOLD + p.getName());
	  	          return true;
	  	        }
	  	        if (args[0].equalsIgnoreCase("diamond"))
	  	        {
	  	          if (!sender.hasPermission("Xeme.platinum"))
	  	          {
	  	           MessageAPI.noPermission(p);
	  	            return true;
	  	          }
	  	          sender.sendMessage("§8[§3Xeme§8] §eYou have been masked as §3Diamond§8!");
	  	          p.setDisplayName(ChatColor.DARK_AQUA + p.getName());
	  	          p.setPlayerListName(ChatColor.DARK_AQUA + p.getName());
	  	          return true;
	  	        }
	  	        if (args[0].equalsIgnoreCase("platinum"))
	  	        {
	  	          if (!sender.hasPermission("Xeme.quantum"))
	  	          {
	  	           MessageAPI.noPermission(p);
	  	            return true;
	  	          }
	  	          sender.sendMessage("§8[§3Xeme§8] §eYou have been masked as §bPlatinum§8!");
	  	          p.setDisplayName(ChatColor.AQUA + p.getName());
	  	          p.setPlayerListName(ChatColor.AQUA + p.getName());
	  	          return true;
	  	        }
	  	        if (args[0].equalsIgnoreCase("quantum"))
	  	        {
	  	          if (!sender.hasPermission("Xeme.moderator"))
	  	          {
	  	        	MessageAPI.noPermission(p);
	  	            return true;
	  	          }
	  	          sender.sendMessage("§8[§3Xeme§8] §eYou have been masked as §aQuantum§8!");
	  	          p.setDisplayName("§a" + p.getName());
	  	          p.setPlayerListName("§a" + p.getName());
	  	          return true;
	  	        }
	  	        p.sendMessage("§8[§3Xeme§8]§r §cInvaid rank§8!");
	  	      }
	  	      else
	  	      {
	  	        if (sender.hasPermission("Xeme.Moderator"))
	  	        {
	  	          sender.sendMessage("§8[§3Xeme§8] §fYou can mask as the following ranks§8;");
	  	          sender.sendMessage("§8[§3Xeme§8] §2Regular§f, §6Gold§f, §3Diamond§f, §bPlatinum§f, §aQuantum");
	  	          return true;
	  	        }
	  	        if (sender.hasPermission("Xeme.Quantum"))
	  	        {
	  	          sender.sendMessage("§8[§3Xeme§8] §fYou can mask as the following ranks§8;");
	  	          sender.sendMessage("§8[§3Xeme§8] §2Regular§f, §6Gold§f, §3Diamond§f, §bPlatinum");
	  	          return true;
	  	        }
	  	        if (sender.hasPermission("Xeme.platinum"))
	  	        {
	  	          sender.sendMessage("§8[§3Xeme§8] §fYou can mask as the following ranks§8;");
	  	          sender.sendMessage("§8[§3Xeme§8] §2Regular§f, §6Gold§f, §3Diamond");
	  	          return true;
	  	        }
	  	        if (sender.hasPermission("Xeme.diamond"))
	  	        {
	  	          sender.sendMessage("§8[§3Xeme§8] §fYou can mask as the following ranks§8;");
	  	          sender.sendMessage("§8[§3Xeme§8] §2Regular§f, §6Gold");
	  	          return true;
	  	        }
	  	        if (sender.hasPermission("Xeme.gold"))
	  	        {
	  	          sender.sendMessage("§8[§3Xeme§8] §fYou can mask as the following ranks§8;");
	  	          sender.sendMessage("§8[§3Xeme§8] §2Regular");
	  	          return true;
	  	        }
	  	       MessageAPI.noPermission(p);
	  	        return true;
	  	      }
	    	}else {
	    		MessageAPI.noPermission(p);
	    	}
	      
	    }
	    return false;
	  }
	}
