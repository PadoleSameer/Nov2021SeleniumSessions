package mytests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHrmTestBM {

WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
	}
	
	@Test(priority = 1)
	public void logoTest() {
		boolean flag = driver.findElement(By.className("nav-logo")).isDisplayed();
		Assert.assertTrue(flag);
	}
	
	@Test(priority = 2)
	public void ContactSalesLinkTest() {
		boolean flag = driver.findElement(By.linkText("CONTACT SALES")).isDisplayed();
		Assert.assertTrue(flag);
	}
	
	@Test(priority = 4)
	public void pageTitleTest() {
		String title = driver.getTitle();
		System.out.println("Page Tile : " +title);
		Assert.assertEquals(title, "Sign Up for a Free HR Software Trial | OrangeHRM");
	}
	
	@Test(priority = 3)
	public void headerTest() {
		String header = driver.findElement(By.xpath("// div[@class='try-it-text']/h1")).getText();
		//System.out.println("Header : " +header);
		Assert.assertTrue(header.contains("free trial111"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
