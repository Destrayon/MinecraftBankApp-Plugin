package me.MCBankApp.Commands;

import java.io.IOException;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.MCBankApp.Main;
import me.MCBankApp.OnlineUser;

public class Signup implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player) sender;
		
		if (sender instanceof Player) {
			if (!Main.checkOnlineUsers(sender.getName()))
			{
				if (args.length == 0)
				{
					player.sendMessage("Please type /signup { username } { password } to continue.");
				}
				
				if (args.length == 2)
				{
					String answer = "";
					try {
						answer = Main.SendCommand("2 " + args[0] + " " + args[1]);
					} catch (Exception e) {
						
					}
					
					if (answer.equals("Signup failed"))
					{
						player.sendMessage("Username already exists.");
					} else
					{
						Main.users.add(new OnlineUser(sender.getName(), args[0]));
						player.sendMessage("Welcome, " + args[0] + "!");
					}
				}
			}else
			{
				player.sendMessage("You are already logged in! Type /logout to logout.");
			}
		}
		return true;
	}
}
