package me.xeme.api;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.bukkit.entity.Player;

import com.xeme.Main;
import com.xeme.mysql.MySQL;

public class StatsAPI {

	
	
	public static void setRank(Player p, int rank) throws SQLException {
		  MySQL mysql = new MySQL(Main.m, "vweb11.nitrado.net", "3306", "ni515720_1sql5", "ni515720_1sql5", "123asd");
		  mysql.openConnection();
		  Statement statement;
		  
		  statement = mysql.getConnection().createStatement();
		  ResultSet rs = statement.executeQuery("SELECT * FROM `Rank` WHERE `UUID`='"+ p.getUniqueId() + "';");
		  
		  if(!rs.next()) {
			  statement.executeUpdate("INSERT INTO Rank (Username, UUID, Rank) VALUES ('" + p.getName() +"', '" + p.getUniqueId() + "', '" + rank + "')");
			  
		  }
		  
	  }
	
	
	public static void setRankDefault(Player p) throws SQLException {
		  MySQL mysql = new MySQL(Main.m, "vweb11.nitrado.net", "3306", "ni515720_1sql5", "ni515720_1sql5", "123asd");
		  mysql.openConnection();
		  Statement statement;
		  
		  statement = mysql.getConnection().createStatement();
		  ResultSet rs = statement.executeQuery("SELECT * FROM `Stats` WHERE `UUID`='"+ p.getUniqueId() + "';");
		  
		  if(!rs.next()) {
			  statement.executeUpdate("INSERT INTO Rank (UUID, UserName, Rank_Number, Rank) VALUES ('" + p.getUniqueId() +"', '" + p.getName() + "', '1', 'OYUNCU')");
			  
		  }
		  
	  }
	
	
	public static int getRank(Player p) throws SQLException{
	       int online = 0;
	       MySQL mysql = new MySQL(Main.m, "vweb11.nitrado.net", "3306", "ni515720_1sql5", "ni515720_1sql5", "123asd");
	       mysql.openConnection();
	       Statement statement;
	       
	       statement = mysql.getConnection().createStatement();
	       ResultSet rs = statement.executeQuery("SELECT * FROM `Rank` WHERE `UUID`='"+ p.getUniqueId() + "';");
	       
	       if(rs.next()){ 
	        online = rs.getInt("Rank");
	        
	       }
	       return online;
	}
	
	 
	  
	  
	  public static void addKills(Player p) throws SQLException {
		  MySQL mysql = new MySQL(Main.m, "vweb11.nitrado.net", "3306", "ni515720_1sql5", "ni515720_1sql5", "123asd");
		  mysql.openConnection();
		  Statement statement;
		  
		  statement = mysql.getConnection().createStatement();
		  ResultSet rs = statement.executeQuery("SELECT * FROM `Stats` WHERE `UUID`='"+ p.getUniqueId() + "';");
		  
		  if(!rs.next()) {
			  statement.executeUpdate("INSERT INTO Stats (Username, UUID, Kills, Deaths) VALUES ('" + p.getUniqueId() +"', '" + p.getName() + "', '1', '0')");
			  
		  }else if(rs.next()){
			  statement.executeUpdate("UPDATE `Stats` set `Kills` = '" + rs.getInt("Kills") + 1 + "' where `UUID`='"+ p.getUniqueId() + "';");
		  }
		  
	  }
	  
	  public static int getKills(Player p) throws SQLException{
	       int kills = 0;
	       MySQL mysql = new MySQL(Main.m, "vweb11.nitrado.net", "3306", "ni515720_1sql5", "ni515720_1sql5", "123asd");
	       mysql.openConnection();
	       Statement statement;
	       
	       statement = mysql.getConnection().createStatement();
	       ResultSet rs = statement.executeQuery("SELECT * FROM `Stats` WHERE `UUID`='"+ p.getUniqueId() + "';");
	       
	       if(rs.next()){ 
	    	   kills = rs.getInt("Kills");
	       }
	       return kills;
	  }
	  
	  
	  
	  
	  
	  public static void addDeaths(Player p) throws SQLException {
		  MySQL mysql = new MySQL(Main.m, "vweb11.nitrado.net", "3306", "ni515720_1sql5", "ni515720_1sql5", "123asd");
		  mysql.openConnection();
		  Statement statement;
		  
		  statement = mysql.getConnection().createStatement();
		  ResultSet rs = statement.executeQuery("SELECT * FROM `Stats` WHERE `UUID`='"+ p.getUniqueId() + "';");
		  
		  if(!rs.next()) {
			  statement.executeUpdate("INSERT INTO Stats (UUID, Username, Kills, Deaths) VALUES ('" + p.getUniqueId() +"', '" + p.getName() + "', '0', '1'')");
			  
		  }else if(rs.next()){
			  statement.executeUpdate("UPDATE `Stats` set `Deaths` = '" + rs.getInt("Deaths") + 1 + "' where `UUID`='"+ p.getUniqueId() + "';");
		  }
		  
	  }
	  
	  
	  public static int getDeaths(Player p) throws SQLException{
	       int deaths = 0;
	       MySQL mysql = new MySQL(Main.m, "vweb11.nitrado.net", "3306", "ni515720_1sql5", "ni515720_1sql5", "123asd");
	       mysql.openConnection();
	       Statement statement;
	       
	       statement = mysql.getConnection().createStatement();
	       ResultSet rs = statement.executeQuery("SELECT * FROM `Stats` WHERE `UUID`='"+ p.getUniqueId() + "';");
	       
	       if(rs.next()){ 
	    	   deaths = rs.getInt("Deaths");
	       }
	       return deaths;
	  }
	  
	  
	  
}
