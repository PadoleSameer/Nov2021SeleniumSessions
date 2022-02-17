package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JqueryDropDownHandle {

	public static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");

		driver.findElement(By.id("justAnInputBox")).click();

		By choiceList = By.xpath("//span[@class='comboTreeItemTitle']");

		// tc_1 : Single selection
		// selectChoice(choiceList, "choice 8");

		// tc_2 : Multiple selection
		selectChoice(choiceList, "choice 6 1", "choice 6 2", "choice 8");

		// tc_3 : all selection
		// selectChoice(choiceList, "all");

	}

	public static void selectChoice(By locator, String... choice) {

		List<WebElement> choicesList = driver.findElements(locator);
		int i = 0;
		boolean flag = false;
		if (!choice[0].equalsIgnoreCase("all")) {

			for (WebElement ele : choicesList) {

				String text = ele.getText();
				System.out.println(text);

				for (i = 0; i < choice.length; i++) {

					if (choice[i].equals(text)) {
						ele.click();
						flag = true;
						break;
					} else {
						flag = false;
					}
				}
			}
			if (flag == false) {
				System.out.println("Choice is not available :" + choice[i]);
			}

		} else { // all selection
			try {
				for (WebElement ele : choicesList) {
					flag = true;
					ele.click();
				}
			} catch (ElementNotInteractableException e) {
				System.out.println("All choices are over");
			}
		}
	}
}