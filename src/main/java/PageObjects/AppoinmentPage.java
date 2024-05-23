package PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AppoinmentPage {

	public WebDriver driver;

	public AppoinmentPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "combo_facility")
	private WebElement facility;

	@FindBy(id = "chk_hospotal_readmission")
	private WebElement checkReadmission;

	@FindBy(id = "radio_program_medicaid")
	private WebElement radioMedicaid;
	
	@FindBy(id = "txt_visit_date")
	@CacheLookup
	private WebElement selectCalendar;
	
	@FindBy(xpath = "//*[@class='datepicker-days'] //tr/th[@class='datepicker-switch']")
	@CacheLookup
	private WebElement MonthYear;
	
	@FindBy(css = ".datepicker-days .next")
	@CacheLookup
	private WebElement NextMonth;
	
	@FindBy(xpath = "//*[@class='datepicker-days'] //td[@class='day']")
	@CacheLookup
	private List<WebElement> days;
	
	@FindBy(id = "txt_comment")
	@CacheLookup
	private WebElement txtComment;
	
	@FindBy(id = "btn-book-appointment")
	@CacheLookup
	private WebElement bookAppointment;
	
	
	public WebElement facilityElement() {
		return facility;
	}

	public void heathCareProgram() {
		checkReadmission.click();
		radioMedicaid.click();
	}
	public String SelectCalender() {
		selectCalendar.click();
		return MonthYear.getText();
	}
	
	public void NextMonthClick() {
		NextMonth.click();
	}
	
	public List<WebElement> GetDays() {
	
		return days;
	}
	
	public WebElement txtCommentSelect() {
		return txtComment;
	}
	public ConfirmationPage bookAppoiment() {
		bookAppointment.click();
		return new ConfirmationPage(driver);
	}


	
	
	
}
