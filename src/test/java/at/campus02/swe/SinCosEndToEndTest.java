package at.campus02.swe;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.Test;

import at.campus02.swe.logic.CalculatorImpl;
import at.campus02.swe.parser.Parser;

public class SinCosEndToEndTest {

    @Test
    public void sinFromXml() throws Exception {

        Calculator calc = new CalculatorImpl();
        Parser parser = new Parser(calc);
        double result = parser.parse(
                new File("src/test/resources/sin-zero.xml"));

        assertEquals(0.0, result, 1e-9);
    }

    @Test
    public void cosFromXml() throws Exception {

        Calculator calc = new CalculatorImpl();
        Parser parser = new Parser(calc);
        double result = parser.parse(
                new File("src/test/resources/cos-zero.xml"));

        assertEquals(1.0, result, 1e-9);
    }
}
