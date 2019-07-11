package me.MCBankApp.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.MCBankApp.Main;

public class Get implements CommandExecutor{
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player) sender;
		
		if (sender instanceof Player)
		{
			try {
				String user = Main.returnOnlineUser(sender.getName()).userName;
				int userPerms = Integer.parseInt(Main.SendCommand("5 " + user));
				
				if (args.length == 2 && userPerms == 1)
				{
					if (args[0].equals("transactions"))
					{
						if (args[1].equals("all"))
						{
							player.sendMessage(Main.SendCommand("10"));
						} else
						{
							player.sendMessage(Main.SendCommand("11 " + args[1]));
						}
					}
				}
				
				if (args.length == 1)
				{
					if (args[0].equals("transactions"))
					{
						player.sendMessage(Main.SendCommand("11 " + user));
					}
					
					if (args[0].equals("conversions"))
					{
						player.sendMessage(Main.SendCommand("12"));
					}
				}
			} catch (Exception e) {}
		}
		
		return true;
	}
}
