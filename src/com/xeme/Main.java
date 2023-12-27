package com.xeme;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.logging.Logger;

import org.apache.commons.io.IOUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerChatTabCompleteEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;

import com.xeme.commands.Apply;
import com.xeme.commands.Ban;
import com.xeme.commands.Broadcast;
import com.xeme.commands.Disguise;
import com.xeme.commands.Fix;
import com.xeme.commands.Gamemode;
import com.xeme.commands.Heal;
import com.xeme.commands.Help;
import com.xeme.commands.Mask;
import com.xeme.commands.Murder;
import com.xeme.commands.Punishment;
import com.xeme.commands.Rank;
import com.xeme.commands.Report;
import com.xeme.commands.Stats;
import com.xeme.commands.Title;
import com.xeme.commands.UnMask;
import com.xeme.commands.fly;
import com.xeme.commands.ping;

import me.xeme.api.CustomItem;
import me.xeme.api.NameAPI;
import me.xeme.api.RankAPI;
import me.xeme.api.Ranks;
import me.xeme.api.SBAPI;
import me.xeme.api.StatsAPI;
import net.minecraft.server.v1_8_R3.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_8_R3.PacketPlayOutPlayerListHeaderFooter;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle.EnumTitleAction;
import xeme.hub.FancyMessage;


public class Main extends JavaPlugin implements Listener{
	
	public static Main m;
	int oda1rastgele1 = 1000;
	int oda1rastgele2 = 3000;
	Random r = new Random();
	
	int oda1rastgele = r.nextInt(oda1rastgele2) + oda1rastgele1;
	  ArrayList<Integer> oda1online =  new ArrayList<>();
	  Map<Player, Integer> cps = new HashMap<Player, Integer>();
	  String tag = "&8[&eXemeAntiCheat&8]".replace("&", "§");
	  String noperms = ChatColor.RED + "You do not have permissions to perform this command!";
	  String commands = " §7Commands: §8[§e/cps setTiklama§8], §8[§e/cps reload§8], §8[§e/cps setSaniye§8] ";
	  ArrayList<String> effect = new ArrayList<>();
	  ArrayList<String> chatspam = new ArrayList<String>();
	  
	  	public static Ranks ranks;

	    public static final Logger logerciamca = Logger.getLogger("Minecraft");
	    
