package utility;

import java.io.InputStream;
import java.util.Properties;

public class AppConfig {
	public static Properties PROPERTIES;
	public static InputStream inputStream = null;
	static {
		try {
			
			ClassLoader cl = Thread.currentThread().getContextClassLoader();
			inputStream=cl.getResourceAsStream("properties/configuration.properties");
			
			PROPERTIES = new Properties();
			PROPERTIES.load(inputStream);
		}
		catch (Exception e) {
			//ErrorLogger.logError("ApplicationConfiguration", "static block", e.getClass().toString());
		}
	
	}
	
	
	/*
	 * Note : Here instead of using the direct input stream object to load the configuration.properties, class loader is used.
 	 *		  Class loader is used because a web project is complex hierarchy of folders and reads the required file form the given path.
	 * */
	
}
