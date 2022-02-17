package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchSugg {

public static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("plants for home");
		Thread.sleep(3000);
		
		selectSuggestion("artificial plant");
	}
	
	public static void selectSuggestion(String suggestion) {
		
		driver.findElement(
				By.xpath("//div[@class='s-suggestion-container']//span[contains(text(),'"+suggestion+"')]"))
		.click();
	}
}