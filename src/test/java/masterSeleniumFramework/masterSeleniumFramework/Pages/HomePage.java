package masterSeleniumFramework.masterSeleniumFramework.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import masterSeleniumFramework.masterSeleniumFramework.POM.Base.BasePage;

public class HomePage extends BasePage {
	
	By ShopNow = By.xpath("//div[@class=\"wp-block-button\"]/a");

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public StorePage clickOnShopPage() {
		driver.findElement(ShopNow).click();
		return new StorePage(driver);
	}
}
