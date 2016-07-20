package com.scarabcoder.alphacore.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;

public class PlayerJoinListener implements Listener{
	@EventHandler
	public void playerJoin(PlayerJoinEvent e){
		e.setJoinMessage(ChatColor.GREEN + e.getPlayer().getName() + " joined Alpha Central");
		e.getPlayer().teleport(new Location(Bukkit.getWorld("emptyspawn"), 30.5, 122, 24.5));
		e.getPlayer().getInventory().clear();
		ItemStack compass = new ItemStack(Material.COMPASS);
		ItemStack chest = new ItemStack(Material.CHEST);
		ItemMeta meta = compass.getItemMeta();
		meta.setDisplayName(ChatColor.BOLD + ChatColor.AQUA.toString() + "Games");
		compass.setItemMeta(meta);
		meta.setDisplayName(ChatColor.BOLD + ChatColor.AQUA.toString() + "Lobby Tools");
		chest.setItemMeta(meta);
		e.getPlayer().getInventory().setItem(0, compass);
		e.getPlayer().getInventory().setItem(4, chest);
	}
}
