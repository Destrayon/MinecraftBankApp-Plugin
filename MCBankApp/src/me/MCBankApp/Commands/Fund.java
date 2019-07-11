package me.MCBankApp.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import me.MCBankApp.Main;

public class Fund implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player) sender;
		
		if (sender instanceof Player)
		{
			try {
				String user = Main.returnOnlineUser(sender.getName()).userName;
				int userPerms = Integer.parseInt(Main.SendCommand("5 " + user));
				
				if(args.length == 3 && userPerms == 1)
				{
					if (args[2].equals("bankfund"))
					{
						player.sendMessage(Main.SendCommand("6 " + args[0] + " " + args[1]));
					}
				}
				
				if (args.length == 2)
				{
					player.sendMessage(Main.SendCommand("7 " + user + " " + args[0] + " " + args[1]));
				}
				
			} catch (Exception e) {
				
			}	
		}
		
		return true;
	}
}
