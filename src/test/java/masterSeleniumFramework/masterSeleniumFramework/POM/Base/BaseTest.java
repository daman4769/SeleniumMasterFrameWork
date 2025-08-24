package masterSeleniumFramework.masterSeleniumFramework.POM.Base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import masterSeleniumFramework.masterSeleniumFramework.POM.Factory.DriverManager;

public class BaseTest {

	protected WebDriver driver;
	
	@Parameters("browser")
	@BeforeMethod
	public void startDriver(String browser) throws IOException {
		driver = new DriverManager(browser).initilizedDriver();
	}
	
	@AfterMethod
	public void closeDrier() {
		driver.close();
	}
	
	
}
