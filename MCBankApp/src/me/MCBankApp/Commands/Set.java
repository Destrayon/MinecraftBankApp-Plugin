package me.MCBankApp.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.MCBankApp.Main;

public class Set implements CommandExecutor{
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player) sender;
		
		if (sender instanceof Player)
		{
			try {
				String user = Main.returnOnlineUser(sender.getName()).userName;
				int userPerms = Integer.parseInt(Main.SendCommand("5 " + user));
				
				if (userPerms == 1 && args.length == 3)
				{
					if (args[1].equals("permissions"))
					{
						player.sendMessage(Main.SendCommand("9 " + args[0] + " " + args[2]));
					}
				}
			} catch (Exception e)
			{
			}
		}
		return true;
	}
}
