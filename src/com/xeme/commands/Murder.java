package com.xeme.commands;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Murder
  implements CommandExecutor
{
  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
  {
    Player player = (Player)sender;
    if (cmd.getName().equalsIgnoreCase("kill"))
    {
      if (args.length == 0)
      {
        player.setGameMode(GameMode.SURVIVAL);
        player.sendMessage("§8[§3Xeme§8] §7You have commited suicide§8.");
        player.damage(100.0D);
      }
      if (args.length == 1) {
        if (player.hasPermission("Xeme.moderator"))
        {
          Player killer = Bukkit.getPlayer(args[0]);
          if (killer == null)
          {
            player.sendMessage("§8[§3Xeme§8]§b " + args[0] + "§c is not online§8!");
          }
          else if (killer == player)
          {
            player.setGameMode(GameMode.SURVIVAL);
            player.sendMessage("§8[§3Xeme§8]§7 You have commited suicide§8.");
            player.damage(100.0D);
            
          }
          else
          {
            killer.setGameMode(GameMode.SURVIVAL);
            killer.damage(100.0D);
            player.sendMessage("§8[§3Xeme§8]§b " + args[0] + "§7 have commited suicide§8.");
          }
        }
        else
        {
          player.sendMessage("§8[§3Xeme§8] &cYou don't have this permission!");
        }
      }
    }
    return false;
  }
}
