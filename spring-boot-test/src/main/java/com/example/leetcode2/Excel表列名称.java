package com.example.leetcode2;

import java.util.HashMap;

/**
 * @author yingru.ljw
 * @date 2020-02-18 01:44
 */
public class Excel表列名称 {

    public static void main(String[] args) {
        String res = new Excel表列名称().convertToTitle(47);
        System.out.println(res);
    }


    public String convertToTitle(int n) {

        StringBuilder stringBuilder = new StringBuilder();
        while (n != 0) {
            n --;//这里稍作处理，因为它是从1开始
            stringBuilder.append((char)(n % 26 + 'A'));
            n /= 26;
        }
        return stringBuilder.reverse().toString();

    }

}
