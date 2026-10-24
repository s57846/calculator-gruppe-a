package at.campus02.swe.parser;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.*;

import at.campus02.swe.Calculator;
import at.campus02.swe.Calculator.Operation;
import at.campus02.swe.CalculatorException;


public class ParserTest {

    @Test(expected = IllegalArgumentException.class)
    public void testNullParser() {
        new Parser(null);
    }

    @Test(expected = FileNotFoundException.class)
    public void testParserInvalidFile() throws Exception {

        Calculator cal = mock(Calculator.class);

        Parser parser = new Parser(cal);
        parser.parse(new File("invalid"));
    }

    @Test
    public void testParserTest01Xml() throws Exception {

        Calculator cal = mock(Calculator.class);

        Parser parser = new Parser(cal);
        parser.parse(new File("src/test/resources/test01.xml"));

        verify(cal).push(1.0);
        verify(cal).push(2.0);
        verify(cal).perform(Operation.add);

        verifyNoMoreInteractions(cal);
    }

    @Test
    public void testParserModuloXml() throws Exception {

        Calculator cal = mock(Calculator.class);

        Parser parser = new Parser(cal);
        parser.parse(new File("src/test/resources/test04.xml"));

        verify(cal).push(10.0);
        verify(cal).push(3.0);
        verify(cal).perform(Operation.mod);

        verifyNoMoreInteractions(cal);
    }

    @Test
    public void testParserModuloByZeroXml() throws Exception {

        Calculator cal = mock(Calculator.class);
        when(cal.perform(Operation.mod))
                .thenThrow(new CalculatorException("Division by zero"));

        Parser parser = new Parser(cal);
        try {
            parser.parse(new File("src/test/resources/test05.xml"));

            fail("Exception expected");
        } catch (CalculatorException e) {
            assertEquals("Division by zero", e.getMessage());
        }

        verify(cal).push(7.0);
        verify(cal).push(0.0);
        verify(cal).perform(Operation.mod);

        verifyNoMoreInteractions(cal);
    }

    @Test
    public void testParserSinXml() throws Exception {

        Calculator cal = mock(Calculator.class);

        Parser parser = new Parser(cal);
        parser.parse(new File("src/test/resources/sin-zero.xml"));

        verify(cal).push(0.0);
        verify(cal).perform(Operation.sin);

        verifyNoMoreInteractions(cal);
    }

    @Test
    public void testParserCosXml() throws Exception {

        Calculator cal = mock(Calculator.class);

        Parser parser = new Parser(cal);
        parser.parse(new File("src/test/resources/cos-zero.xml"));

        verify(cal).push(0.0);
        verify(cal).perform(Operation.cos);

        verifyNoMoreInteractions(cal);
    }
}