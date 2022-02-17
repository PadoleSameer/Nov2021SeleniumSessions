package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleDropDownWithoutUsingSelect {

	public static WebDriver driver;
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		
		By countryList = By.xpath("//select[@name='Country']/option");
		By stateList = By.id("Form_submitForm_State");
		
		List<WebElement> ctryList = driver.findElements(countryList);
		
		for (WebElement ctry : ctryList) {
		
			String ctryName = ctry.getText();
			if(ctryName.equalsIgnoreCase("india")) {
				
				ctry.click();
				break;
			}
		}
	}
}