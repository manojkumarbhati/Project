package com.utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import constants.PropCons;

public class UtilClasses 
{
	
		private WebDriver driver ;
		private PropCons props = new PropCons();
		Actions actionProvider = null;
		
		public UtilClasses(WebDriver driver) {
			this.driver = driver;
			if(driver!=null)
				System.out.println("Util Driver");
		}

		public void setProps(Properties prop, String filepath) {
			try {
				FileInputStream stream = readProps(filepath);
				prop.load(stream);
			} catch (Exception e) {
				System.out.println("Exception in : setProperties()");
				e.printStackTrace();
			}
		}

		public FileInputStream readProps(String filepath) {
			try {
				return new FileInputStream(filepath);
			} catch (Exception e) {
				System.out.println("Exception in : readProperties()");
				e.printStackTrace();
			}
			return null;
		}

		public final void wait(int time) {
			try {
				Thread.sleep(time);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public final void iwait(int time) {
			driver.manage().timeouts().implicitlyWait(time, TimeUnit.MILLISECONDS);
		}
		
		public boolean controlClick(WebElement locater) {
			actionProvider = new Actions(driver);
			Action keydown = actionProvider.keyDown(Keys.CONTROL).build();
			Action keyup = actionProvider.keyUp(Keys.CONTROL).build();

			try {
				keydown.perform();
				locater.click();
				keyup.perform();
				return true;
			} catch (Exception e) {
				System.out.println("Exception in click \t" + locater);
				e.printStackTrace();
			}
			return false;
		}
		
		

		public  List<WebElement> getWebElements(String xpath) {
			List<WebElement> data = null;
			int i = 0;
			while (data == null) {
				try {
					data = driver.findElements(By.xpath(xpath));
					
				} catch (Exception e) {
					System.out.println();
				}
				i++;
				if (i > 3)
					break;
				wait(500);
				System.out.println(i);
			}
			return data;// return first Row
		}
		public WebElement getWebElement(String xpath) {
			WebElement data = null;
			int i = 0;
			while (data == null) {
				try {
					data = driver.findElement(By.xpath(xpath));
					
				} catch (Exception e) {
					System.out.println();
				}
				i++;
				if (i > 5)
					break;
				wait(500);
				System.out.println(i);
			}
			return data;// return first Row
		}

		public void handelTab() {
			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			wait(200);
			driver.switchTo().window(tabs.get(1));
			driver.close();
			driver.switchTo().window(tabs.get(0));
		}

		public void handelTabSnapShot( int waitTime) {
			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			wait(200);
			driver.switchTo().window(tabs.get(1));
			wait(waitTime);
//			takesnapshort.takeScreenShort("");
			driver.close();
			driver.switchTo().window(tabs.get(0));
		}

		public boolean click(String locater) {
			try {
				System.out.println(driver);
				System.out.println(By.xpath(locater));
				driver.findElement(By.xpath(locater)).click();
				return true;
			} catch (Exception e) {
				System.out.println("Exception in click \t" + locater);
				e.printStackTrace();
			}
			return false;
		}

		public boolean sendValue(String locater, String data) {
			try {
				driver.findElement(By.xpath(locater)).sendKeys(data);
				return true;
			} catch (Exception e) {
				System.out.println("Exception in send Value \t" + locater);
				e.printStackTrace();
			}
			return false;
		}

		public boolean hover(String locater) {
			Actions ac = new Actions(driver);
			try {
				ac.moveToElement(driver.findElement(By.xpath(locater))).perform();
				return true;
			} catch (Exception e) {
				System.out.println("Exception in send Value \t" + locater);
				e.printStackTrace();
			}
			return false;
		}

		public boolean click(WebElement locater) {
			try {
				locater.click();
				return true;
			} catch (Exception e) {
				System.out.println("Exception in click \t" + locater);
				e.printStackTrace();
			}
			return false;
		}


		public boolean sendValue(WebElement locater, String data) {
			try {
				locater.sendKeys(data);
				return true;
			} catch (Exception e) {
				System.out.println("Exception in send Value \t" + locater);
				e.printStackTrace();
			}
			return false;
		}

		public boolean hover(WebElement locater) {
			Actions ac = new Actions(driver);
			try {
				ac.moveToElement(locater).perform();
				return true;
			} catch (Exception e) {
				System.out.println("Exception in send Value \t" + locater);
				e.printStackTrace();
			}
			return false;
		}

		public void scrollDown(int pixel) {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("window.scrollBy(0," + pixel + ")", "");
		}

		public void scrollTop() {
			JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
			javascriptExecutor.executeScript("window.scrollBy(0,-1900)");

		}
		public void Ewait(String xpath)
		{
			WebDriverWait wait = new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath(xpath))));
			click(xpath);
		}
		public void hoverElements(String locator)
		{
			List<WebElement> li  = driver.findElements(By.xpath(locator));
			for (Iterator iterator = li.iterator(); iterator.hasNext();) {
				WebElement webElement = (WebElement) iterator.next();
				wait(2000);
				actionProvider = new Actions(driver);
				actionProvider.moveToElement(webElement).perform();
			}
		}
			public void clickElements(String locator)
			{
				List<WebElement> li  = getWebElements(locator);
				for (Iterator iterator = li.iterator(); iterator.hasNext();) {
					WebElement webElement = (WebElement) iterator.next();
					webElement.click();
					wait(3000);
					driver.navigate().back();
					wait(2000);
				}
			}
			public ArrayList<String> getExcelData(String path)
			{
				File file = new File(path) ;
				ArrayList<String> list = null;
				try 
				{
					FileInputStream fileInputStream = new FileInputStream(file);
					XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
					XSSFSheet sheet = workbook.getSheetAt(0);	
					list = new ArrayList<String>();
					for (int i = 1; i <= sheet.getLastRowNum(); i++) 
					{
						list.add(sheet.getRow(i).getCell(0).getStringCellValue());
					}
				} catch (IOException e) 
				{
					e.printStackTrace();
				}
				return list;	
			}
			public void sendExcelData(String loactor)
			{
				ArrayList<String> list =getExcelData(props.email);
				for (int i = 0; i < list.size(); i++) 
				{
					driver.findElement(By.xpath(loactor)).sendKeys(list.get(i));
					wait(2000);
					driver.findElement(By.xpath(loactor)).clear();
					wait(2000);
				}
			}
			
		}
	

