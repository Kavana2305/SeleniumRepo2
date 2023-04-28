package Generic_utility;

import java.io.FileInputStream;
import java.util.Properties;

public class Property_utility {

	public String get_key_value(String Key) throws Throwable
	{
         FileInputStream fis=new FileInputStream("./src/test/resources/propertyfile.properties.txt");
         Properties pro=new Properties();
         pro.load(fis);
         String value = pro.getProperty(Key);
         return value;
	}
	

}
