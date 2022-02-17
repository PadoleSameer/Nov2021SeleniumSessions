package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSearchTest {

	public static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.google.co.in/");
		
		driver.findElement(By.name("q")).sendKeys("test automation test");
		Thread.sleep(3000);
		
		List<WebElement> searchList = 
				driver.findElements(By.xpath("//ul[@role='listbox']//div[@class='wM6W7d']//span"));
		
		for (WebElement wElement : searchList) {	
			
			String searchText = wElement.getText(); 
			System.out.println(searchText);
			if(searchText.contains("test automation vs automated testing")) {
				wElement.click();
				break;
			}
		}
	}
}
