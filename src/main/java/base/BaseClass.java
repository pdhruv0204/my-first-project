package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

public class BaseClass {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public static void loadConfig() throws IOException {
		
		prop = new Properties();
		
		FileInputStream fis = new FileInputStream("src/main/resources/config/config.properties");
		prop.load(fis);
	}
	
	public static void initPageFactory(Object page) {
		
		PageFactory.initElements(driver, page);
	}
	
	public static void launchBrowser() {
		
		switch (prop.getProperty("browser")) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;	
		default:
			driver = new EdgeDriver();
			break;
		}
	
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
	}
	
	public static void closeBrowser() {
		
		driver.quit();
	}

}
