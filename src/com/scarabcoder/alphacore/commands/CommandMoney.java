package com.scarabcoder.alphacore.commands;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.scarabcoder.alphacore.economy.Economy;

import net.md_5.bungee.api.ChatColor;

public class CommandMoney implements CommandExecutor {

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
		
		if(sender.hasPermission("economy.modify")){
			if(args.length > 1){
				if(args[0].equalsIgnoreCase("set") || args[0].equalsIgnoreCase("add") || args[0].equalsIgnoreCase("remove")){
					if(args.length == 3){
						if(Bukkit.getOfflinePlayer(args[1]) != null){
							try{
								int amount = Integer.parseInt(args[2]);
								OfflinePlayer p = Bukkit.getOfflinePlayer(args[1]);
								if(args[0].equalsIgnoreCase("set")){
									Economy.setBalance(p, amount);
								}else if(args[0].equalsIgnoreCase("add")){
									Economy.addBalance(p, amount);
								}else{
									Economy.removeBalance(p, amount);
								}
								sender.sendMessage(ChatColor.GREEN + "Set " + args[1] + "'s balance to $" + amount + ".");
								if(p.isOnline()){
									p.getPlayer().sendMessage("Your balance was changed to " + Economy.getBalance(p));
								}
							}catch(NumberFormatException e){
								sender.sendMessage(ChatColor.RED + "Please use a number in the third argument.");
							}
						}else{
							sender.sendMessage(ChatColor.RED + "Player does not exist!");
						}
					}else{
						sender.sendMessage(ChatColor.RED + "Usage: /economy set <player> <amount>");
					}
				}else if(args[0].equalsIgnoreCase("get")){
					if(args.length == 2){
						if(Economy.isInSystem(Bukkit.getOfflinePlayer(args[1]))){
							sender.sendMessage(ChatColor.GREEN + args[1] + "'s balance: " + Economy.getBalance(Bukkit.getOfflinePlayer(args[1])));
						}else{
							sender.sendMessage(ChatColor.RED + "Player not found!");
						}
					}else{
						sender.sendMessage(ChatColor.RED + "Usage: /economy get <player>");
					}
				}
			}else{
				sender.sendMessage(ChatColor.GREEN + "Command Usage:");
				sender.sendMessage("/money set:add:remove <player> <amount>: Sets a player's balance.");
				sender.sendMessage("/money get <player>: Gets a player's balance.");
			}
		}else{
			sender.sendMessage("Unknown command. Type \"/help\" for help.");
		}
		
		return true;
	}

}
