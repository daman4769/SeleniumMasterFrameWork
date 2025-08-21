package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class propertieUtils {

	private static Properties properties = new Properties();
	
	static{
		try(InputStream inputStream = propertieUtils.class.getClassLoader().getResourceAsStream("config.properties")){
				if(inputStream == null) {
					throw new RuntimeException("onfig.properties not found in resources folder");
				}
				properties.load(inputStream);
		}	catch(IOException e) {
			throw new RuntimeException("Failed to load properties file", e);
		}
	}
	 public static String getProperty(String key) {
	        return properties.getProperty(key);
	    }
}
