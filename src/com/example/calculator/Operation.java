package com.example.calculator;

public enum Operation {
    ADD("+"),
    SUBTRACT("-"),
    MULTIPLY("*"),
    DIVIDE("/");

    private final String symbol;

    Operation(String symbol) {
        this.symbol = symbol;
    }

    public String getOperationSymbol() {
        return symbol;
    }
    
    public static Operation getOperation(String symbol) {
        for (Operation op : Operation.values()) {
            if (op.getOperationSymbol().equals(symbol)) {
                return op;
            }
        }
        throw new IllegalArgumentException("Invalid operation symbol: " + symbol);
    }
}
