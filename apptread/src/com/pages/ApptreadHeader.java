package com.pages;

import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import constants.PropCons;

import com.utils.UtilClasses;
public class ApptreadHeader {
	
//		private SnapShot takesnapshot = null;
		private Properties prop = new Properties();
		private PropCons props = new PropCons();
		private WebDriver driver = null;
		UtilClasses ut = null;
		public ApptreadHeader(WebDriver driver) {
			this.driver = driver;
//			this.takesnapshot = takesnapshot;
		}
		public void topHeaderOperation()
		{
			ut = new UtilClasses(driver);
			ut.wait(5000);
			driver.navigate().to(props.siteurl);
			
			ut.setProps(prop, props.headerLocators);
			ut.wait(5000);
			List<WebElement> listOfTopHeader = ut.getWebElements(prop.getProperty("topHeader"));
			//System.out.println(listOfTopHeader.size());
			Iterator<WebElement> iterator = listOfTopHeader.iterator();
			while (iterator.hasNext()) {
				WebElement webElement = iterator.next();
				ut.wait(2000);
//				takesnapshot.takeScreenShort("");
				ut.hover(webElement);
			}
		}

		public void headerOperation() {
			ut.wait(5000);
			List<WebElement> listOfHeaderElements = ut.getWebElements(prop.getProperty("header"));
			Iterator<WebElement> iterator = listOfHeaderElements.iterator();
			while (iterator.hasNext()) {
				WebElement webElement = iterator.next();
				ut.wait(3000);
//				takesnapshot.takeScreenShort("");
				ut.hover(webElement);
			}
			ut.wait(2000);
			ut.hover(prop.getProperty("letsTalk"));
			ut.wait(2000);

		}

	}

