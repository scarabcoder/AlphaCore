package com.scarabcoder.alphacore.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class CommandListener implements Listener {
	@EventHandler
	public void commandEvent(PlayerCommandPreprocessEvent e){
		if(e.getMessage().startsWith("/pl") || e.getMessage().startsWith("/plugins")){
			if(!e.getPlayer().hasPermission("alphacore.plugin")){
				e.getPlayer().sendMessage("Unknown command. Type \"/help\" for help.");
				e.setCancelled(true);
			}
		}
	}
}
