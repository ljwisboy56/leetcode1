package com.example.leetcode3;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yingru.ljw
 * @date 2020-02-27 17:01
 */
public class MyStack {

    Queue<Integer> queue1 = new LinkedList<>();
    Queue<Integer> queue2 = new LinkedList<>();


    /** Initialize your data structure here. */
    public MyStack() {

    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue1.add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int res = 0;
        while (queue1.size() != 1){
            queue2.add(queue1.poll());
        }
        res =  queue1.poll();
        while (!queue2.isEmpty()){
            queue1.add(queue2.poll());
        }
        return res;
    }

    /** Get the top element. */
    public int top() {
        int res = 0;
        while (queue1.size() != 1){
            queue2.add(queue1.poll());
        }
        int cur = queue1.poll();
        while (!queue2.isEmpty()){
            queue1.add(queue2.poll());
        }
        queue1.add(cur);
        return cur;

    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.isEmpty();
    }

}
