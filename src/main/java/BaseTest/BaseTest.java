package BaseTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Utils.ConstantsHelper;

public class BaseTest {

	Properties prop;
	FileInputStream fis;
	public WebDriver driver;

	@BeforeMethod(alwaysRun=true)
	public void beforeSuite() throws IOException {
		intializeDriver();
		driver.manage().window().maximize();
		driver.get(ConstantsHelper.url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ConstantsHelper.timeout));
	}

	@AfterMethod(alwaysRun=true)
	public void AfterSuite() {
		driver.quit();
	}

	public void intializeDriver() throws IOException {
		prop = new Properties();
		fis = new FileInputStream(System.getProperty("user.dir") + File.separator + "Configurations" + File.separator
				+ "global.properties");
		prop.load(fis);
		String browserName = System.getProperty("browser") != null ? System.getProperty("browser")
				: prop.getProperty("browser");
		if (browserName.equalsIgnoreCase("Firefox")) {
			System.setProperty(prop.getProperty(ConstantsHelper.driverName),
					prop.getProperty(ConstantsHelper.firefoxDriverPath));
			driver = new FirefoxDriver();
		}
	}

	public String getScreenshot(String TestCaseName,WebDriver driver) throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		File destination = new File(System.getProperty("user.dir") + File.separator + "Screenshot" + File.separator
				+ TestCaseName + ".png");
		FileUtils.copyFile(source, destination);
		return System.getProperty("user.dir") + File.separator + "Screenshot" + File.separator + TestCaseName + ".png";

	}

//		public void afterMethod(ITestResult result) {
//			if(result.getStatus()==ITestResult.SUCCESS) {
//				logger.log(Status.PASS, MarkupHelper.createLabel(result.getName()+ "-TestCase passed", ExtentColor.GREEN));
//			}
//			else if(result.getStatus()==ITestResult.FAILURE) {
//				logger.log(Status.FAIL,MarkupHelper.createLabel(result.getName()+"-TestCase failed", ExtentColor.RED) );
//				logger.log(Status.FAIL,MarkupHelper.createLabel(result.getThrowable()+"-TestCase failed", ExtentColor.RED) );
//			}
//			else if(result.getStatus()==ITestResult.SKIP) {
//				logger.log(Status.FAIL,MarkupHelper.createLabel(result.getName()+"-TestCase failed", ExtentColor.ORANGE) );
//			}
//			
//		}

}
