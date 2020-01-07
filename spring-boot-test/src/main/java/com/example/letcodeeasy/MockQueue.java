package com.example.letcodeeasy;

import java.util.Stack;

/**
 * @author yingru.ljw
 * @date 2019-11-22 13:47
 */
public class MockQueue {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.add(node);
    }

    public int pop() {
        int res ;
        while (!stack1.isEmpty()){
            stack2.add(stack1.pop());
        }

        res = stack2.pop();
        while (!stack2.isEmpty()){
            stack1.add(stack2.pop());
        }
        return res;

    }

}
