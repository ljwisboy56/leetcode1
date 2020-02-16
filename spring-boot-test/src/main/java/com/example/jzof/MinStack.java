package com.example.jzof;


import java.util.Stack;

/**
 * @author yingru.ljw
 * @date 2019-12-01 00:55
 */
public class MinStack {


    Stack<Integer> dataStack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();


    public void push(int node) {
        dataStack.push(node);
        if(minStack.isEmpty() || minStack.peek() > node){
            minStack.push(node);
        }else {
            minStack.push(minStack.peek());
        }

    }


    public void pop() {
        dataStack.pop();
        minStack.pop();
    }

    public int top() {
        return dataStack.peek();
    }

    public int min() {
        return minStack.peek();
    }

}
