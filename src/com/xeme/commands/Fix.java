package com.xeme.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Fix
  implements CommandExecutor
{
  public boolean onCommand(CommandSender ss, Command cmd, String label, String[] args)
  {
    Player player = (Player)ss;
    if (cmd.getName().equalsIgnoreCase("fix")) {
      if (args.length == 0)
      {
        if ((ss instanceof Player)) {
          fixPlayer((Player)ss);
        } else {
          fixPlayer((Player)ss);
        }
      }
      else if ((ss instanceof Player)) {
        fixPlayer((Player)ss);
      } else {
        player.sendMessage("§8[§3Xeme§8]§4 /fix");
      }
    }
    return false;
  }
  
  public void fixPlayer(Player player)
  {
    player.sendMessage("§8[§3Xeme§8]§f The server has attemped to de-ghost you.");
    player.teleport(player.getLocation().add(0.0D, 1.5D, 0.0D));
    refreshPlayer(player);
  }
  
  public void refreshPlayer(Player player)
  {
    for (Player players : Bukkit.getServer().getOnlinePlayers())
    {
      players.hidePlayer(player);
      players.showPlayer(player);
    }
  }
}
