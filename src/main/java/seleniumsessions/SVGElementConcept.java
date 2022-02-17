package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SVGElementConcept {

	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		int i=0;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://petdiseasealerts.org/forecast-map#/");
		Thread.sleep(3000);
		
		String svgXpath = 
				"//*[local-name()='svg' and @id='map-svg']//*[name()='g' and @id='states']//*[name()='g']//*[name()='path']";
		
		List<WebElement> statesList = driver.findElements(By.xpath(svgXpath));
		Actions a = new Actions(driver);
		
		for (WebElement state : statesList) {
		
			a.moveToElement(state).perform();
			String nameAttr = state.getAttribute("name");
			System.out.println(nameAttr);
			if(nameAttr.equals("Maryland")) {
//				state.click();				
				// In case of ElementClickInterceptedException
				a.click(state).perform();
				String svgSubPath =
						"//*[local-name()='svg' and @id='map-svg']//*[name()='g' and @id='states']//*[name()='g' and @class='counties']//*[name()='path']";
				List<WebElement> subStateList = driver.findElements(By.xpath(svgSubPath));
				
				
				for (WebElement e : subStateList) {
				
					a.moveToElement(e).perform();
					i++;
				}
				break;
			}
		}
		System.out.println(i);
	}

	//xpath of search icon in flipkart
	//*[local-name()='svg']//*[name()='g' and @fill-rule='evenodd']
}
