package com.example.leetcode3;

/**
 * @author yingru.ljw
 * @date 2020-02-27 21:04
 */

import java.util.LinkedList;
import java.util.Stack;

public class 字符串转整数 {

    public int calculate(String exp) {

        LinkedList<String> res = backTempExp(exp);

        return calRst(res);

    }

    private int doCalCulCate(LinkedList<String> res) {

        String[] strings = new String[res.size()];

        for (int i = 0; i < res.size() ; i++) {
            strings[i] = res.get(i);
        }

        return evalRPN(strings);

    }

    // 计算后缀表达式
    public static LinkedList<String> backTempExp(String exp) {

        Stack<String> stack =new Stack<>();
        LinkedList<String> list = new LinkedList<>();
        for (int i = 0; i < exp.length(); i++) {
            //1、遇到了数字
            if(Character.isDigit(exp.charAt(i))){
                int k=i + 1;
                for (; k < exp.length() && Character.isDigit(exp.charAt(k)); k++) {

                }
                String tmp = exp.substring(i,k);
                i = k -1;
                list.add(tmp);
                continue;
            }
            if(exp.charAt(i) == '/' || exp.charAt(i) == '*'){
                while (!stack.isEmpty() && (stack.lastElement().equals("/") || stack.lastElement().equals("*"))) {
                    list.add(stack.pop()); // 弹出优先级相同或以上的栈内运算符
                }
                //运算符入栈
                stack.add(String.valueOf(exp.charAt(i)));
                continue;
            }
            if(exp.charAt(i) == '+' || exp.charAt(i) == '-'){
                while (!stack.isEmpty() && !isNumeric(stack.lastElement())){
                    list.add(stack.pop());
                }
                //运算符入栈
                stack.add(String.valueOf(exp.charAt(i)));
                continue;
            }
        }
        // 4.最后弹出栈内所有元素到表达式
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        return list;

    }

    public static boolean isNumeric(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

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

    public static int calRst(LinkedList<String> tempBackExp) {
        Stack<Integer> calStk = new Stack<Integer>();
        for (String c : tempBackExp) {
            // 1.数字，入栈
            if (isNumeric(c)) {
                calStk.push(Integer.valueOf(c)); // string to int
                continue;
            }
            // 2.非数字，则为符号，出栈两个元素计算出结果然后再入栈该计算值
            else {
                int a = calStk.pop();
                int b = calStk.pop();
                switch (c.toCharArray()[0]) {
                    // 注意减法和除法时，注意出栈的顺序与原表达式是相反的

                    case '+':
                        calStk.push(b + a);
                        continue;
                    case '-':
                        calStk.push(b - a);
                        continue;
                    case '*':
                        calStk.push(b * a);
                        continue;
                    case '/':
                        calStk.push(b / a);
                        continue;
                }
            }
        }
        return calStk.pop();
    }







}

