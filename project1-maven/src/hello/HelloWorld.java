package hello;

import org.joda.time.LocalTime;
import org.joda.time.LocalDate;

public class HelloWorld {
	public static void main(String[] args)
	{
		Greeter gr = new Greeter();
		LocalTime time = new LocalTime();
		
		LocalDate date = new LocalDate();
		
		System.out.println("Aktuální čas: " + time);
		System.out.printf("Aktuální datum: " + date.getDayOfMonth() +"."+date.getMonthOfYear() +"."+ date.getYear());
		
		System.out.println("\n" + gr.sayHello());
	}

}
