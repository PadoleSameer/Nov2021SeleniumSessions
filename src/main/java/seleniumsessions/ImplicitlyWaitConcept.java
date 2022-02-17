package seleniumsessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImplicitlyWaitConcept {

	public static void main(String[] args) {

		//Implicitly Wait
		// Its as dynamic wait
		// Its only applicable for WebElements : FindElement and FindElements
		// Not applicable for Non WebElements : title , url, alert
		// Global Wait: Once its applied it will be applicable for all the 
		// Upcoming web elements
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver =  new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Login Page
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		
		//10 sec
		WebElement emailId = driver.findElement(By.id("input-email"));
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//5 sec
		WebElement pwd = driver.findElement(By.id("input-password"));
		
		//e3 -- 5
		//e4 -- 5
		
		//homepage : 20 secs
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//HE1
		//HE2
		//HE3
		//Click on logout --landing on login page
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Click on reg page : 0 secs
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
		//RE1
		//RE2
		
		
		
		
		
		
		
		
	}
}
