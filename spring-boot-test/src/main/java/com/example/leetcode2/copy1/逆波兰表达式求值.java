package com.example.leetcode2.copy1;

import java.util.Stack;

/**
 * @author yingru.ljw
 * @date 2020-02-22 15:43
 */
public class 逆波兰表达式求值 {

    public int evalRPN(String[] tokens) {

        if(tokens == null || tokens.length == 0){
            return 0;
        }

        int res = 0;

        Stack<String> statck = new Stack<>();

        for(String str : tokens){
            if("+".equals(str)){
                String s1 = statck.pop();
                String s2 = statck.pop();
                res = Integer.valueOf(s2) + Integer.valueOf(s1);
                statck.push(String.valueOf(res));
            }
            else if("-".equals(str)){
                String s1 = statck.pop();
                String s2 = statck.pop();
                res = Integer.valueOf(s2) - Integer.valueOf(s1);
                statck.push(String.valueOf(res));
            }
            else if("*".equals(str)){
                String s1 = statck.pop();
                String s2 = statck.pop();
                res = Integer.valueOf(s2) * Integer.valueOf(s1);
                statck.push(String.valueOf(res));
            }
            else if("/".equals(str)){
                String s1 = statck.pop();
                String s2 = statck.pop();
                res = Integer.valueOf(s2) / Integer.valueOf(s1);
                statck.push(String.valueOf(res));
            }else {
                statck.push(str);
                res =Integer.valueOf(str);
            }

        }
        return res;

    }
}
