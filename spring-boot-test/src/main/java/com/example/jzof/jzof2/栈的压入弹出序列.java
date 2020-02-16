package com.example.jzof.jzof2;

import java.util.Stack;

/**
 * @author yingru.ljw
 * @date 2019-12-25 00:41
 */
public class 栈的压入弹出序列 {

    Stack<Integer> stack = new Stack<>();

    public boolean IsPopOrder(int [] pushA,int [] popA) {


        if(pushA.length == 0 || popA.length == 0){
            return false;
        }

        int index = 0;


        for(int value : pushA){

            stack.push(value);

            while (!stack.isEmpty()){

                if(stack.peek() == popA[index]){
                    stack.pop();
                    index++;
                }else {
                    break;
                }
            }
        }
        return stack.isEmpty();

    }

}
