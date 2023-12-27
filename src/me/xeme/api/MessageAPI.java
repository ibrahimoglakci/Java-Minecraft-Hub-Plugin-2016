package me.xeme.api;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class MessageAPI extends JavaPlugin implements Listener{
	
	

	public static void noPermission(Player p) {
		
		p.sendMessage("§8[§3Xeme§8] §cYou don't have permission this command");
		
	}
	
	public static void playerNotFound(Player p) {
		
		p.sendMessage("§8[§3Xeme§8] §cPlayer is Not Found");
		
	}
	
	
	
	
	
	


	
	

}
