package masterSeleniumFramework.masterSeleniumFramework.POM.Factory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverManager {

	public WebDriver initilizedDriver() {
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--headless=new");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		return driver;
	}

}
