package com.example.leetcode1.leetcodecopy1;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author yingru.ljw
 * @date 2020-01-19 23:36
 */
public class 整数翻转 {

    public static void main(String[] args) {
        int res = new 整数翻转().reverse(1534236469);
        System.out.println(res);
    }

    public int reverse(int x) {
        try {
            String[] strings = String.valueOf(x).split("");

            if(strings[0].equals("-")){
                String[] tmp = Arrays.copyOfRange(strings,1,strings.length);
                return - Integer.valueOf(doReverse(tmp));
            }else {
                return Integer.valueOf(doReverse(strings));
            }
        }catch (Exception e){
            return 0;
        }

    }

    private String doReverse(String[] strings){

        Stack<String> stack = new Stack<>();
        for (String s : strings){
            stack.push(s);
        }

        String res = "";
        while (!stack.isEmpty()){
            res += stack.pop();
        }
        return res;
    }

}
