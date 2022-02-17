package seleniumsessions;

public class CustomXpath {

	public static void main(String[] args) {

		//Xpath: address of the element in the HTML DOM.
		//absolute xpath : /html/body/div[2]/div[1]/ul[3]/li[2]/a
		//This is not preferred one. Any change in webelement location will make xpath useless.
		//Relative xpath : custom xpath : Can be created using diff functions,properties and xpath axes.
		//This is preferred one. 
		
		
		//input[@id='input-email']
		//input[@id='input-email' and @name='email']
		//input[@type='submit' and @value='Login']
		
	}

}