	@SuppressWarnings("deprecation")
	public void onEnable() {
		Bukkit.getServer().getPluginManager().registerEvents(this , this);
		m = this;
		
		log("§6=§b=§6=§b=§6=§b=§6=§b=§6=§b=§6=§b=§6=§b=§6=§b=§6=§b=§6=§b=§6=§b=§6=§b=§6=§b=§6=§b=§6=§b=§6=§b=");
		log("");
		log("");
		log("       §r" + NameAPI.setColouredString("Xeme_V3NSYJ") + " §7is §a§lEnabled !");
		log("");
		log("       §9§lPlugin Coded by " + NameAPI.setColouredString("WalkingUcak_"));
		log("");
		log("");
		log("§6=§b=§6=§b=§6=§b=§6=§b=§6=§b=§6=§b=§6=§b=§6=§b=§6=§b=§6=§b=§6=§b=§6=§b=§6=§b=§6=§b=§6=§b=§6=§b=");
		
		for(Player players : Bukkit.getOnlinePlayers()){
	         
	           if(players.isOp()){
		            String body = "";
		           try {
		            
		            URL url = new URL("http://hyperwalk.esy.es/plugins/antiautoclicker/version/version.php");
		            URLConnection con = url.openConnection();
		            InputStream in = con.getInputStream();
		            String encoding = con.getContentEncoding();
		            encoding = (encoding == null) ? "UTF-8" : encoding;
		            body = IOUtils.toString(in, encoding);
		            } catch (Exception e1) {
		            e1.printStackTrace();
		            }
		           if(!body.equalsIgnoreCase("2.0.1")){
		        	   players.sendMessage("&c&lPlease upgrade the AntiMacro plugin with &3http://auragamer.net/xplayz/Project/AntiMacro/download".replaceAll("&", "§"));
		           }
	           	}
	           }
		
		for (World world : this.getServer().getWorlds()){
	        if (world.getTime() >= 12000){
	            world.setTime(0);
	        }
	    }
		Bukkit.getServer().broadcastMessage("§7[§bXeme§7] §aPlugin is Reloaded");
		getCommand("rank").setExecutor(new Rank());
		getCommand("disguise").setExecutor(new Disguise());
		getCommand("undisguise").setExecutor(new Disguise());
		getCommand("apply").setExecutor(new Apply());
		getCommand("heal").setExecutor(new Heal());
		getCommand("stats").setExecutor(new Stats());
		getCommand("fix").setExecutor(new Fix());
		getCommand("mask").setExecutor(new Mask());
	    getCommand("unmask").setExecutor(new UnMask());
	    //getCommand("list").setExecutor((CommandExecutor) new List());
	    getCommand("ping").setExecutor(new ping());
	    getCommand("gamemode").setExecutor(new Gamemode());
	    getCommand("gmc").setExecutor(new Gamemode());
	    getCommand("gms").setExecutor(new Gamemode());
	    getCommand("broadcast").setExecutor(new Broadcast());
	    getCommand("alert").setExecutor(new Broadcast());
	    getCommand("kill").setExecutor(new Murder());
	    getCommand("fly").setExecutor(new fly());
	    getCommand("help").setExecutor(new Help());
	    getCommand("report").setExecutor(new Report());
	    getCommand("punishment").setExecutor(new Punishment());
	    getCommand("ban").setExecutor(new Ban());
	   // getCommand("lookup").setExecutor(new Lookup());
	    ItemStack fw = new CustomItem(Material.FIREWORK, 1, 1).setDisplayName("§a§lPegasus §e§lJeti").build();
	    ShapedRecipe fwrep = new ShapedRecipe(fw);
	    fwrep.shape("rcf", "ata", "pol").setIngredient('r', Material.GLASS).setIngredient('c', Material.COAL_ORE).setIngredient('f', Material.FIREBALL).setIngredient('a', Material.AIR).setIngredient('t', Material.TORCH).setIngredient('p', Material.REDSTONE_COMPARATOR).setIngredient('o', Material.REDSTONE).setIngredient('l', Material.LAVA_BUCKET);
	    Bukkit.addRecipe(fwrep);
	    ItemStack goldenhead = new CustomItem(Material.GOLDEN_APPLE, 1, 0).setDisplayName("&6Golden Head").build();
	    ShapedRecipe goldenheadrep = new ShapedRecipe(goldenhead);
	    goldenheadrep.shape("ccc", "chc", "ccc").setIngredient('c', Material.GOLD_INGOT).setIngredient('h', Material.SKULL_ITEM, 3);
	    Bukkit.addRecipe(goldenheadrep);
	    chatDisable.add("false");
	    FileConfiguration config = getConfig();
	    config.options().copyDefaults(true);
	    getConfig().addDefault("Click", Integer.valueOf(20));
	    getConfig().addDefault("Seconds", Integer.valueOf(1));
	    getConfig().addDefault("Kick_Message", String.valueOf(" %nl% &cYou're reached more than &8[&6%cps%&8] &cClick per Seconds&8."));
	    getConfig().addDefault("Broadcast_Message", String.valueOf("%nl% &4&l%player% &6is reached more than &8[&e%cps%&8] %nl% &6Click Per Seconds&8!"));
	    if (!getConfig().contains("Join_Message")) {
	      getConfig().set("Join_Message", "%player% &6has joined&8.".replace("&", "§"));
	    }
	    

	    if (!getConfig().contains("Quit_Message")) {
		      getConfig().set("Quit_Message", "%player% &6has left&8.".replace("&", "§"));
		}
	    saveConfig();
	    Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable()
	    {
	      public void run()
	      {
	        for (Player p : Main.this.cps.keySet()) {
	          Main.this.cps.put(p, Integer.valueOf(1));
	        }
	      }
	    }, 0L, getConfig().getInt("Seconds") * 20);
	}
	
	ArrayList<String>Gems = new ArrayList<String>();
	ArrayList<String> chatDisable = new ArrayList<String>();
	public ArrayList<Player> colorgreen = new ArrayList<Player>();
	public ArrayList<Player> colorred = new ArrayList<Player>();
	public ArrayList<Player> coloryellow = new ArrayList<Player>();
	public ArrayList<Player> colorblue = new ArrayList<Player>();
	ArrayList<String> waitClock = new ArrayList<String>();
	String prefix = "§8[§3Xeme§8]§r";
	String serverprefix = "§b§lXemeNetWork";

	
	//-------------------------------------- Komutlar --------------------------------------\\
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		
		
		if(cmd.getName().equalsIgnoreCase("sethub")) {
			if(p.hasPermission("xeme.owner")) {
				if(args.length == 0) {
					
					getConfig().set("hub.World" , p.getEyeLocation().getWorld().getName());
					getConfig().set("hub.X" , p.getEyeLocation().getX());
					getConfig().set("hub.Y" , p.getEyeLocation().getY());
					getConfig().set("hub.Z" , p.getEyeLocation().getZ());
					getConfig().set("hub.Yaw" , p.getEyeLocation().getYaw());
					getConfig().set("hub.Pitch" , p.getEyeLocation().getPitch());
					
					saveConfig();
					p.sendMessage(prefix + " &aSuccesfully Setted HUB !".replace("&", "§"));
				}
			}
		}
		if(cmd.getName().equalsIgnoreCase("hub")) {
			if(args.length == 0) {
				int rastgele1 = 1000;
				int rastgele2 = 3000;
				Random r = new Random();
				int rastgele = r.nextInt(rastgele2) + rastgele1;
				World w = Bukkit.getServer().getWorld(getConfig().getString("hub.World"));
				double x = getConfig().getDouble("hub.X");
				double y = getConfig().getDouble("hub.Y");
				double z = getConfig().getDouble("hub.Z");
				Location hub = new Location(w, x, y, z);
				p.teleport(hub);
				p.sendMessage(prefix + " &aYou Teleporting to &3".replace("&", "§") + rastgele);
			}
		}
		if (label.equalsIgnoreCase("xemesystem")) {
			if(args.length == 0) {
				p.sendMessage(prefix + " §c/xemesystem <reload>");
			}
			else if (args.length == 1)
		    {
		    	if (args[0].equalsIgnoreCase("reload"))
		        {
		        	Plugin pl = Bukkit.getPluginManager().getPlugin(this.getName());
		        	Bukkit.getServer().getPluginManager().disablePlugin(pl);
		        	Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
				        public void run() {
				        	Bukkit.getServer().getPluginManager().enablePlugin(pl);
				        }
				    },40);
		        	
		        	
		        }
		    }
		}
		if (label.equalsIgnoreCase("cps")) {
		      if (args.length == 1)
		      {
		        if (args[0].equalsIgnoreCase("reload"))
		        {
		          if ((sender.hasPermission("cps.reload")) || (sender.hasPermission("cps.admin")))
		          {
		            reloadConfig();
		            sender.sendMessage(this.tag + " §aConfig Yenilendi!");
		          }
		          else
		          {
		            sender.sendMessage(this.tag + this.noperms);
		          }
		        }
		        else {
		          sender.sendMessage(this.tag + this.commands);
		        }
		      }
		      else if (args.length == 2)
		      {
		        if (args[0].equalsIgnoreCase("setTiklama"))
		        {
		          if ((sender.hasPermission("cps.setTiklama")) || (sender.hasPermission("cps.admin"))) {
		            getConfig().set("Tiklama", Integer.valueOf(Integer.parseInt(args[1])));
		            p.sendMessage(prefix + " §aSetted antimacro click cps integer to §e" + args[1]);
		          } else {
		            sender.sendMessage(this.tag + this.noperms);
		          }
		        }
		        else if ((args[0].equalsIgnoreCase("setSaniye")) || (sender.hasPermission("cps.admin")))
		        {
		          if (sender.hasPermission("cps.setSaniye")) {
		            getConfig().set("Saniye", Integer.valueOf(Integer.parseInt(args[1])));
		            p.sendMessage(prefix + " §aSetted antimacro click seconds integer to §e" + args[1]);
		          } else {
		            sender.sendMessage(this.tag + this.noperms);
		          }
		        }
		        else {
		          sender.sendMessage(this.tag + this.commands);
		        }
		      }
		      else {
		        sender.sendMessage(this.tag + this.commands);
		      }
		    }
		
		
		
		if(cmd.getName().equalsIgnoreCase("xeme")) {
			
			
			p.sendMessage("\n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n");
			p.sendMessage("§b§m--------------§r§8[   §6§lXeme System   §8]§b§m--------------");
		    p.sendMessage("§8[§3Xeme§8]§r §fHello " + p.getDisplayName());
	    	p.sendMessage("§8[§3Xeme§8]§r §fI am §3§lXeme_V3NSYJ");
	    	p.sendMessage("§8[§3Xeme§8]§r §fMy Coder is §4§lW§c§la§6§ll§e§lk§a§li§2§ln§3§lg§4§lU§c§lc§9§la§1§lk§3§l_");
	    	p.sendMessage("§8[§3Xeme§8]§r §9§lGood Luck");
	    	
	    	
		}

		 
		
		if(cmd.getName().equalsIgnoreCase("chat")) {
			if(args.length == 0) {
				if(p.hasPermission("xemechat.message")) {
					p.sendMessage("\n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n");
					p.sendMessage("§6§m--------------§r§8[   §aChat System   §8]§6§m-------------- \n \n§8[§3Xeme§8]§7 Chat Clear - §b/chat clear \n§8[§3Xeme§8]§7 Chat Enabled - §b/chat enable \n§8[§3Xeme§8]§7 Chat Disabled - §b/chat disable");
				}
			}
			if(args.length == 1) {
				if(args[0].equalsIgnoreCase("clear")) {
					if(p.hasPermission("xemechat.clear")) {
						Bukkit.getServer().broadcastMessage("\n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n" + "\n §9§lChat §7§l» §6§lChat Cleared");
					}
				}
				if(args[0].equalsIgnoreCase("enable")) {
					if(p.hasPermission("xemechat.enable")) {
						chatDisable.remove("false");
						chatDisable.remove("true");
						chatDisable.add("false");
						
						getConfig().set("GlobalMute", false);
						saveConfig();
						Bukkit.getServer().broadcastMessage("\n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n");
						Bukkit.getServer().broadcastMessage(prefix + "§b§l Global Mute is Now §c§lDisabled.");
							
					}
				}
				if(args[0].equalsIgnoreCase("disable")) {
					if(p.hasPermission("xemechat.disable")) {
						chatDisable.remove("false");
						chatDisable.remove("true");
						chatDisable.add("true");
						getConfig().set("GlobalMute", true);
						saveConfig();
						Bukkit.getServer().broadcastMessage("\n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n");
						Bukkit.getServer().broadcastMessage(prefix + "§b§l Global Mute is Now §a§lEnabled.");
					}
				}
			}
		}
		
		if (cmd.getName().equalsIgnoreCase("chatcolor"))
	    {
	      Player player = (Player) sender;
	      File data = new File(Bukkit.getPluginManager().getPlugin("Xeme_V3NSYJ").getDataFolder(), File.separator + "userdata");
		  File f = new File(data, File.separator + player.getName() + ".yml");
		  FileConfiguration playerData = YamlConfiguration.loadConfiguration(f);
	      if (player.hasPermission("Xeme.diamond"))
	      {
	        if (args.length == 0)
	        {
	          player.sendMessage("§8[§3Xeme§8] §f You have the following options§8:");
	          player.sendMessage("§8[§3Xeme§8] §c &c, §e&e, §9&9, §a&a, §b&b, §fOFF§8.");
	          player.sendMessage("§c/chatcolor <ColorCode:Off>");
	        }
	        if (args.length == 1)
	        {
	          if (args[0].equalsIgnoreCase("&a"))
	          {
	            player.sendMessage("§8[§3Xeme§8]§r You have selected your chat color as §aGreen§8!");
	            this.colorgreen.remove(player);
	            this.colorred.remove(player);
	            this.colorblue.remove(player);
	            this.coloryellow.remove(player);
	            this.colorgreen.add(player);
	            playerData.set("ChatColor",	"&a");
	            try {
	            	playerData.save(f);
	            }catch (IOException ex){
					 ex.printStackTrace();
	            }
	            ;
	          }
	          if (args[0].equalsIgnoreCase("&c"))
	          {
	            player.sendMessage("§8[§3Xeme§8]§r You have selected your chat color as §cRed§8!");
	            this.colorred.remove(player);
	            this.colorgreen.remove(player);
	            this.colorblue.remove(player);
	            this.coloryellow.remove(player);
	            this.colorred.add(player);
	            playerData.set("ChatColor",	"&c");
	            try {
	            	playerData.save(f);
	            }catch (IOException ex){
					 ex.printStackTrace();
	            }
	          }
	          if (args[0].equalsIgnoreCase("&9"))
	          {
	            player.sendMessage("§8[§3Xeme§8]§r You have selected your chat color as §9Blue§8!");
	            this.colorred.remove(player);
	            this.colorgreen.remove(player);
	            this.colorblue.remove(player);
	            this.coloryellow.remove(player);
	            this.colorblue.add(player);
	            playerData.set("ChatColor",	"&9");
	            try {
	            	playerData.save(f);
	            }catch (IOException ex){
					 ex.printStackTrace();
	            }
	          }
	          if (args[0].equalsIgnoreCase("&e"))
	          {
	            player.sendMessage("§8[§3Xeme§8]§r You have selected your chat color as §eYellow§8!");
	            this.coloryellow.remove(player);
	            this.colorred.remove(player);
	            this.colorgreen.remove(player);
	            this.colorblue.remove(player);
	            this.coloryellow.add(player);
	            playerData.set("ChatColor",	"&e");
	            try {
	            	playerData.save(f);
	            }catch (IOException ex){
					 ex.printStackTrace();
	            }
	          }
	          if (args[0].equalsIgnoreCase("&b"))
	          {
	            player.sendMessage("§8[§3Xeme§8]§r You have selected your chat color as §bAqua§8!");
	            this.coloryellow.remove(player);
	            this.colorred.remove(player);
	            this.colorgreen.remove(player);
	            this.colorblue.remove(player);
	            this.coloryellow.add(player);
	            playerData.set("ChatColor",	"&b");
	            try {
	            	playerData.save(f);
	            }catch (IOException ex){
					 ex.printStackTrace();
	            }
	          }
	          if (args[0].equalsIgnoreCase("off"))
	          {
	            this.colorgreen.remove(player);
	            this.colorred.remove(player);
	            this.colorblue.remove(player);
	            this.coloryellow.remove(player);
	            playerData.set("ChatColor",	"&f");
	            try {
	            	playerData.save(f);
	            }catch (IOException ex){
					 ex.printStackTrace();
	            }
	          
	            player.sendMessage("§8[§3Xeme§8]§r You have reseted your color chat§8.");
	          }
	         
	        }
	      }
	      else
	      {
	        player.sendMessage("§8[§3Xeme§8]§4 You don't have permissions for use this§8.");
	      }
	    }
		
		
		if(cmd.getName().equalsIgnoreCase("gamemaster")) {
			if(args.length == 0) {
				if(p.hasPermission("Xeme.gamemaster")) {
					p.sendMessage(prefix + "§c /goto <player>");
				}else{
					p.sendMessage(prefix + "§4 You don't have permission");
				}
			}
			
			if(args.length == 1) {
				if(p.hasPermission("Xeme.gamemaster")) {
					Player target = Bukkit.getPlayer(args[0]);
					if(target == null) {
						p.sendMessage("§cTarget is not online");
					}else {
						p.getInventory().clear();
						ItemStack gamemaster = new ItemStack(Material.ARROW);
						ItemMeta gamemasterm = gamemaster.getItemMeta();
						gamemasterm.setDisplayName("§cExit Gamemaster §7- Right Click");
						ArrayList<String> gamemasterLore = new ArrayList<String>();
						gamemasterLore.add("");
						gamemasterm.setLore(gamemasterLore);
						gamemaster.setItemMeta(gamemasterm);
						p.teleport(target);
						p.sendMessage(prefix + "§7 Your Gamemaster Mode to §aTrue \n" + prefix + " §7You teleported to §c" + args[0]);
						for (Player o : Bukkit.getServer().getOnlinePlayers()) {
							o.hidePlayer(p);
							
						
						}
					}
					
				}else{
					p.sendMessage(prefix + "§4 You don't have permission");
				}
			}
		
			
		}
		if(cmd.getName().equalsIgnoreCase("gamemasterexit")) {
			if(p.hasPermission("Xeme.gamemaster")) {
				
				p.sendMessage(prefix + "§7 Your Gamemaster Mode to §cFalse");
				p.getInventory().clear();
				for (Player o : Bukkit.getServer().getOnlinePlayers()) {
					o.showPlayer(p);
				}
				
			}else{
				p.sendMessage(prefix + "§4 You don't have permission");
			}
		}
		
	
		
		return false;
	}
	
	//-------------------------------------- Eventler --------------------------------------\\
	

	
	 

    
	ArrayList<UUID> droppedItems = new ArrayList<UUID>();
	@EventHandler
	public void gamemasterExit(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		if (player.getItemInHand().getType() == Material.IRON_AXE) {
			if(event.getAction().equals(Action.RIGHT_CLICK_BLOCK) || event.getAction().equals(Action.RIGHT_CLICK_AIR)){
				final Item drop = player.getWorld().dropItem(player.getLocation(), new ItemStack(Material.IRON_AXE, 1));
				droppedItems.add(drop.getUniqueId());
				Vector currentVelocity = player.getLocation().getDirection();
				drop.setVelocity(currentVelocity.multiply(1.5D));
				
				drop.getWorld().createExplosion(drop.getLocation(), 0.0F);
					      
			}
		}
	
		 if(player.getItemInHand().getType() == Material.ARROW) {
			 if(player.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§cExit Gamemaster §7- Right Click"))
				 if(event.getAction().equals(Action.RIGHT_CLICK_BLOCK) || event.getAction().equals(Action.RIGHT_CLICK_AIR)){
					 event.setCancelled(true);
					 player.performCommand("gamemasterexit");
				 }
		 }
		 
	}
	
	@EventHandler
	public void cosmetic(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		 if(player.getItemInHand().getType() == Material.GOLD_INGOT) {
			 if(player.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§e§lXeme Shop §7- Right click to open the shop!"))
				 if(event.getAction().equals(Action.RIGHT_CLICK_BLOCK) || event.getAction().equals(Action.RIGHT_CLICK_AIR)){
					 event.setCancelled(true);
					 player.openInventory(myInventory);
				 }
		 }
	}
	
	
	
	@EventHandler
	  public void onInventoryClick(InventoryClickEvent event)
	  {
	    Player player = (Player)event.getWhoClicked();
	    ItemStack clicked = event.getCurrentItem();
	    Inventory inventory = event.getInventory();
		if (inventory.getName().equals(myInventory.getName())){
	    if (clicked.getType() == Material.PAPER) {
	        
	    event.setCancelled(true);
	
	    }
	  if(clicked.getType() == Material.NETHER_STAR) {
	  	event.setCancelled(true);
	  	player.closeInventory();
	  	player.openInventory(effectInventory);
	  }
	  
	  if(clicked.getType() == Material.GOLD_BOOTS) {
	  	event.setCancelled(true);
	  }
	  
	  if(clicked.getType() == Material.DIAMOND_CHESTPLATE) {
	  	event.setCancelled(true);
	  	player.openInventory(costumeInventory);
	  }
	  if(clicked.getType() == Material.MELON_BLOCK) {
	  	event.setCancelled(true);
	  }
	  if(clicked.getType() == Material.GOLD_HELMET) {
		  	event.setCancelled(true);
		  }
	  }
		
		if (inventory.getName().equals(effectInventory.getName())) {
		      if(clicked.getType() == Material.ARROW) {
		    	    
		        	event.setCancelled(true);
		        	player.closeInventory();
		        	player.openInventory(myInventory);
		      }
		      if(clicked.getType() == Material.FLINT_AND_STEEL) {
		    
		    	event.setCancelled(true);
		    	if(player.hasPermission("auraeffect.flame")) {
		    		player.closeInventory();
		    		player.getWorld().playEffect(player.getLocation(), Effect.FLAME, 10000);
		    		player.sendMessage(this.prefix + " §e§lFlame Effect §aEnabled");
		    		Title title = new Title("", "", 4,5,4);
			    	title.setTitleColor(ChatColor.RED);
			    	title.setSubtitleColor(ChatColor.GREEN);
			    	title.send(player);
		    		PacketPlayOutTitle subtitle = new PacketPlayOutTitle(EnumTitleAction.SUBTITLE, ChatSerializer.a("{\"text\":\"§6§lEffect §7§l» §c§lFlame §eEffect §a§lEnabled\"}"), 5, 10, 6);
			        ((CraftPlayer) event.getWhoClicked()).getHandle().playerConnection.sendPacket(subtitle);
		    		effect.add(player + "flame");
			    	effect.remove(player + "heart");
			    	effect.remove(player + "reddust");
			    	effect.remove(player + "emeraldtwirl");
			    	effect.remove(player + "smoke");
			    	effect.remove(player + "lava");
			    	effect.remove(player + "explode");
			    	effect.remove(player + "firework");
			    	effect.remove(player + "crit");
			    	effect.remove(player + "cloud");
			    	effect.remove(player + "music");
		    	}
		      }
		    
		    if(clicked.getType() == Material.STAINED_GLASS_PANE) {
		    	event.setCancelled(true);
		    }
		    if(clicked.getType() == Material.APPLE) {
		    	event.setCancelled(true);
		    	player.closeInventory();
		    	if(player.hasPermission("auraeffect.heart")) {
		    		player.closeInventory();
			    	player.getWorld().playEffect(player.getLocation(), Effect.HEART, 10000);
			    	player.sendMessage(this.prefix + " §e§lHeart Effect §aEnabled");
			    	Title title = new Title("", "", 4,5,4);
			    	title.setTitleColor(ChatColor.RED);
			    	title.setSubtitleColor(ChatColor.GREEN);
			    	title.send(player);
			        PacketPlayOutTitle subtitle = new PacketPlayOutTitle(EnumTitleAction.SUBTITLE, ChatSerializer.a("{\"text\":\"§6§lEffect §7§l» §c§lHeart §eEffect §a§lEnabled\"}"), 5, 10, 5);
			        ((CraftPlayer) event.getWhoClicked()).getHandle().playerConnection.sendPacket(subtitle);
			    	effect.add(player + "heart");
			    	effect.remove(player + "flame");
			    	effect.remove(player + "reddust");
			    	effect.remove(player + "emeraldtwirl");
			    	effect.remove(player + "smoke");
			    	effect.remove(player + "lava");
			    	effect.remove(player + "explode");
			    	effect.remove(player + "firework");
			    	effect.remove(player + "crit");
			    	effect.remove(player + "cloud");
			    	effect.remove(player + "music");
		    	}
		    }
		    if(clicked.getType() == Material.REDSTONE) {
		    	event.setCancelled(true);
		    	if(player.hasPermission("auraeffect.reddust")) {
		    		player.closeInventory();
			    	player.getWorld().playEffect(player.getLocation(), Effect.COLOURED_DUST, 10000);
			    	player.sendMessage(this.prefix + " §e§lRedDust Effect §aEnabled");
			    	Title title = new Title("", "", 4,5,4);
			    	title.setTitleColor(ChatColor.RED);
			    	title.setSubtitleColor(ChatColor.GREEN);
			    	title.send(player);
			    	PacketPlayOutTitle subtitle = new PacketPlayOutTitle(EnumTitleAction.SUBTITLE, ChatSerializer.a("{\"text\":\"§6§lEffect §7§l» §c§lRedDust §eEffect §a§lEnabled\"}"), 5, 10, 5);
			        ((CraftPlayer) event.getWhoClicked()).getHandle().playerConnection.sendPacket(subtitle);
			    	effect.add(player + "reddust");
			    	effect.remove(player + "flame");
			    	effect.remove(player + "heart");
			    	effect.remove(player + "emeraldtwirl");
			    	effect.remove(player + "smoke");
			    	effect.remove(player + "lava");
			    	effect.remove(player + "explode");
			    	effect.remove(player + "firework");
			    	effect.remove(player + "crit");
			    	effect.remove(player + "cloud");
			    	effect.remove(player + "music");
		    	}
		    }
		    if(clicked.getType() == Material.EMERALD) {
		    	event.setCancelled(true);
		    	if(player.hasPermission("auraeffect.emeraldtwirl")) {
		    		player.closeInventory();
			    	player.getWorld().playEffect(player.getLocation(), Effect.HAPPY_VILLAGER, 10000);
			    	player.sendMessage(this.prefix + " §e§lEmerald Twirl Effect §aEnabled");
			    	Title title = new Title("", "", 4,5,4);
			    	title.setTitleColor(ChatColor.RED);
			    	title.setSubtitleColor(ChatColor.GREEN);
			    	title.send(player);
			    	PacketPlayOutTitle subtitle = new PacketPlayOutTitle(EnumTitleAction.SUBTITLE, ChatSerializer.a("{\"text\":\"§6§lEffect §7§l» §c§lEmeraldTwirl §eEffect §a§lEnabled\"}"), 5, 10, 5);
			        ((CraftPlayer) event.getWhoClicked()).getHandle().playerConnection.sendPacket(subtitle);
			    	effect.add(player + "emeraldtwirl");
			    	effect.remove(player + "flame");
			    	effect.remove(player + "reddust");
			    	effect.remove(player + "heart");
			    	effect.remove(player + "smoke");
			    	effect.remove(player + "lava");
			    	effect.remove(player + "explode");
			    	effect.remove(player + "firework");
			    	effect.remove(player + "crit");
			    	effect.remove(player + "cloud");
			    	effect.remove(player + "music");
		    	}
		    }
		    if(clicked.getType() == Material.IRON_INGOT) {
		    	event.setCancelled(true);
		    	if(player.hasPermission("auraeffect.smoke")) {
		    		player.closeInventory();
			    	player.getWorld().playEffect(player.getLocation(), Effect.SMOKE, 10000);
			    	player.sendMessage(this.prefix + " §e§lSmoke Effect §aEnabled");
			    	Title title = new Title("", "", 4,5,4);
			    	title.setTitleColor(ChatColor.RED);
			    	title.setSubtitleColor(ChatColor.GREEN);
			    	title.send(player);
			    	PacketPlayOutTitle subtitle = new PacketPlayOutTitle(EnumTitleAction.SUBTITLE, ChatSerializer.a("{\"text\":\"§6§lEffect §7§l» §c§lSmoke §eEffect §a§lEnabled\"}"), 5, 10, 5);
			        ((CraftPlayer) event.getWhoClicked()).getHandle().playerConnection.sendPacket(subtitle);
			    	effect.add(player + "smoke");
			    	effect.remove(player + "flame");
			    	effect.remove(player + "reddust");
			    	effect.remove(player + "emeraldtwirl");
			    	effect.remove(player + "heart");
			    	effect.remove(player + "lava");
			    	effect.remove(player + "explode");
			    	effect.remove(player + "firework");
			    	effect.remove(player + "crit");
			    	effect.remove(player + "cloud");
			    	effect.remove(player + "music");
		    	}
		    }
		    if(clicked.getType() == Material.LAVA_BUCKET) {
		    	event.setCancelled(true);
		    	if(player.hasPermission("auraeffect.lava")) {
		    		player.closeInventory();
			    	player.getWorld().playEffect(player.getLocation(), Effect.LAVADRIP, 10000);
			    	player.sendMessage(this.prefix + " §e§lLava Effect §aEnabled");
			    	Title title = new Title("", "", 4,5,4);
			    	title.setTitleColor(ChatColor.RED);
			    	title.setSubtitleColor(ChatColor.GREEN);
			    	title.send(player);
			    	PacketPlayOutTitle subtitle = new PacketPlayOutTitle(EnumTitleAction.SUBTITLE, ChatSerializer.a("{\"text\":\"§6§lEffect §7§l» §c§lLava §eEffect §a§lEnabled\"}"), 5, 10, 5);
			        ((CraftPlayer) event.getWhoClicked()).getHandle().playerConnection.sendPacket(subtitle);
			    	effect.add(player + "lava");
			    	effect.remove(player + "flame");
			    	effect.remove(player + "reddust");
			    	effect.remove(player + "emeraldtwirl");
			    	effect.remove(player + "smoke");
			    	effect.remove(player + "heart");
			    	effect.remove(player + "explode");
			    	effect.remove(player + "firework");
			    	effect.remove(player + "crit");
			    	effect.remove(player + "cloud");
			    	effect.remove(player + "music");
		    	}
		    }
		    if(clicked.getType() == Material.TNT) {
		    	event.setCancelled(true);
		    	if(player.hasPermission("auraeffect.explode")) {
		    		player.closeInventory();
			    	player.getWorld().playEffect(player.getLocation(), Effect.EXPLOSION_LARGE, 10000);
			    	player.sendMessage(this.prefix + " §e§lExplode Effect §aEnabled");
			    	Title title = new Title("", "", 4,5,4);
			    	title.setTitleColor(ChatColor.RED);
			    	title.setSubtitleColor(ChatColor.GREEN);
			    	title.send(player);
			    	PacketPlayOutTitle subtitle = new PacketPlayOutTitle(EnumTitleAction.SUBTITLE, ChatSerializer.a("{\"text\":\"§6§lEffect §7§l» §c§lExplode §eEffect §a§lEnabled\"}"), 5, 10, 5);
			        ((CraftPlayer) event.getWhoClicked()).getHandle().playerConnection.sendPacket(subtitle);
			    	effect.add(player + "explode");
			    	effect.remove(player + "flame");
			    	effect.remove(player + "reddust");
			    	effect.remove(player + "emeraldtwirl");
			    	effect.remove(player + "smoke");
			    	effect.remove(player + "lava");
			    	effect.remove(player + "heart");
			    	effect.remove(player + "firework");
			    	effect.remove(player + "crit");
			    	effect.remove(player + "cloud");
			    	effect.remove(player + "music");
			    	
		    	}
		    }
		    if(clicked.getType() == Material.FIREWORK) {
		    	event.setCancelled(true);
		    	if(player.hasPermission("auraeffect.firework")) {
		    		player.closeInventory();
			    	player.getWorld().playEffect(player.getLocation(), Effect.FIREWORKS_SPARK, 10000);
			    	player.sendMessage(this.prefix + " §e§lFireWork Effect §aEnabled");
			    	Title title = new Title("", "", 4,5,4);
			    	title.setTitleColor(ChatColor.RED);
			    	title.setSubtitleColor(ChatColor.GREEN);
			    	title.send(player);
			    	PacketPlayOutTitle subtitle = new PacketPlayOutTitle(EnumTitleAction.SUBTITLE, ChatSerializer.a("{\"text\":\"§6§lEffect §7§l» §c§lFireWork §eEffect §a§lEnabled\"}"), 5, 10, 5);
			        ((CraftPlayer) event.getWhoClicked()).getHandle().playerConnection.sendPacket(subtitle);
			    	effect.add(player + "firework");
			    	effect.remove(player + "flame");
			    	effect.remove(player + "reddust");
			    	effect.remove(player + "emeraldtwirl");
			    	effect.remove(player + "smoke");
			    	effect.remove(player + "lava");
			    	effect.remove(player + "explode");
			    	effect.remove(player + "heart");
			    	effect.remove(player + "crit");
			    	effect.remove(player + "cloud");
			    	effect.remove(player + "music");
		    	}
		    }
		    if(clicked.getType() == Material.BOW) {
		    	event.setCancelled(true);
		    	if(player.hasPermission("auraeffect.critical")) {
		    		player.closeInventory();
			    	player.getWorld().playEffect(player.getLocation(), Effect.CRIT, 10000);
			    	player.sendMessage(this.prefix + " §e§lCritical Effect §aEnabled");
			    	Title title = new Title("", "", 4,5,4);
			    	title.setTitleColor(ChatColor.RED);
			    	title.setSubtitleColor(ChatColor.GREEN);
			    	title.send(player);
			    	PacketPlayOutTitle subtitle = new PacketPlayOutTitle(EnumTitleAction.SUBTITLE, ChatSerializer.a("{\"text\":\"§6§lEffect §7§l» §c§lCritical §eEffect §a§lEnabled\"}"), 5, 10, 5);
			        ((CraftPlayer) event.getWhoClicked()).getHandle().playerConnection.sendPacket(subtitle);
			    	effect.add(player + "crit");
			    	effect.remove(player + "flame");
			    	effect.remove(player + "reddust");
			    	effect.remove(player + "emeraldtwirl");
			    	effect.remove(player + "smoke");
			    	effect.remove(player + "lava");
			    	effect.remove(player + "explode");
			    	effect.remove(player + "firework");
			    	effect.remove(player + "heart");
			    	effect.remove(player + "cloud");
			    	effect.remove(player + "music");
		    	}
		    }
		    if(clicked.getType() == Material.SNOW_BLOCK) {
		    	event.setCancelled(true);
		    	if(player.hasPermission("auraeffect.cloud")) {
		    		player.closeInventory();
			    	player.getWorld().playEffect(player.getLocation(), Effect.CLOUD, 10000);
			    	player.sendMessage(this.prefix + " §e§lCloud Effect §aEnabled");
			    	Title title = new Title("", "", 4,5,4);
			    	title.setTitleColor(ChatColor.RED);
			    	title.setSubtitleColor(ChatColor.GREEN);
			    	title.send(player);
			    	PacketPlayOutTitle subtitle = new PacketPlayOutTitle(EnumTitleAction.SUBTITLE, ChatSerializer.a("{\"text\":\"§6§lEffect §7§l» §c§lCloud §eEffect §a§lEnabled\"}"), 5, 10, 5);
			        ((CraftPlayer) event.getWhoClicked()).getHandle().playerConnection.sendPacket(subtitle);
			    	effect.add(player + "cloud");
			    	effect.remove(player + "flame");
			    	effect.remove(player + "reddust");
			    	effect.remove(player + "emeraldtwirl");
			    	effect.remove(player + "smoke");
			    	effect.remove(player + "lava");
			    	effect.remove(player + "explode");
			    	effect.remove(player + "firework");
			    	effect.remove(player + "crit");
			    	effect.remove(player + "heart");
			    	effect.remove(player + "music");
		    	}
		    }
		    if(clicked.getType() == Material.GREEN_RECORD) {
		    	event.setCancelled(true);
		    	if(player.hasPermission("auraeffect.music")) {
		    		player.closeInventory();
			    	player.getWorld().playEffect(player.getLocation(), Effect.NOTE, 10000);
			    	player.sendMessage(this.prefix + " §e§lMusic Effect §aEnabled");
			    	Title title = new Title("", "", 4,5,4);
			    	title.setTitleColor(ChatColor.RED);
			    	title.setSubtitleColor(ChatColor.GREEN);
			    	title.send(player);
			    	PacketPlayOutTitle subtitle = new PacketPlayOutTitle(EnumTitleAction.SUBTITLE, ChatSerializer.a("{\"text\":\"§6§lEffect §7§l» §c§lMusic §eEffect §a§lEnabled\"}"), 5, 10, 5);
			        ((CraftPlayer) event.getWhoClicked()).getHandle().playerConnection.sendPacket(subtitle);
			    	effect.add(player + "music");
			    	effect.remove(player + "flame");
			    	effect.remove(player + "reddust");
			    	effect.remove(player + "emeraldtwirl");
			    	effect.remove(player + "smoke");
			    	effect.remove(player + "lava");
			    	effect.remove(player + "explode");
			    	effect.remove(player + "firework");
			    	effect.remove(player + "crit");
			    	effect.remove(player + "cloud");
			    	effect.remove(player + "heart");
		    	}
		    }
		    if(clicked.getType() == Material.REDSTONE_BLOCK) {
		    	event.setCancelled(true);
		    	if(player.hasPermission("auraeffect.clear")) {
		    		player.closeInventory();
			    	player.sendMessage(this.prefix + " §e§lAll Effects §cDisabled");
			    	Title title = new Title("", "", 4,5,4);
			    	title.setTitleColor(ChatColor.RED);
			    	title.setSubtitleColor(ChatColor.GREEN);
			    	title.send(player);
			    	PacketPlayOutTitle subtitle = new PacketPlayOutTitle(EnumTitleAction.SUBTITLE, ChatSerializer.a("{\"text\":\"§6§lEffect §7§l» §a§lAll Effect §c§lDisabled\"}"), 5, 10, 5);
			        ((CraftPlayer) event.getWhoClicked()).getHandle().playerConnection.sendPacket(subtitle);
			    	effect.remove(player + "music");
			    	effect.remove(player + "flame");
			    	effect.remove(player + "reddust");
			    	effect.remove(player + "emeraldtwirl");
			    	effect.remove(player + "smoke");
			    	effect.remove(player + "lava");
			    	effect.remove(player + "explode");
			    	effect.remove(player + "firework");
			    	effect.remove(player + "crit");
			    	effect.remove(player + "cloud");
			    	effect.remove(player + "heart");
		    	}
		    }
		    }
		if (inventory.getName().equals(costumeInventory.getName())) {
	    	if(clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§c§Clear Armor") && clicked.getType() == Material.REDSTONE_BLOCK) {
	    		event.setCancelled(true);
	    		player.getInventory().setHelmet(new ItemStack(Material.AIR));
	    	    player.getInventory().setChestplate(new ItemStack(Material.AIR));
	    	    player.getInventory().setLeggings(new ItemStack(Material.AIR));
	    	    player.getInventory().setBoots(new ItemStack(Material.AIR));

	    	}
	    	if(clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§c§lWalking Helmet") && clicked.getType() == Material.LEATHER_HELMET) {
	    
	    		event.setCancelled(true);
	    		player.closeInventory();
	    		ItemStack helmet = new ItemStack(Material.LEATHER_HELMET);
	    	    ItemMeta helmetm = (ItemMeta) helmet.getItemMeta();
	    	    helmetm.setDisplayName("§c§lWalking Helmet");
	    	    ArrayList<String> helmetLore = new ArrayList<String>();
	    	    helmetLore.add("");
	    	    helmetm.setLore(helmetLore);
	    	    helmet.setItemMeta(helmetm);
	        	player.getEquipment().setHelmet(helmet);
	        	player.sendMessage(this.prefix + "§aYou Equipment to §c§lWalking Helmet");
	    	}
	    if(clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§c§lWalking Jacket") && clicked.getType() == Material.LEATHER_CHESTPLATE) {
	    	event.setCancelled(true);
	    	player.closeInventory();
	    	ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
		    ItemMeta chestplatem = (ItemMeta) chestplate.getItemMeta();
		    chestplatem.setDisplayName("§c§lWalking Jacket");
		    ArrayList<String> chestplateLore = new ArrayList<String>();
		    chestplateLore.add("");
		    chestplatem.setLore(chestplateLore);
		    chestplate.setItemMeta(chestplatem);
	    	player.getEquipment().setChestplate(chestplate);
	    	player.sendMessage(this.prefix + "§aYou Equipment to §c§lWalking Jacket");
	    }
	    
	    if(clicked.getType() == Material.LEATHER_LEGGINGS && clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§c§lWalking Leggings")) {
	    	event.setCancelled(true);
	    	player.closeInventory();
	    	ItemStack pants = new ItemStack(Material.LEATHER_LEGGINGS);
		    ItemMeta pantsm = (ItemMeta) pants.getItemMeta();
		    pantsm.setDisplayName("§c§lWalking Leggins");
		    ArrayList<String> pantsLore = new ArrayList<String>();
		    pantsLore.add("");
		    pantsm.setLore(pantsLore);
		    pants.setItemMeta(pantsm);
	    	player.getEquipment().setChestplate(pants);
	    	player.sendMessage(this.prefix + "§aYou Equipment to §c§lWalking Leggins");
	    }
	    if(clicked.getType() == Material.LEATHER_BOOTS && clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§c§lWalking Boots")) {
	    	event.setCancelled(true);
	    	player.closeInventory();
	    	ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);
		    ItemMeta bootsm = (ItemMeta) boots.getItemMeta();
		    bootsm.setDisplayName("§c§lWalking Leggins");
		    ArrayList<String> pantsLore = new ArrayList<String>();
		    pantsLore.add("");
		    bootsm.setLore(pantsLore);
		    boots.setItemMeta(bootsm);
	    	player.getEquipment().setChestplate(boots);
	    	player.sendMessage(this.prefix + "§aYou Equipment to §c§lWalking Boots");
	    }
	    if(clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§c§lPeace Helmet") && clicked.getType() == Material.LEATHER_HELMET) {
	    	event.setCancelled(true); 
	    	player.closeInventory();
	    	ItemStack mavihelm = new ItemStack(Material.LEATHER_HELMET);
		    LeatherArmorMeta mavihelmm = (LeatherArmorMeta) mavihelm.getItemMeta();
		    mavihelmm.setColor(Color.AQUA);
		    mavihelmm.setDisplayName("§c§lPeace Helmet");
		    ArrayList<String> mavihelmLore = new ArrayList<String>();
		    mavihelmLore.add("");
		    mavihelmm.setLore(mavihelmLore);
		    mavihelm.setItemMeta(mavihelmm);
	    	player.getEquipment().setHelmet(mavihelm);
	    	player.sendMessage(this.prefix + "§aYou Equipment to §c§lPeace Helmet");
	    }
	    if(clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§c§lPeace Jacket") && clicked.getType() == Material.LEATHER_CHESTPLATE) {
	    	event.setCancelled(true); 
	    	player.closeInventory();
	    	ItemStack mavichestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
	        LeatherArmorMeta mavichestplatem = (LeatherArmorMeta) mavichestplate.getItemMeta();
	        mavichestplatem.setColor(Color.AQUA);
	        mavichestplatem.setDisplayName("§c§lPeace Jacket");
	        ArrayList<String> mavichestplateLore = new ArrayList<String>();
	        mavichestplateLore.add("");
	        mavichestplatem.setLore(mavichestplateLore);
	        mavichestplate.setItemMeta(mavichestplatem);
	    	player.getEquipment().setChestplate(mavichestplate);
	    	player.sendMessage(this.prefix + "§aYou Equipment to §c§lPeace Jacket");
	    }
	    if(clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§c§lPeace Leggings") && clicked.getType() == Material.LEATHER_LEGGINGS) {
	    	event.setCancelled(true); 
	    	player.closeInventory();
	    	ItemStack mavipants = new ItemStack(Material.LEATHER_LEGGINGS);
	        LeatherArmorMeta mavipantsm = (LeatherArmorMeta) mavipants.getItemMeta();
	        mavipantsm.setColor(Color.AQUA);
	        mavipantsm.setDisplayName("§c§lPeace Leggings");
	        ArrayList<String> mavipantsLore = new ArrayList<String>();
	        mavipantsLore.add("");
	        mavipantsm.setLore(mavipantsLore);
	        mavipants.setItemMeta(mavipantsm);
	    	player.getEquipment().setLeggings(mavipants);
	    	player.sendMessage(this.prefix + "§aYou Equipment to §c§lPeace Leggings");
	    }
	    if(clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§c§lPeace Boots") && clicked.getType() == Material.LEATHER_BOOTS) {
	    	event.setCancelled(true); 
	    	player.closeInventory();
	    	ItemStack maviboots = new ItemStack(Material.LEATHER_BOOTS);
	        LeatherArmorMeta mavibootsm = (LeatherArmorMeta) maviboots.getItemMeta();
	        mavibootsm.setColor(Color.AQUA);
	        mavibootsm.setDisplayName("§c§lPeace Boots");
	        ArrayList<String> mavibootsLore = new ArrayList<String>();
	        mavibootsLore.add("");
	        mavibootsm.setLore(mavibootsLore);
	        maviboots.setItemMeta(mavibootsm);
	    	player.getEquipment().setBoots(maviboots);
	    	player.sendMessage(this.prefix + "§aYou Equipment to §c§lPeace Boots");
	    }
	    if(clicked.getType() == Material.STAINED_GLASS_PANE) {
	    	event.setCancelled(true);
	    }
	    }
	}
	
	@EventHandler
	public void adamYurudugunde(PlayerMoveEvent e) {
		Player player = e.getPlayer();
		if(effect.contains(player + "flame")) {
			World world = e.getPlayer().getWorld();
			world.playEffect(e.getPlayer().getLocation().add(0, 0.5, 0), Effect.FLAME, 1000);
		}
		else if(effect.contains(player + "heart")) {
			World world = e.getPlayer().getWorld();
			world.playEffect(e.getPlayer().getLocation().add(0, 0.5, 0), Effect.HEART, 1000);
		}
		else if(effect.contains(player + "reddust")) {
			World world = e.getPlayer().getWorld();
			world.playEffect(e.getPlayer().getLocation().add(0, 0.5, 0), Effect.COLOURED_DUST, 1000);
		}
		else if(effect.contains(player + "emeraldtwirl")) {
			World world = e.getPlayer().getWorld();
			world.playEffect(e.getPlayer().getLocation().add(0, 0.5, 0), Effect.HAPPY_VILLAGER, 1000);
		}
		else if(effect.contains(player + "smoke")) {
			World world = e.getPlayer().getWorld();
			world.playEffect(e.getPlayer().getLocation().add(0, 0.5, 0), Effect.SMOKE, 1000);
		}
		else if(effect.contains(player + "lava")) {
			World world = e.getPlayer().getWorld();
			world.playEffect(e.getPlayer().getLocation().add(0, 0.5, 0), Effect.LAVA_POP, 1000);
		}
		else if(effect.contains(player + "explode")) {
			World world = e.getPlayer().getWorld();
			world.playEffect(e.getPlayer().getLocation().add(0, 0.5, 0), Effect.EXPLOSION_LARGE, 1000);
		}
		else if(effect.contains(player + "firework")) {
			World world = e.getPlayer().getWorld();
			world.playEffect(e.getPlayer().getLocation().add(0, 0.5, 0), Effect.FIREWORKS_SPARK, 1000);
		}
		else if(effect.contains(player + "crit")) {
			World world = e.getPlayer().getWorld();
			world.playEffect(e.getPlayer().getLocation().add(0, 0.5, 0), Effect.CRIT, 1000);
		}
		else if(effect.contains(player + "cloud")) {
			World world = e.getPlayer().getWorld();
			world.playEffect(e.getPlayer().getLocation().add(0, 0.5, 0), Effect.CLOUD, 1000);
		}
		else if(effect.contains(player + "music")) {
			World world = e.getPlayer().getWorld();
			world.playEffect(e.getPlayer().getLocation().add(0, 0.5, 0), Effect.NOTE, 1000);
		}
	}
	
	public static Inventory costumeInventory = Bukkit.createInventory(null, 54, "§a§lCosmetics §8» §2§lCostumes");
	static
	{
		ItemStack cam1 = new ItemStack(Material.STAINED_GLASS_PANE);
	    ItemMeta cam1m = cam1.getItemMeta();
	    cam1m.setDisplayName("§4§lAura§e§lHUB");
	    ArrayList<String> cam1Lore = new ArrayList<String>();
	    cam1Lore.add("");
	    cam1m.setLore(cam1Lore);
	    cam1.setItemMeta(cam1m);
	    costumeInventory.setItem(0, cam1);
	    ItemStack cam2 = new ItemStack(Material.STAINED_GLASS_PANE);
	    ItemMeta cam2m = cam2.getItemMeta();
	    cam2m.setDisplayName("§4§lAura§e§lHUB");
	    ArrayList<String> cam2Lore = new ArrayList<String>();
	    cam2Lore.add("");
	    cam2m.setLore(cam2Lore);
	    cam2.setItemMeta(cam2m);
	    costumeInventory.setItem(1, cam2);
	    ItemStack cam3 = new ItemStack(Material.STAINED_GLASS_PANE);
	    ItemMeta cam3m = cam3.getItemMeta();
	    cam3m.setDisplayName("§4§lAura§e§lHUB");
	    ArrayList<String> cam3Lore = new ArrayList<String>();
	    cam3Lore.add("");
	    cam3m.setLore(cam3Lore);
	    cam3.setItemMeta(cam3m);
	    costumeInventory.setItem(2, cam3);
	    ItemStack cam4 = new ItemStack(Material.STAINED_GLASS_PANE);
	    ItemMeta cam4m = cam4.getItemMeta();
	    cam4m.setDisplayName("§4§lAura§e§lHUB");
	    ArrayList<String> cam4Lore = new ArrayList<String>();
	    cam4Lore.add("");
	    cam4m.setLore(cam4Lore);
	    cam4.setItemMeta(cam4m);
	    costumeInventory.setItem(3, cam4);
	    ItemStack cam5 = new ItemStack(Material.STAINED_GLASS_PANE);
	    ItemMeta cam5m = cam5.getItemMeta();
	    cam5m.setDisplayName("§4§lAura§e§lHUB");
	    ArrayList<String> cam5Lore = new ArrayList<String>();
	    cam5Lore.add("");
	    cam5m.setLore(cam5Lore);
	    cam5.setItemMeta(cam5m);
	    costumeInventory.setItem(4, cam5);
	    ItemStack cam6 = new ItemStack(Material.STAINED_GLASS_PANE);
	    ItemMeta cam6m = cam6.getItemMeta();
	    cam6m.setDisplayName("§4§lAura§e§lHUB");
	    ArrayList<String> cam6Lore = new ArrayList<String>();
	    cam6Lore.add("");
	    cam6m.setLore(cam6Lore);
	    cam6.setItemMeta(cam6m);
	    costumeInventory.setItem(5, cam6);
	    ItemStack cam7 = new ItemStack(Material.STAINED_GLASS_PANE);
	    ItemMeta cam7m = cam7.getItemMeta();
	    cam7m.setDisplayName("§4§lAura§e§lHUB");
	    ArrayList<String> cam7Lore = new ArrayList<String>();
	    cam7Lore.add("");
	    cam7m.setLore(cam7Lore);
	    cam7.setItemMeta(cam7m);
	    costumeInventory.setItem(6, cam7);	    
	    ItemStack cam8 = new ItemStack(Material.STAINED_GLASS_PANE);
	    ItemMeta cam8m = cam8.getItemMeta();
	    cam8m.setDisplayName("§4§lAura§e§lHUB");
	    ArrayList<String> cam8Lore = new ArrayList<String>();
	    cam8Lore.add("");
	    cam8m.setLore(cam8Lore);
	    cam8.setItemMeta(cam8m);
	    costumeInventory.setItem(7, cam8);
	    ItemStack cam9 = new ItemStack(Material.STAINED_GLASS_PANE);
	    ItemMeta cam9m = cam9.getItemMeta();
	    cam9m.setDisplayName("§4§lAura§e§lHUB");
	    ArrayList<String> cam9Lore = new ArrayList<String>();
	    cam9Lore.add("");
	    cam9m.setLore(cam9Lore);
	    cam9.setItemMeta(cam9m);
	    costumeInventory.setItem(8, cam9);
	    ItemStack cam10 = new ItemStack(Material.STAINED_GLASS_PANE);
	    ItemMeta cam10m = cam10.getItemMeta();
	    cam10m.setDisplayName("§4§lAura§e§lHUB");
	    ArrayList<String> cam10Lore = new ArrayList<String>();
	    cam10Lore.add("");
	    cam10m.setLore(cam10Lore);
	    cam10.setItemMeta(cam10m);
	    costumeInventory.setItem(45, cam10);
	    ItemStack cam11 = new ItemStack(Material.STAINED_GLASS_PANE);
	    ItemMeta cam11m = cam11.getItemMeta();
	    cam11m.setDisplayName("§4§lAura§e§lHUB");
	    ArrayList<String> cam11Lore = new ArrayList<String>();
	    cam11Lore.add("");
	    cam11m.setLore(cam11Lore);
	    cam11.setItemMeta(cam11m);
	    costumeInventory.setItem(46, cam11);
	    ItemStack cam12 = new ItemStack(Material.STAINED_GLASS_PANE);
	    ItemMeta cam12m = cam12.getItemMeta();
	    cam12m.setDisplayName("§4§lAura§e§lHUB");
	    ArrayList<String> cam12Lore = new ArrayList<String>();
	    cam12Lore.add("");
	    cam12m.setLore(cam12Lore);
	    cam12.setItemMeta(cam12m);
	    costumeInventory.setItem(47, cam12);
	    ItemStack cam13 = new ItemStack(Material.STAINED_GLASS_PANE);
	    ItemMeta cam13m = cam13.getItemMeta();
	    cam13m.setDisplayName("§4§lAura§e§lHUB");
	    ArrayList<String> cam13Lore = new ArrayList<String>();
	    cam13Lore.add("");
	    cam13m.setLore(cam13Lore);
	    cam13.setItemMeta(cam13m);
	    costumeInventory.setItem(48, cam13);
	    ItemStack cam14 = new ItemStack(Material.STAINED_GLASS_PANE);
	    ItemMeta cam14m = cam14.getItemMeta();
	    cam14m.setDisplayName("§4§lAura§e§lHUB");
	    ArrayList<String> cam14Lore = new ArrayList<String>();
	    cam14Lore.add("");
	    cam14m.setLore(cam14Lore);
	    cam14.setItemMeta(cam14m);
	    costumeInventory.setItem(49, cam14);
	    ItemStack cam15 = new ItemStack(Material.STAINED_GLASS_PANE);
	    ItemMeta cam15m = cam15.getItemMeta();
	    cam15m.setDisplayName("§4§lAura§e§lHUB");
	    ArrayList<String> cam15Lore = new ArrayList<String>();
	    cam15Lore.add("");
	    cam15m.setLore(cam15Lore);
	    cam15.setItemMeta(cam15m);
	    costumeInventory.setItem(50, cam15);
	    ItemStack cam16 = new ItemStack(Material.STAINED_GLASS_PANE);
	    ItemMeta cam16m = cam16.getItemMeta();
	    cam16m.setDisplayName("§4§lAura§e§lHUB");
	    ArrayList<String> cam16Lore = new ArrayList<String>();
	    cam16Lore.add("");
	    cam16m.setLore(cam16Lore);
	    cam16.setItemMeta(cam16m);
	    costumeInventory.setItem(51, cam16);
	    ItemStack cam17 = new ItemStack(Material.STAINED_GLASS_PANE);
	    ItemMeta cam17m = cam17.getItemMeta();
	    cam17m.setDisplayName("§4§lAura§e§lHUB");
	    ArrayList<String> cam17Lore = new ArrayList<String>();
	    cam17Lore.add("");
	    cam17m.setLore(cam17Lore);
	    cam17.setItemMeta(cam17m);
	    costumeInventory.setItem(52, cam17);	    
	    ItemStack lhelmet = new ItemStack(Material.LEATHER_HELMET);
	    ItemMeta lhelmetm= lhelmet.getItemMeta();
	    lhelmetm.setDisplayName("§c§lWalking Helmet");
	    ArrayList<String> lhelmetLore = new ArrayList<String>();
	    lhelmetLore.add("");
	    lhelmetLore.add("§7Designed specifically for combat");
	    lhelmetLore.add("§7in deep World for a sport ");
	    lhelmetLore.add("§7known as 'Walking'");
	    lhelmetLore.add("");
	    lhelmetLore.add("§fWalking Suit Set");
	    lhelmetLore.add("  §c» §7Walking Helmet");
	    lhelmetLore.add("  §c» §7Walking Jacket");
	    lhelmetLore.add("  §c» §7Walking Leggings");
	    lhelmetLore.add("  §c» §7Walking Boots");
	    lhelmetLore.add("");
	    
	    lhelmetm.setLore(lhelmetLore);
	    lhelmet.setItemMeta(lhelmetm);
	    costumeInventory.setItem(10,lhelmet);
	    ItemStack lchestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
	    ItemMeta lchestplatem= lchestplate.getItemMeta();
	    lchestplatem.setDisplayName("§c§lWalking Jacket");
	    ArrayList<String> lchestplateLore = new ArrayList<String>();
	    lchestplateLore.add("");
	    lchestplateLore.add("§7Designed specifically for combat");
	    lchestplateLore.add("§7in deep World for a sport ");
	    lchestplateLore.add("§7known as 'Walking'");
	    lchestplateLore.add("");
	    lchestplateLore.add("§fWalking Suit Set");
	    lchestplateLore.add("  §c» §7Walking Helmet");
	    lchestplateLore.add("  §c» §7Walking Jacket");
	    lchestplateLore.add("  §c» §7Walking Leggings");
	    lchestplateLore.add("  §c» §7Walking Boots");
	    lchestplateLore.add("");
	    lchestplatem.setLore(lchestplateLore);
	    lchestplate.setItemMeta(lchestplatem);
	    costumeInventory.setItem(19,lchestplate);
	    ItemStack lpants = new ItemStack(Material.LEATHER_LEGGINGS);
	    ItemMeta lpantsm= lpants.getItemMeta();
	    lpantsm.setDisplayName("§c§lWalking Leggins");
	    ArrayList<String> lpantsLore = new ArrayList<String>();
	    lpantsLore.add("");
	    lpantsLore.add("§7Designed specifically for combat");
	    lpantsLore.add("§7in deep World for a sport ");
	    lpantsLore.add("§7known as 'Walking'");
	    lpantsLore.add("");
	    lpantsLore.add("§fWalking Suit Set");
	    lpantsLore.add("  §c» §7Walking Helmet");
	    lpantsLore.add("  §c» §7Walking Jacket");
	    lpantsLore.add("  §c» §7Walking Leggings");
	    lpantsLore.add("  §c» §7Walking Boots");
	    lpantsLore.add("");
	    lpantsm.setLore(lpantsLore);
	    lpants.setItemMeta(lpantsm);
	    costumeInventory.setItem(28,lpants);
	    ItemStack lboots = new ItemStack(Material.LEATHER_BOOTS);
	    ItemMeta lbootsm= lboots.getItemMeta();
	    lbootsm.setDisplayName("§f§lLeather Pants");
	    ArrayList<String> lbootsLore = new ArrayList<String>();
	    lbootsLore.add("");
	    lbootsLore.add("§7Designed specifically for combat");
	    lbootsLore.add("§7in deep World for a sport ");
	    lbootsLore.add("§7known as 'Walking'");
	    lbootsLore.add("");
	    lbootsLore.add("§fWalking Suit Set");
	    lbootsLore.add("  §c» §7Walking Helmet");
	    lbootsLore.add("  §c» §7Walking Jacket");
	    lbootsLore.add("  §c» §7Walking Leggings");
	    lbootsLore.add("  §c» §7Walking Boots");
	    lbootsLore.add("");
	    lbootsm.setLore(lbootsLore);
	    lboots.setItemMeta(lbootsm);
	    costumeInventory.setItem(37,lboots);
	    ItemStack mavihelm = new ItemStack(Material.LEATHER_HELMET);
	    LeatherArmorMeta mavihelmm = (LeatherArmorMeta) mavihelm.getItemMeta();
	    mavihelmm.setColor(Color.AQUA);
	    mavihelmm.setDisplayName("§c§lPeace Helmet");
	    ArrayList<String> mavihelmLore = new ArrayList<String>();
	    mavihelmLore.add("");
	    mavihelmLore.add("§7Designed specifically for combat");
	    mavihelmLore.add("§7in deep World for a sport ");
	    mavihelmLore.add("§7known as 'Peace'");
	    mavihelmLore.add("");
	    mavihelmLore.add("§fPeace Suit Set");
	    mavihelmLore.add("  §c» §7Peace Helmet");
	    mavihelmLore.add("  §c» §7Peace Jacket");
	    mavihelmLore.add("  §c» §7Peace Leggings");
	    mavihelmLore.add("  §c» §7Peace Boots");
	    mavihelmLore.add("");
	    mavihelmm.setLore(mavihelmLore);
	    mavihelm.setItemMeta(mavihelmm);
	    costumeInventory.setItem(12, mavihelm);
	    ItemStack mavichestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
	    LeatherArmorMeta mavichestplatem = (LeatherArmorMeta) mavichestplate.getItemMeta();
	    mavichestplatem.setColor(Color.AQUA);
	    mavichestplatem.setDisplayName("§c§lPeace Jacket");
	    ArrayList<String> mavichestplateLore = new ArrayList<String>();
	    mavichestplateLore.add("");
	    mavichestplateLore.add("§7Designed specifically for combat");
	    mavichestplateLore.add("§7in deep World for a sport ");
	    mavichestplateLore.add("§7known as 'Peace'");
	    mavichestplateLore.add("");
	    mavichestplateLore.add("§fPeace Suit Set");
	    mavichestplateLore.add("  §c» §7Peace Helmet");
	    mavichestplateLore.add("  §c» §7Peace Jacket");
	    mavichestplateLore.add("  §c» §7Peace Leggings");
	    mavichestplateLore.add("  §c» §7Peace Boots");
	    mavichestplateLore.add("");
	    mavichestplatem.setLore(mavichestplateLore);
	    mavichestplate.setItemMeta(mavichestplatem);
	    costumeInventory.setItem(21, mavichestplate);
	    ItemStack mavipants = new ItemStack(Material.LEATHER_LEGGINGS);
	    LeatherArmorMeta mavipantsm = (LeatherArmorMeta) mavipants.getItemMeta();
	    mavipantsm.setColor(Color.AQUA);
	    mavipantsm.setDisplayName("§c§lPeace Leggings");
	    ArrayList<String> mavipantsLore = new ArrayList<String>();
	    mavipantsLore.add("");
	    mavipantsLore.add("§7Designed specifically for combat");
	    mavipantsLore.add("§7in deep World for a sport ");
	    mavipantsLore.add("§7known as 'Peace'");
	    mavipantsLore.add("");
	    mavipantsLore.add("§fPeace Suit Set");
	    mavipantsLore.add("  §c» §7Peace Helmet");
	    mavipantsLore.add("  §c» §7Peace Jacket");
	    mavipantsLore.add("  §c» §7Peace Leggings");
	    mavipantsLore.add("  §c» §7Peace Boots");
	    mavipantsLore.add("");
	    mavipantsm.setLore(mavipantsLore);
	    mavipants.setItemMeta(mavipantsm);
	    costumeInventory.setItem(30, mavipants);
	    ItemStack maviboots = new ItemStack(Material.LEATHER_BOOTS);
	    LeatherArmorMeta mavibootsm = (LeatherArmorMeta) maviboots.getItemMeta();
	    mavibootsm.setColor(Color.AQUA);
	    mavibootsm.setDisplayName("§c§lPeace Boots");
	    ArrayList<String> mavibootsLore = new ArrayList<String>();
	    mavibootsLore.add("");
	    mavibootsLore.add("§7Designed specifically for combat");
	    mavibootsLore.add("§7in deep World for a sport ");
	    mavibootsLore.add("§7known as 'Peace'");
	    mavibootsLore.add("");
	    mavibootsLore.add("§fPeace Suit Set");
	    mavibootsLore.add("  §c» §7Peace Helmet");
	    mavibootsLore.add("  §c» §7Peace Jacket");
	    mavibootsLore.add("  §c» §7Peace Leggings");
	    mavibootsLore.add("  §c» §7Peace Boots");
	    mavibootsLore.add("");
	    mavibootsm.setLore(mavibootsLore);
	    maviboots.setItemMeta(mavibootsm);
	    costumeInventory.setItem(39, maviboots);
	    ItemStack clear = new ItemStack(Material.REDSTONE_BLOCK);
	    ItemMeta clearm= clear.getItemMeta();
	    clearm.setDisplayName("§c§lClear Armor");
	    ArrayList<String> clearLore = new ArrayList<String>();
	    clearLore.add("");
	    clearm.setLore(clearLore);
	    clear.setItemMeta(clearm);
	    costumeInventory.setItem(53,clear);
	}
	
	public static Inventory effectInventory = Bukkit.createInventory(null, 54, "§a§lCosmetics §8» §6§lEffects");
	static
	{
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
	
	public static Inventory myInventory = Bukkit.createInventory(null, 45, "§a§lCosmetics");
	static {
		ItemStack star = new ItemStack(Material.NETHER_STAR);
	    ItemMeta starm = star.getItemMeta();
	    starm.setDisplayName("§a§lParticle Effect");
	    ArrayList<String> starLore = new ArrayList<String>();
	    starLore.add("");
	    starm.setLore(starLore);
	    star.setItemMeta(starm);
	    myInventory.setItem(10, star);
	    ItemStack boots = new ItemStack(Material.GOLD_BOOTS);
	    ItemMeta bootsm = boots.getItemMeta();
	    bootsm.setDisplayName("§a§lDouble Jump Effect");
	    ArrayList<String> bootsLore = new ArrayList<String>();
	    bootsLore.add("");
	    bootsm.setLore(bootsLore);
	    boots.setItemMeta(bootsm);
	    myInventory.setItem(32, boots);
	    ItemStack melon = new ItemStack(Material.MELON_BLOCK);
	    ItemMeta melonm = melon.getItemMeta();
	    melonm.setDisplayName("§a§lGadgets");
	    ArrayList<String> melonLore = new ArrayList<String>();
	    melonLore.add("");
	    melonm.setLore(melonLore);
	    melon.setItemMeta(melonm);
	    myInventory.setItem(13, melon);
	    ItemStack hats = new ItemStack(Material.GOLD_HELMET);
	    ItemMeta hatsm = hats.getItemMeta();
	    hatsm.setDisplayName("§a§lHats");
	    ArrayList<String> hatsLore = new ArrayList<String>();
	    hatsLore.add("");
	    hatsm.setLore(hatsLore);
	    hats.setItemMeta(hatsm);
	    myInventory.setItem(16, hats);
	    ItemStack costume = new ItemStack(Material.DIAMOND_CHESTPLATE);
	    ItemMeta costumem = costume.getItemMeta();
	    costumem.setDisplayName("§a§lCostumes");
	    ArrayList<String> costumeLore = new ArrayList<String>();
	    costumeLore.add("");
	    costumem.setLore(costumeLore);
	    costume.setItemMeta(costumem);
	    myInventory.setItem(30, costume);
	}
	

	@EventHandler
	public void breakevent(BlockBreakEvent event) {
		if(!event.getPlayer().hasPermission("xeme.admin")) {
			event.setCancelled(true);
		}
		else {
			event.setCancelled(false);
		}
	}
	@EventHandler
	public void placefire(BlockPlaceEvent event) {
		if(!event.getPlayer().hasPermission("xeme.admin")) {
			/*/if(event.getBlock().getType() == Material.STONE) {
				Bukkit.getServer().dispatchCommand(getServer().getConsoleSender(), "setblock " + event.getBlock().getLocation() + " mob_spawner 0 replace {EntityId:Item,SpawnData:{Item:{id:minecraft:diamond,Count:1b}},SpawnCount:1,SpawnRange:1,RequiredPlayerRange:140,Delay:20}");
			}/*/
			if(event.getBlock().getType() != Material.FIRE) {
				if(!event.getPlayer().getWorld().getName().equalsIgnoreCase("ffa")) {
					event.setCancelled(true);
				}else {
					event.setCancelled(false);
					Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
				        public void run() {
				           event.getBlock().setType(Material.AIR);
				           
				        }
				    },100);
				}
			}
		}
		else {
			event.setCancelled(false);
			if(event.getBlock().getType() == Material.FIRE) {
				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
			        public void run() {
			           event.getBlock().setType(Material.AIR);
			           
			        }
			    },100);
			}
		}
		
	}
	
	
	@EventHandler
	public void tabChat(PlayerChatTabCompleteEvent e){
	    e.getTabCompletions().clear();
		e.getTabCompletions().add("/help");
		e.getTabCompletions().add("/apply");
		e.getTabCompletions().add("/report");
		e.getTabCompletions().add("/ping");
		
		
	}
	
	@EventHandler
	  public void onSetDisplayName(PlayerJoinEvent e) throws SQLException
	  {
	    Player oyuncu = e.getPlayer();
	    Player p = e.getPlayer();
	    File data = new File(Bukkit.getPluginManager().getPlugin("Xeme_V3NSYJ").getDataFolder(), File.separator + "userdata");
	    File f = new File(data, File.separator + p.getName() + ".yml");
	    FileConfiguration playerData = YamlConfiguration.loadConfiguration(f);
	    StatsAPI.setRankDefault(p);
	    
	    if(!p.hasPlayedBefore()) {
	    	if(!f.exists()) {
	    		playerData.set("Rank", "Regular");
	    		playerData.set("RankColor", "&2");
	    		playerData.set("ChatColor",	"&f");
	    		playerData.set("Stats.Kills", Integer.valueOf(0));
	    		playerData.set("Stats.Deaths", Integer.valueOf(0));
	    		
	    		try {
	    			playerData.save(f);
	    			
	    		}catch(IOException ex) {
	    			ex.printStackTrace();
	    		}
	    	}
	    	PacketPlayOutTitle title = new PacketPlayOutTitle(EnumTitleAction.TITLE, ChatSerializer.a("{\"text\":\"§2Welcome To §6SquiireLion NetWork\"}"), 20, 40, 20);
	        PacketPlayOutTitle subtitle = new PacketPlayOutTitle(EnumTitleAction.SUBTITLE, ChatSerializer.a("{\"text\":\"§3§lNews §7§l» §a§lAll Bans Pardoned\"}"), 20, 40, 20);
	        ((CraftPlayer) e.getPlayer()).getHandle().playerConnection.sendPacket(title);
	        ((CraftPlayer) e.getPlayer()).getHandle().playerConnection.sendPacket(subtitle);
	        
	        
	        
		    PacketPlayOutPlayerListHeaderFooter headerfooter = new PacketPlayOutPlayerListHeaderFooter();
	        try {
	            java.lang.reflect.Field header = headerfooter.getClass().getDeclaredField("a");
	            java.lang.reflect.Field footer = headerfooter.getClass().getDeclaredField("b");
	            header.setAccessible(true);
	            footer.setAccessible(true);
	            header.set(headerfooter, ChatSerializer.a("\"\n§4§m-----------------------§r \n  §6§lXeme \""));
	            footer.set(headerfooter, ChatSerializer.a("\"\n §9§lArenaPvP §fand §9§lUHC §ais online! \n \n§a§lWelcome to Server ! \n§r §4§m-----------------------§r\""));
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	        ((CraftPlayer) p).getHandle().playerConnection.sendPacket(headerfooter);
	        
		    oyuncu.getInventory().setHeldItemSlot(0);
		    oyuncu.teleport(oyuncu.getWorld().getSpawnLocation());
		    RankAPI.playerSetDisplayName(p);
		    e.setJoinMessage("");
		    p.getInventory().clear();
		    p.getInventory().setHelmet(new ItemStack(Material.AIR));
		    p.getInventory().setChestplate(new ItemStack(Material.AIR));
		    p.getInventory().setLeggings(new ItemStack(Material.AIR));
		    p.getInventory().setBoots(new ItemStack(Material.AIR));
		    ItemStack shop = new ItemStack(Material.GOLD_INGOT);
			ItemMeta shopm = shop.getItemMeta();
			shopm.setDisplayName("§e§lXeme Shop §7- Right click to open the shop!");
			ArrayList<String> shopLore = new ArrayList<String>();
			shopLore.add("");
			shopm.setLore(shopLore);
			shop.setItemMeta(shopm);
			p.getInventory().setItem(7, shop);
			SBAPI.scoreBoardManager(p);
			for(Player players : Bukkit.getServer().getOnlinePlayers()) {
				SBAPI.scoreBoardManager(players);
			}
			p.performCommand("hub");
	    }else {
	    	if(!f.exists()) {
	    		playerData.set("Rank", "Regular");
	    		playerData.set("RankColor", "&2");
	    		playerData.set("ChatColor",	"&f");
	    		playerData.set("Stats.Kills", Integer.valueOf(0));
	    		playerData.set("Stats.Deaths", Integer.valueOf(0));
	    		
	    		try {
	    			playerData.save(f);
	    			
	    		}catch(IOException ex) {
	    			ex.printStackTrace();
	    		}
	    	}
		    PacketPlayOutTitle title = new PacketPlayOutTitle(EnumTitleAction.TITLE, ChatSerializer.a("{\"text\":\"§2Welcome To §6SquiireLion NetWork\"}"), 20, 40, 20);
	        PacketPlayOutTitle subtitle = new PacketPlayOutTitle(EnumTitleAction.SUBTITLE, ChatSerializer.a("{\"text\":\"§3§lNews §7§l» §a§lAll Bans Pardoned\"}"), 20, 40, 20);
	        ((CraftPlayer) e.getPlayer()).getHandle().playerConnection.sendPacket(title);
	        ((CraftPlayer) e.getPlayer()).getHandle().playerConnection.sendPacket(subtitle);
	        
	        
		    PacketPlayOutPlayerListHeaderFooter headerfooter = new PacketPlayOutPlayerListHeaderFooter();
	        try {
	            java.lang.reflect.Field header = headerfooter.getClass().getDeclaredField("a");
	            java.lang.reflect.Field footer = headerfooter.getClass().getDeclaredField("b");
	            header.setAccessible(true);
	            footer.setAccessible(true);
	            header.set(headerfooter, ChatSerializer.a("\"\n§4§m-----------------------§r \n  §6§lXeme \""));
	            footer.set(headerfooter, ChatSerializer.a("\"\n §9§lArenaPvP §fand §9§lUHC §ais online! \n \n§a§lWelcome to Server ! \n§r §4§m-----------------------§r\""));
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	        ((CraftPlayer) p).getHandle().playerConnection.sendPacket(headerfooter);
	        
		    oyuncu.getInventory().setHeldItemSlot(0);
		    oyuncu.teleport(oyuncu.getWorld().getSpawnLocation());
		    RankAPI.playerSetDisplayName(p);
		    e.setJoinMessage("");
		    p.getInventory().clear();
		    p.getInventory().setHelmet(new ItemStack(Material.AIR));
		    p.getInventory().setChestplate(new ItemStack(Material.AIR));
		    p.getInventory().setLeggings(new ItemStack(Material.AIR));
		    p.getInventory().setBoots(new ItemStack(Material.AIR));
		    ItemStack shop = new ItemStack(Material.GOLD_INGOT);
			ItemMeta shopm = shop.getItemMeta();
			shopm.setDisplayName("§e§lXeme Shop §7- Right click to open the shop!");
			ArrayList<String> shopLore = new ArrayList<String>();
			shopLore.add("");
			shopm.setLore(shopLore);
			shop.setItemMeta(shopm);
			p.getInventory().setItem(7, shop);
			SBAPI.scoreBoardManager(p);
			for(Player players : Bukkit.getServer().getOnlinePlayers()) {
				SBAPI.scoreBoardManager(players);
			}
			p.performCommand("hub");
	    }
	  }
	
	
	  

	
	
	@EventHandler
	  public void onItemDrop(PlayerDropItemEvent e)
	  {
	  	if (!e.getPlayer().hasPermission("Xeme.admin"))
	  	{
	    	e.setCancelled(true);
	   	}
	  }
	
	@EventHandler
	public void addStats(PlayerDeathEvent event) throws SQLException {
		Player attacker = event.getEntity().getKiller();
		Player victim = event.getEntity();
		StatsAPI.addDeaths(victim);
		StatsAPI.addKills(attacker);
		
		event.setDeathMessage("");
		victim.sendMessage(prefix + " &cYou have killed by &a&l".replace("&", "§") + attacker.getName());
		attacker.sendMessage(prefix + " &aYou have been killed to &c&l".replace("&", "§") + victim.getName());
		victim.teleport((Location) getConfig().get("hub"));
		victim.spigot().respawn();
		
		
	
		
	}
	
	
	@EventHandler
	  public void onClick(PlayerInteractEvent e)
	  {
	    if (this.cps.get(e.getPlayer()) != null)
	    {
	      if (((Integer)this.cps.get(e.getPlayer())).intValue() >= getConfig().getInt("Click") - 1)
	      {
	        e.getPlayer().kickPlayer(this.tag + "\n " + getConfig().getString("Kick_Message").replace("%player%", e.getPlayer().getDisplayName()).replace("&", "§").replace("%nl%", "\n").replace("%cps%", String.valueOf(getConfig().getInt("Click"))));
	        Bukkit.broadcastMessage(this.tag + "\n " + getConfig().getString("Broadcast_Message").replace("&", "§").replace("%player%", e.getPlayer().getDisplayName()).replace("&", "§").replace("%nl%", "\n").replace("%cps%", String.valueOf(getConfig().getInt("Click"))));
	      }
	      else
	      {
	        this.cps.put(e.getPlayer(), Integer.valueOf(((Integer)this.cps.get(e.getPlayer())).intValue() + 1));
	      }
	    }
	    else {
	      this.cps.put(e.getPlayer(), Integer.valueOf(1));
	    }
	  }
	
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent e){
	    for (World world : this.getServer().getWorlds()){
	        if (world.getTime() >= 12000){
	            world.setTime(0);
	            
	            if(e.getPlayer().getWorld().getName().equalsIgnoreCase("AuraHUB")) {
	            	e.getPlayer().setFoodLevel(20);
	            	
	            }
	        }
	    }
	}
	
	@EventHandler
	public void weatherChance(WeatherChangeEvent event) {
		event.setCancelled(true);
	}
	
	
	
	
	// ----------------------------------- XKMBG ------------------------------------ \\
	
	
	@EventHandler
	public void onChat(AsyncPlayerChatEvent event){
		Player player = event.getPlayer();
		File data = new File(Bukkit.getPluginManager().getPlugin("Xeme_V3NSYJ").getDataFolder(), File.separator + "userdata");
		  File f = new File(data, File.separator + player.getName() + ".yml");
		  FileConfiguration playerData = YamlConfiguration.loadConfiguration(f);
		event.setCancelled(true);
		for(Player players : Bukkit.getServer().getOnlinePlayers()){
			if(players.hasPermission("xeme.moderator")){
				if(player.hasPermission("xeme.panel")){
					if(getConfig().getBoolean("GlobalMute") == true) {
						new FancyMessage("§8[§b§lGMUTE§8]").then("§2 " + player.getDisplayName() + "§8:§r " + playerData.getString("ChatColor").replace("&", "§") + event.getMessage().replace("&", "§")).send(players);
						
					}else if(getConfig().getBoolean("GlobalMute") == false) {
						
							new FancyMessage("[")
							.color(ChatColor.DARK_GRAY)
							.then("S")					
							.style(ChatColor.BOLD)
							.color(ChatColor.GOLD)
							.then("T")
							.style(ChatColor.BOLD)
							.color(ChatColor.GOLD)
							.then("A")
							.style(ChatColor.BOLD)
							.color(ChatColor.GOLD)
							.then("F")
							.style(ChatColor.BOLD)
							.color(ChatColor.GOLD)
							.then("F")
							.style(ChatColor.BOLD)
							.color(ChatColor.GOLD)
						    .then("]")
						    .color(ChatColor.DARK_GRAY)
						    .then("§2 " + player.getDisplayName() + "§8:§r " + playerData.getString("ChatColor").replace("&", "§") + event.getMessage())
						    .send(players);
						
					}
					
				}else{
					 if(getConfig().getBoolean("GlobalMute") == true) {
						 player.sendMessage(prefix + "§c§l Global Mute is Enabled");
					 }
					 else if(getConfig().getBoolean("GlobalMute") == false){
						}
							
								new FancyMessage("[")
								.color(ChatColor.DARK_GRAY)
								.then("X")
								.style(ChatColor.BOLD)
								.color(ChatColor.GOLD)
								.command("/lookup " + player.getName())
								.tooltip("§6" + player.getName() + "§6's history")
								.then("K")
								.style(ChatColor.BOLD)
								.color(ChatColor.DARK_AQUA)
								.suggest("/kick " + player.getName())
								.tooltip("§3Kick the " + player.getName())
								.then("M")
								.style(ChatColor.BOLD)
								.color(ChatColor.DARK_GREEN)
								.suggest("/mute " + player.getName())
								.tooltip("§2Mute the " + player.getName())
								.then("B")
								.style(ChatColor.BOLD)
								.color(ChatColor.DARK_RED)
								.suggest("/ban " + player.getName())
								.tooltip("§4Ban the " + player.getName())
								.then("G")
								.style(ChatColor.BOLD)
						        .color(ChatColor.DARK_PURPLE)
						        .command("/goto " + player.getName())
						        .tooltip("§5Goto " + player.getName())
						        .then("]")
						        .color(ChatColor.DARK_GRAY)
						        .then("§2 " + player.getDisplayName() + "§8:§r " + playerData.getString("ChatColor").replace("&", "§") + event.getMessage().replace("&", "§"))
						        .send(players);
								chatspam.add(player.getName());
								Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
							        public void run() {
							           chatspam.remove(player.getName());
							        }
							    },60);
						 }

				}else{
					if(getConfig().getBoolean("GlobalMute") == true) {
						player.sendMessage(prefix + "§c§l Global Mute is Enabled");
					}
					
					else if(getConfig().getBoolean("GlobalMute") == false) {
							players.sendMessage(player.getDisplayName() + "§8:§r " + playerData.getString("ChatColor").replace("&", "§") + event.getMessage().replace("&", "§"));
								
				
					}
				
						
					
				}
				
				
		}
		
	}
	
	public static void log(String message)
	  {
	    Bukkit.getConsoleSender().sendMessage(Main.m.getName() + message);
	  }
	
	
	

	
}