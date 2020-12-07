package com.testexecution;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.pages.*;
import com.utils.*;
import com.utils.*;
public class Tc001 {
	
		private WebDriver driver = null;
		

		@BeforeClass
		public void setProps() { 
			System.out.println(System.getProperty("user.dir"));
			Browserutil browserUtil = new Browserutil();
			driver = browserUtil.getDriver("chrome");
			if (driver == null)
				System.exit(0);
			wait(2000);
		}

		@Test(priority=1)
		public void Header() {
			ApptreadHeader header = new ApptreadHeader(driver);
			header.topHeaderOperation();
			wait(2000);
			header.headerOperation();
			wait(2000);
		}

		@Test(priority = 2)
		public void bodyTest() {
			Body b = new Body(driver);
//			b.ChatBot();
			b.Body();
		}
		
		@Test(priority = 3)
		public void footerTest() {
			Footer f = new Footer(driver);
			f.footerOperation();
		}
		
		

		@AfterClass
		public void closeBrowser() {
			wait(5000);
			driver.quit();
		}
		
		
		public void wait(int time) {
			try {
				Thread.sleep(time);
			} catch (Exception e) {
			}
		}
}
