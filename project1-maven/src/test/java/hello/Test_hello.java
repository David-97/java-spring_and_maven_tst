package hello;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.containsString;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class Test_hello 
{

	Greeter g = new Greeter();
	
    @Test
    public void sayinghello()
    {
        assertThat( g.sayHello(), containsString("Hello World"));
    }
}
