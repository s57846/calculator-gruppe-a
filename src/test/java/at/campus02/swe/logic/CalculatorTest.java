package at.campus02.swe.logic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import at.campus02.swe.Calculator;
import at.campus02.swe.CalculatorException;
import at.campus02.swe.Calculator.Operation;

public class CalculatorTest {

    @Test
    public void testSimpleAddOperation() throws Exception {

        //setup
        Calculator calc = new CalculatorImpl();

        //execute
        calc.push(2.0);
        calc.push(3);
        double result = calc.perform(Operation.add);

        //verify
        assertEquals(5, result, 0);


    }

    @Test
    public void testSimpleMulOperation() throws Exception {

        Calculator calc = new CalculatorImpl();
        calc.push(2.0);
        calc.push(3);
        double result = calc.perform(Operation.mul);

        assertEquals(6, result, 0);

    }

    @Test
    public void testSimpleDivOperation() throws Exception {

        Calculator calc = new CalculatorImpl();
        calc.push(6.0);
        calc.push(2);
        double result = calc.perform(Operation.div);

        assertEquals(3, result, 0);

    }

    @Test
    public void testSimpleModOperation() throws Exception {

        Calculator calc = new CalculatorImpl();
        calc.push(7.0);
        calc.push(3);
        double result = calc.perform(Operation.mod);

        assertEquals(1, result, 0);

    }

    @Test
    public void testModOperationWithoutRemainder() throws Exception {

        Calculator calc = new CalculatorImpl();
        calc.push(8.0);
        calc.push(4);
        double result = calc.perform(Operation.mod);

        assertEquals(0, result, 0);

    }

    @Test
    public void testModOperationNegativeDividend() throws Exception {

        Calculator calc = new CalculatorImpl();
        calc.push(-7.0);
        calc.push(3);
        double result = calc.perform(Operation.mod);

        assertEquals(-1, result, 0);

    }

    @Test
    public void testModuloByZero() throws Exception {

        Calculator calc = new CalculatorImpl();
        try {
            calc.push(7);
            calc.push(0);
            calc.perform(Operation.mod);

            fail("Exception expected");

        } catch (CalculatorException e) {
            assertEquals("Division by zero", e.getMessage());
        }

    }

    @Test
    public void sinOfZero() throws CalculatorException {

        Calculator calc = new CalculatorImpl();
        calc.push(0);
        double result = calc.perform(Operation.sin);

        assertEquals(0.0, result, 1e-9);

    }

    @Test
    public void sinOfHalfPi() throws CalculatorException {

        Calculator calc = new CalculatorImpl();
        calc.push(Math.PI / 2);
        double result = calc.perform(Operation.sin);

        assertEquals(1.0, result, 1e-9);

    }

    @Test
    public void cosOfZero() throws CalculatorException {

        Calculator calc = new CalculatorImpl();
        calc.push(0);
        double result = calc.perform(Operation.cos);

        assertEquals(1.0, result, 1e-9);

    }

    @Test
    public void cosOfPi() throws CalculatorException {

        Calculator calc = new CalculatorImpl();
        calc.push(Math.PI);
        double result = calc.perform(Operation.cos);

        assertEquals(-1.0, result, 1e-9);

    }

    @Test(expected = CalculatorException.class)
    public void sinOnEmptyStack() throws CalculatorException {

        Calculator calc = new CalculatorImpl();
        calc.perform(Operation.sin);

    }

    @Test(expected = CalculatorException.class)
    public void cosOnEmptyStack() throws CalculatorException {

        Calculator calc = new CalculatorImpl();
        calc.perform(Operation.cos);

    }




    //
    @Test(expected = CalculatorException.class)
    public void testPopOnEmptyStack() throws Exception {

        Calculator calc = new CalculatorImpl();
        calc.pop();

    }

    @Test
    public void testDivisionByZero() throws Exception {

        //Setup
        Calculator calc = new CalculatorImpl();
        try {
            calc.push(2);
            calc.push(0);
            calc.perform(Operation.div);

            fail("Exception expected");


        } catch (CalculatorException e) {
            assertEquals("Division by zero", e.getMessage());
            // e.getCause()
        }

    }
}