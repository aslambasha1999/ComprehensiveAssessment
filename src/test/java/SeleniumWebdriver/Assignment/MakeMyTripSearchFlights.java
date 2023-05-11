package SeleniumWebdriver.Assignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MakeMyTripSearchFlights {
	
    static WebDriver driver;

    	public static void main(String[] args) throws InterruptedException {
			
    	// Set path for chromedriver.exe
    	System.setProperty("webdriver.chrome.driver", "src\\test\\java\\SeleniumWebdriver\\Assignment\\Drivers\\chromedriver.exe");
    	
    	// Set binary path for Google Chrome
    	ChromeOptions options = new ChromeOptions();
    	options.setBinary("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
    	
    	// Launch Google Chrome browser
    	driver = new ChromeDriver(options);
    	
        // Maximize browser window and navigate to MakeMyTrip homepage
        driver.manage().window().maximize();
        driver.get("https://www.makemytrip.com/");
    
    	
    	// Click on Flights tab
    	WebElement flights = findElementByXPath("//a[@class='makeFlex hrtlCenter column active']");
    	flights.click();
    	Thread.sleep(1000);
    	
    	// Select one-way trip option if it's not already selected
    	WebElement oneWayTrip = findElementByXPath("//li[@data-cy='oneWayTrip']");
    	if(!(oneWayTrip.isSelected())) {
    		
    		oneWayTrip.click();	
		}
    	
    	// Enter "New Delhi" in the "From" input box and select the suggestion
    	WebElement fromCityBox = findElementByXPath("//input[@id='fromCity']");
    	fromCityBox.sendKeys("New Delhi");
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	WebElement fromSuggestionList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@role='listbox']")));
    	List<WebElement> fromSuggestions=driver.findElements(By.xpath("//li[@role='option']"));
    	for(WebElement item:fromSuggestions)
    	{
    		if(item.getText().contains("DEL, Indira Gandhi International Airport India"))
    		{
    			item.click();
    		}
    	}
    	
    	// Enter "Bengaluru" in the "To" input box and select the suggestion
    	WebElement toCity = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='toCity']")));
    	toCity.click();
    	WebElement toCityInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='To']")));
    	toCityInput.sendKeys("Bengaluru");
    	Thread.sleep(2000);
    	WebElement enterToCity=findElementByXPath("(//li[@data-suggestion-index='0'])[1]");
    	enterToCity.click();
    	
    	// Select today's date in the calendar
    	WebElement selectTodayDate = driver.findElement(By.cssSelector("div[class*='today']"));
    	selectTodayDate.click();
    	
    	// Click on the search button
    	WebElement searchBtn=findElementByXPath("//a[contains(text(),'Search')]");
    	searchBtn.click();
    	Thread.sleep(1000);


  
        // Quit the browser
        driver.quit();

    	}
    	
    public static WebElement findElementByXPath(String xpath) {
        // Utility method to find an element by its XPath
        return driver.findElement(By.xpath(xpath));
    }
}
