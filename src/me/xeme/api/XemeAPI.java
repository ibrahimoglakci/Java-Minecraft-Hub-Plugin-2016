package me.xeme.api;


import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import com.xeme.Main;

public class XemeAPI extends JavaPlugin implements Listener{
	
	
	
	public static String setColouredString(String message) {
		String sa = "";
		if(message.length() == 3) {
			String[] words = message.split("");
			String first = words[0];
			String second = words[1];
			String third = words[2];
			String nick = "§4§l" + first + "§c§l" + second + "§6§l" + third;
			sa = nick;
			
		}
		else if(message.length() == 4) {
			String[] words = message.split("");
			String first = words[0];
			String second = words[1];
			String third = words[2];
			String fourth = words[3];
			String nick = "§4§l" + first + "§c§l" + second + "§6§l" + third + "§e§l" + fourth;
			sa = nick;
		}
		else if(message.length() == 5) {
			String[] words = message.split("");
			String first = words[0];
			String second = words[1];
			String third = words[2];
			String fourth = words[3];
			String fifth = words[4];
			String nick = "§4§l" + first + "§c§l" + second + "§6§l" + third + "§e§l" + fourth + "§a§l" + fifth;
			sa = nick;
			
		}
		else if(message.length() == 6) {
			String[] words = message.split("");
			String first = words[0];
			String second = words[1];
			String third = words[2];
			String fourth = words[3];
			String fifth = words[4];
			String sixth = words[5];
			String nick = "§4§l" + first + "§c§l" + second + "§6§l" + third + "§e§l" + fourth + "§a§l" + fifth + "§2§l" + sixth;
			sa = nick;
			
		}
		else if(message.length() == 7) {
			String[] words = message.split("");
			String first = words[0];
			String second = words[1];
			String third = words[2];
			String fourth = words[3];
			String fifth = words[4];
			String sixth = words[5];
			String seventh = words[6];
			String nick = "§4§l" + first + "§c§l" + second + "§6§l" + third + "§e§l" + fourth + "§a§l" + fifth + "§2§l" + sixth + "§b§l" + seventh;
			sa = nick;
			
		}
		else if(message.length() == 8) {
			String[] words = message.split("");
			String first = words[0];
			String second = words[1];
			String third = words[2];
			String fourth = words[3];
			String fifth = words[4];
			String sixth = words[5];
			String seventh = words[6];
			String eightth = words[7];
			String nick = "§4§l" + first + "§c§l" + second + "§6§l" + third + "§e§l" + fourth + "§a§l" + fifth + "§2§l" + sixth + "§b§l" + seventh + "§3§l" + eightth;
			sa = nick;
			
		}
		else if(message.length() == 9) {
			String[] words = message.split("");
			String first = words[0];
			String second = words[1];
			String third = words[2];
			String fourth = words[3];
			String fifth = words[4];
			String sixth = words[5];
			String seventh = words[6];
			String eightth = words[7];
			String nineth = words[8];
			String nick = "§4§l" + first + "§c§l" + second + "§6§l" + third + "§e§l" + fourth + "§a§l" + fifth + "§2§l" + sixth + "§b§l" + seventh + "§3§l" + eightth + "§9§l" + nineth;
			sa = nick;
			
		}
		else if(message.length() == 10) {
			String[] words = message.split("");
			String first = words[0];
			String second = words[1];
			String third = words[2];
			String fourth = words[3];
			String fifth = words[4];
			String sixth = words[5];
			String seventh = words[6];
			String eightth = words[7];
			String nineth = words[8];
			String tenth = words[9];
			String nick = "§4§l" + first + "§c§l" + second + "§6§l" + third + "§e§l" + fourth + "§a§l" + fifth + "§2§l" + sixth + "§b§l" + seventh + "§3§l" + eightth + "§9§l" + nineth + "§1§l" + tenth;
			sa = nick;
			
		}
		else if(message.length() == 11) {
			String[] words = message.split("");
			String first = words[0];
			String second = words[1];
			String third = words[2];
			String fourth = words[3];
			String fifth = words[4];
			String sixth = words[5];
			String seventh = words[6];
			String eightth = words[7];
			String nineth = words[8];
			String tenth = words[9];
			String eleventh = words[10];
			String nick = "§4§l" + first + "§c§l" + second + "§6§l" + third + "§e§l" + fourth + "§a§l" + fifth + "§2§l" + sixth + "§b§l" + seventh + "§3§l" + eightth + "§9§l" + nineth + "§1§l" + tenth + "§5§l" + eleventh;
			sa = nick;
			
		}
		else if(message.length() == 12) {
			String[] words = message.split("");
			String first = words[0];
			String second = words[1];
			String third = words[2];
			String fourth = words[3];
			String fifth = words[4];
			String sixth = words[5];
			String seventh = words[6];
			String eightth = words[7];
			String nineth = words[8];
			String tenth = words[9];
			String eleventh = words[10];
			String twelfth = words[11];
			String nick = "§4§l" + first + "§c§l" + second + "§6§l" + third + "§e§l" + fourth + "§a§l" + fifth + "§2§l" + sixth + "§b§l" + seventh + "§3§l" + eightth + "§9§l" + nineth + "§1§l" + tenth + "§5§l" + eleventh + "§d§l" + twelfth;
			sa = nick;
			
		}
		else if(message.length() == 13) {
			String[] words = message.split("");
			String first = words[0];
			String second = words[1];
			String third = words[2];
			String fourth = words[3];
			String fifth = words[4];
			String sixth = words[5];
			String seventh = words[6];
			String eightth = words[7];
			String nineth = words[8];
			String tenth = words[9];
			String eleventh = words[10];
			String twelfth = words[11];
			String thirteenth = words[12];
			String nick = "§4§l" + first + "§c§l" + second + "§6§l" + third + "§e§l" + fourth + "§a§l" + fifth + "§2§l" + sixth + "§b§l" + seventh + "§3§l" + eightth + "§9§l" + nineth + "§1§l" + tenth + "§5§l" + eleventh + "§d§l" + twelfth + "§4§l" + thirteenth;
			sa = nick;
			
		}
		else if(message.length() == 14) {
			String[] words = message.split("");
			String first = words[0];
			String second = words[1];
			String third = words[2];
			String fourth = words[3];
			String fifth = words[4];
			String sixth = words[5];
			String seventh = words[6];
			String eightth = words[7];
			String nineth = words[8];
			String tenth = words[9];
			String eleventh = words[10];
			String twelfth = words[11];
			String thirteenth = words[12];
			String fourteenth = words[13];
			String nick = "§4§l" + first + "§c§l" + second + "§6§l" + third + "§e§l" + fourth + "§a§l" + fifth + "§2§l" + sixth + "§b§l" + seventh + "§3§l" + eightth + "§9§l" + nineth + "§1§l" + tenth + "§5§l" + eleventh + "§d§l" + twelfth + "§4§l" + thirteenth + "§c§l" + fourteenth;
			sa = nick;
			
		}
		else if(message.length() == 15) {
			String[] words = message.split("");
			String first = words[0];
			String second = words[1];
			String third = words[2];
			String fourth = words[3];
			String fifth = words[4];
			String sixth = words[5];
			String seventh = words[6];
			String eightth = words[7];
			String nineth = words[8];
			String tenth = words[9];
			String eleventh = words[10];
			String twelfth = words[11];
			String thirteenth = words[12];
			String fourteenth = words[13];
			String fifteenth = words[14];
			String nick = "§4§l" + first + "§c§l" + second + "§6§l" + third + "§e§l" + fourth + "§a§l" + fifth + "§2§l" + sixth + "§b§l" + seventh + "§3§l" + eightth + "§9§l" + nineth + "§1§l" + tenth + "§5§l" + eleventh + "§d§l" + twelfth + "§4§l" + thirteenth + "§c§l" + fourteenth + "§6§l" + fifteenth;
			sa = nick;
			
		}
		else if(message.length() == 16) {
			String[] words = message.split("");
			String first = words[0];
			String second = words[1];
			String third = words[2];
			String fourth = words[3];
			String fifth = words[4];
			String sixth = words[5];
			String seventh = words[6];
			String eightth = words[7];
			String nineth = words[8];
			String tenth = words[9];
			String eleventh = words[10];
			String twelfth = words[11];
			String thirteenth = words[12];
			String fourteenth = words[13];
			String fifteenth = words[14];
			String sixteenth = words[15];
			String nick = "§4§l" + first + "§c§l" + second + "§6§l" + third + "§e§l" + fourth + "§a§l" + fifth + "§2§l" + sixth + "§b§l" + seventh + "§3§l" + eightth + "§9§l" + nineth + "§1§l" + tenth + "§5§l" + eleventh + "§d§l" + twelfth + "§4§l" + thirteenth + "§c§l" + fourteenth + "§6§l" + fifteenth + "§e§l" + sixteenth;
			sa = nick;
			
			
		}
		return sa;
	}
	
