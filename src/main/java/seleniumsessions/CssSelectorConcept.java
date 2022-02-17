package seleniumsessions;

import org.openqa.selenium.By;

public class CssSelectorConcept {

	public static void main(String[] args) {

		//{id} --> #id , tag#id
		// #input-email - https://demo.opencart.com/index.php?route=account/login
		// input#input-email
		
		//class --> .class
		// .form-control
		// input.form-control
		
		//Combined id and class
		// input#input-email.form-control
		// input.form-control#input-email
		// .form-control#input-email
		
		// If class and Id are not available
		// tag[type= 'submit']
		// input[type='submit']
		// input[type='submit'][value='Login']
		By.cssSelector("#input-email");
		By.cssSelector("input[type='submit']");
		
		// In case of multiple classes
		//https://app.hubspot.com/login?hubs_signup-url=www.hubspot.com%2F&hubs_signup-cta=homepage-nav-login&_ga=2.263633992.599487844.1643535631-1508259724.1643136050
		//form-control private-form__control login-email
		//form-control private-form__control login-password m-bottom-3
		//.c1.c2.c3...
		// .form-control.private-form__control.login-password.m-bottom-3
		// input.form-control.private-form__control.login-password.m-bottom-3
		// input.form-control.private-form__control.login-password.m-bottom-3#password
		
		By.cssSelector(".form-control.private-form__control.login-password.m-bottom-3");
		By.className("form-control private-form__control login-password m-bottom-3");
		//Incorrect way to define by locator.. expect only single class.
		By.xpath("//input[@class='form-control private-form__control login-email']");
		By.className("login-email");
		

		//<input type="text" name="email" value="" placeholder="E-Mail Address" id="input-email" class="form-control">
		// input[id*='Email']  -- contains
		// input[id^='input'] -- starts with
		// input[id$='email'] -- ends with
		
		//Parent to Child
		// Parent CSSselector > Child CSSselector
		// div.form-group > #input-email
		
		//finding all child elements
		// Parent CSSselector<space> Child CSSselector
		// div#content div
		
		// div#content > div -- direct child -- 1
		// div#content div -- all indirect and direct children 
		
		
		// Child to Parent : Backward travesing
		// NA
		
		// sibling in CSS
		// div.form-group label + input[id='input-email']
		
		// Index in CSS
		// ul.footer-nav li:nth-of-type(2)
		
		
		
		
		
		
		
		
		
	}

}
