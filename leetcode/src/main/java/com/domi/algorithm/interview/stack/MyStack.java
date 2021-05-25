package com.domi.algorithm.interview.stack;

import java.util.Stack;

/**
 * @author domisong.
 * @description: TODO
 * @date 2021/5/25.
 */
public class MyStack {

    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public MyStack() {
        this.stackData = new Stack<Integer>();
        this.stackMin = new Stack<Integer>();
    }

    public void push(int newNum) {
        if (this.stackMin.isEmpty()) {
            this.stackMin.push(newNum);
        } else if (newNum < this.getMin()) {
            this.stackMin.push(newNum);
        } else {
            int newMin = this.stackMin.peek();
            this.stackMin.push(newMin);
        }
        this.stackData.push(newNum);
    }

    public int pop() {
        if (this.stackData.isEmpty()) {
            throw new RuntimeException("Your stack is empty.");
        }
        this.stackMin.pop();
        return this.stackData.pop();
    }

    public int getMin() {
        if (this.stackMin.isEmpty()) {
            throw new RuntimeException("Your stack is empty.");
        }
        return this.stackMin.peek();
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(3);
        myStack.push(5);
        myStack.push(7);
        myStack.push(2);

        int min = myStack.getMin();
        System.out.println("--最小值是：" + min);
    }
}
