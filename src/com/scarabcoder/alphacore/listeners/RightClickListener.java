package com.scarabcoder.alphacore.listeners;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.scarabcoder.alphacore.economy.Economy;


public class RightClickListener implements Listener{
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void playerRightClick(PlayerInteractEvent e){
		if(e.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
			if(e.getClickedBlock().getType().equals(Material.WALL_SIGN)){
				Sign sign = (Sign) e.getClickedBlock().getState();
				if(sign.getLine(2).equalsIgnoreCase(ChatColor.AQUA + "For link")){
					e.getPlayer().sendMessage(ChatColor.GREEN + sign.getLine(0) + "'s channel: http://www.beam.pro/" + sign.getLine(0));
				}
			}
		}
		if(e.getAction().equals(Action.RIGHT_CLICK_AIR) || (e.getAction().equals(Action.RIGHT_CLICK_BLOCK))){
			if(e.getPlayer().getItemInHand() != null){
				if(e.getPlayer().getItemInHand().getItemMeta().getDisplayName() != null){
					if(e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equals(ChatColor.BOLD + ChatColor.AQUA.toString() + "Games")){
						e.setCancelled(true);
						Inventory inv = Bukkit.createInventory(null, 9, ChatColor.GREEN.toString() + ChatColor.BOLD + "GAMES");
						ItemStack sg = new ItemStack(Material.IRON_SWORD);
						ItemMeta meta = sg.getItemMeta();
						meta.setDisplayName(ChatColor.GREEN + "Survival Games");
						meta.setLore(Arrays.asList(ChatColor.GOLD + "Classic SG"));
						sg.setItemMeta(meta);
						ItemStack btag = new ItemStack(Material.GOLD_HOE);
						meta.setDisplayName(ChatColor.YELLOW + "Banana Tag");
						meta.setLore(Arrays.asList(ChatColor.GOLD + "Players can tag each other,", ChatColor.GOLD + "don't get tagged!"));
						btag.setItemMeta(meta);
						ItemStack infect = new ItemStack(Material.IRON_HOE);
						meta.setDisplayName(ChatColor.RED + "Infection");
						meta.setLore(Arrays.asList(ChatColor.GOLD + "Humans vs Zombies; don't get infected!"));
						infect.setItemMeta(meta);
						ItemStack egg = new ItemStack(Material.DRAGON_EGG);
						meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Egg Wars");
						meta.setLore(Arrays.asList(ChatColor.GOLD + "Team game; break enemies' eggs to prevent", ChatColor.GOLD + "their respawning!"));
						egg.setItemMeta(meta);
						ItemStack sw = new ItemStack(Material.ENDER_PEARL);
						meta.setDisplayName(ChatColor.AQUA + "Sky Wars" + ChatColor.RED + " (Coming Soon)");
						meta.setLore(Arrays.asList(ChatColor.GOLD + "Go from island to island in order to dominate all!"));
						sw.setItemMeta(meta);
						
						inv.setItem(0, sg);
						inv.setItem(2, btag);
						inv.setItem(4, infect);
						inv.setItem(6, egg);
						inv.setItem(8, sw);
						e.getPlayer().openInventory(inv);
					}else if(e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equals(ChatColor.BOLD + ChatColor.AQUA.toString() + "Lobby Tools")){
						e.setCancelled(true);
						
						ItemStack crystal = new ItemStack(Material.PRISMARINE_CRYSTALS);
						ItemMeta meta = crystal.getItemMeta();
						meta.setDisplayName(ChatColor.GREEN + "You have " + Economy.getBalance(e.getPlayer()) + " Crystals");
						crystal.setItemMeta(meta);
						
						ItemStack settings = new ItemStack(Material.REDSTONE_COMPARATOR);
						meta.setDisplayName(ChatColor.GREEN + "Settings");
						settings.setItemMeta(meta);
						
						ItemStack gadgets = new ItemStack(Material.BLAZE_ROD);
						meta.setDisplayName(ChatColor.GREEN + "Gadgets");
						gadgets.setItemMeta(meta);
						
						ItemStack companion = new ItemStack(Material.ARMOR_STAND);
						meta.setDisplayName(ChatColor.GREEN + "Companion");
						companion.setItemMeta(meta);
						
						Inventory inv = Bukkit.createInventory(null, 36, ChatColor.GREEN + ChatColor.BOLD.toString() + "Lobby Tools");
						inv.setItem(4, crystal);
						
						inv.setItem(19, gadgets);
						
						inv.setItem(22, settings);
						
						inv.setItem(25, companion);
						
						e.getPlayer().openInventory(inv);
						
					}
				}
			}
		}
	}
}
