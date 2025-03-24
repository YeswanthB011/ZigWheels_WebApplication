package TestCases;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.datadriven.framework.base.BaseUI;
import com.datadriven.framework.utils.ExtentReportManager;

import PageClasses.LoginPage;

public class TestCases extends LoginPage {

	LoginPage project = new LoginPage();
	ExtentReports report = ExtentReportManager.getReportInstance();

	/**********
	 * Invoking Browser
	 * 
	 * @throws IOException
	 *******/
	@Test(priority = 1)
	public void invokeBrowser() throws Exception {
		ExtentTest logger = report.createTest("Invoking Browser");
		try {
			project.invokeBrowser("edge");
			project.openURL("websiteURL");
			logger.log(Status.INFO, "Open the Browser");
			logger.log(Status.PASS, "Browser has been invoked successfully");
		} catch (Exception e) {
			logger.log(Status.INFO, "Error in opening the browser");
			logger.log(Status.FAIL, "Browser not Opened");
			BaseUI.captureScreenshot(driver, "Fail-to-open");
		}
	}

	/******** Selecting Honda bikes *********/
	@Test(priority=2) // (dependsOnMethods = "invokeBrowser")
	public void selectingBikes() throws Exception {
		ExtentTest logger = report.createTest("Clicking upcomming bikes");
		try {
			project.upcomingBikes();
			logger.log(Status.INFO, "Clicking upcomming bikes");
			logger.log(Status.PASS, "Upcomming bikes clicked successfuly");
		} catch (Exception e) {
			logger.log(Status.INFO, "Upcomming Bikes not Clicked");
			logger.log(Status.FAIL, e.getMessage());
			BaseUI.captureScreenshot(driver, "Fail-to-click");
		}
	}

	/******* Clicking View more *********/
	@Test(priority=3)
	public void bikesKnown() throws Exception {
		ExtentTest logger = report.createTest("Selecting Honda bikes");
		try {
			project.bikes();
			logger.log(Status.INFO, "Selecting the Honda bikes");
			logger.log(Status.PASS, "Honda Bikes Selected Sucessfuly");
		} catch (Exception e) {
			logger.log(Status.INFO, "Honda Bikes not Selected");
			logger.log(Status.FAIL, e.getMessage());
			BaseUI.captureScreenshot(driver, "Fail-to-select");
		}
	}

	/****** Clicking view more to get all bikes info *******/
	@Test(priority=4)
	public void clickViewMore() throws Exception {
		ExtentTest logger = report.createTest("Clicking view more to get all bikes");
		try {
			project.viewMore();
			logger.log(Status.INFO, "Clicking view more");
			logger.log(Status.PASS, "View more Clicked Successfuly");
		} catch (Exception e) {
			logger.log(Status.INFO, "View more not Clicked");
			logger.log(Status.FAIL, e.getMessage());
			BaseUI.captureScreenshot(driver, "View-more-Fail");
		}
	}

	/******* Getting Bikes which are less than 4 Lakhs ********/
	@Test(priority=5)
	public void bikesInfo() throws Exception {
		ExtentTest logger = report.createTest("Getting bikes data");
		try {
			project.gettingBikesInfo();
			logger.log(Status.INFO, "Gathering bike data under 4 lakhs");
			logger.log(Status.PASS, "Successfully gathered bikes data");
		} catch (Exception e) {
			logger.log(Status.INFO, "Bike details not fetched");
			logger.log(Status.FAIL, e.getMessage());
			BaseUI.captureScreenshot(driver, "not-fetched");
		}
	}

	/****** Clicking used cars in Chennai *******/
	@Test(priority=6)
	public void usedCars() throws Exception {
		ExtentTest logger = report.createTest("Navigating to used cars in chennai");
		try {
			project.usedCars();
			logger.log(Status.INFO, "Clicking used cars in chennai");
			logger.log(Status.PASS, "Used Cars in Chennai clicked Successfully");
		} catch (Exception e) {
			logger.log(Status.INFO, "Used Cars not Clicked");
			logger.log(Status.FAIL, e.getMessage());
			BaseUI.captureScreenshot(driver, "Not-select-cars");
		}

	}

	/****** Getting popular models *******/
	@Test(priority=7)
	public void popularModels() throws Exception {
		ExtentTest logger = report.createTest("Getting popular models info");
		try {
			project.popularCars();
			logger.log(Status.INFO, "Gathered popular models info");
			logger.log(Status.PASS, "Popular models fetched successfully");
		} catch (Exception e) {
			logger.log(Status.INFO, "Popular Car models not fetched");
			logger.log(Status.FAIL, e.getMessage());
			BaseUI.captureScreenshot(driver, "Not-get-models");
		}

	}

	/****** Navigating to google login page *********/
	@Test(priority=8)
	public void google() throws Exception {
		ExtentTest logger = report.createTest("Navigating to login page");
		try {
			project.googleLogin();
			logger.log(Status.INFO, "Navigating to google login");
			logger.log(Status.PASS, "Successfully Navigated to google login");
		} catch (Exception e) {
			logger.log(Status.INFO, "Error in Navigation to google login");
			logger.log(Status.FAIL, e.getMessage());
			BaseUI.captureScreenshot(driver, "not-navigate");
		}

	}

	/******* Providing invalid details ********/
	@Test(priority=9)
	public void invalidLogin() throws Exception {
		ExtentTest logger = report.createTest("Giving invalid credentials");
		try {
			project.invalidDetaiils();
			logger.log(Status.INFO, "Giving invalid credentials");
			logger.log(Status.FAIL, "User Not able to login");
			Thread.sleep(2000);
			BaseUI.captureScreenshot(driver, "invalid_details");

		} catch (Exception e) {
			
			
		}

	}

	@AfterTest
	public void endReport() throws Exception {
		ExtentTest logger = report.createTest("Closing the Browser");
		try {
			logger.log(Status.INFO, "Close the Browser");
			logger.log(Status.PASS, "Browser Closed");
			project.quitBrowser();
			report.flush();
		} catch (Exception e) {
			logger.log(Status.INFO, "Browser not closed");
			logger.log(Status.FAIL, e.getMessage());
			BaseUI.captureScreenshot(driver, "Fail-to-close");

		}

	}
}
