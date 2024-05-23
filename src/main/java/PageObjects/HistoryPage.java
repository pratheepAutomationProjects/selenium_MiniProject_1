package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HistoryPage  {
	public WebDriver driver;
	
	public HistoryPage(WebDriver driver){
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(css=".fa.fa-bars")
	private WebElement toogle;
	
	@FindBy(linkText = "History")
	private WebElement HistoryButton;
	
	@FindBy(className ="panel-heading")
	private WebElement Date;
		
	public void SelectHistory() {
		toogle.click();
		HistoryButton.click();		
	}
	
	public String getDateInHistory() {
	return 	Date.getText();
	}
	
}
