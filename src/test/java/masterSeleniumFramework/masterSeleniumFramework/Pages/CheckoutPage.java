package masterSeleniumFramework.masterSeleniumFramework.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import masterSeleniumFramework.masterSeleniumFramework.POM.Base.Abstracts;
import masterSeleniumFramework.masterSeleniumFramework.POM.Base.BasePage;
import testData.billingAdressDetails;

public class CheckoutPage extends  BasePage{
	
	@FindBy(id="billing_first_name")
	WebElement firstNameFild;
	
	@FindBy(id="billing_last_name")
	WebElement lastNameFild;
	
	@FindBy(id="billing_address_1")
	WebElement addressLine1Fild;
	
	@FindBy(id="billing_address_2")
	WebElement addressLine2Fild;
	
	@FindBy(id="billing_city")
	WebElement cityFild;
	
	@FindBy(id="billing_postcode")
	WebElement postCodeFild;

	@FindBy(id="billing_email")
	WebElement emailFild;
	
	@FindBy(id="select2-billing_country-container")
	WebElement CountrytextBox;
	
	@FindBy(xpath="//ul[@id='select2-billing_country-results']/li")
	List<WebElement> listOfCountryinDropDown;
	
	By CountryNameInputBox = By.className("select2-search__field");
	
	
	By placeOrderButton = By.id("place_order");
	By CODRadioBtn = By.id("payment_method_cod");
	
	Abstracts   ab = new Abstracts();
	
	public CheckoutPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	private void selectCountryFromDromDown(String country) {
		CountrytextBox.click();
		ab.waitforPresenceOfElement(driver,CountryNameInputBox);
		driver.findElement(CountryNameInputBox).sendKeys(country);
		for(WebElement e : listOfCountryinDropDown) {
			if(e.getText().equalsIgnoreCase(country)) {
				e.click();
				break;
			}
		}
	}
	
public void addAdddress(String firstName, String lastName,String addressLine1,String addressLine2,String city,String post,String email,String country) {
	firstNameFild.sendKeys(firstName);
	lastNameFild.sendKeys(lastName);
	addressLine1Fild.sendKeys(addressLine1);
	addressLine2Fild.sendKeys(addressLine2);
	selectCountryFromDromDown(country);
	cityFild.sendKeys(city);
	postCodeFild.sendKeys(post);
	emailFild.sendKeys(email);
} 

public void addAdddress2(billingAdressDetails BillingAdressDetails) {
	
	firstNameFild.sendKeys(BillingAdressDetails.getFirstName());
	lastNameFild.sendKeys(BillingAdressDetails.getLastName());
	addressLine1Fild.sendKeys(BillingAdressDetails.getAddressLine1());
	addressLine2Fild.sendKeys(BillingAdressDetails.getAddressLine2());
	cityFild.sendKeys(BillingAdressDetails.getCity());
	postCodeFild.sendKeys(BillingAdressDetails.getPost());
	emailFild.sendKeys(BillingAdressDetails.getEmail());
//	return BillingAdressDetails;
} 	
  public void checkoutwithDirectBankTransfer() {
	
	  ab.waitforPresenceOfElement(driver, placeOrderButton);
	  driver.findElement(placeOrderButton).click();
  }
  
  public void checkoutwithCOD() throws InterruptedException {
	  Thread.sleep(2000);
	  ab.waitforElementToBeClickble(driver, CODRadioBtn);
	  driver.findElement(CODRadioBtn).click();
	  ab.waitForVisibilityOfEkemente(driver, placeOrderButton);
	  driver.findElement(placeOrderButton).click();
  }
  }
