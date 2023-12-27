package com.xeme.commands;

import java.io.BufferedReader;
import java.net.URL;
import java.net.URLConnection;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.libs.jline.internal.InputStreamReader;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import me.xeme.api.MessageAPI;
import me.xeme.api.RankAPI;
import net.minecraft.server.v1_8_R3.EntityPlayer;
import net.minecraft.server.v1_8_R3.EntityTracker;
import net.minecraft.server.v1_8_R3.WorldServer;

public class Disguise implements CommandExecutor, Listener{
	
	String prefix = "§8[§6Disguise§8]";
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("disguise")) {
			if(p.hasPermission("Disguise.Disguise")) {
				/*/String name = "";
				try
			      {
			        URL url = new URL("http://hyperwalk.esy.es/randomdisguise/randomname/names.php");
			        URLConnection con = url.openConnection();
			        BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
			        name = reader.readLine();
			      }
			      catch (Exception e1)
			      {
			        e1.printStackTrace();
			      }/*/
				setname(p);
				
			}else {
				MessageAPI.noPermission(p);
			
			}
		}
		if(cmd.getName().equalsIgnoreCase("undisguise")){
			if(p.hasPermission("Disguise.Disguise")) {
				RankAPI.playerSetDisplayName(p);
				p.teleport(p.getLocation());
				p.sendMessage(prefix + " §aYou have been to Undisguised");
			}else {
				MessageAPI.noPermission(p);
			}
		}
		
		
		
		return false;
	}
	
	
	  @SuppressWarnings({ "resource", "unused" })
	public void setname(Player o)
	    {
		  
		String name = "";
		try
		{
			URL url = new URL("http://teamplayz.com/randomdisguise/randomname/names.php");
			URLConnection con = url.openConnection();
			BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
			name = reader.readLine();
		}
		catch (Exception e1)
		{
			e1.printStackTrace();
		}
		o.setDisplayName("§2" + name);
		o.setPlayerListName("§2" + name);
		
	    EntityPlayer player = ((CraftPlayer)o).getHandle();
	    Player senderplayer = (Player)o;
		
		WorldServer world = (WorldServer)player.world;
	    EntityTracker tracker = world.tracker;
	    tracker.untrackEntity(player);
	
	    tracker.track(player);
		
		o.sendMessage(prefix + " §c§lWarning! §cThis command is loged!");
		o.sendMessage(prefix + " §cStaff can see your real username !");
		o.sendMessage(prefix + " §eGenerating Random username...");
		o.sendMessage(prefix + " §eYou now appear as §2" + name);
		o.sendMessage(prefix + " §eTo undisguise, use §8[§e/undisguise§8]");
	    /*/  List<String> r_taunt = Main.m.getConfig().getStringList("name1");
	      
	      Random rand = new Random();
	      int choice = rand.nextInt(r_taunt.size());
	      
	      List<String> name2 = Main.m.getConfig().getStringList("name2");
	      Random rand1 = new Random();
	      int choice1 = rand1.nextInt(name2.size());
	      List<String> name3 = Main.m.getConfig().getStringList("name3");
	      Random rand2 = new Random();
	      int choice2 = rand2.nextInt(name3.size());
	      List<String> skin = Main.m.getConfig().getStringList("skins");
	      
	      Random randskin = new Random();
	      int choiceskin = randskin.nextInt(skin.size());
	      String skinsec = (String)skin.get(choiceskin);
	      Random random = new Random();
	      int sans1 = random.nextInt(2);
	      if (sans1 == 1)
	      {
	        List<String> list = Main.m.getConfig().getStringList("Disguise Gecmisi");
	        DateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy HH:mm:ss");
	        Date date = new Date();
	        String kayit = o.getName() + "-->" + (String)r_taunt.get(choice) + (String)name2.get(choice1) + (String)name3.get(choice2) + " " + dateFormat.format(date);
	        List<String> dkm = Main.m.getConfig().getStringList("dk");
	        Main.m.getConfig().createSection(kayit);
	        o.sendMessage(prefix + " §c§lWarning! §cThis command is loged!");
			o.sendMessage(prefix + " §cStaff can see your real username!");
		    o.sendMessage(prefix + " §eGenerating Random username...");
		    o.sendMessage(prefix + " §eYou now appear as §2" + (String)r_taunt.get(choice) + (String)name2.get(choice1) + (String)name3.get(choice2));
		    o.sendMessage(prefix + " §eTo undisguise, use §8[§e/undisguise§8]"); 
		    String name = (String)r_taunt.get(choice) + (String)name2.get(choice1) + (String)name3.get(choice2);
		    o.setDisplayName("§2 " + name);
	        o.setPlayerListName("§2" + name);
	        
	        Main.m.saveConfig();
	      }
	      else if (sans1 == 0)
	      {
	        List<String> dkm = Main.m.getConfig().getStringList("Disguise Gecmisi");
	        DateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy HH:mm:ss");
	        Date date = new Date();
	        String kayit = o.getName() + "-->" + (String)r_taunt.get(choice) + (String)name2.get(choice1) + " " + dateFormat.format(date);
	        Main.m.getConfig().createSection(kayit);
	        o.sendMessage(prefix + " §c§lWarning! §cThis command is loged!");
			o.sendMessage(prefix + " §cStaff can see your real username!");
		    o.sendMessage(prefix + " §eGenerating Random username...");
		    o.sendMessage(prefix + " §eYou now appear as §2" + (String)r_taunt.get(choice) + (String)name2.get(choice1));
		    o.sendMessage(prefix + " §eTo undisguise, use §8[§e/undisguise§8]"); 
		    String name = (String)r_taunt.get(choice) + (String)name2.get(choice1);
	        o.setDisplayName("§2 " + name);
	        o.setPlayerListName("§2" + name);
	        Main.m.saveConfig();
	      }
	    }/*/
	    }
	  
	 
	  
}
