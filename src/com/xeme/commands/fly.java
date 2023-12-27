package com.xeme.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class fly
  implements CommandExecutor
{
  public boolean onCommand(CommandSender ss, Command cmd, String label, String[] args)
  {
    Player player = (Player)ss;
    if (cmd.getName().equalsIgnoreCase("fly")) {
      if (player.hasPermission("Xeme.platinum"))
      {
        if (args.length == 0) {
          if (player.getAllowFlight())
          {
            player.sendMessage("§8[§3Xeme§8]§f You can't fly now");
            player.setAllowFlight(false);
          }
          else if (!player.getAllowFlight())
          {
            player.sendMessage("§8[§3Xeme§8]§f You can fly now");
            player.setAllowFlight(true);
          }
        }
        if (args.length == 1) {
          if (args[0].equalsIgnoreCase("on"))
          {
            if (player.getAllowFlight())
            {
              player.sendMessage("§8[§3Xeme§8]§f You can already fly");
            }
            else if (!player.getAllowFlight())
            {
              player.sendMessage("§8[§3Xeme§8]§f You can fly now");
              player.setAllowFlight(true);
            }
          }
          else if (args[0].equalsIgnoreCase("off"))
          {
            if (player.getAllowFlight())
            {
              player.sendMessage("§8[§3Xeme§8]§f You can't fly now");
              player.setAllowFlight(false);
            }
            else if (!player.getAllowFlight())
            {
              player.sendMessage("§8[§3Xeme§8]§f You can't already fly");
            }
          }
          else {
            player.sendMessage("§8[§3Xeme§8] §cCorrect Usage§8: §7/fly §c<on/off>");
          }
        }
      }
      else
      {
        player.sendMessage("§8[§3Xeme§8]§4 You don't have this permission!");
      }
    }
    return false;
  }
}
