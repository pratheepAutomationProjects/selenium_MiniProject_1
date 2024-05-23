package BaseTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class testd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "C:/Users/Pratheep/eclipse-workspace2/SeleniumFramework/drivers/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();	
		driver.get("https://www.google.com/");
		
		
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver = new ChromeDriver();
//		driver.get("https://www.google.com/");
	}

}
