package com.example.calculator;

import java.util.Stack;

public class Calculator {
	
	public String calculate(String input) throws Exception{
		String[] comArray = input.split(" ");					
		Stack<Double> values = new Stack<>(); // 
		Operation op = null;
		Double m = Double.parseDouble(comArray[0]);
		values.push(m);
		
		for(int i = 1; i < comArray.length; i++) {
			if(i%2==1) {				
				if(comArray[i].equals(op.ADD.getOperationSymbol())) 			// ADD
					values.push(Double.parseDouble(comArray[i+1]));
				if(comArray[i].equals(op.SUBTRACT.getOperationSymbol())) 	// SUBTRACT
					values.push(-Double.parseDouble(comArray[i+1]));
				if(comArray[i].equals(op.MULTIPLY.getOperationSymbol())) { 	// MULTIPLY
					double num = values.peek();
					values.pop();
					values.push(num * Double.parseDouble(comArray[i+1]));
				}
				if(comArray[i].equals("/")) { 								// DIVIDE
					 double divisor = Double.parseDouble(comArray[i+1]);  
					 if(divisor == 0)
						 throw new Exception("Infinity");
					 double dividend = values.peek(); 
					 values.pop(); 
					 values.push(dividend/divisor);  
				}
			}
		}
		
		double sum = 0;
		while(!values.isEmpty()) {		// Calculate sum from stack
			sum += values.peek();
			values.pop();
		}
		
		String result = String.valueOf(sum);
		return result;
	}
}