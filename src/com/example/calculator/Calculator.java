package com.example.calculator;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Calculator {
	
	private static boolean isNumber(String val) {
        try {
            Double.parseDouble(val);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
	
	public static double calculate(Operation operation, double num1, double num2) throws Exception {
        switch (operation) {
            case ADD:
                return num1 + num2;
            case SUBTRACT:
                return num1 - num2;
            case MULTIPLY:
                return num1 * num2;
            case DIVIDE:
                if (num2 != 0) {
                    return num1 / num2;
                } else {
                    throw new Exception("Division can't be zero");
                }
            default:
                throw new IllegalArgumentException("Invalid operation: " + operation);
        }
    }
	
	
	// Return the priority of operation
    private int precedence(Operation op) {
        switch (op) {
            case ADD:
            case SUBTRACT:
                return 1;
            case MULTIPLY:
            case DIVIDE:
                return 2;
            default:
                return 0;
        }
    }
    
    // Take the input string and separate numbers and operators
    private double applyOperation(Stack<Double> values, Stack<Operation> operators) throws Exception {
        double b = values.pop();
        double a = values.pop();
        Operation op = operators.pop();
        return calculate(op, a, b);
    }
	
	public double handleExpression(String input) throws Exception{

		String[] commandArray = input.split(" ");
        Stack<Double> values = new Stack<>();
        Stack<Operation> operators = new Stack<>();
        Map<String, Operation> operationsMap = new HashMap<>();
        for (Operation op : Operation.values()) {
            operationsMap.put(op.getOperationSymbol(), op);
        }

        for (String val : commandArray) {
            if (isNumber(val)) {
                values.push(Double.parseDouble(val));
            } else {
                Operation op = operationsMap.get(val);
                while (!operators.isEmpty() && precedence(operators.peek()) >= precedence(op)) {
                    double result = applyOperation(values, operators);
                    values.push(result);
                }
                operators.push(op);
            }
        }

        while (!operators.isEmpty()) {
            double result = applyOperation(values, operators);
            values.push(result);
        }

        return values.pop();
    }
}