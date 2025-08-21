package masterSeleniumFramework.masterSeleniumFramework.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import masterSeleniumFramework.masterSeleniumFramework.POM.Base.Abstracts;
import masterSeleniumFramework.masterSeleniumFramework.POM.Base.BasePage;

public class CartPage extends BasePage {
 By ProductTitle = By.xpath("//td[@class=\"product-name\"]/a");
 By checkoutBtn = By.className("checkout-button");
	public CartPage(WebDriver driver) {
		super(driver);
	}
	
    public String getProductName() {
    	return driver.findElement(ProductTitle).getText();
    }
    
    public CheckoutPage goToCheckoutPage() {
    	driver.findElement(checkoutBtn).click();
    	return new CheckoutPage(driver);
    }
}
