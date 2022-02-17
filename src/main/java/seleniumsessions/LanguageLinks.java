package seleniumsessions;

import java.sql.DriverManager;
import java.util.List;

import org.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi.ecCVCDSA;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LanguageLinks {

	public static WebDriver driver;

	public static void main(String[] args) {
		// //div[@id='SIvCob']/a

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		//1. Google language search
		//driver.get("https://www.google.co.in/");
		//By lang = By.xpath("//div[@id='SIvCob']/a");		
		//clickOnLink(lang,"मराठी");
		
		//2. Google footer search
//		driver.get("https://www.google.co.in/");
//		By lang = By.xpath("//div[@jscontroller='NzU6V']//a");	
//		clickOnLink(lang,"test");
		
		//3. Freshworks footer search
		driver.get("https://www.freshworks.com/");
		By footerLinks = By.xpath("//ul[@class='footer-nav']//a");	
		clickOnLink(footerLinks,"Partners");
	}

	public static void clickOnLink(By locator, String linkText) {

		List<WebElement> langLinks = driver.findElements(locator);

		System.out.println(langLinks.size());

		for (WebElement wElement : langLinks) {
			String text = wElement.getText();
			String link = wElement.getAttribute("href");
			System.out.println(text);
			System.out.println(link);

			if (text.contains(linkText)) {
				wElement.click();
				break;
			}
		}
	}
}