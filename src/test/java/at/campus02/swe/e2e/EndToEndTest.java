package at.campus02.swe.e2e;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.Test;

import at.campus02.swe.Calculator;
import at.campus02.swe.CalculatorException;
import at.campus02.swe.logic.CalculatorImpl;
import at.campus02.swe.parser.Parser;

public class EndToEndTest {

    @Test
    public void testAddThenMultiply() throws Exception {
        //setup
        Calculator calc = new CalculatorImpl();
        Parser parser = new Parser(calc);

        //execute: (3 + 4) * 5 = 35
        double result = parser.parse(new File("src/test/resources/e2e01.xml"));

        //verify
        assertEquals(35, result, 0);
    }

    @Test
    public void testSubtractDivideModulo() throws Exception {
        //setup
        Calculator calc = new CalculatorImpl();
        Parser parser = new Parser(calc);

        //execute: ((20 - 8) / 4) % 2 = 3 % 2 = 1
        double result = parser.parse(new File("src/test/resources/e2e02.xml"));

        //verify
        assertEquals(1, result, 0);
    }

    @Test(expected = CalculatorException.class)
    public void testDivisionByZero() throws Exception {
        //setup
        Calculator calc = new CalculatorImpl();
        Parser parser = new Parser(calc);

        //execute: 9 / 0 -> CalculatorException
        parser.parse(new File("src/test/resources/e2e03.xml"));
    }

    @Test
    public void testDotProductLengthOne() throws Exception {
        //setup
        Calculator calc = new CalculatorImpl();
        Parser parser = new Parser(calc);

        //execute: (3) · (4) = 12
        double result = parser.parse(new File("src/test/resources/dotproduct-length-1.xml"));

        //verify
        assertEquals(12, result, 0);
    }

    @Test
    public void testDotProductLengthTwo() throws Exception {
        //setup
        Calculator calc = new CalculatorImpl();
        Parser parser = new Parser(calc);

        //execute: (1, 3) · (2, 4) = 1*2 + 3*4 = 14
        double result = parser.parse(new File("src/test/resources/dotproduct-length-2.xml"));

        //verify
        assertEquals(14, result, 0);
    }

    @Test(expected = CalculatorException.class)
    public void testDotProductInvalidLength() throws Exception {
        //setup
        Calculator calc = new CalculatorImpl();
        Parser parser = new Parser(calc);

        //execute: Länge 0 -> CalculatorException
        parser.parse(new File("src/test/resources/dotproduct-invalid-length.xml"));
    }
}
