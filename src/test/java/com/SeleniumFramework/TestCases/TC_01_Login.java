package com.SeleniumFramework.TestCases;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import BaseTest.BaseTest;
import PageObjects.AppoinmentPage;
import PageObjects.ConfirmationPage;
import PageObjects.LoginPage;
import Utils.ConstantsHelper;

public class TC_01_Login extends BaseTest {

	@Test
	public void LoginFlowValidation() {
		LoginPage loginPage = new LoginPage(driver);

		loginPage.LoginButtonClick();
		AppoinmentPage AppoinmentPage = loginPage.Login(ConstantsHelper.username, ConstantsHelper.password);
		WebElement facilityElement = AppoinmentPage.facilityElement();
		Select sc = new Select(facilityElement);
		sc.selectByValue(ConstantsHelper.Facility);
		AppoinmentPage.heathCareProgram();
		while (true) {
			// month year select
			String monthYear = AppoinmentPage.SelectCalender();
			if (monthYear.equals(ConstantsHelper.month)) {
				break;
			} else {
				// click next if current year, month not matches
				AppoinmentPage.NextMonthClick();
			}

		}
		// select date
		WebElement day = AppoinmentPage.GetDays().stream().filter(s -> s.getText().equals(ConstantsHelper.date))
				.findFirst().orElse(null);
		day.click();
		// enter comments
		Actions a = new Actions(driver);
		WebElement CommentBoxLocation = AppoinmentPage.txtCommentSelect();
		a.sendKeys(CommentBoxLocation, ConstantsHelper.Comments).build().perform();
		// click appoiment
		ConfirmationPage ConfirmationPage = AppoinmentPage.bookAppoiment();
		String ConfirmationText = ConfirmationPage.confirmationMessage();
		Assert.assertEquals(ConstantsHelper.ConfirmationMessage, ConfirmationText);

	}
}
