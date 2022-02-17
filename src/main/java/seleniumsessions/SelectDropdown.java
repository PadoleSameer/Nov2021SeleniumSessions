package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectDropdown {

	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");

		By country = By.id("Form_submitForm_Country");
		By state = By.id("Form_submitForm_State");

//		WebElement country_ele = driver.findElement(country);
//		WebElement state_ele = driver.findElement(state);
//		
//		Select ctry_select = new Select(country_ele);
//		Select state_select = new Select(state_ele);
//		
		// ctry_select.selectByIndex(5);// Value at index 5 gets selected.
		// ctry_select.selectByVisibleText("India"); //visible text are the values
		// available in drop down - Value passed gets selected.
		// ctry_select.selectByValue("United Kingdom");//if value attribute is available
		// for that option then it can be selected.

		// Thread.sleep(3000);
		// state_select.selectByVisibleText("Maharashtra");

		doSelectByIndex(country, 5);
		doSelectByVisibleText(country, "India");
		Thread.sleep(3000);
		doSelectByValue(state, "Maharashtra");
		selectValueFromDropDown(state, "Manipur");
	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public static void doSelectByIndex(By locator, int index) {

		Select dropDown = new Select(getElement(locator));
		dropDown.selectByIndex(index);
	}

	public static void doSelectByVisibleText(By locator, String text) {

		Select dropDown = new Select(getElement(locator));
		dropDown.selectByVisibleText(text);
	}

	public static void doSelectByValue(By locator, String value) {

		Select dropDown = new Select(getElement(locator));
		dropDown.selectByValue(value);
	}

	public static void selectValueFromDropDown(By locator, String value) {

		Select select = new Select(getElement(locator));

		List<WebElement> optionsList = select.getOptions();

		for (WebElement wElement : optionsList) {
			String optionsText = wElement.getText();
			if (optionsText.equals(value)) {
				wElement.click();
				break;
			}
		}
	}
}
