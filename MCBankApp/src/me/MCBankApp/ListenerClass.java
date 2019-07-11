package me.MCBankApp;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class ListenerClass implements Listener {
	public ListenerClass(Main plugin)
	{
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e)
	{
		Player player = e.getPlayer();
		
		if (Main.checkOnlineUsers(player.getName()))
		{
			player.sendMessage("Welcome, " + player.getName() +"!\nTo see available commands, type /helpme.");
		} else
		{
			player.sendMessage("Welcome, " + player.getName() + "!\nTo see available commands, type /helpme.\nTo login, type /login and to signup, type /signup!");
		}
	}
	
	@EventHandler
	public void onPlayerCommand(PlayerCommandPreprocessEvent e) throws Exception
	{
		if (!Main.clientSocket.isConnected())
		{
			Main.clientSocket();
		}
	}
}
