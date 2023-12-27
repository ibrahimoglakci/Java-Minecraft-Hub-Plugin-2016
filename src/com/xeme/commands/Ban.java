package com.xeme.commands;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import com.xeme.banmanager.type.PUNISHMENT_TYPE;

public class Ban implements CommandExecutor{

	
	public static int PERMANENT_TIME = -4;
	
	String prefix = "§8[§bXeme§8]§r";
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("ban")) {
			if(p.hasPermission("Xeme.owner") || p.hasPermission("Xeme.admin") || p.hasPermission("Xeme.srmod") || p.hasPermission("Xeme.mod")) {
				if(args.length == 0) {
					p.sendMessage(prefix + " §cUsage: /ban <player> <time#:/permanent> <reason>");
				}else if(args.length == 1) {
					Player target = Bukkit.getPlayer(args[0]);
					if(target != null) {
						File data = new File(Bukkit.getPluginManager().getPlugin("Xeme_V3NSYJ").getDataFolder(), File.separator + "userdata");
						File f = new File(data, File.separator + target.getName() + ".yml");
						FileConfiguration playerData = YamlConfiguration.loadConfiguration(f);
						if(playerData.getBoolean("Banned") == false) {
							Bukkit.broadcastMessage(prefix + "§r " + p.getDisplayName() + " &6was banned by§r ".replace("&", "§") +  target.getDisplayName() + "&6for &4permanent &6with reason&b Banned by operator".replace("&", "§"));
							playerData.set("Banned", true);
						/*/	try {
								playerData.save(f);
							}catch (IOException ex) {
								ex.printStackTrace();
							}
							Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.m, new Runnable() {
						        public void run() {
						        	playerData.set("Banned", false);
						        	try {
										playerData.save(f);
									}catch (IOException ex) {
										ex.printStackTrace();
									}
						        }
						    },100);/*/
						
							
						}else {
							p.sendMessage(prefix + " §cPlayer is already banned from server !");
						}
					}
				}else if(args.length < 2){
					Player target = Bukkit.getPlayer(args[0]);
					String reason = "";
				     for (int i = 1; i < args.length; i++) {
				    	 reason = reason + args[i] + " ";
				    	 reason.replace("&", "§");
				     }
				     if(target != null) {
						File data = new File(Bukkit.getPluginManager().getPlugin("Xeme_V3NSYJ").getDataFolder(), File.separator + "userdata");
						File f = new File(data, File.separator + p.getName() + ".yml");
						FileConfiguration playerData = YamlConfiguration.loadConfiguration(f);
						
						if(playerData.getBoolean("Banned") == false) {
							
							p.sendMessage(reason.replace("&", "§"));
							Bukkit.broadcastMessage(prefix + "§r " + p.getDisplayName() + " &6was banned by§r ".replace("&", "§") +  target.getDisplayName() + "&6for &4permanent &6with reason&b Banned by operator".replace("&", "§"));
							playerData.set("Banned", true);
							playerData.set("Banned_Message", reason);
							try {
								playerData.save(f);
							}catch (IOException ex) {
								ex.printStackTrace();
							}
							
						}else {
							p.sendMessage(prefix + " §cPlayer is already banned from server !");
						}
				     }
				}/*/else {
					String reason = "";
				     for (int i = 3; i < args.length; i++) {
				    	 reason = reason + args[i] + " ";
				    	
				     }
					if(args[2].equalsIgnoreCase("s") || args[2].equalsIgnoreCase("seconds")) {
						Player target = Bukkit.getPlayer(args[0]);
						
						int durations = Integer.valueOf(args[1]) * 20;
						Long duration = (System.currentTimeMillis() /1000000) - durations;
								 
						if(duration >= 432000) {
								p.sendMessage("saaaa §e" + duration);
						}else {
							p.sendMessage("Yarragýmý ye §a" + duration);
						}
						File data = new File(Bukkit.getPluginManager().getPlugin("Xeme_V3NSYJ").getDataFolder(), File.separator + "userdata");
						File f = new File(data, File.separator + target.getName() + ".yml");
						FileConfiguration targetData = YamlConfiguration.loadConfiguration(f);
						if(targetData.getBoolean("Banned") == false) {
							p.sendMessage("Yarrrrrrak " + System.currentTimeMillis() / 1000);
							Bukkit.broadcastMessage(prefix + "§r " + p.getDisplayName() + " &6was banned by§r ".replace("&", "§") +  target.getDisplayName() + "&6for &4permanent &6with reason&b Banned by operator".replace("&", "§"));
							targetData.set("Banned", true);
							try {
								targetData.save(f);
							}catch (IOException ex) {
								ex.printStackTrace();
							}
							Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.m, new Runnable() {
						        public void run() {
						        	targetData.set("Banned", false);
						        	try {
						        		targetData.save(f);
									}catch (IOException ex) {
										ex.printStackTrace();
									}
						        }
						    },duration);
						}
						
					}
				}/*/
			}
		}
		return false;
	}

	
	
	
	public String nicePunishmentTime(long time) {
		if (time == PERMANENT_TIME) {
			return "forever";
		}

		// Cut off millis
		time /= 1000;

		if (time < 3600) {
			return time / 60 + " Minute(s)";
		} else if (time < 84600) {
			return time / 3600  + " Hour(s)";
		} else if (time < 86400 * 7) {
			return time / 86400 + " Day(s)";
		} else if (time < 86400 * 31) {
			return time / (86400 * 7) + " Week(s)";
		} else {
			return time / (86400 * 30) + " Month(s)";
		}
	}

	public long getTimeToPunish(String[] args, CommandSender sender, PUNISHMENT_TYPE type) {
		if (type == PUNISHMENT_TYPE.MUTE && args.length < 2) {
			return -1;
		} else if (type == PUNISHMENT_TYPE.BAN && args.length < 2) {
			return PERMANENT_TIME;
		}

		if (args[1].equalsIgnoreCase("perma") && sender.hasPermission("badlion.globalmod")) {
			return PERMANENT_TIME;
		}

		if (args[1].substring(0, 1).matches("[0-9]")) {
			try {
				char timeLength = args[1].charAt(args[1].length() - 1);
				long time = Long.parseLong(args[1].substring(0, args[1].length() - 1));
				if (time < 1) {
					return -10;
				}

				if (timeLength == 's' || timeLength == 'S') {
					time = time * 1000;
				} else if (timeLength == 'm' || timeLength == 'M') {
					time = time * 1000 * 60;
				} else if (timeLength == 'h' || timeLength == 'H') {
					time = time * 1000 * 60 * 60;
				} else if (timeLength == 'd' || timeLength == 'D') {
					time = time * 1000 * 60 * 60 * 24;
				} else if (timeLength == 'w' || timeLength == 'W') {
					time = time * 1000 * 60 * 60 * 24 * 7;
				} else if (timeLength == 'n' || timeLength == 'N') {
					time = time * 1000 * 60 * 60 * 24 * 30;
				} else if (timeLength == 'y' || timeLength == 'Y') {
					time = time * 1000 * 60 * 60 * 24 * 365;
				} else {
					sender.sendMessage(ChatColor.RED + "Valid date format required (#s/m/h/d/w/n)");
					return -30;
				}

				if (sender != null && !sender.hasPermission("bm.admin") && time > (long) 1000 * 60 * 60 * 24 * 365) {
					sender.sendMessage(ChatColor.RED + "You are not allowed to ban/mute for more than 1 year");
					return -20;
				}

				return time;
			} catch (Exception e) {
				sender.sendMessage(ChatColor.RED + "Invalid date format: " + args[1]);
				return -30;
			}
		}
		if (type == PUNISHMENT_TYPE.BAN) {
			return PERMANENT_TIME;
		}

		sender.sendMessage(ChatColor.RED + "Invalid date format: " + args[1]);
		return -30;
	}
}
