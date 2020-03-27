package com.example.leetcode2.copy2;

import java.util.Stack;

/**
 * @author yingru.ljw
 * @date 2020-03-27 15:44
 */
public class 第150题逆波兰表达式求值 {

    /**
     * 输入: ["2", "1", "+", "3", "*"]
     * 输出: 9
     * 解释: ((2 + 1) * 3) = 9
     */
    public int evalRPN(String[] tokens) {

        Stack<String> stack = new Stack<>();

        for(String str : tokens){
            if("+".equals(str)){
                String s1 = stack.pop();
                String s2 = stack.pop();
                stack.push(String.valueOf(Integer.valueOf(s2) + Integer.valueOf(s1)));
            }else if("-".equals(str)){
                String s1 = stack.pop();
                String s2 = stack.pop();
                stack.push(String.valueOf(Integer.valueOf(s2) - Integer.valueOf(s1)));
            }else if("*".equals(str)){
                String s1 = stack.pop();
                String s2 = stack.pop();
                stack.push(String.valueOf(Integer.valueOf(s2) * Integer.valueOf(s1)));
            }else if("/".equals(str)){
                String s1 = stack.pop();
                String s2 = stack.pop();
                stack.push(String.valueOf(Integer.valueOf(s2) / Integer.valueOf(s1)));
            }else {
                stack.push(str);
            }
        }
        return Integer.valueOf(stack.pop());

    }

}
