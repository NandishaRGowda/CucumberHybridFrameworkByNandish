package utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
	
	public  Properties InitializeProperties() {
		
		Properties prop=new Properties();
		File Propfile=new File(System.getProperty("user.dir")+"/src/test/resources/PropertiesFileSRN/config.properties");
		
		try {
			FileInputStream fis=new FileInputStream(Propfile);
			prop.load(fis);
		} catch (Throwable e) {
				e.printStackTrace();
		}
		return prop;
	
	
	}
	

}
