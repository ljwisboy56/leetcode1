package com.example.leetcode2;

import java.util.Stack;

/**
 * @author yingru.ljw
 * @date 2020-02-16 19:00
 */
public class 逆波兰表达式求值 {

    public static void main(String[] args) {
        String[] strings = new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        int res = new 逆波兰表达式求值().evalRPN(strings);
        System.out.println(res);


    }


    /**
     * 输入: ["2", "1", "+", "3", "*"]
     * 输出: 9
     * 解释: ((2 + 1) * 3) = 9
     * @param tokens
     * @return
     */
    public int evalRPN(String[] tokens) {

        if(tokens == null || tokens.length == 0){
            return 0;
        }

        Stack<String> stack = new Stack<>();

        for (String str : tokens){
            if(str.equals("+")){
                String s1 = stack.pop();
                String s2 = stack.pop();
                String s3 = String.valueOf(Integer.valueOf(s2)+Integer.valueOf(s1));
                stack.push(s3);
            }else if(str.equals("-")){
                String s1 = stack.pop();
                String s2 = stack.pop();
                String s3 = String.valueOf(Integer.valueOf(s2)-Integer.valueOf(s1));
                stack.push(s3);
            }else if(str.equals("/")){
                String s1 = stack.pop();
                String s2 = stack.pop();
                String s3 = String.valueOf(Integer.valueOf(s2)/Integer.valueOf(s1));
                stack.push(s3);
            }else if(str.equals("*")){
                String s1 = stack.pop();
                String s2 = stack.pop();
                String s3 = String.valueOf(Integer.valueOf(s2)*Integer.valueOf(s1));
                stack.push(s3);
            }else {
                stack.push(str);
            }
        }
        return Integer.valueOf(stack.pop());
    }

}
