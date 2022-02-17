package mytests;

import org.testng.annotations.Test;

public class EcommTest {

	//Test NG will execute test cases in alphabetical order if priority is not defined.
	//If all test cases have same priority then test cases will be executed in alphabetical order.
	//In case if suite has non-priority based and priority based test cases then non-priority based test cases 
	//are executed first in alphabetical order
	
	
	@Test( priority = 1)
	public void loginTest() {
		System.out.println("LoginTest");
	}
	
	@Test(priority = 2)
	public void homeTest() {
		System.out.println("homeTest");
	}
	
	@Test(priority = 3)
	public void cartTest() {
		System.out.println("cartTest");
	}
	
	@Test(priority = 4)
	public void searchTest() {
		System.out.println("searchTest");
	}
	
	@Test
	public void m1Test() {
		System.out.println("m1Test");
	}
	
	@Test
	public void m2Test() {
		System.out.println("m2Test");
	}
}