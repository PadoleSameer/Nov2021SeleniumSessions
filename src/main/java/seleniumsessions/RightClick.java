package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RightClick {

	public static WebDriver driver;
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
		
		WebElement ele = driver.findElement(By.xpath("//span[text()=\"right click me\"]"));
		//WebElement copy = driver.findElement(By.xpath("//li[@class='context-menu-item context-menu-icon context-menu-icon-copy context-menu-visible']"));
		
		Actions act = new Actions(driver);
	
		// right click
		act.contextClick(ele).perform();
		//Performs a context-clock at middle of the given element
		//First performs mouse move to the location of the element.
		
		//right click and select option
		List<WebElement> optionsList =
				driver.findElements(By.xpath("//ul[@class='context-menu-list context-menu-root']/li[contains(@class,'context-menu-icon')]"));
		
		for (WebElement option : optionsList) {
		
			String text = option.getText();
			if(text.equals("Copy")) {
				option.click();
				break;
			}
		}
	}
}
