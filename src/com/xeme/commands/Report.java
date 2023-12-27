package com.xeme.commands;

import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import com.xeme.Main;
import com.xeme.mysql.MySQL;

import me.xeme.api.MessageAPI;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;

public class Report implements CommandExecutor{
	
	String prefix = "§8[§3Xeme§8]";
	
	public static int getReportID() throws SQLException {
		MySQL mysql = new MySQL(Main.m, "vweb11.nitrado.net", "3306", "ni515720_1sql5", "ni515720_1sql5", "123asd");
		 mysql.openConnection();
		 Statement statement;
		 statement = mysql.getConnection().createStatement();
		 ResultSet rs = statement.executeQuery("SELECT * FROM 'Reports'");
		 int reportedid = rs.getInt("Reported_ID")+1;
			return reportedid;
		 
		
		
	}
	
	public static void addReports(Player p, Player target, String reportreason, int reportid) throws SQLException {
		Date now = new Date();
		SimpleDateFormat format = new SimpleDateFormat("dd.MMMM.yyyy");
		 MySQL mysql = new MySQL(Main.m, "vweb11.nitrado.net", "3306", "ni515720_1sql5", "ni515720_1sql5", "123asd");
		 mysql.openConnection();
		 Statement statement;
		 statement = mysql.getConnection().createStatement();
		 statement.executeUpdate("INSERT INTO Reports (Reporter_Name, Reported_Name, Report_Reason, Reported_Date, Reported_ID) VALUES ('" + p.getName() + "', '" + target.getName() + "', '" + reportreason + "', '" + format.format(now) + "', '1'");;
			 
		 
	}
	
	
	 public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	  {
		 /*/statement.executeUpdate("INSERT INTO Reports (Reporter_Name, Reported_Name, Report_Reason, Reported_Date, Reported_ID) VALUES ('" + p.getName() + "', '" + target.getName() + "', '" + message + "', '" + format.format(now) + "', '1'");
		  /*/
		

		 Player p = (Player) sender;
	
		
		 if(cmd.getName().equalsIgnoreCase("report")) {
			 if(args.length == 0) {
				 p.sendMessage(prefix + " &7/report <player> <reason>".replace("&", "§"));
			 }else if (args.length == 1) {
				 p.sendMessage(prefix + " &7/report <player> <reason>".replace("&", "§"));
			 }else {
				 String message = "";
			     for (int i = 1; i < args.length; i++) {
			    	 message = message + args[i] + " ";
			    	 message.replace("ý", "i");
			    	 message.replace("Ý", "i");
			    	 message.replace("Ö", "o");
			    	 message.replace("ö", "o");
			    	 message.replace("ð", "g");
			    	 message.replace("þ", "s");
			    	 message.replace("Þ", "s");
			    	 message.replace("Ç", "c");
			    	 message.replace("ç", "c");
			    	 
			     }
				 Player target = Bukkit.getServer().getPlayer(args[0]);
				 if(target == null) {
					 MessageAPI.playerNotFound(p);
				 }else {
					 
					 p.sendMessage(prefix + " &aYou reported &c".replace("&", "§") + target.getDisplayName() + " &afrom reason &8[&e".replace("&", "§") + message+ "§8]");
					 for(Player players: Bukkit.getServer().getOnlinePlayers()) {
						 players.sendMessage("&8&m------------------------------------------------".replace("&", "§"));
						 players.sendMessage(" ");
						 players.sendMessage("                              &6&lNEW REPORT !".replace("&", "§"));
						 players.sendMessage(" ");
						 players.sendMessage("&a&l".replace("&", "§") + p.getName() + " &bhas reported to &c&l".replace("&", "§") + target.getName() + " &bfrom reason &8[&e".replace("&", "§") + message + "§8]");
						 players.sendMessage("");
						
						 TextComponent x = new TextComponent("§9§lX ");
						 x.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/history " + p.getName()));
						 x.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§9/history " + p.getName()).create()));
						 TextComponent g = new TextComponent("§c§lG ");
						 g.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/goto " + p.getName() + " <reason>"));
						 g.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§c/kick " + p.getName()).create()));
						 TextComponent punish = new TextComponent("§e§lP§8");
						 punish.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/punish " + p.getName() + " <time> <reason>"));
						 punish.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§e/punish " + p.getName()).create()));
						 TextComponent punishmessage = new TextComponent("          §7§lPunish to §a" + target.getDisplayName() + "§r ");
						 
						 players.spigot().sendMessage(punishmessage, x, g, punish);
						 players.sendMessage(" ");
						 players.sendMessage("&8&m------------------------------------------------".replace("&", "§"));
						 File reportdata = new File(Bukkit.getPluginManager().getPlugin("Xeme_V3NSYJ").getDataFolder(), File.separator + "Reports");
						 File reportf = new File(reportdata, File.separator + "allreports.yml");
						 FileConfiguration reportData = YamlConfiguration.loadConfiguration(reportf);
						 try {
							addReports(p, target, message, getReportID());
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						 
						 if(!reportf.exists()) {
						
							 List<String> reportlist = reportData.getStringList("Reports");
							 message = message.replace("ý", "i");
							 message = message.replace("Ý", "I");
							 message = message.replace("Ö", "O");
							 message = message.replace("ö", "o");
							 message = message.replace("ð", "g");
							 message = message.replace("Ð", "G");
							 message = message.replace("þ", "s");
							 message = message.replace("Þ", "S");
							 message = message.replace("Ç", "C");
							 message = message.replace("ç", "c");
							 if(reportlist.contains(p.getName() + " has reported " + target.getName() + " from reason [ " + message + " ]")) {
								 reportlist.size();
							 }else {
								 message = message.replace("ý", "i");
								 message = message.replace("Ý", "I");
								 message = message.replace("Ö", "O");
								 message = message.replace("ö", "o");
								 message = message.replace("ð", "g");
								 message = message.replace("Ð", "G");
								 message = message.replace("þ", "s");
								 message = message.replace("Þ", "S");
								 message = message.replace("Ç", "C");
								 message = message.replace("ç", "c");
								 reportlist.add(p.getName() + " has reported to " + target.getName() + " from reason [ " + message + " ]");
								 reportData.set("Reports", reportlist);
								 
								 //reportData.set("Reports", configList);
								 //reports.add(p.getName() + " has reported to " + target.getName() + " from reason [ " + message + " ]");
								 //reportData.set("Reports", reports);
								 
								 try {
									 reportData.save(reportf);
								 }catch (IOException ex){
									 ex.printStackTrace();
								 }
							 }
						 }else {
							 List<String> reportlist = reportData.getStringList("Reports");
							 message = message.replace("ý", "i");
							 message = message.replace("Ý", "I");
							 message = message.replace("Ö", "O");
							 message = message.replace("ö", "o");
							 message = message.replace("ð", "g");
							 message = message.replace("Ð", "G");
							 message = message.replace("þ", "s");
							 message = message.replace("Þ", "S");
							 message = message.replace("Ç", "C");
							 message = message.replace("ç", "c");
							 if(reportlist.contains(p.getName() + " has reported " + target.getName() + " from reason [ " + message + " ]")) {
								 reportlist.size();
							 }else {
								message = message.replace("ý", "i");
								message = message.replace("Ý", "I");
								message = message.replace("Ö", "O");
								message = message.replace("ö", "o");
								message = message.replace("ð", "g");
								message = message.replace("Ð", "G");
								message = message.replace("þ", "s");
								message = message.replace("Þ", "S");
								message = message.replace("Ç", "C");
								message = message.replace("ç", "c");
								 reportlist.add(p.getName() + " has reported to " + target.getName() + " from reason [ " + message + " ]");
								 reportData.set("Reports", reportlist);
								 //reportData.set("Reports", configList);
								 //reports.add(p.getName() + " has reported to " + target.getName() + " from reason [ " + message + " ]");
								 //reportData.set("Reports", reports);
								 
								 try {
									 reportData.save(reportf);
								 }catch (IOException ex){
									 ex.printStackTrace();
								 }
							 }
						 }
					 }
				 }
			 }
		 }
		 return false;
	  }
	 
	 
	 

}
