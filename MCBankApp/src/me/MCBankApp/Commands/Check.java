package me.MCBankApp.Commands;

import java.io.IOException;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.MCBankApp.Main;

public class Check implements CommandExecutor{
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player) sender;
		
		if (sender instanceof Player)
		{
			try {
				String user = Main.returnOnlineUser(sender.getName()).userName;
				int userPerms = Integer.parseInt(Main.SendCommand("5 " + user));
					if (args.length == 2)
					{
						if(userPerms == 1)
						{
							if(args[0].equals("balance"))
							{
								player.sendMessage(Main.SendCommand("3 " + args[1]));
							}
						
							if(args[0].equals("permissions") && !args[1].equals("raw"))
							{
								int permission = Integer.parseInt(Main.SendCommand("5 " + args[1]));
							
								if (permission == 1)
								{
									player.sendMessage(args[1] + " has administrator permissions.");
								} else
								{
								player.sendMessage(args[1] + " has basic permissions.");
								}
							}
						}
					
						if(args[0].equals("permissions") && args[1].equals("raw"))
						{
							player.sendMessage(String.valueOf(userPerms));
						}
						
						if (args[0].equals("user"))
						{
							player.sendMessage(Main.returnOnlineUser(args[1]).userName);
						}
					}
					
					if (args.length == 1)
					{
						if (args[0].equals("balance"))
						{
							player.sendMessage(Main.SendCommand("3 " + user));
						}
						if (args[0].equals("users"))
						{
							player.sendMessage(Main.SendCommand("4"));
						}
						if(args[0].equals("permissions"))
						{
							if (userPerms == 1)
							{
								player.sendMessage("You have administrator permissions.");
							} else
							{
								player.sendMessage("You have basic permissions.");
							}
						}
						if(args[0].equals("me"))
						{
							player.sendMessage("You are " + user);
						}
					}
			}catch (Exception e) 
			{
			}
		}
		return true;
	}

}
