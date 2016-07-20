package com.scarabcoder.alphacore;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import com.scarabcoder.alphacore.commands.CommandMoney;
import com.scarabcoder.alphacore.economy.Economy;
import com.scarabcoder.alphacore.listeners.CommandListener;
import com.scarabcoder.alphacore.listeners.DropItemListener;
import com.scarabcoder.alphacore.listeners.InventoryListener;
import com.scarabcoder.alphacore.listeners.PlayerJoinListener;
import com.scarabcoder.alphacore.listeners.RightClickListener;
import com.scarabcoder.alphacore.listeners.SignPlaceListener;

import net.md_5.bungee.api.ChatColor;

public class Main extends JavaPlugin {
	
	public static Plugin plugin;
	
	private int x = 0;
	
	private int timer = 0;
	
	public static Plugin getPlugin(){
		return plugin;
	}
	
	public void setupConfig(){
		this.getConfig().options().copyDefaults(true); // NOTE: You do not have to use "plugin." if the class extends the java plugin
        //Save the config whenever you manipulate it
        this.saveConfig();
        Main.plugin = this;
	}
	
	@Override
	public void onEnable(){
		Bukkit.getLogger().log(Level.INFO, "Enabling AlphaCore by ScarabCoder");
		this.setupConfig();
		
		Bukkit.getPluginCommand("money").setExecutor(new CommandMoney());
		
		for(Player p : Bukkit.getOnlinePlayers()){
			if(!Economy.isInSystem(p)){
				getConfig().set("balance." + p.getUniqueId().toString(), 0);
			}
		}
		
		Bukkit.getPluginManager().registerEvents(new RightClickListener(), this);
		Bukkit.getPluginManager().registerEvents(new CommandListener(), this);
		Bukkit.getPluginManager().registerEvents(new SignPlaceListener(), this);
		Bukkit.getPluginManager().registerEvents(new PlayerJoinListener(), this);
		Bukkit.getPluginManager().registerEvents(new InventoryListener(), this);
		Bukkit.getPluginManager().registerEvents(new DropItemListener(), this);
		
		List<String> msgs = new ArrayList<String>();
		msgs.add("You can use coins to buy lobby and ingame items!");
		msgs.add("Follow our Twitter for updates! http://www.twitter.com/AlphaCentralMC");
		msgs.add("Use /vote to vote for us on server lists to get ingame rewards! (Coming Soon)");
		msgs.add("You can donate for ingame ranks and coins! (Coming Soon)");
		msgs.add("Don't forget to check out our streamers' channels!");
		msgs.add("You can signup for our forums or check out the shop at http://www.alphacentral.net");
		msgs.add("Join the official Discord channel! https://discord.gg/umH5WUK");
		Main.getPlugin().saveConfig();
		Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable(){

			@Override
			public void run() {
				for(Player p : Bukkit.getOnlinePlayers()){
					ScoreboardManager manager = Bukkit.getScoreboardManager();
					Scoreboard scoreboard = manager.getNewScoreboard();
					Objective money = scoreboard.registerNewObjective("money", "dummy");
					money.setDisplayName(ChatColor.GREEN + "Balance");
					money.setDisplaySlot(DisplaySlot.SIDEBAR);
					p.setScoreboard(scoreboard);
					Score score = money.getScore("Crystals:");
					score.setScore(Economy.getBalance(p));
					
				}
				timer += 1;
				if(timer == 2 * 60){
					timer = 0;
					Bukkit.broadcastMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + "TIP: " + ChatColor.RESET + ChatColor.GREEN.toString() + msgs.get(x));
					if(x + 1 != msgs.size()){
						x += 1;
					}else{
						x = 0;
					}
				}
			}
			
		}, 0L, 20L);
	}
}
