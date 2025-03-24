package PageClasses;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HondaBikes extends HomePage {
	/******** Selecting Hondabikes *********/
	public void bikes() {
		Select select = new Select(getElement("honda_Id"));
		select.selectByVisibleText("Honda");
	}

	/******* Clicking ViewMore *********/
	public void viewMore() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement view = getElement("view_Xpath");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", view);
		js.executeScript("arguments[0].click()", view);
	}

	/******* Getting Bikes which are less than 4 Lakhs ********/
	public void gettingBikesInfo() {
		List<WebElement> bikes11 = driver.findElements(By.xpath("//strong[@class='lnk-hvr block of-hid h-height']"));

		List<WebElement> priceTag = driver.findElements(By.xpath("//div[@class='b fnt-15']"));

		List<WebElement> Date = driver.findElements(By.xpath("//div[@class='clr-try fnt-14']"));

		for (int i = 0; i < bikes11.size(); i++) {

			WebElement bikeElement = bikes11.get(i);
            WebElement priceElement = priceTag.get(i);
            WebElement dateElement = Date.get(i);

			String bikeName = bikeElement.getText();

			double bikePriceText = extractPriceValue(priceElement.getText());

			String dateLaunch = dateElement.getText();

			if (bikePriceText < 4.0) {
				
                  System.out.println("Bike Name: " + bikeName);
                  System.out.println("Price: " + bikePriceText + " Lakhs");
                  System.out.println(dateLaunch);

			}

		}

		System.out.println("-------------------------");

	}

	public static double extractPriceValue(String priceText) {

		String numericValue = priceText.replaceAll("[^\\d.]", "");
		String[] parts = numericValue.split("\\.");
		StringBuilder stringBuilder = new StringBuilder();

		for (String part : parts) {
			stringBuilder.append(part);
		}
		return Double.parseDouble(stringBuilder.toString()) / 100;

	}

	/****** Clicking usedcars in Chennai *******/
	public void usedCars() throws Exception {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,-1800)");

		WebElement UsedCars = getElement("usedCars_Xpath");
		Actions action = new Actions(driver);
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(UsedCars));
		
		
		action.moveToElement(UsedCars).perform();
		Thread.sleep(3000);
		elementClick("chennai_Xpath");
	}

}
