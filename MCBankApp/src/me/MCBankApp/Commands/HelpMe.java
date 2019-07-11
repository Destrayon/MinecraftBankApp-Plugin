package me.MCBankApp.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.MCBankApp.Main;

public class HelpMe implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player) sender;
		
		if (sender instanceof Player)
		{
			try {
				String message = "";
				
				if (!Main.checkOnlineUsers(sender.getName()))
				{
					message += "/login {username} {password}\n/signup {username} {password}\n/login\n/signup\n";
				} else
				{
					String user = Main.returnOnlineUser(sender.getName()).userName;
					int userPerms = Integer.parseInt(Main.SendCommand("5 " + user));
					if (userPerms == 1)
					{
						message += "/check balance {username}\n/check permissions {username}\n/fund {username} {amount} bankfund\n/withdraw {username} {amount}\n/set {username} permissions {permission}\n/get transactions all\n/get transactions {username}\n";
					}
					
					message += "/check user {ingamename}\n/check permissions raw\n/check balance\n/check users\n/check permissions\n/check me\n/fund {username} {amount}\n/get transactions\n/get conversions\n/logout\n";
				}
				
				player.sendMessage(message);
			} catch (Exception e) {}
		}
		
		return true;
	}
}
