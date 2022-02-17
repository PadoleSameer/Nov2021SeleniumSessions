package mytests;

import org.testng.annotations.Test;

public class DependsOnMethodsConcept {
	
	@Test
	public void loginTest() {
		System.out.println("Login to app");
		int i = 9/0;
	}
	
	@Test(dependsOnMethods = "loginTest")
	public void homeTest() {
	
		System.out.println("HomeTest");
	}
	
	@Test(dependsOnMethods = "loginTest")
	public void searchTest() {
	
		System.out.println("SearchTest");
	}
	
	//test should be independent ... not to be dependent
	//try to avoid priority
	//always define the assertion - act vs exp = validation point/check point
	//CRUD
	
	
	
}


