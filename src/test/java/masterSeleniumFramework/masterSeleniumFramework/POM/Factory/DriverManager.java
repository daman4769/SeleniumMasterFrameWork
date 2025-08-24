package masterSeleniumFramework.masterSeleniumFramework.POM.Factory;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import utils.propertieUtils;

public class DriverManager {

    WebDriver driver;
    String browser;
    public DriverManager(String browser) {
    	this.browser = browser;
    }
   
    public WebDriver initilizedDriver() throws IOException {   
  
      
//        
//        String localbrowser = (System.getProperty("Browser") != null) 
//                ? System.getProperty("Browser") 
//                : propertieUtils.getProperty("browser");
        
        String localbrowser = (System.getProperty("Browser") != null) 
                ? System.getProperty("Browser") 
                : browser;

        if (localbrowser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            driver = new ChromeDriver(options);
        }
        else if(localbrowser.equalsIgnoreCase("edge")) {
        	 System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"/src/msedgedriver.exe");
        	driver = new EdgeDriver();
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        return driver;
    }
}
