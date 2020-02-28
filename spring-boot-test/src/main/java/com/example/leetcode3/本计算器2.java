package com.example.leetcode3;

import java.util.Stack;

/**
 * @author yingru.ljw
 * @date 2020-02-27 20:41
 */
public class 本计算器2 {

    public static void main(String[] args) {

        System.out.println(new 本计算器2().convertStr("123"));

    }


    private int convertStr(String str){
        int res = 0;
        for (int i = str.length()-1,n = 1; i >=0; i--,n *= 10) {
            res += (str.charAt(i) - '0') * n;
        }
        return res;

    }

    public int calculate(String s) {
       return 1;
    }

}
