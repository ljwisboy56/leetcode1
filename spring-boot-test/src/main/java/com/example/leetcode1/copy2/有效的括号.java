package com.example.leetcode1.copy2;

import java.util.Stack;

/**
 * @author yingru.ljw
 * @date 2020-03-04 23:46
 */
public class 有效的括号 {


    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     *
     * 有效字符串需满足：
     */
    public boolean isValid(String s) {

        if(s == null || "".equals(s)){
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for(Character character : s.toCharArray()){
            char tmp = character;
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