	public static void setColouredName(Player player) {
		if(player.getName().length() == 3) {
			String[] words = player.getName().split("");
			String first = words[0];
			String second = words[1];
			String third = words[2];
			String nick = "§4§l" + first + "§c§l" + second + "§6§l" + third;
			player.setDisplayName(nick);
			player.setPlayerListName(nick);
		}
		else if(player.getName().length() == 4) {
			String[] words = player.getName().split("");
			String first = words[0];
			String second = words[1];
			String third = words[2];
			String fourth = words[3];
			String nick = "§4§l" + first + "§c§l" + second + "§6§l" + third + "§e§l" + fourth;
			player.setDisplayName(nick);
			player.setPlayerListName(nick);
		}
		else if(player.getName().length() == 5) {
			String[] words = player.getName().split("");
			String first = words[0];
			String second = words[1];
			String third = words[2];
			String fourth = words[3];
			String fifth = words[4];
			String nick = "§4§l" + first + "§c§l" + second + "§6§l" + third + "§e§l" + fourth + "§a§l" + fifth;
			player.setDisplayName(nick);
			player.setPlayerListName(nick);
		}
		else if(player.getName().length() == 6) {
			String[] words = player.getName().split("");
			String first = words[0];
			String second = words[1];
			String third = words[2];
			String fourth = words[3];
			String fifth = words[4];
			String sixth = words[5];
			String nick = "§4§l" + first + "§c§l" + second + "§6§l" + third + "§e§l" + fourth + "§a§l" + fifth + "§2§l" + sixth;
			player.setDisplayName(nick);
			player.setPlayerListName(nick);
		}
		else if(player.getName().length() == 7) {
			String[] words = player.getName().split("");
			String first = words[0];
			String second = words[1];
			String third = words[2];
			String fourth = words[3];
			String fifth = words[4];
			String sixth = words[5];
			String seventh = words[6];
			String nick = "§4§l" + first + "§c§l" + second + "§6§l" + third + "§e§l" + fourth + "§a§l" + fifth + "§2§l" + sixth + "§b§l" + seventh;
			player.setDisplayName(nick);
			player.setPlayerListName(nick);
		}
		else if(player.getName().length() == 8) {
			String[] words = player.getName().split("");
			String first = words[0];
			String second = words[1];
			String third = words[2];
			String fourth = words[3];
			String fifth = words[4];
			String sixth = words[5];
			String seventh = words[6];
			String eightth = words[7];
			String nick = "§4§l" + first + "§c§l" + second + "§6§l" + third + "§e§l" + fourth + "§a§l" + fifth + "§2§l" + sixth + "§b§l" + seventh + "§3§l" + eightth;
			player.setDisplayName(nick);
			player.setPlayerListName(nick);
		}
		else if(player.getName().length() == 9) {
			String[] words = player.getName().split("");
			String first = words[0];
			String second = words[1];
			String third = words[2];
			String fourth = words[3];
			String fifth = words[4];
			String sixth = words[5];
			String seventh = words[6];
			String eightth = words[7];
			String nineth = words[8];
			String nick = "§4§l" + first + "§c§l" + second + "§6§l" + third + "§e§l" + fourth + "§a§l" + fifth + "§2§l" + sixth + "§b§l" + seventh + "§3§l" + eightth + "§9§l" + nineth;
			player.setDisplayName(nick);
			player.setPlayerListName(nick);
		}
		else if(player.getName().length() == 10) {
			String[] words = player.getName().split("");
			String first = words[0];
			String second = words[1];
			String third = words[2];
			String fourth = words[3];
			String fifth = words[4];
			String sixth = words[5];
			String seventh = words[6];
			String eightth = words[7];
			String nineth = words[8];
			String tenth = words[9];
			String nick = "§4§l" + first + "§c§l" + second + "§6§l" + third + "§e§l" + fourth + "§a§l" + fifth + "§2§l" + sixth + "§b§l" + seventh + "§3§l" + eightth + "§9§l" + nineth + "§1§l" + tenth;
			player.setDisplayName(nick);
			player.setPlayerListName(nick);
		}
		else if(player.getName().length() == 11) {
			String[] words = player.getName().split("");
			String first = words[0];
			String second = words[1];
			String third = words[2];
			String fourth = words[3];
			String fifth = words[4];
			String sixth = words[5];
			String seventh = words[6];
			String eightth = words[7];
			String nineth = words[8];
			String tenth = words[9];
			String eleventh = words[10];
			String nick = "§4§l" + first + "§c§l" + second + "§6§l" + third + "§e§l" + fourth + "§a§l" + fifth + "§2§l" + sixth + "§b§l" + seventh + "§3§l" + eightth + "§9§l" + nineth + "§1§l" + tenth + "§5§l" + eleventh;
			player.setDisplayName(nick);
			player.setPlayerListName(nick);
		}
		else if(player.getName().length() == 12) {
			String[] words = player.getName().split("");
			String first = words[0];
			String second = words[1];
			String third = words[2];
			String fourth = words[3];
			String fifth = words[4];
			String sixth = words[5];
			String seventh = words[6];
			String eightth = words[7];
			String nineth = words[8];
			String tenth = words[9];
			String eleventh = words[10];
			String twelfth = words[11];
			String nick = "§4§l" + first + "§c§l" + second + "§6§l" + third + "§e§l" + fourth + "§a§l" + fifth + "§2§l" + sixth + "§b§l" + seventh + "§3§l" + eightth + "§9§l" + nineth + "§1§l" + tenth + "§5§l" + eleventh + "§d§l" + twelfth;
			player.setDisplayName(nick);
			player.setPlayerListName(nick);
		}
		else if(player.getName().length() == 13) {
			String[] words = player.getName().split("");
			String first = words[0];
			String second = words[1];
			String third = words[2];
			String fourth = words[3];
			String fifth = words[4];
			String sixth = words[5];
			String seventh = words[6];
			String eightth = words[7];
			String nineth = words[8];
			String tenth = words[9];
			String eleventh = words[10];
			String twelfth = words[11];
			String thirteenth = words[12];
			String nick = "§4§l" + first + "§c§l" + second + "§6§l" + third + "§e§l" + fourth + "§a§l" + fifth + "§2§l" + sixth + "§b§l" + seventh + "§3§l" + eightth + "§9§l" + nineth + "§1§l" + tenth + "§5§l" + eleventh + "§d§l" + twelfth + "§4§l" + thirteenth;
			player.setDisplayName(nick);
			player.setPlayerListName(nick);
		}
		else if(player.getName().length() == 14) {
			String[] words = player.getName().split("");
			String first = words[0];
			String second = words[1];
			String third = words[2];
			String fourth = words[3];
			String fifth = words[4];
			String sixth = words[5];
			String seventh = words[6];
			String eightth = words[7];
			String nineth = words[8];
			String tenth = words[9];
			String eleventh = words[10];
			String twelfth = words[11];
			String thirteenth = words[12];
			String fourteenth = words[13];
			String nick = "§4§l" + first + "§c§l" + second + "§6§l" + third + "§e§l" + fourth + "§a§l" + fifth + "§2§l" + sixth + "§b§l" + seventh + "§3§l" + eightth + "§9§l" + nineth + "§1§l" + tenth + "§5§l" + eleventh + "§d§l" + twelfth + "§4§l" + thirteenth + "§c§l" + fourteenth;
			player.setDisplayName(nick);
			player.setPlayerListName(nick);
		}
		else if(player.getName().length() == 15) {
			String[] words = player.getName().split("");
			String first = words[0];
			String second = words[1];
			String third = words[2];
			String fourth = words[3];
			String fifth = words[4];
			String sixth = words[5];
			String seventh = words[6];
			String eightth = words[7];
			String nineth = words[8];
			String tenth = words[9];
			String eleventh = words[10];
			String twelfth = words[11];
			String thirteenth = words[12];
			String fourteenth = words[13];
			String fifteenth = words[14];
			String nick = "§4§l" + first + "§c§l" + second + "§6§l" + third + "§e§l" + fourth + "§a§l" + fifth + "§2§l" + sixth + "§b§l" + seventh + "§3§l" + eightth + "§9§l" + nineth + "§1§l" + tenth + "§5§l" + eleventh + "§d§l" + twelfth + "§4§l" + thirteenth + "§c§l" + fourteenth + "§6§l" + fifteenth;
			player.setDisplayName(nick);
			player.setPlayerListName(nick);
		}
		else if(player.getName().length() == 16) {
			String[] words = player.getName().split("");
			String first = words[0];
			String second = words[1];
			String third = words[2];
			String fourth = words[3];
			String fifth = words[4];
			String sixth = words[5];
			String seventh = words[6];
			String eightth = words[7];
			String nineth = words[8];
			String tenth = words[9];
			String eleventh = words[10];
			String twelfth = words[11];
			String thirteenth = words[12];
			String fourteenth = words[13];
			String fifteenth = words[14];
			String sixteenth = words[15];
			String nick = "§4§l" + first + "§c§l" + second + "§6§l" + third + "§e§l" + fourth + "§a§l" + fifth + "§2§l" + sixth + "§b§l" + seventh + "§3§l" + eightth + "§9§l" + nineth + "§1§l" + tenth + "§5§l" + eleventh + "§d§l" + twelfth + "§4§l" + thirteenth + "§c§l" + fourteenth + "§6§l" + fifteenth + "§e§l" + sixteenth;
			player.setDisplayName(nick);
			player.setPlayerListName(nick);
			
		}
	}
		
