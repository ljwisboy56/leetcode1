package com.example.leetcode1;

import java.util.Stack;

/**
 * @author yingru.ljw
 * @date 2020-01-01 23:35
 */
public class 有效的括号 {


    public static void main(String[] args) {
        boolean res = new 有效的括号().isValid("]");
        System.out.println(res);

        Stack<Character> stack = new Stack<>();
        Character c = stack.peek();
        System.out.println(c);

    }

    public boolean isValid(String s) {
        if(s == null){
            return true;
        }

        char[] chars = s.toCharArray();

        Stack<Character> stack = new Stack<>();

        for(char c : chars){
            if(c == '[' || c == '{' || c =='('){
                stack.push(c);
            }else {
                if(!stack.isEmpty()){
                    char tmp = stack.pop();
                    if(c == ']' && tmp != '['){
                        return false;
                    }
                    if(c == '}' && tmp != '{'){
                        return false;
                    }
                    if(c == ')' && tmp != '('){
                        return false;
                    }
                }else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }


}
