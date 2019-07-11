package config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesFile {
	
	public static String readIPAddress() throws IOException
	{
		Properties prop = new Properties();
		
		InputStream input = new FileInputStream(new File("src/config/config.properties").getAbsolutePath());
		
		prop.load(input);
		
		return prop.getProperty("IpAddress");
	}
	
	public static String readPort() throws IOException
	{
		Properties prop = new Properties();
		
		InputStream input = new FileInputStream(new File("src/config/config.properties").getAbsolutePath());
		
		prop.load(input);
		
		return prop.getProperty("Port");
	}
}
