package me.xeme.api;

import org.bukkit.entity.Player;

public class RankAPI {

	
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
	
}
