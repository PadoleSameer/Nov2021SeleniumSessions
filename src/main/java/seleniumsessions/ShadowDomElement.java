package seleniumsessions;

import java.sql.DriverManager;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ShadowDomElement {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://selectorshub.com/xpath-practice-page/");
		
		// Hierarchy of the this page is
		//BR- Page - iFrame - ShowdowDom- input
		
		// First we should switch to iFrame.
		driver.switchTo().frame("pact");
		
		//Js Path
		// document.querySelector("#snacktime").shadowRoot.querySelector("#tea")
		// we should use Java executor to execute above java script
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		//Execute will retrun HTML Dom element. As we need webelement it is type casted to web element.
		WebElement chai=  (WebElement) js.executeScript("return document.querySelector(\"#snacktime\").shadowRoot.querySelector(\"#tea\")");
		chai.sendKeys("Masala Chai");
		
	}

}
