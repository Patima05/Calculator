package com.example.calculator;

public class Calculator {

    private double prevValue;
    private Character prevOperator;
    private String valueStr;

    public Calculator() {
        this.prevValue = 0;
    }

    public String setValueStr(Character ch) {
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

        if (operator == 'c'){
            prevOperator = null;
            prevValue = 0;
            valueStr = null;
            return 0;
        }

        if (valueStr == null) valueStr = "0";

        double value = Double.valueOf(valueStr);

        if (prevOperator == null && prevValue == 0) {
            prevValue = value;
            prevOperator = operator;
            valueStr = null;
            return prevValue;
        }

        if (value == 0 && operator == '=') {
            value = prevValue;
            operator = prevOperator;
        }

        switch (operator) {
            case '%': {
                prevValue = value * 0.01;
                prevOperator = null;
                valueStr = String.valueOf(prevValue);
                return prevValue;
            }
            case 's': {
                prevValue = - value;
                prevOperator = null;
                valueStr = String.valueOf(prevValue);
                return prevValue;
            }
        }
        switch (prevOperator) {
            case '+': {
                prevValue += value;
                prevOperator = operator;
                break;
            }
            case '-': {
                prevValue -= value;
                prevOperator = operator;
                break;
            }
            case '*': {
                prevValue *= value;
                prevOperator = operator;
                break;
            }
            case '/': {
                prevValue /= value;
                prevOperator = operator;
                break;
            }
        }

        valueStr = null;
        return prevValue;
    }

}