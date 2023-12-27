package me.xeme.api;

import org.bukkit.entity.Player;

import net.minecraft.server.v1_8_R3.World;

public class XemePlayer {
	
	
	private Player player;
	
	public XemePlayer(Player p) {
		
		setXemePlayer(p);
		
	}
	
	

	
	public void setAllowFlight(boolean flight) {
		
		player.setAllowFlight(flight);
		
	}
	
	public void setFyling(boolean flaying) {
		
		player.setFlying(flaying);
		
	}
	public void setDisplayName(String displayname) {
		player.setDisplayName(displayname);
	}
	
	public World getWorld() {
		
		return (World) player.getWorld();
		
	}
	public String getWorldName() {
		
		return player.getWorld().getName();
	}
	public String getDisplayName() {
		
		return player.getDisplayName();
		
	}
	public String getName() {
		
		return player.getName();
	}
	

	public void setXemePlayer(Player xemePlayer) {
			player= xemePlayer;
	}

}
