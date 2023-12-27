package me.xeme.api;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import com.xeme.Main;

public class SBAPI {

	
	@SuppressWarnings("deprecation")
	public static void scoreBoardManager(Player p) {
		ScoreboardManager sbm = Bukkit.getScoreboardManager();
		Scoreboard sb = sbm.getNewScoreboard();
		Objective obj = sb.registerNewObjective("Scoreboard", "dummy");
		Score score1 = obj.getScore(Bukkit.getOfflinePlayer(" §3§lYou"));
		score1.setScore(16);
		Score score2 = obj.getScore(Bukkit.getOfflinePlayer("" + p.getDisplayName()));
		score2.setScore(15);
		Score bos1 = obj.getScore(Bukkit.getOfflinePlayer(" §f"));
		bos1.setScore(14);
		Score score3 = obj.getScore(Bukkit.getOfflinePlayer(" §e§lServer"));
		score3.setScore(13);
		Score score4 = obj.getScore(Bukkit.getOfflinePlayer("" + p.getWorld().getName().toUpperCase()));
		score4.setScore(12);
		Score bos2 = obj.getScore(Bukkit.getOfflinePlayer(" §c "));
		bos2.setScore(11);
		Score score5 = obj.getScore(Bukkit.getOfflinePlayer(" §3§lRank"));
		score5.setScore(10);
		
		 File data = new File(Bukkit.getPluginManager().getPlugin("Xeme_V3NSYJ").getDataFolder(), File.separator + "userdata");
		  File f = new File(data, File.separator + p.getName() + ".yml");
		  FileConfiguration playerData = YamlConfiguration.loadConfiguration(f);
		Score score6 = obj.getScore(Bukkit.getOfflinePlayer(" " + playerData.getString("RankColor").replace("&", "§") + playerData.getString("Rank")));
		score6.setScore(9);
		Score bos3 = obj.getScore(Bukkit.getOfflinePlayer(" §e"));
		bos3.setScore(8);
		Score score7 = obj.getScore(Bukkit.getOfflinePlayer(" §c§lPlayers"));
		score7.setScore(2);
		Score score9 = obj.getScore(Bukkit.getOfflinePlayer(" §b§lTime"));
		score9.setScore(7);
		Date now = new Date();
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date saat = new Date();
		SimpleDateFormat saatformat = new SimpleDateFormat("hh:mm a z");
		Score score10 = obj.getScore(Bukkit.getOfflinePlayer(" §f" + format.format(now)));
		score10.setScore(6);
		Score score11 = obj.getScore(Bukkit.getOfflinePlayer(" §f" + saatformat.format(saat)));
		score11.setScore(5);
		Score bos4 = obj.getScore(Bukkit.getOfflinePlayer(" §r"));
		bos4.setScore(4);
		Score score12 = obj.getScore(Bukkit.getOfflinePlayer(" §r" + Bukkit.getOnlinePlayers().size()));
		score12.setScore(1);
		obj.setDisplaySlot(DisplaySlot.SIDEBAR);
		obj.setDisplayName("  §6§lSquirrelNetWork  ");
		p.setScoreboard(sb);
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.m, new Runnable() {
	        public void run() {
	          scoreBoardManager(p);
	        }
	    },1200);
		
		
	}
	
}