	public static String PlayerChatColor(Player p) {
		File data = new File(Bukkit.getPluginManager().getPlugin("Xeme_V3NSYJ").getDataFolder(), File.separator + "Userdata");
    	File f = new File(data, File.separator + p.getName() + ".yml");
    	FileConfiguration playerData = YamlConfiguration.loadConfiguration(f);
    	String chatcolor = (String) playerData.get("Chatcolor");
    	
    	
    	return chatcolor;
	}
	public static void noPermission(Player p) {
		
		p.sendMessage("§8[§3Xeme§8] §cYou don't have permission this command");
		
	}
	
	public static void playerNotFound(Player p) {
		
		p.sendMessage("§8[§3Xeme§8] §cPlayer is Not Found");
		
	}
	public static void playerSetDisplayName(Player p) {
		if(p.getName().equalsIgnoreCase("WalkingUcak_")) {
	    	  p.setDisplayName("§4§lW§c§la§6§ll§e§lk§a§li§2§ln§3§lg§4§lU§c§lc§9§la§1§lk§3§l_");
	    }
		if (p.hasPermission("Xeme.owner"))
	    {
	        p.setDisplayName("§4§l" + p.getName());
	        p.setPlayerListName("§4§l" + p.getName());
	    }
	    else if (p.hasPermission("Xeme.admin"))
	    {
	      p.setDisplayName("§4§l" + p.getName());
	      p.setPlayerListName("§4§l" + p.getName());
	    }
	    else if (p.hasPermission("Xeme.developer"))
	    {
	        p.setDisplayName("§9§l" + p.getName());
	        p.setPlayerListName("§9§l" + p.getName());
	    }
	    else if (p.hasPermission("Xeme.srmod"))
	    {
	        p.setDisplayName("§4" + p.getName());
	        p.setPlayerListName("§4" + p.getName());
	    }
	    else if (p.hasPermission("Xeme.mod"))
	    {
	        p.setDisplayName("§c" + p.getName());
	        p.setPlayerListName("§c" + p.getName());
	    }
	    else if (p.hasPermission("Xeme.mapmaker"))
	    {
	        p.setDisplayName("§d" + p.getName());
	        p.setPlayerListName("§d" + p.getName());
	    }
	    else if (p.hasPermission("Xeme.vip"))
	    {
	        p.setDisplayName("§5" + p.getName());
	        p.setPlayerListName("§5" + p.getName());
	    }
	    else if (p.hasPermission("Xeme.Quantum"))
	    {
	        p.setDisplayName("§a" + p.getName());
	        p.setPlayerListName("§a" + p.getName());
	    }
	    else if (p.hasPermission("Xeme.Platinum"))
	    {
	        p.setDisplayName("§b" + p.getName());
	        p.setPlayerListName("§b" + p.getName());
	    }
	    else if (p.hasPermission("Xeme.Diamond"))
	    {
	        p.setDisplayName("§3" + p.getName());
	        p.setPlayerListName("§3" + p.getName());
	    }
	    else if (p.hasPermission("Xeme.gold"))
	    {
	        p.setDisplayName("§e" + p.getName());
	        p.setPlayerListName("§e" + p.getName());
	    }
	    else
	    {
	        p.setDisplayName("§2" + p.getName());
	        p.setPlayerListName("§2" + p.getName());
	    }
	    
		
	}
	
