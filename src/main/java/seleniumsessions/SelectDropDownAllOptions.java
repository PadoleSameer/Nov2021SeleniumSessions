package seleniumsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectDropDownAllOptions {

public static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		
		By country = By.id("Form_submitForm_Country");
		By state = By.id("Form_submitForm_State");
		
//		Select select = new Select(driver.findElement(country));
//		
//		List<WebElement> optionsList = select.getOptions();
//		System.out.println(optionsList.size());
//		
//		int c =0;
//		for (WebElement wElement : optionsList) {
//			String countryName = wElement.getText();
//			//System.out.println(c+" :"+countryName);
//			if(countryName.equalsIgnoreCase("india")) {
//				System.out.println("India is at index: "+c);
//				break;
//			}
//			c++;
//		}
		System.out.println(getDropDownOptionsList(country));
		
		if(getDropDownOptionsList(country).contains("India")) {
			System.out.println("India is present in the dropdown");
		}
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static List<String> getDropDownOptionsList(By locator) {
		Select select = new Select(driver.findElement(locator));
		
		List<WebElement> optionsList = select.getOptions();
		List<String> optionsTextList = new ArrayList<String>();
	
		for (WebElement wElement : optionsList) {
			
			String optionsText = wElement.getText();
			optionsTextList.add(optionsText);
		}
		return optionsTextList;
	}
}