package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverSingleton {
	
	private static WebDriver driver;
	
	private WebDriverSingleton() {
		
		
	}
	
	public static WebDriver getInstance() {
		
		if (driver == null) {
			
			System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");		
			driver = new ChromeDriver();
		}
		
		return driver;
	}

}
