package masterSeleniumFramework.masterSeleniumFramework;

import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import masterSeleniumFramework.masterSeleniumFramework.POM.Base.BasePage;
import masterSeleniumFramework.masterSeleniumFramework.POM.Base.BaseTest;
import masterSeleniumFramework.masterSeleniumFramework.Pages.CartPage;
import masterSeleniumFramework.masterSeleniumFramework.Pages.CheckoutPage;
import masterSeleniumFramework.masterSeleniumFramework.Pages.HomePage;
import masterSeleniumFramework.masterSeleniumFramework.Pages.StorePage;
import testData.billingAdressDetails;
import utils.JectionUtils;
import utils.propertieUtils;

public class firstTest extends BaseTest{
	
@Test(priority = 1)
public void CheckoutwithDirectbanktransfer() throws IOException, InterruptedException {
	billingAdressDetails BillingAdressDetails =
		    JectionUtils.deserializeJsonFromResource("myBillingAddress.json");
	propertieUtils PropertieUtils = new propertieUtils();
	BasePage basePage = new BasePage(driver);
	basePage.loadPage("https://askomdch.com/");
	WebDriverWait wait  = new WebDriverWait(driver,Duration.ofSeconds(10));
	HomePage homePage = new HomePage(driver);
	StorePage storePage = homePage.clickOnShopPage();
	storePage.SearchItem("Blue");
	Assert.assertEquals(storePage.getSearchedTitle(),"Search results: “Blue”");
	storePage.addSelectedProductedToCart("Blue Denim Shorts");
	 CartPage cartpage =storePage.goToCartFromButtonBelowSelectedproduct();
     Assert.assertEquals(cartpage.getProductName(), PropertieUtils.getProperty("product"));
     CheckoutPage checkoutPage = cartpage.goToCheckoutPage();
     checkoutPage.addAdddress2(BillingAdressDetails);
     Thread.sleep(5000);
	checkoutPage.checkoutwithDirectBankTransfer();
	
	}
@Test(priority = 2 )
public void CheckoutwithCOD() throws InterruptedException {
	BasePage basePage = new BasePage(driver);
	basePage.loadPage("https://askomdch.com/");
	HomePage homePage = new HomePage(driver);
	StorePage storePage = homePage.clickOnShopPage();
	storePage.SearchItem("Blue");
	Assert.assertEquals(storePage.getSearchedTitle(),"Search results: “Blue”");
	storePage.addSelectedProductedToCart("Blue Denim Shorts");
	 CartPage cartpage =storePage.goToCartFromButtonBelowSelectedproduct();
     Assert.assertEquals(cartpage.getProductName(), "Blue Denim Shorts");
     CheckoutPage checkoutPage = cartpage.goToCheckoutPage();
     checkoutPage.addAdddress("Aman", "deep", "vill get", "ran", "Ranchi", "93599", "d1234@gmail.com","India");
     checkoutPage.checkoutwithCOD();
}

@Test(priority= 3)
public void conformSearchFuncinility() {
	BasePage basePage = new BasePage(driver);
	basePage.loadPage("https://askomdch.com/");
	HomePage homePage = new HomePage(driver);
	StorePage storePage= homePage.clickOnShopPage();
	storePage.SearchItem("Blue");
	Assert.assertEquals(storePage.getSearchedTitle(), "Search results: “Blue”" , "Search Fiunctionlity is not working");
	
}

}
