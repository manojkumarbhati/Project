package constants;

public class PropCons {
	// *******WebSite Name*******
		public final String siteurl = "https://apptread.com/";
		// *******
		public final String projectLocation = System.getProperty("user.dir");
		// *******Excel file*******
		public final String email = projectLocation + "\\src\\com\\resources\\email.xlsx";
		// *******Properties files*******
		public final String headerLocators = projectLocation + "\\src\\com\\resources\\headerLocators.properties";
		public final String otherLocators = projectLocation + "\\src\\com\\resources\\otherLocators.properties";
		public final String footerLocators = projectLocation + "\\src\\com\\resources\\footerLocators.properties";

		// *******Driver Locations*******
		public final String googleDriver = "D:\\impactQA\\chromedriver_win32\\chromedriver.exe";
		public final String firefoxDriver = projectLocation + "\\Driver\\geckodriver.exe";
		public final String eageDriver = projectLocation + "\\Driver\\msedgedriver.exe";
}
