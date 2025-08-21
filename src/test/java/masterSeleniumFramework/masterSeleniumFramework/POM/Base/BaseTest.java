package masterSeleniumFramework.masterSeleniumFramework.POM.Base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import masterSeleniumFramework.masterSeleniumFramework.POM.Factory.DriverManager;

public class BaseTest {

	protected WebDriver driver;
	
	@BeforeMethod
	public void startDriver() throws IOException {
		driver = new DriverManager().initilizedDriver();
	}
	
	@AfterMethod
	public void closeDrier() {
		driver.close();
	}
	
	
}
