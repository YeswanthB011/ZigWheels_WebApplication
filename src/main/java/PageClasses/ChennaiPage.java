package PageClasses;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChennaiPage extends HondaBikes{
	/****** Getting popular models *******/
	public void popularCars() throws InterruptedException {
		Thread.sleep(3000);
		List<WebElement> popularCars = driver
				.findElements(By.xpath("/html/body/div[10]/div/div[1]/div[1]/div[1]/div[2]/ul/li[2]/div[2]/div[5]"));
		
		JavascriptExecutor jse = (JavascriptExecutor) driver ;
		jse.executeScript("window.scrollBy(0,600)");
		Thread.sleep(4000);
		
		WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfAllElements(popularCars));
		
		Thread.sleep(3000);
		
		System.out.println("Popular car models: ");
		
		for (int i = 0; i < popularCars.size(); i++) {
			System.out.println(popularCars.get(i).getText());
		}
	}
}
