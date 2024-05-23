package Utils;

import java.io.File;

public interface ConstantsHelper {
	
	String url="https://katalon-demo-cura.herokuapp.com/";
	String username = "John Doe";
	String password = "ThisIsNotAPassword";
	int timeout =10;
	String firefoxDriverPath ="firefoxDriverPath";
	String driverName = "driverName";
	String month="June 2025";
	String date ="8";
	String ExtentReportsPath = "./Reports" +File.separator + "extentReport ";
	String Facility ="Seoul CURA Healthcare Center";
	String Comments = "My country is India";
	String ConfirmationMessage = "Appointment Confirmation";
	String excelPath= "./DataDriven" + File.separator +"data.xlsx";
	

}
