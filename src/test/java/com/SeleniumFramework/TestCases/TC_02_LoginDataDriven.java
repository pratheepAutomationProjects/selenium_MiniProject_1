package com.SeleniumFramework.TestCases;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BaseTest.BaseTest;
import PageObjects.AppoinmentPage;
import PageObjects.ConfirmationPage;
import PageObjects.LoginPage;
import Utils.ConstantsHelper;
import Utils.XcelUtils;

public class TC_02_LoginDataDriven extends BaseTest {
	XcelUtils XcelUtils = new XcelUtils();

	@Test(dataProvider = "LoginData")
	public void loginDDT(String username, String password) {
		System.out.println("username ="+username);
		System.out.println("password ="+password);
		LoginPage loginPage = new LoginPage(driver);

		loginPage.LoginButtonClick();
		AppoinmentPage AppoinmentPage = loginPage.Login(username, password);
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

	@DataProvider(name = "LoginData")
	public String[][] getData() throws IOException {

		String excelPath = ConstantsHelper.excelPath;
		String xcelSheet = "Sheet1";
		int rowCount = XcelUtils.getRowCount(excelPath, xcelSheet);
		int columnCount = XcelUtils.getColumnCount(excelPath, xcelSheet);
		String LoginData[][] = new String[rowCount][columnCount-1];
		System.out.println("rowCount"+rowCount);
		System.out.println("columnCount"+columnCount);

		for (int i = 1; i<=rowCount; i++) {
			for (int j = 1; j < columnCount; j++) {
				LoginData[i - 1][j - 1] = XcelUtils.getCellData(excelPath, xcelSheet, i, j);
			}
		}
		return LoginData;

	}

}
