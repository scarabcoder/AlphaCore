package com.scarabcoder.alphacore.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class DropItemListener implements Listener{
	@EventHandler
	public void playerDrop(PlayerDropItemEvent e){
		if(!e.getPlayer().hasPermission("core.dropitem")){
			e.setCancelled(true);
		}
	}
}
