package com.datadriven.framework.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

import com.google.common.io.Files;

public class BaseUI {
	public WebDriver driver;
	public Properties prop;

	/************* Invoking Browser ****************/
	public void invokeBrowser(String browser) {

		try {
			if (browser.equalsIgnoreCase("chrome")) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--disable-notifications");
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "\\src\\main\\resources\\drivers\\chromedriver.exe");
				driver = new ChromeDriver(options);
			} else if (browser.equalsIgnoreCase("edge")) {
				System.setProperty("webdriver.msedge.driver",
						System.getProperty("user.dir") + "\\src\\main\\resources\\drivers\\msedgedriver.exe");
				driver = new EdgeDriver();

			}else {
				System.out.println("Invalid Browser");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		driver.manage().window().maximize();
		if (prop == null) {
			prop = new Properties();
			try {
				FileInputStream file = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties\\ProConf.properties");
				prop.load(file);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/************** Opening URL ***************/
	public void openURL(String websiteURLKey) {
		try {
			driver.get(prop.getProperty(websiteURLKey));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/********* Locating the elements using different ***********/
	public WebElement getElement(String locatorKey) {
		WebElement element = null;
		try {
			if (locatorKey.endsWith("_Id")) {
				element = driver.findElement(By.id(prop.getProperty(locatorKey)));
			} else if (locatorKey.endsWith("_Xpath")) {
				element = driver.findElement(By.xpath(prop.getProperty(locatorKey)));
			} else if (locatorKey.endsWith("_CSS")) {
				element = driver.findElement(By.cssSelector(prop.getProperty(locatorKey)));
			} else if (locatorKey.endsWith("_LinkText")) {
				element = driver.findElement(By.linkText(prop.getProperty(locatorKey)));
			} else if (locatorKey.endsWith("_PartialLinkText")) {
				element = driver.findElement(By.partialLinkText(prop.getProperty(locatorKey)));
			} else if (locatorKey.endsWith("_Name")) {
				element = driver.findElement(By.name(prop.getProperty(locatorKey)));
			} else {
				// reportFail
				Assert.fail("Failing the TestCase, Invalid Locator " + locatorKey);
			}

		} catch (Exception e) {

			e.printStackTrace();

			Assert.fail("Failing the TestCase: " + e.getMessage());

		}
		return element;
}

	/************ Sending Text using xpath ************/
	public void enterText(String xpathKey, String data) {
		getElement(xpathKey).sendKeys(data);
	}

	/************* Cliking an element ****************/
	public void elementClick(String xpathKey) {
		getElement(xpathKey).click();
	}

	/************ Quiting browser *************/
	public void quitBrowser() {
		driver.quit();
	}

	/********** Switching to Windows ***********/
	public void switchToWindows(int i) {
		Set<String> windows = driver.getWindowHandles();
		List<String> list = new ArrayList<String>(windows);
		driver.switchTo().window(list.get(i));
	}
	/********** Taking Screenshot***********/
	public static void captureScreenshot(WebDriver driver, String screenshotName) throws IOException {

		String screenshotPath =System.getProperty("user.dir") + "\\Screenshot\\";
		String fileName = screenshotName + ".jpg";
        
		TakesScreenshot s = ((TakesScreenshot) driver) ;
		File TempFile = s.getScreenshotAs(OutputType.FILE);
		Files.copy(TempFile, new File(screenshotPath + fileName));

		System.out.println("******Screenshot captured: " + fileName +"******");

	}
}










