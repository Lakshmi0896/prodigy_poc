package com.prodigy.driver;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.prodigy.utilities.ReadPropertiesFile;

public class Driver {
	public static WebDriver driver;
	public static final String filename = null;
	public ReadPropertiesFile readfile = new ReadPropertiesFile();
	public Properties prop = readfile.readPropertiesFile(filename);

	public static void init(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}
	}
}