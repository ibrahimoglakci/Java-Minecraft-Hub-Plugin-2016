package com.xeme.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class ping
  implements CommandExecutor
{
  public boolean onCommand(CommandSender ss, Command cmd, String label, String[] args)
  {
    Player player = (Player) ss;
    if (cmd.getName().equalsIgnoreCase("ping"))
    {
      int ping = ((CraftPlayer)player).getHandle().ping;
      if (args.length == 0) {
        player.sendMessage("§8[§3Xeme§8]§7 Your current ping is§6 " + ping + "§6 ms.");
      }
    }
    return false;
  }
}
