package com.scarabcoder.alphacore.listeners;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;


public class RightClickListener implements Listener{
	@EventHandler
	public void playerRightClick(PlayerInteractEvent e){
		if(e.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
			if(e.getClickedBlock().getType().equals(Material.WALL_SIGN)){
				Sign sign = (Sign) e.getClickedBlock().getState();
				if(sign.getLine(2).equalsIgnoreCase(ChatColor.AQUA + "For link")){
					e.getPlayer().sendMessage(ChatColor.GREEN + sign.getLine(0) + "'s channel: http://www.beam.pro/" + sign.getLine(0));
				}
			}
		}
	}
}
