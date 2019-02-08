package hello;

import org.joda.time.LocalTime;

public class HelloWorld {
	public static void main(String[] args)
	{
		Greeter gr = new Greeter();
		LocalTime time = new LocalTime();
		
		System.out.println("Aktuální čas" + time);
		
		System.out.println(gr.sayHello());
	}

}
