package com.scarabcoder.alphacore.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.PlayerInventory;

public class InventoryListener implements Listener {
	@EventHandler
	public void playerClickInInv(InventoryClickEvent e){
		if(e.getInventory().getName().endsWith("GAMES")){
			e.setCancelled(true);
			if(e.getCurrentItem() != null){
				e.getWhoClicked().closeInventory();
				if(e.getCurrentItem().getType().equals(Material.IRON_SWORD)){
					Location sg = new Location(Bukkit.getWorld("emptyspawn"), -11.5, 127, 46.5,0,0);
					e.getWhoClicked().teleport(sg);
				}else if(e.getCurrentItem().getType().equals(Material.GOLD_HOE)){
					Location btag = new Location(Bukkit.getWorld("emptyspawn"), -2.5, 125, 4.5, 90, 0);
					e.getWhoClicked().teleport(btag);
				}else if(e.getCurrentItem().getType().equals(Material.IRON_HOE)){
					Location infected = new Location(Bukkit.getWorld("emptyspawn"), 56.5, 126, 57.5, 0, 0);
					e.getWhoClicked().teleport(infected);
				}else if(e.getCurrentItem().getType().equals(Material.DRAGON_EGG)){
					Location egg = new Location(Bukkit.getWorld("EggWars"), -7.5, 121, -8.5, -90, 0);
					e.getWhoClicked().teleport(egg);
				}
			}
		}else if(e.getInventory() instanceof PlayerInventory){
			if(!e.getWhoClicked().isOp()){
				e.setCancelled(true);
			}
		}else if(e.getInventory().getName().endsWith("Lobby Tools")){
			if(e.getCurrentItem() != null){
				e.setCancelled(true);
				if(e.getCurrentItem().getType().equals(Material.BLAZE_ROD)){
					
					
					
					
				}else if(e.getCurrentItem().getType().equals(Material.REDSTONE_COMPARATOR)){
					
				}else if(e.getCurrentItem().getType().equals(Material.ARMOR_STAND)){
					
				}
			}
			
			
		}
	}
}