	public static void EffectInv(Player p) {
			Inventory effectInventory = Bukkit.createInventory(null, 54, "§a§lCosmetics §8» §6§lEffects");
			ItemStack back = new ItemStack(Material.ARROW);
			ItemMeta backm = back.getItemMeta();
			backm.setDisplayName("§cBack");
			ArrayList<String> backLore = new ArrayList<String>();
			backLore.add("");
			backm.setLore(backLore);
			back.setItemMeta(backm);
			effectInventory.setItem(45, back);
		    ItemStack fns = new ItemStack(Material.FLINT_AND_STEEL);
		    ItemMeta fnsm = fns.getItemMeta();
		    fnsm.setDisplayName("§c§lFlame Rings");
		    ArrayList<String> fnsLore = new ArrayList<String>();
		    fnsLore.add("");
		    fnsm.setLore(fnsLore);
		    fns.setItemMeta(fnsm);
		    effectInventory.setItem(13, fns);
		    ItemStack apple = new ItemStack(Material.APPLE);
		    ItemMeta applem = apple.getItemMeta();
		    applem.setDisplayName("§4§lHeart Effect");
		    ArrayList<String> appleLore = new ArrayList<String>();
		    appleLore.add("");
		    applem.setLore(appleLore);
		    apple.setItemMeta(applem);
		    effectInventory.setItem(20, apple);
		    ItemStack reddust = new ItemStack(Material.REDSTONE);
		    ItemMeta reddustm = reddust.getItemMeta();
		    reddustm.setDisplayName("§cRed Dust");
		    ArrayList<String> reddustLore = new ArrayList<String>();
		    reddustLore.add("");
		    reddustm.setLore(reddustLore);
		    reddust.setItemMeta(reddustm);
		    effectInventory.setItem(22, reddust);
		    ItemStack emerald = new ItemStack(Material.EMERALD);
		    ItemMeta emeraldm = emerald.getItemMeta();
		    emeraldm.setDisplayName("§aEmerald Twirl");
		    ArrayList<String> emeraldLore = new ArrayList<String>();
		    emeraldLore.add("");
		    emeraldm.setLore(emeraldLore);
		    emerald.setItemMeta(emeraldm);
		    effectInventory.setItem(24, emerald);
		    ItemStack smoke = new ItemStack(Material.IRON_INGOT);
		    ItemMeta smokem = smoke.getItemMeta();
		    smokem.setDisplayName("§cSmoke");
		    ArrayList<String> smokeLore = new ArrayList<String>();
		    smokeLore.add("");
		    smokem.setLore(smokeLore);
		    smoke.setItemMeta(smokem);
		    effectInventory.setItem(37, smoke);
		    ItemStack lava = new ItemStack(Material.LAVA_BUCKET);
		    ItemMeta lavam = lava.getItemMeta();
		    lavam.setDisplayName("§c§lLava Effect");
		    ArrayList<String> lavaLore = new ArrayList<String>();
		    lavaLore.add("");
		    lavam.setLore(lavaLore);
		    lava.setItemMeta(lavam);
		    effectInventory.setItem(39, lava);
		    ItemStack explode = new ItemStack(Material.TNT);
		    ItemMeta explodem = explode.getItemMeta();
		    explodem.setDisplayName("§7§lExplode");
		    ArrayList<String> explodeLore = new ArrayList<String>();
		    explodeLore.add("");
		    explodem.setLore(explodeLore);
		    explode.setItemMeta(explodem);
		    effectInventory.setItem(41, explode);
		    ItemStack firework = new ItemStack(Material.FIREWORK);
		    ItemMeta fireworkm = firework.getItemMeta();
		    fireworkm.setDisplayName("§aFireWork");
		    ArrayList<String> fireworkLore = new ArrayList<String>();
		    fireworkLore.add("");
		    fireworkm.setLore(fireworkLore);
		    firework.setItemMeta(fireworkm);
		    effectInventory.setItem(43, firework);
		    ItemStack crit = new ItemStack(Material.BOW);
		    ItemMeta critm = crit.getItemMeta();
		    critm.setDisplayName("§bCritical");
		    ArrayList<String> critLore = new ArrayList<String>();
		    critLore.add("");
		    critm.setLore(critLore);
		    crit.setItemMeta(critm);
		    effectInventory.setItem(49, crit);
		    ItemStack cloud = new ItemStack(Material.SNOW_BLOCK);
		    ItemMeta cloudm = cloud.getItemMeta();
		    cloudm.setDisplayName("§f§lCloud");
		    ArrayList<String> cloudLore = new ArrayList<String>();
		    cloudLore.add("");
		    cloudm.setLore(cloudLore);
		    cloud.setItemMeta(cloudm);
		    effectInventory.setItem(0, cloud);
		    ItemStack music = new ItemStack(Material.GREEN_RECORD);
		    ItemMeta musicm = music.getItemMeta();
		    musicm.setDisplayName("§5Music");
		    ArrayList<String> musicLore = new ArrayList<String>();
		    musicLore.add("");
		    musicm.setLore(musicLore);
		    music.setItemMeta(musicm);
		    effectInventory.setItem(8, music);
		    ItemStack close = new ItemStack(Material.REDSTONE_BLOCK);
		    ItemMeta closem = close.getItemMeta();
		    closem.setDisplayName("§4§lClear Effects");
		    ArrayList<String> closeLore = new ArrayList<String>();
		    closeLore.add("");
		    closem.setLore(closeLore);
		    close.setItemMeta(closem);
		    effectInventory.setItem(53, close);
		    ItemStack cam = new ItemStack(Material.STAINED_GLASS_PANE);
		    ItemMeta camm = cam.getItemMeta();
		    camm.setDisplayName("");
		    ArrayList<String> camLore = new ArrayList<String>();
		    camLore.add("");
		    camm.setLore(camLore);
		    cam.setItemMeta(camm);
		    effectInventory.setItem(3, cam);
		    ItemStack cam1 = new ItemStack(Material.STAINED_GLASS_PANE);
		    ItemMeta cam1m = cam1.getItemMeta();
		    cam1m.setDisplayName("");
		    ArrayList<String> cam1Lore = new ArrayList<String>();
		    cam1Lore.add("");
		    cam1m.setLore(cam1Lore);
		    cam1.setItemMeta(cam1m);
		    effectInventory.setItem(4, cam1);
		    ItemStack cam2 = new ItemStack(Material.STAINED_GLASS_PANE);
		    ItemMeta cam2m = cam2.getItemMeta();
		    cam2m.setDisplayName("");
		    ArrayList<String> cam2Lore = new ArrayList<String>();
		    cam2Lore.add("");
		    cam2m.setLore(cam2Lore);
		    cam2.setItemMeta(cam2m);
		    effectInventory.setItem(5, cam2);
		    ItemStack cam3 = new ItemStack(Material.STAINED_GLASS_PANE);
		    ItemMeta cam3m = cam3.getItemMeta();
		    camm.setDisplayName("");
		    ArrayList<String> cam3Lore = new ArrayList<String>();
		    cam3Lore.add("");
		    cam3m.setLore(cam3Lore);
		    cam3.setItemMeta(cam3m);
		    effectInventory.setItem(27, cam3);
		    ItemStack cam4 = new ItemStack(Material.STAINED_GLASS_PANE);
		    ItemMeta cam4m = cam4.getItemMeta();
		    cam4m.setDisplayName("");
		    ArrayList<String> cam4Lore = new ArrayList<String>();
		    cam4Lore.add("");
		    cam4m.setLore(cam4Lore);
		    cam4.setItemMeta(cam4m);
		    effectInventory.setItem(28, cam4);
		    ItemStack cam5 = new ItemStack(Material.STAINED_GLASS_PANE);
		    ItemMeta cam5m = cam5.getItemMeta();
		    cam5m.setDisplayName("");
		    ArrayList<String> cam5Lore = new ArrayList<String>();
		    cam5Lore.add("");
		    cam5m.setLore(cam5Lore);
		    cam5.setItemMeta(cam5m);
		    effectInventory.setItem(29, cam);
		    ItemStack cam6 = new ItemStack(Material.STAINED_GLASS_PANE);
		    ItemMeta cam6m = cam6.getItemMeta();
		    cam6m.setDisplayName("");
		    ArrayList<String> cam6Lore = new ArrayList<String>();
		    cam6Lore.add("");
		    cam6m.setLore(cam6Lore);
		    cam6.setItemMeta(cam6m);
		    effectInventory.setItem(30, cam6);
		    ItemStack cam7 = new ItemStack(Material.STAINED_GLASS_PANE);
		    ItemMeta cam7m = cam7.getItemMeta();
		    cam7m.setDisplayName("");
		    ArrayList<String> cam7Lore = new ArrayList<String>();
		    cam7Lore.add("");
		    cam7m.setLore(cam7Lore);
		    cam7.setItemMeta(cam7m);
		    effectInventory.setItem(31, cam7);	    
		    ItemStack cam8 = new ItemStack(Material.STAINED_GLASS_PANE);
		    ItemMeta cam8m = cam8.getItemMeta();
		    cam8m.setDisplayName("");
		    ArrayList<String> cam8Lore = new ArrayList<String>();
		    cam8Lore.add("");
		    cam8m.setLore(cam8Lore);
		    cam8.setItemMeta(cam8m);
		    effectInventory.setItem(32, cam8);
		    ItemStack cam9 = new ItemStack(Material.STAINED_GLASS_PANE);
		    ItemMeta cam9m = cam9.getItemMeta();
		    cam9m.setDisplayName("");
		    ArrayList<String> cam9Lore = new ArrayList<String>();
		    cam9Lore.add("");
		    cam9m.setLore(cam9Lore);
		    cam9.setItemMeta(cam9m);
		    effectInventory.setItem(33, cam9);
		    ItemStack cam10 = new ItemStack(Material.STAINED_GLASS_PANE);
		    ItemMeta cam10m = cam10.getItemMeta();
		    cam10m.setDisplayName("");
		    ArrayList<String> cam10Lore = new ArrayList<String>();
		    cam10Lore.add("");
		    cam10m.setLore(cam10Lore);
		    cam10.setItemMeta(cam10m);
		    effectInventory.setItem(34, cam10);
		    ItemStack cam11 = new ItemStack(Material.STAINED_GLASS_PANE);
		    ItemMeta cam11m = cam11.getItemMeta();
		    cam11m.setDisplayName("");
		    ArrayList<String> cam11Lore = new ArrayList<String>();
		    cam11Lore.add("");
		    cam11m.setLore(cam11Lore);
		    cam11.setItemMeta(cam11m);
		    effectInventory.setItem(35, cam11);
		    ItemStack cam12 = new ItemStack(Material.STAINED_GLASS_PANE);
		    ItemMeta cam12m = cam12.getItemMeta();
		    cam12m.setDisplayName("");
		    ArrayList<String> cam12Lore = new ArrayList<String>();
		    cam12Lore.add("");
		    cam12m.setLore(cam12Lore);
		    cam12.setItemMeta(cam12m);
		    effectInventory.setItem(46, cam12);
		    ItemStack cam13 = new ItemStack(Material.STAINED_GLASS_PANE);
		    ItemMeta cam13m = cam13.getItemMeta();
		    cam13m.setDisplayName("");
		    ArrayList<String> cam13Lore = new ArrayList<String>();
		    cam13Lore.add("");
		    cam13m.setLore(cam13Lore);
		    cam13.setItemMeta(cam13m);
		    effectInventory.setItem(47, cam13);
		    ItemStack cam14 = new ItemStack(Material.STAINED_GLASS_PANE);
		    ItemMeta cam14m = cam14.getItemMeta();
		    cam14m.setDisplayName("");
		    ArrayList<String> cam14Lore = new ArrayList<String>();
		    cam14Lore.add("");
		    cam14m.setLore(cam14Lore);
		    cam14.setItemMeta(cam14m);
		    effectInventory.setItem(48, cam14);
		    ItemStack cam15 = new ItemStack(Material.STAINED_GLASS_PANE);
		    ItemMeta cam15m = cam15.getItemMeta();
		    camm.setDisplayName("");
		    ArrayList<String> cam15Lore = new ArrayList<String>();
		    cam15Lore.add("");
		    cam15m.setLore(cam15Lore);
		    cam15.setItemMeta(cam15m);
		    effectInventory.setItem(50, cam15);
		    ItemStack cam16 = new ItemStack(Material.STAINED_GLASS_PANE);
		    ItemMeta cam16m = cam16.getItemMeta();
		    cam16m.setDisplayName("");
		    ArrayList<String> cam16Lore = new ArrayList<String>();
		    cam16Lore.add("");
		    cam16m.setLore(cam16Lore);
		    cam16.setItemMeta(cam16m);
		    effectInventory.setItem(51, cam16);
		    ItemStack cam17 = new ItemStack(Material.STAINED_GLASS_PANE);
		    ItemMeta cam17m = cam.getItemMeta();
		    cam17m.setDisplayName("");
		    ArrayList<String> cam17Lore = new ArrayList<String>();
		    cam17Lore.add("");
		    cam17m.setLore(cam17Lore);
		    cam17.setItemMeta(cam17m);
		    effectInventory.setItem(52, cam17);
	}
	
