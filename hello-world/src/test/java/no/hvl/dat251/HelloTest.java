package no.hvl.dat251;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class HelloTest {
	
	@Test
	public void shouldSayHelloToName() {
		Helloer helloer = new Helloer();
		assertEquals("Hello Per!", helloer.sayHelloTo("Per"));
	}
	
}