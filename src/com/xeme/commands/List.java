package com.xeme.commands;

import java.util.ArrayList;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;

public class List
  implements CommandExecutor
{
  ArrayList<Player> yetkililer = new ArrayList<Player>();
  
  @EventHandler
  public void giris(PlayerJoinEvent e)
  {
    Player p = e.getPlayer();
    this.yetkililer.add(p);
  }
  
  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
  {
    Player player = (Player)sender;
    if (cmd.getName().equalsIgnoreCase("list"))
    {
      String s = "";
      for (Player p : Bukkit.getOnlinePlayers()) {
        s = s + p.getDisplayName() + "§8, ";
      }
      s = s.substring(0, s.length() - 2);
      s = s + "§8.";
      player.sendMessage("§8[§3Xeme§8]§r There are§8 [§6" + Bukkit.getServer().getOnlinePlayers().size() + "§8/§632§8] §fplayers online§8.");
      player.sendMessage(s);
    }
    return true;
  }
}
