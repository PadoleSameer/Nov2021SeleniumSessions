package AppTests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleTest extends BaseTest {
	
	@Test(priority = 1)
	public void googleTitleTest() {
			Assert.assertEquals(driver.getTitle(),"Google");
	}
	
	@Test(priority = 2, enabled = false)
	public void googleSearchTest() {
		driver.findElement(By.name("q")).sendKeys("Hello World");		
		Assert.assertTrue(true);
	}
}
