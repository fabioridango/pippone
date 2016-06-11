
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Driver.WebDrivers;


public class GoogleFind {

	public static void main(String[] args) {
		
	// Create Driver
	WebDrivers.CreateDriver();
			
	// Load browser
	WebDriver driver = null;
	try {
	  driver = WebDrivers.GetDriver();
			
	 }catch (Exception e) {
		e.printStackTrace();
	 }
		
	// Maximize browser
	driver.manage().window().maximize();
		
	//Test case GoogleSignIn
	GoogleFind testGoogle = new GoogleFind();
    try {
    	testGoogle.GoogleSignIn(driver);
	} catch (Exception e) {
		e.printStackTrace();
	}
       
    //Close driver
  	WebDrivers.QuitDriver();
	}

	
	public void GoogleSignIn(WebDriver driver) throws Exception { 
		
	// Open Application
	driver.get("https://www.google.com/ncr"); 	
	
	// Wait element signin 
	WebElement signInElement = (new WebDriverWait(driver, 60)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='gb_70']")));
	driver.findElement(By.xpath("//*[@id='gb_70']")).click();
	
	// Insert don't valid user name
	WebElement emailElement = (new WebDriverWait(driver, 60)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='Email']")));
	driver.findElement(By.xpath("//*[@id='Email']")).sendKeys("test@libero.com");
	
	// Next step 
	WebElement stepElement = (new WebDriverWait(driver, 60)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='next']")));
	driver.findElement(By.xpath("//*[@id='next']")).click();
	
	// Open default page
	driver.get("https://www.google.com/"); 
	Thread.sleep(2000);
	
	// Insert the word to search
	WebElement searchElement = (new WebDriverWait(driver, 60)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='lst-ib']")));
    driver.findElement(By.xpath("//*[@id='lst-ib']")).sendKeys("PewPow");
    Thread.sleep(2000);
    
    // Search the word
	WebElement searchWordElement = (new WebDriverWait(driver, 60)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='sblsbb']/button/span")));
    driver.findElement(By.xpath("//*[@id='sblsbb']/button/span")).click();
    
    // Return to default page
    driver.get("https://www.google.com/");
    Thread.sleep(1000);
	}
}
