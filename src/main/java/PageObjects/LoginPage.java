package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@id='menu-toggle']")
	private WebElement toogleButton;

	@FindBy(xpath = "//li/a[text()='Login']")
	private WebElement LoginButton;

	@FindBy(id = "txt-username")
	private WebElement username;

	@FindBy(id = "txt-password")
	private WebElement password;

	@FindBy(css = ".btn.btn-default")
	private WebElement submitButton;

	
	public void LoginButtonClick() {
		toogleButton.click();
		LoginButton.click();
	}

	public AppoinmentPage Login(String LoginUsername, String LoginPassword) {
		username.sendKeys(LoginUsername);
		password.sendKeys(LoginPassword);
		submitButton.click();
		return new AppoinmentPage(driver);
	}


}
