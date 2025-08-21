package masterSeleniumFramework.masterSeleniumFramework.POM.Base;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Abstracts {
     
	WebDriver driver;
	WebDriverWait wait;
	
	
	public void waitforPresenceOfElement(WebDriver driver,By locater) {
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(locater));
	}
	
	public void waitforElementToBeClickble(WebDriver driver,By locater) {
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(locater));
	}
	
	public void waitForVisibilityOfEkemente(WebDriver driver,By locater) {
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locater));
	}
	
}
