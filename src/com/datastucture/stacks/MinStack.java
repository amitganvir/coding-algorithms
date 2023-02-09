package com.datastucture.stacks;

import java.util.Stack;

public class MinStack {

    public static void main(String[] args) {

    }

    private Stack<Integer> minStack;
    private Stack<Integer> stack;

    public MinStack() {
        minStack = new Stack<>();
        stack = new Stack<>();
    }

    public void push(int val) {

        stack.push(val);
        int minValue = Math.min(val, minStack.isEmpty() ? val : minStack.peek());
        minStack.push(minValue);
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
