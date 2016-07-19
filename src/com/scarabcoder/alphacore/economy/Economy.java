package com.scarabcoder.alphacore.economy;

import org.bukkit.OfflinePlayer;

import com.scarabcoder.alphacore.Main;

public class Economy {
	
	public static void setBalance(OfflinePlayer p, int balance){
		Main.getPlugin().getConfig().set("balance." + p.getUniqueId().toString(), balance);
		Main.getPlugin().saveConfig();
		
	}
	
	public static boolean isInSystem(OfflinePlayer p){
		return Main.getPlugin().getConfig().contains("balance." + p.getUniqueId().toString());
	}
	
	public static int getBalance(OfflinePlayer p){
		return Main.getPlugin().getConfig().getInt("balance." + p.getUniqueId().toString());
	}
	
	public static void addBalance(OfflinePlayer p, int balance){
		setBalance(p, getBalance(p) + balance);
	}
	
	public static void removeBalance(OfflinePlayer p, int balance){
		setBalance(p, getBalance(p) - balance);
	}
}
