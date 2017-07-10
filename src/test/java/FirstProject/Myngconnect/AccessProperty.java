package FirstProject.Myngconnect;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AccessProperty {
	
	public String getproperty(String key) throws IOException
	{
		 InputStream input = new FileInputStream("src/test/resources/options.properties");
		 Properties p=new Properties();
		 p.load(input);
		 return p.getProperty(key).toString();
	}
	
	

}
