package com.pages;

import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import constants.PropCons;

import com.utils.UtilClasses;

public class Body {

	private Properties prop = new Properties();
	private PropCons props = new PropCons();
	private WebDriver driver = null;
	UtilClasses ut = new UtilClasses(driver);

	public Body(WebDriver driver) {
		this.driver = driver;
		System.out.println(driver);
	}

	public void Body() {
		ut = new UtilClasses(driver);
		ut.wait(5000);
		driver.navigate().to(props.siteurl);
		ut.setProps(prop, props.otherLocators);
		ut.hover(prop.getProperty("contactUs"));
		ut.hoverElements(prop.getProperty("knowMore"));
	}

	public void ChatBot() {
		System.out.println(driver);
		ut.wait(2000);
		ut.click(prop.getProperty("chatBot"));
		ut.wait(3000);
		ut.click(prop.getProperty("closeBot"));
		ut.wait(3000);
	}

}
