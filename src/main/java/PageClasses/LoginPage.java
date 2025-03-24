package PageClasses;



import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;



public class LoginPage extends ChennaiPage {
	/****** Navigating to google login page *********/
	public void googleLogin() {
		elementClick("homePage_Xpath");
		elementClick("login_Xpath");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement google = getElement("google_Xpath");
		google.click();

	}

	/******* Providing invalid details ********/
	public void invalidDetaiils() throws InterruptedException {
		switchToWindows(1);
		Thread.sleep(3000);
		WebElement email = getElement("email_Xpath");
		email.sendKeys("hkasb@gmail.co", Keys.ENTER);
		

	}
}
