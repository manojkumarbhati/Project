package com.pages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import constants.PropCons;

import com.utils.UtilClasses;
public class Footer {
	
//		private SnapShot takesnapshot = null;
		private Properties prop = new Properties();
		private PropCons props = new PropCons();
		private WebDriver driver = null;
		UtilClasses ut = null;
		public Footer(WebDriver driver) {
			this.driver = driver;
		}
		public void footerOperation()
		{
			ut = new UtilClasses(driver);
			ut.wait(5000);
			driver.navigate().to(props.siteurl);
			ut.setProps(prop, props.footerLocators);
			ut.wait(2000);
			
			ut.hoverElements(prop.getProperty("cities"));
			
			ut.sendExcelData(prop.getProperty("email"));
			
			ut.hoverElements(prop.getProperty("footer1"));
			ut.hoverElements(prop.getProperty("footer2"));
			ut.hoverElements(prop.getProperty("footer3"));
			ut.hoverElements(prop.getProperty("bottom"));
			
		}
		
	}

