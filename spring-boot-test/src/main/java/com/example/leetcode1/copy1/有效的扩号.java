package com.example.leetcode1.copy1;

import java.util.Stack;

/**
 * @author yingru.ljw
 * @date 2020-02-01 23:00
 */
public class 有效的扩号 {

    /**
     * 条件： （（（（）））
     * 如果
     * @param s
     * @return
     */
    public boolean isValid(String s) {

        if(s == null || "".equals(s.trim())){
            return true;
        }

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length();i++){

            char tmp = s.charAt(i);

            if(tmp == '(' || tmp == '[' || tmp == '{'){
                stack.push(tmp);
            }else {
                if(stack.isEmpty()){
                    return false;
                }else {
                    if(tmp == ')'){
                        if(stack.pop() != '('){
                            return false;
                        }
                    }
                    if(tmp == ']'){
                        if(stack.pop() != '['){
                            return false;
                        }
                    }
                    if(tmp == '}'){
                        if(stack.pop() != '{'){
                            return false;
                        }
                    }
                }
            }
        }

        return stack.isEmpty();

    }
}
