package me.MCBankApp.Test;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.io.OutputStream;
import java.io.InputStream;
import config.PropertiesFile;

public class Client {
	
	static Socket clientSocket;
	
	public static void main(String[] args) throws IOException
	{
		Scanner scan = new Scanner(System.in);
		
		clientSocket = new Socket(InetAddress.getByName(PropertiesFile.readIPAddress()), Integer.parseInt(PropertiesFile.readPort()));
		
		System.out.println(clientSocket.isConnected());
		
		scan.nextLine();
		
		scan.close();
		
	}
}
