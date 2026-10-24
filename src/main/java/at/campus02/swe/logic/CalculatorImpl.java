package at.campus02.swe.logic;


import at.campus02.swe.Calculator;
import at.campus02.swe.CalculatorException;

import java.util.Stack;

public class CalculatorImpl implements Calculator {

    private Stack<Double> stack_ = new Stack<Double>();

    @Override
    public double perform(Operation op) throws CalculatorException {
      
        // sin and cos only need one value
        if (op == Operation.sin)
            return Math.sin(pop());
        if (op == Operation.cos)
            return Math.cos(pop());
        if (op == Operation.dotproduct)
            return dotProduct();


        double b = pop();
        double a = pop();

        switch (op) {
            case add:
                return a + b;
            case sub:
                return a - b;
            case div:
                double c = a / b;
                if (Double.isInfinite(c))
                    throw new CalculatorException("Division by zero");
                return c;
            case mul:
                return a * b;
            case mod:
                if (b == 0)
                    throw new CalculatorException("Division by zero");
                return a % b;
        }
        return 0;
    }

    private double dotProduct() throws CalculatorException {
        double count = pop();
        if (count < 1 || count != Math.floor(count) || Double.isInfinite(count))
            throw new CalculatorException("Invalid vector length");

        if (stack_.size() < 2 * count)
            throw new CalculatorException("Not enough values");

        int n = (int) count;
        double[] second = new double[n];
        for (int i = n - 1; i >= 0; i--)
            second[i] = pop();

        double result = 0;
        for (int i = n - 1; i >= 0; i--)
            result += pop() * second[i];
        return result;
    }

    @Override
    public double pop() throws CalculatorException {
        if (stack_.isEmpty())
            throw new CalculatorException();
        return stack_.pop();
    }

    @Override
    public void push(double v) {
        stack_.push(v);
    }

    @Override
    public void clear() {
        stack_.clear();
    }

}
