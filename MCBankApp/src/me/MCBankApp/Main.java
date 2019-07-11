package me.MCBankApp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;
import me.MCBankApp.Commands.*;

public class Main extends JavaPlugin{
	
	public static ArrayList<OnlineUser> users = new ArrayList<OnlineUser>();
	
	static Socket clientSocket;
	
	public void onEnable(){
		try {
			clientSocket();
		} catch (Exception e)
		{
			
		}
		
		new ListenerClass(this);
		
		this.getCommand("check").setExecutor((CommandExecutor) new Check());	
		this.getCommand("login").setExecutor((CommandExecutor) new Login());
		this.getCommand("signup").setExecutor((CommandExecutor) new Signup());
		this.getCommand("logout").setExecutor((CommandExecutor) new Logout());
		this.getCommand("fund").setExecutor((CommandExecutor) new Fund());
		this.getCommand("withdraw").setExecutor((CommandExecutor) new Withdraw());
		this.getCommand("set").setExecutor((CommandExecutor) new Set());
		this.getCommand("get").setExecutor((CommandExecutor) new Get());
		this.getCommand("helpme").setExecutor((CommandExecutor) new HelpMe());
	}
	
	public void onDisable() {
		try {
			clientSocket.close();
		} catch (Exception e) {}

	}
	
	public static String SendCommand(String cmd) throws IOException
	{
		OutputStream socketWrite = clientSocket.getOutputStream();
		
		InputStream socketRead = clientSocket.getInputStream();
		
		byte[] buf = cmd.getBytes(StandardCharsets.US_ASCII);
		
		socketWrite.write(buf);
		
		byte[] receivedBuf = new byte[1024];
		
		int c = socketRead.read(receivedBuf);
		
		byte[] data = new byte[c];
		
		System.arraycopy(receivedBuf, 0, data, 0, c);

		return new String(data, StandardCharsets.US_ASCII);
	}
	
	public static void clientSocket() throws NumberFormatException, UnknownHostException, IOException
	{
		clientSocket = new Socket(InetAddress.getByName("127.0.0.1"), 100);
	}
	
	public static boolean checkOnlineUsers(String inGameName)
	{
		for(OnlineUser user : users)
		{
			if (user.inGameName.equalsIgnoreCase(inGameName))
			{
				return true;
			}
		}
		
		return false;
	}
	
	public static OnlineUser returnOnlineUser(String inGameName)
	{
		for(OnlineUser user : users)
		{
			if (user.inGameName.equalsIgnoreCase(inGameName))
			{
				return user;
			}
		}
		return null;
	}
}
