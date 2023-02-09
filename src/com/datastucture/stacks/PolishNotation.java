package com.datastucture.stacks;

import java.util.Arrays;
import java.util.Stack;

public class PolishNotation {

    public static void main(String[] args) {
        PolishNotation polishNotation = new PolishNotation();
        polishNotation.evalRPN(new String[]{"4", "13", "5", "/", "+"});
    }

    public int evalRPN(String[] tokens) {

        if (tokens.length == 1) return Integer.parseInt(tokens[0]);
        int result = 1;

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            String element = tokens[i];

            if (isMathematicalOperand(element)) {
                int secondElement = stack.pop();
                int firstElement = stack.pop();

                result = mathOperation(firstElement, secondElement, element);
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(element));
            }
        }

        System.out.println(Arrays.toString(tokens) + " --> " + result);
        return result;
    }

    private int mathOperation(int firstNumber, int secondNumber, String operator) {

        if (operator.equals("+")) return firstNumber + secondNumber;
        if (operator.equals("-")) return firstNumber - secondNumber;
        if (operator.equals("*")) return firstNumber * secondNumber;

        return firstNumber / secondNumber;

    }

    private boolean isMathematicalOperand(String s) {
        return s.equals("*") || s.equals("/") || s.equals("+") || s.equals("-");
    }
}
