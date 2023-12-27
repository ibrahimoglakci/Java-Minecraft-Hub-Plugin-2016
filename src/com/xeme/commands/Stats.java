package com.xeme.commands;

import java.io.File;
import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import me.xeme.api.MessageAPI;


public class Stats implements CommandExecutor{
	
	String prefix = "§8[§6HyperWalkMC§8]";
	ArrayList<String> kills = new ArrayList<String>();
	ArrayList<String> death = new ArrayList<String>();
	
	  
	  
	  
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	  {
	      Player player = (Player) sender;
	      if (cmd.getName().equalsIgnoreCase("stats"))
	      {	
	    	  
	    	  
	    	  if(args.length == 0) {
	    		  File data = new File(Bukkit.getPluginManager().getPlugin("Xeme_V3NSYJ").getDataFolder(), File.separator + "userdata");
	    		  File f = new File(data, File.separator + player.getName() + ".yml");
	    		  FileConfiguration playerData = YamlConfiguration.loadConfiguration(f);
	    		  player.sendMessage(prefix + " " + player.getDisplayName() + "§f's Records");
	    		  player.sendMessage(prefix + " §fRank§8:" + " §r" + playerData.getString("RankColor").replace("&", "§") + playerData.getString("Rank"));
	    		  player.sendMessage(prefix + " &fKills&8: &e".replace("&", "§") + playerData.getInt("Stats.Kills") + ".0");
	    		  player.sendMessage(prefix + " &fDeaths&8: &e".replace("&", "§") +  playerData.getInt("Stats.Deaths") + ".0");
	    	  }
	    	  else if(args.length == 1) {
	    		  Player target = Bukkit.getServer().getPlayer(args[0]);
	    		  if(target == null) {
	    			  MessageAPI.playerNotFound(player);
	    		  }
	    		  else {
	    			  File data = new File(Bukkit.getPluginManager().getPlugin("Xeme_V3NSYJ").getDataFolder(), File.separator + "userdata");
		    		  File f = new File(data, File.separator + target.getName() + ".yml");
		    		  FileConfiguration targetData = YamlConfiguration.loadConfiguration(f);
		    		  player.sendMessage(prefix + " " + target.getDisplayName() + "§f's Records");
		    		  player.sendMessage(prefix + " §fRank§8:" + " §r" + targetData.getString("RankColor").replace("&", "§") + targetData.getString("Rank"));
		    		  player.sendMessage(prefix + " &fKills&8: &e".replace("&", "§") + targetData.getInt("Stats.Kills") + ".0");
		    		  player.sendMessage(prefix + " &fDeaths&8: &e".replace("&", "§") +  targetData.getInt("Stats.Deaths") + ".0");
		    		  if(player.hasPermission("xeme.moderator")) {
		    			  player.sendMessage(prefix + " &fIP Adress&8: &e".replace("&", "§") + target.getAddress());
		    		  }
		    		 
		    		  }
		    	  }
	    	  
	    	
	      }
	      return false;
	      
	      
	  }
	  
	 

}
