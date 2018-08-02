package constants;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class Constants {

	public static String USERNAME;
	public static String PASSWORD;
	public static String URL;
	public static String ID = "id";
	public static String CS = "cssSelector";
	public static String XP = "xpath";
	public static String LOGIN_BUTTON = ".login";
	public static String SEARCH_BUTTON;
	public static String SUBMIT_BUTTON;
	public static String CONTACTUS_BUTTON;
	public static String URLSV;
	
	public static void getPropValues()
	{
		Properties prop;
		InputStream input;
		prop = new Properties();
		input = null;

		try {

			input = new FileInputStream("Resources/config.properties");

			// load a properties file
			prop.load(input);

			// get the property value and print it out
			Constants.USERNAME = prop.getProperty("USERNAME");
			Constants.PASSWORD = prop.getProperty("PASSWORD");
			Constants.URL = prop.getProperty("URL");
			Constants.URLSV = prop.getProperty("URLSV");

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static String getUsername()
	{
		return USERNAME;
	}
	
	public static String getPassword()
	{
		return PASSWORD;
	}
	
	public static String getUrl()
	{
		return URL;
	}
	
	public static String getID() {
		return ID;
	}
	
	public static String getCS() {
		return CS;
	}
	
	public static String getLOGIN_BUTTON() {
		return LOGIN_BUTTON;
	}
	
	public static String getXP() {
		return XP;
	}
	
	public static String getUrlSv() {
		return URLSV;
	}
}
