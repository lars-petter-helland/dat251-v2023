/* 
 * For more information on how to use JUnit5, see
 * https://junit.org/junit5/docs/current/user-guide/
 */

package no.hvl.dat251;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assumptions.assumingThat;

import java.util.logging.Logger;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class TemperatureConverterTest {
	
//	static {		
//		System.setProperty("java.util.logging.SimpleFormatter.format", 
//				"[%1$tF %1$tT] [%4$-7s] %5$s %n");
//	
//	}
	
	TemperatureConverter tc = new TemperatureConverter();

	@BeforeEach
	void runBeforeEachTest() {
		Logger.getGlobal().info("Some output");
	}
	
	@Test
	void zeroCelsiusShouldBe27315Kelvin() {
		assertEquals(273.15, tc.celciusToKelvin(0.0));
		assertEquals(273.15, tc.celciusToKelvin(0.0), "Incorrect conversion");
		assertEquals(273.15, tc.celciusToKelvin(0.0), () -> "Lazy! Incorrect conversion");
		assertEquals(273.15, tc.celciusToKelvin(0.0), Double.MIN_VALUE);
		assertEquals(273.15, tc.celciusToKelvin(0.0), Double.MIN_VALUE, "Incorrect conversion");
		assertEquals(273.15, tc.celciusToKelvin(0.0), Double.MIN_VALUE, () -> "Lazy! Incorrect conversion");
	}
	
	@Test
	void oneHundredCelsiusShouldBe37315Kelvin() {
		assertEquals(373.15, tc.celciusToKelvin(100.0));
	}

	@ParameterizedTest(name = "{0} C should be {1} K")
	@CsvSource({"0.0, 273.15",
		        "-10.0, 263.15",
		        "-273.15, 0.0",
		        "-274.15, -1.0",
				"100.0, 373.15"})
	void someCelsiusShouldBeOtherKelvin(double celcius, double kelvin) {
		
//		assumeTrue(celcius >= -273.15);
//		assertEquals(kelvin, tc.celciusToKelvin(celcius));
		
		assumingThat(celcius >= -273.15, 
				() -> assertEquals(kelvin, tc.celciusToKelvin(celcius)));
	}
	
	@Test
	void minus274CelsiusShouldThrowException() {
		Throwable exception = assertThrows(IllegalArgumentException.class, 
				() -> tc.celciusToKelvin(-274.0));
		assertEquals("The temperature can not be below the absolute zero.", 
				exception.getMessage());
	}

}







