package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationPage {

	public WebDriver driver;

	public ConfirmationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='col-xs-12 text-center']/h2")
	@CacheLookup
	private WebElement confirmationMessage;
	
	@FindBy(xpath ="//a[contains(text(),'Go to Homepage')]")
	private WebElement HomePageButton;

	public String confirmationMessage() {
		return confirmationMessage.getText();
	}
	
	public HistoryPage ClickOnHomePage() {
		HomePageButton.click();
		return new HistoryPage(driver);
		
	}

}
