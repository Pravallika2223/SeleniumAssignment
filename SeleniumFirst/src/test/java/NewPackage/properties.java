package NewPackage;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class properties {

	public static void main(String[] args) throws IOException {
		
    Properties properties = new Properties();
    FileInputStream inputstream = new FileInputStream("C:\\Users\\Praveen\\eclipse-workspace\\SeleniumFirst\\src\\test\\resources\\properties\\config.properties");
    properties.load(inputstream);
   System.out.println( properties.getProperty("browser"));
   System.out.println(properties.getProperty("url"));
   
   
   FileOutputStream outputstream = new FileOutputStream("C:\\Users\\Praveen\\eclipse-workspace\\SeleniumFirst\\src\\test\\resources\\properties\\config.properties");
   
   properties.setProperty("testdate", "9876544321");
   properties.store(outputstream, "data of a person");
   
	}

}
