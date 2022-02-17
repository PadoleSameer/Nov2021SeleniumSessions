package seleniumsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TotalImages {

	public static WebDriver driver;
	
	public static void main(String[] args) {
	
		//WAP:
		//1. Total links
		//2. print the src
		//3. print the alt 
			
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://www.amazon.com");
		
		By allImages = By.tagName("img");
		List<WebElement> imgsList = getElements(allImages);

		System.out.println("Total Images :"+ imgsList.size());
		
		int c =0;
		for (WebElement webElement : imgsList) {
			
			String altText= webElement.getAttribute("alt");
			if (!altText.isEmpty()) {
			
				System.out.println(c+" : "+altText);
	
			}
			System.out.println(webElement.getAttribute("src"));
			c++;
		}
					
	}
	
	public static List<WebElement> getElements(By locator){
		return driver.findElements(locator);
	}
	
}