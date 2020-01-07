package com.example.jzof;

import java.util.Stack;

/**
 * @author yingru.ljw
 * @date 2019-12-01 15:45
 */
public class IsPopOrder {



    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA.length == 0 || popA.length == 0){
            return false;
        }
        Stack<Integer> stack =new Stack<>();

        int index = 0;

        for (int value : pushA) {

            stack.push(value);

            while (!stack.isEmpty()) {
                if (stack.peek() == popA[index]) {
                    stack.pop();
                    index++;
                } else {
                    break;
                }
            }
        }
        return stack.isEmpty();


    }

}
