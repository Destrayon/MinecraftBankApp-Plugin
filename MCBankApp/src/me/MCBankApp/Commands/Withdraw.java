package me.MCBankApp.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.MCBankApp.Main;

public class Withdraw implements CommandExecutor{
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player) sender;
		if (sender instanceof Player)
		{
			try {
				String user = Main.returnOnlineUser(sender.getName()).userName;
				int userPerms = Integer.parseInt(Main.SendCommand("5 " + user));
				
				if (userPerms == 1 && args.length == 2)
				{
					player.sendMessage(Main.SendCommand("8 " + args[0] + " " + args[1]));
				}
			} catch (Exception e)
			{
			}
		}
		return true;
	}
}
