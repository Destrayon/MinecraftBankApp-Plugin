package me.MCBankApp.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.MCBankApp.Main;

public class Logout implements CommandExecutor{
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player) sender;
		
		if (sender instanceof Player) {
			if (args.length == 0)
			{
				if(Main.checkOnlineUsers(player.getName()))
				{
					Main.users.remove(Main.returnOnlineUser(player.getName()));
					player.sendMessage("You have been logged out.");
				}
			}
		}
		return true;
	}
}
