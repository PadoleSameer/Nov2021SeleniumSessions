package seleniumsessions;

public class WaitConcept {

	public static void main(String[] args) {

		//1. Static wait : Thread.sleep(time is seconds) . Here even element gets loaded in 3 sec script will be on hold for wait time.
		//2. Dynamic wait : Timeout 10 sec for element e1 to load. if e1 gets loaded in 3 sec then remaining 7 sec will be ignored
			//2.a :Implicitly wait:
			//2.b :Explicit wait
				//2.b.1 :WebDriverWait ( class)
				//2.b.2 :FluentWait	( class)

		//WebDriverWait(C) --> extends -->  FluentWait(c) -->Implements --> Wait(I) --> Until() method
		//Until(){}							//Until(){}
		//other methods						//other methods
		
	}

}
