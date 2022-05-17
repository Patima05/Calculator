package com.example.calculator;

public class Calculator {

    private Double prevValue;
    private Character prevOperator;
    private String valueStr;

    public double getValue() {
        if (prevValue == null) {
            return 0;
        }
        prevValue = Double.valueOf(valueStr);
        return prevValue;
    }

    public String setValueStrInc(Character ch) {
        if (valueStr == null) valueStr = "";
        if (Character.isDigit(ch)) {
            valueStr += ch;
            return valueStr;
        }
        if (valueStr.contains(".")) {
            return valueStr;
        }
        valueStr += ch;
        return valueStr;

    }

    public double setOperator(Character operator) {

        if (valueStr == null) valueStr = "0";
        Double value = Double.valueOf(valueStr);
        if (prevOperator == null && prevValue == null) {
            prevValue = value;
            prevOperator = operator;
            valueStr = null;
            return prevValue;
        }

        if (value == null && operator == '=') {
            value = prevValue;
            operator = prevOperator;

        }

        switch (prevOperator) {
            case '+': {
                prevValue += value;
                break;
            }
            case '-': {
                prevValue -= value;
                break;
            }
            case '*': {
                prevValue *= value;
                break;
            }
            case '/': {
                prevValue /= value;
                break;
            }
        }

        prevOperator = operator;
        valueStr = null;
        return prevValue;
    }

}
