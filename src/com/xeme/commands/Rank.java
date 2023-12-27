package com.xeme.commands;




import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.xeme.Main;

import me.xeme.api.MessageAPI;
import me.xeme.api.NameAPI;

public class Rank implements CommandExecutor{
	
	
	String prefix = "&8[&3Xeme&8]".replace("&", "§");
	
	
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	  Player p = (Player) sender;
	  if(cmd.getName().equalsIgnoreCase("rank")) {
		  if(p.hasPermission("xeme.admin")) {
			  if(args.length == 0) {
				  p.sendMessage(this.prefix + " &cUsage: /rank &8[&2Regular&7/&6GoldDonor&7/&3DiamonDonor&7/&bPlatinumDonor&7/&aQuantumDonor&7/&cModerator&7/&4Sr.Moderator&7/&4&lAdmin&7/&9&lDeveloper&7/&4&lOwner&8]".replace("&", "§"));
			  }
			  else if(args.length == 1) {
				  Player target = Bukkit.getPlayer(args[0]);
				  if(target != null) {
					  p.sendMessage(this.prefix + " &cUsage: /rank &8[&2Regular&7/&6GoldDonor&7/&3DiamonDonor&7/&bPlatinumDonor&7/&aQuantumDonor&7/&cModerator&7/&4Sr.Moderator&7/&4&lAdmin&7/&9&lDeveloper&7/&4&lOwner&8]".replace("&", "§"));
				  }
				  else {
					  MessageAPI.playerNotFound(p);
				  }
				 
			  }
			  else if(args.length == 2) {
				  Player target = Bukkit.getPlayer(args[0]);
				  if(target != null) {
					  if(args[1].equalsIgnoreCase("regular")) {
						  
						  target.sendMessage(this.prefix + " §aYou Ranking Is Updating to §2Regular");
						  p.sendMessage(this.prefix + " §aSuccessfully Rank Updating to §2Regular to " + target.getDisplayName());
						  target.setDisplayName("§2" + target.getName());
						  target.setPlayerListName("§2" + target.getName());
						  Main.m.getConfig().set("Stats.Rank." + target.getName(), "&2Regular");
						  Main.m.saveConfig();
						  Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "groupmanager:manuadd " + target.getName() + " regular");
					  }
					  if(args[1].equalsIgnoreCase("golddonor")) {
						  target.sendMessage(this.prefix + " §aYou Ranking Is Updating to §6Gold Donor");
						  target.kickPlayer(this.prefix + "\n \n§c§lYour Rank Update to \n \n§6§lGold Donor");
						  p.sendMessage(this.prefix + " §aSuccessfully Rank Updating to §6Gold Donor to " + target.getDisplayName());
						  target.setDisplayName("§6" + target.getName());
						  target.setPlayerListName("§6" + target.getName());
						  Main.m.getConfig().set("Stats.Rank." + target.getName(), "&6Gold Donor");
						  Main.m.saveConfig();
						  Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "groupmanager:manuadd " + target.getName() + " golddonor");
					  }
					  if(args[1].equalsIgnoreCase("diamonddonor")) {
						  target.sendMessage(this.prefix + " §aYou Ranking Is Updating to §3Diamond Donor");
						  target.kickPlayer(this.prefix + "\n \n§c§lYour Rank Update to \n \n§3§lDiamond Donor");
						  p.sendMessage(this.prefix + " §aSuccessfully Rank Updating to §3Diamond Donor to " + target.getDisplayName());
						  target.setDisplayName("§3" + target.getName());
						  target.setPlayerListName("§3" + target.getName());
						  Main.m.getConfig().set("Stats.Rank." + target.getName(), "&3Diamond Donor");
						  Main.m.saveConfig();
						  Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "groupmanager:manuadd " + target.getName() + " diamonddonor");
					  }
					  if(args[1].equalsIgnoreCase("platinumdonor")) {
						  target.sendMessage(this.prefix + " §aYou Ranking Is Updating to §bPlatinum Donor");
						  target.kickPlayer(this.prefix + "\n \n§c§lYour Rank Update to \n \n§b§lPlatinum Donor");
						  p.sendMessage(this.prefix + " §aSuccessfully Rank Updating to §bPlatinum Donor to " + target.getDisplayName());
						  target.setDisplayName("§b" + target.getName());
						  target.setPlayerListName("§b" + target.getName());
						  Main.m.getConfig().set("Stats.Rank." + target.getName(), "&bPlatinum Donor");
						  Main.m.saveConfig();
						  Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "groupmanager:manuadd " + target.getName() + " platinumdonor");
					  }
					  if(args[1].equalsIgnoreCase("quantumdonor")) {
						  target.sendMessage(this.prefix + " §aYou Ranking Is Updating to §aQuantum Donor");
						  target.kickPlayer(this.prefix + "\n \n§c§lYour Rank Update to \n \n§a§lQuantum Donor");
						  p.sendMessage(this.prefix + " §aSuccessfully Rank Updating to §aQuantum Donor to " + target.getDisplayName());
						  target.setDisplayName("§a" + target.getName());
						  target.setPlayerListName("§a" + target.getName());
						  Main.m.getConfig().set("Stats.Rank." + target.getName(), "&aQuantum Donor");
						  Main.m.saveConfig();
						  Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "groupmanager:manuadd " + target.getName() + " quantumdonor");
					  }
					  if(args[1].equalsIgnoreCase("moderator")) {
						  target.sendMessage(this.prefix + " §aYou Ranking Is Updating to §cModerator");
						  target.kickPlayer(this.prefix + "\n \n§c§lYour Rank Update to \n \n§c§lModerator");
						  p.sendMessage(this.prefix + " §aSuccessfully Rank Updating to §cModerator to " + target.getDisplayName());
						  target.setDisplayName("§c" + target.getName());
						  target.setPlayerListName("§c" + target.getName());
						  Main.m.getConfig().set("Stats.Rank." + target.getName(), "&cModerator");
						  Main.m.saveConfig();
						  Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "groupmanager:manuadd " + target.getName() + " Moderator");
					  }
					  if(args[1].equalsIgnoreCase("sr.moderator")) {
						  target.sendMessage(this.prefix + " §aYou Ranking Is Updating to §4Sr.Moderator");
						  target.kickPlayer(this.prefix + "\n \n§c§lYour Rank Update to \n \n§4§lSr. Moderator");
						  p.sendMessage(this.prefix + " §aSuccessfully Rank Updating to §4Sr.Moderator to " + target.getDisplayName());
						  target.setDisplayName("§4" + target.getName());
						  target.setPlayerListName("§4" + target.getName());
						  Main.m.getConfig().set("Stats.Rank." + target.getName(), "&4Sr.Moderator");
						  Main.m.saveConfig();
						  Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "groupmanager:manuadd " + target.getName() + " srmoderator");
					  }
					  if(args[1].equalsIgnoreCase("Admin")) {
						  target.sendMessage(this.prefix + " §aYou Ranking Is Updating to §4§lAdmin");
						  target.kickPlayer(this.prefix + "\n \n§c§lYour Rank Update to \n \n§4§lAdmin");
						  p.sendMessage(this.prefix + " §aSuccessfully Rank Updating to §4§lAdmin to " + target.getDisplayName());
						  target.setDisplayName("§4§l" + target.getName());
						  target.setPlayerListName("§4§l" + target.getName());
						  Main.m.getConfig().set("Stats.Rank." + target.getName(), "&4&lAdmin");
						  Main.m.saveConfig();
						  Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "groupmanager:manuadd " + target.getName() + " Admin");
					  }
					  if(args[1].equalsIgnoreCase("Developer")) {
						  target.sendMessage(this.prefix + " §aYou Ranking Is Updating to §e§lDeveloper");
						  p.sendMessage(this.prefix + " §aSuccessfully Rank Updating to §e§lDeveloper to " + target.getDisplayName());
						  NameAPI.setColouredName(target);
				
					  }
					  if(args[1].equalsIgnoreCase("owner")) {
						  target.sendMessage(this.prefix + " §aYou Ranking Is Updating to §4§lOwner");
						  target.kickPlayer(this.prefix + "\n \n§c§lYour Rank Update to \n \n§4§lOwner");
						  p.sendMessage(this.prefix + " §aSuccessfully Rank Updating to §4§lOwner to " + target.getDisplayName());
						  target.setDisplayName("§4§l§n" + target.getName());
						  target.setPlayerListName("§4§l§n" + target.getName());
						  Main.m.getConfig().set("Stats.Rank." + target.getName(), "&4&lOwner");
						  Main.m.saveConfig();
						  Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "groupmanager:manuadd " + target.getName() + " Owner");
					  }
					  
				  }
				  else {
					  MessageAPI.playerNotFound(p);
				  }
				  
			  }
		  }
		  else {
			  MessageAPI.noPermission(p);
		  }
	  }
		
		
		
		
		
		return false;
	}

}
