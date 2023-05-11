package SeleniumWebdriver.Assignment;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;

public class MakeMyTripLogoTest {
	
    static WebDriver driver;
    static String url = "https://www.makemytrip.com/";

    public static void main(String[] args) {
    	
        // Launch Firefox browser
        System.setProperty("webdriver.gecko.driver", "src\\test\\java\\SeleniumWebdriver\\Assignment\\Drivers\\geckodriver.exe");
        FirefoxOptions options = new FirefoxOptions();
        options.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
        driver = new FirefoxDriver(options);
        
        // Navigate to MakeMyTrip website
        driver.get(url);

        // Verify if MakeMyTrip logo is present on the page
        WebElement logoElement = driver.findElement(By.xpath("//img[@alt='Make My Trip']"));
        Assert.assertTrue(logoElement.isDisplayed(), "MakeMyTrip logo is not present on the page");
        if (logoElement.isDisplayed()) {
			
        	System.out.println("logo Verified Successfully");
		}
    

        // Close the browser
        driver.quit();	
    	
		
	}
   
}

