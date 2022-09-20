package Com.Demosite.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties pro;
	
	//Constructor
	public ReadConfig()
	{
		File src = new File("./Confrigration\\config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			
			System.out.println("Exception is" + e.getMessage());
			
		}
		
	}
	
	public String getApplicationURL()
	{
		String url = pro.getProperty("baseURL");
		return url;
	}
	
	public String getUserEmail()
	{
		String useremailPro = pro.getProperty("useremail");
		return useremailPro;
	}
	
	public String getUserPassword()
	{
		String userPassPro = pro.getProperty("usepassword");
		return userPassPro;
	}
	
	public String getChromePath()
	{
		String chromepathPro = pro.getProperty("chromepath");
		return chromepathPro;
	}
	
	public String getEdgePath()
	{
		String EdgePathpro = pro.getProperty("Edgexpath");
		return EdgePathpro;
	}
	
	
}