	@SuppressWarnings("deprecation")
	public static void scoreBoardManager(Player p) {
		ScoreboardManager sbm = Bukkit.getScoreboardManager();
		Scoreboard sb = sbm.getNewScoreboard();
		Objective obj = sb.registerNewObjective("Scoreboard", "dummy");
		Score score1 = obj.getScore(Bukkit.getOfflinePlayer(" §3§lYou"));
		score1.setScore(16);
		Score score2 = obj.getScore(Bukkit.getOfflinePlayer("" + p.getDisplayName()));
		score2.setScore(15);
		Score bos1 = obj.getScore(Bukkit.getOfflinePlayer(" §f"));
		bos1.setScore(14);
		Score score3 = obj.getScore(Bukkit.getOfflinePlayer(" §e§lServer"));
		score3.setScore(13);
		Score score4 = obj.getScore(Bukkit.getOfflinePlayer("" + p.getWorld().getName().toUpperCase()));
		score4.setScore(12);
		Score bos2 = obj.getScore(Bukkit.getOfflinePlayer(" §c "));
		bos2.setScore(11);
		Score score5 = obj.getScore(Bukkit.getOfflinePlayer(" §3§lRank"));
		score5.setScore(10);
		Score score6 = obj.getScore(Bukkit.getOfflinePlayer(" " + Main.m.getConfig().getString("Rank." + p.getName()).replace("&", "§")));
		score6.setScore(9);
		Score bos3 = obj.getScore(Bukkit.getOfflinePlayer(" §e"));
		bos3.setScore(8);
		Score score7 = obj.getScore(Bukkit.getOfflinePlayer(" §c§lPlayers"));
		score7.setScore(2);
		Score score9 = obj.getScore(Bukkit.getOfflinePlayer(" §b§lTime"));
		score9.setScore(7);
		Date now = new Date();
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date saat = new Date();
		SimpleDateFormat saatformat = new SimpleDateFormat("hh:mm a z");
		Score score10 = obj.getScore(Bukkit.getOfflinePlayer(" §f" + format.format(now)));
		score10.setScore(6);
		Score score11 = obj.getScore(Bukkit.getOfflinePlayer(" §f" + saatformat.format(saat)));
		score11.setScore(5);
		Score bos4 = obj.getScore(Bukkit.getOfflinePlayer(" §r"));
		bos4.setScore(4);
		Score score12 = obj.getScore(Bukkit.getOfflinePlayer(" §r" + Bukkit.getOnlinePlayers().size()));
		score12.setScore(1);
		obj.setDisplaySlot(DisplaySlot.SIDEBAR);
		obj.setDisplayName("  §6§lSquirrelNetWork  ");
		p.setScoreboard(sb);
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.m, new Runnable() {
	        public void run() {
	          scoreBoardManager(p);
	        }
	    },1200);
		
		
	}
	

}
