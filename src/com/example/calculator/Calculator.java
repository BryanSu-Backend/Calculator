package com.example.calculator;

import java.util.Stack;

public class Calculator {
	
	private static boolean isNumber(String token) {
        try {
            Double.parseDouble(token);
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
	
	public double handleExpression(String input) throws Exception{
		String[] comArray = input.split(" ");			
        double result = Double.parseDouble(comArray[0]);
        
        for (int i = 1; i < comArray.length; i += 2) {
            String operationSymbol = comArray[i];
            double nextNumber = Double.parseDouble(comArray[i + 1]);
            Operation operation = Operation.getOperation(operationSymbol);
            result = calculate(operation, result, nextNumber);
        }
        
        return result;
	}
}