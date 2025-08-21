package masterSeleniumFramework.masterSeleniumFramework.POM.Base;

import org.openqa.selenium.WebDriver;

public class BasePage extends Abstracts{
	protected WebDriver driver;

	public BasePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void loadPage(String URL) {
		driver.get(URL);
	}
}
