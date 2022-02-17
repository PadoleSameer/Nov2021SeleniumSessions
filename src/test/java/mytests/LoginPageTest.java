package mytests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginPageTest {
	
	@DataProvider
	public Object[][] loginTestData() {
		
		return new Object[][] {
		
			{"admin@gmail.com", "admin123"},
			{"customer@gmail.com", "customer123"},
			{"vendor@gmail.com", "vendor123"},
			{"admin@gmail.com", "@@@#123"},
			{"@@@#123@gmail.com", "admin123"},
			{"", ""},
			{null ,null },
		};		
	}
	
	@Test(dataProvider = "loginTestData")
	public void loginTest(String userName, String password) {
	Assert.assertTrue(doLogin(userName, password));	
	}

	public boolean doLogin(String userName, String password) {
		System.out.println("User name : "+userName);
		System.out.println("Pasword   : "+password);
		System.out.println("Login Sucessfull");
		return true;
	}
}