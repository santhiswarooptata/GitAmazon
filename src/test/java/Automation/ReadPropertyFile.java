package Automation;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertyFile {

	public static void main(String[] args) throws IOException {

		FileReader fr = new FileReader(
				"C:\\Users\\Administrator\\eclipse-workspace\\Amazon\\src\\test\\java\\Automation\\config.properties");
		Properties prop = new Properties();
		prop.load(fr);
		System.out.println(prop.getProperty("browser"));
		System.out.println(prop.getProperty("testurl"));
	}

}
