package com.scarabcoder.alphacore.listeners;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;


public class SignPlaceListener implements Listener{
	@EventHandler
	public void signPlace(SignChangeEvent e){
		if(e.getLine(0).equals("Right-click for") && e.getLine(1).equals("link")){
			e.setLine(0, e.getLine(2));
			e.setLine(1, ChatColor.RESET + "[" + ChatColor.AQUA + "Right Click" + ChatColor.RESET + "]");
			
			e.setLine(2, ChatColor.AQUA + "For link");
			e.getBlock().getState().update();
		}
	}
}
