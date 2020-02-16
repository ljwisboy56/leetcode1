package com.example.jzof.jzof2;

import java.util.Stack;

/**
 * @author yingru.ljw
 * @date 2019-12-22 19:35
 */
public class 两个栈实现一个队列 {


    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        int res ;
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        res = pop();
        while (!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return res;
    }


}
