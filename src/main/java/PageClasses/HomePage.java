package PageClasses;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.datadriven.framework.base.BaseUI;

public class HomePage extends BaseUI{
	/********* Clicking Upcoming Bikes *********/
	public void upcomingBikes() {
		WebElement newBikes = getElement("newBikes_Xpath");
		Actions action = new Actions(driver);
		action.moveToElement(newBikes).perform();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement upComing = getElement("upcomingBikes_Xpath");
		wait.until(ExpectedConditions.visibilityOf(upComing));
		action.moveToElement(upComing).click().perform();
	}

}
