package com.xeme.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;

public class Punishment implements CommandExecutor{

	String prefix = "§8[§bXeme§8]§r";
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("punishment")) {
			if(p.hasPermission("Xeme.owner") || p.hasPermission("Xeme.admin") || p.hasPermission("Xeme.srmod") || p.hasPermission("Xeme.mod")) {
				if(args.length == 0) {
					p.sendMessage(prefix + " §cUsage: /punishment <player>");
				}else if(args.length == 1) {
					Player target = Bukkit.getPlayer(args[0]);
					if(target != null) {
						TextComponent parantezac  = new TextComponent("          §8[");
						TextComponent x = new TextComponent("     §9§lX");
						x.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/history " + p.getName()));
						x.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§9/history " + p.getName()).create()));
						TextComponent k = new TextComponent("     §6§lK");
						k.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/kick " + p.getName() + " <reason>"));
						k.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§6/kick " + p.getName() + " §6<reason>").create()));
						TextComponent b = new TextComponent("     §4§lB");
						b.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/ban " + p.getName() + " <time:w/d/h/m/s or permanent> <reason>"));
						b.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§4/ban " + p.getName() + " §4<time:w/d/h/m/s or permanent> <reason>").create()));
						TextComponent m  = new TextComponent("     §2§lM");
						m.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/mute " + p.getName() + " <time:w/d/h/m/s or permanent> <reason>"));
						m.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§2/mute " + p.getName() + " §2<time:w/d/h/m/s or permanent> <reason>").create()));
						TextComponent parantezkapat  = new TextComponent("     §8]");
						p.sendMessage("§6=§b=§6=§b=§6=§b=§6=§b=§6=§b=§6=§b=§6=§b=§6=§b=§6=§b=§6=§b=§6=§b=§6=§b=§6=§b=§6=§b=§6=§b=§6=§b=§6=§b=§6=§b=§6=§b=§6=§b=§6=§b=§6=§b=§6=§b=§6=§b=");
						p.sendMessage("");
						p.sendMessage("");
						p.sendMessage("           §3Punishment to §e§l" + target.getName());
						p.sendMessage("");
						p.spigot().sendMessage(parantezac, x, k, b, m, parantezkapat);
						p.sendMessage("");
						p.sendMessage("");
						p.sendMessage("§6=§b=§6=§b=§6=§b=§6=§b=§6=§b=§6=§b=§6=§b=§6=§b=§6=§b=§6=§b=§6=§b=§6=§b=§6=§b=§6=§b=§6=§b=§6=§b=§6=§b=§6=§b=§6=§b=§6=§b=§6=§b=§6=§b=§6=§b=§6=§b=");
					}
				}
			}
		}
		return false;
	}

}
