package com.xeme.commands;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.xeme.api.MessageAPI;

public class Gamemode
  implements CommandExecutor
{
  String prefix = "§8[§3Xeme§8]§7";
  
  public boolean onCommand(CommandSender ss, Command cmd, String label, String[] args)
  {
    Player player = (Player)ss;
    if (cmd.getName().equalsIgnoreCase("gm"))
    {
      if (args.length == 0) {
        if (player.hasPermission("hyperwalk.admin"))
        {
          player.setGameMode(GameMode.CREATIVE);
          player.sendMessage(this.prefix + " Your gamemode is now §cCreative§8.");
        }
        else
        {
          MessageAPI.noPermission(player);
        }
      }
      if (args.length == 1) {
        if (player.hasPermission("hyperwalk.admin"))
        {
          Player dgg = Bukkit.getPlayer(args[0]);
          if (dgg == null)
          {
            player.sendMessage(this.prefix + "§b " + args[0] + "§c is not online§8!");
          }
          else if (dgg == player)
          {
            player.setGameMode(GameMode.CREATIVE);
            player.sendMessage(this.prefix + " Your gamemode is now §cCreative§8.");
          }
          else
          {
            dgg.setGameMode(GameMode.CREATIVE);
            dgg.sendMessage(this.prefix + " Your gamemode is now §cCreative§8.");
            player.sendMessage(this.prefix + "§b " + args[0] + "§7 gamemode is now §cCreative§8.");
          }
        }
        else
        {
        	MessageAPI.noPermission(player);
        }
      }
    }
    if (cmd.getName().equalsIgnoreCase("gms"))
    {
      if (args.length == 0) {
        if (player.hasPermission("Xeme.srmod"))
        {
          player.setGameMode(GameMode.SURVIVAL);
          player.sendMessage(this.prefix + "§7 Your gamemode is now §aSurvival");
        }
        else
        {
        	MessageAPI.noPermission(player);
        }
      }
      if (args.length == 1) {
        if (player.hasPermission("hyperwalk.admin"))
        {
          Player dgs = Bukkit.getPlayer(args[0]);
          if (dgs == null)
          {
            player.sendMessage(this.prefix + "§b " + args[0] + "§c is not online§8!");
          }
          else if (dgs == player)
          {
            player.setGameMode(GameMode.SURVIVAL);
            player.sendMessage(this.prefix + " Your gamemode is now §aSurvival§8.");
          }
          else
          {
            dgs.setGameMode(GameMode.SURVIVAL);
            dgs.sendMessage(this.prefix + " Your gamemode is now §cSurvival");
            player.sendMessage(this.prefix + "§b " + args[0] + "§7 gamemode is now §aSurvival§8.");
          }
        }
        else
        {
        	MessageAPI.noPermission(player);
        }
      }
    }
    if ((cmd.getName().equalsIgnoreCase("gamemode")) && 
      (player.hasPermission("hyperwalk.Admin")))
    {
      if (args.length == 0) {
        player.sendMessage(" §cUsage: /gamemode <survival,creative>");
      }
      if (args.length == 1) {
        if ((args[0].equalsIgnoreCase("creative")) || (args[0].equalsIgnoreCase("1")) || (args[0].equalsIgnoreCase("c")))
        {
          player.sendMessage(this.prefix + " Your gamemode is now §cCreative");
          player.setGameMode(GameMode.CREATIVE);
        }
        else if ((args[0].equalsIgnoreCase("survival")) || (args[0].equalsIgnoreCase("0")) || (args[0].equalsIgnoreCase("s")))
        {
          player.sendMessage(this.prefix + " Your gamemode is now §cSurvival");
          player.setGameMode(GameMode.SURVIVAL);
        }
        else if ((!args[0].equalsIgnoreCase("creative")) || (!args[0].equalsIgnoreCase("1")) || (!args[0].equalsIgnoreCase("c")) || (!args[0].equalsIgnoreCase("survival")) || (!args[0].equalsIgnoreCase("0")) || (!args[0].equalsIgnoreCase("s")))
        {
          player.sendMessage(this.prefix + " §c/gamemode <survival,creative>");
        }
      }
    }else if (!player.hasPermission("hyperwalk.admin")){
    	MessageAPI.noPermission(player);
    }
    return false;
  }
}
