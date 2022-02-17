package AppTests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

//TDD - test centric approach
//Req ---> test cases --> failed --> refactor code --> passed --> test cases --> faciled---refactor -- passed

public class OrangeHrmTest extends BaseTest{
	
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
		Assert.assertTrue(header.contains("free trial"));
	}	
}
