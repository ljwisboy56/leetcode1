package com.example.leetcode3;

import java.util.Stack;

/**
 * @author yingru.ljw
 * @date 2020-02-28 11:32
 */
public class MyQueue {

    Stack<Integer> stack1= new Stack<>();
    Stack<Integer> stack2= new Stack<>();

    /** Initialize your data structure here. */
    public MyQueue() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while (stack1.size() != 1){
            stack2.push(stack1.pop());
        }
        int res = stack1.pop();
        while (!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return res;

    }

    /** Get the front element. */
    public int peek() {
        while (stack1.size() != 1){
            stack2.push(stack1.pop());
        }
        int res = stack1.peek();
        while (!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return res;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.isEmpty();
    }

}
