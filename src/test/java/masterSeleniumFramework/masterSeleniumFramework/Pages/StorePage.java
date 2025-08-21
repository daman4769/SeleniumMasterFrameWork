package masterSeleniumFramework.masterSeleniumFramework.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import masterSeleniumFramework.masterSeleniumFramework.POM.Base.Abstracts;
import masterSeleniumFramework.masterSeleniumFramework.POM.Base.BasePage;

public class StorePage extends BasePage {

	private Abstracts ab;
	
	By SearchBox = By.id("woocommerce-product-search-field-0");
	By SearchButton = By.xpath("//button[@type='submit' and @value='Search']");
	By SearchedTitle = By.xpath("//h1[@class=\"woocommerce-products-header__title page-title\"]");
	By SummeryWrap = By.className("astra-shop-summary-wrap");
	By goToCartBtn = By.xpath("//a[@class=\"added_to_cart wc-forward\"]");
	
	
	
	
	public StorePage(WebDriver driver) {
		super(driver);
	}
	
	public void SearchItem(String product) {
		driver.findElement(SearchBox).sendKeys(product);
		driver.findElement(SearchButton).click();
		
	}
	public String getSearchedTitle() {
		 ab = new Abstracts();
		ab.waitforPresenceOfElement(driver,SearchedTitle);
		return driver.findElement(SearchedTitle).getText();
		
	}
	
	public void addSelectedProductedToCart(String productName) {
		ab.waitforPresenceOfElement(driver, SummeryWrap);
		int noOfproductSummeryWrap = driver.findElements(SummeryWrap).size();
		for(int i = 1 ; i <= noOfproductSummeryWrap;i++) 
		{
			String productTitle =driver.findElement(By.xpath("//li["+i+"]/div[2]/a/h2")).getText();
			if(productTitle.equals(productName)) 
			{
				driver.findElement(By.xpath("//li["+i+"]/div/a[contains(text(),\"Add to cart\")]")).click();
				break;
			}
		}
	}
	
	public CartPage goToCartFromButtonBelowSelectedproduct() {
		ab.waitforPresenceOfElement(driver, goToCartBtn);
		driver.findElement(goToCartBtn).click();
		return new CartPage(driver);
	}
	
	

}
