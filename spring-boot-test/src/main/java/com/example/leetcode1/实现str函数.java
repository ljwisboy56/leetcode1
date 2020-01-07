package com.example.leetcode1;

import java.util.Arrays;

/**
 * @author yingru.ljw
 * @date 2020-01-04 20:56
 */
public class 实现str函数 {

    public static void main(String[] args) {

        int a = new 实现str函数().strStr("abcc","cc");
        System.out.println(a);


    }

    /**
     * 滑动窗口
     */
    public int strStr(String haystack, String needle) {
        if(haystack.equals("") || needle.equals("")){
            return 0;
        }

        char[] originStr = haystack.toCharArray();
        char[] needStr = needle.toCharArray();

        for (int i = 0;i < originStr.length;i++){
            char[] tmp = Arrays.copyOfRange(originStr,i,i+needStr.length);
            if(juege(needStr,tmp)){
                return i;
            }
        }
        return -1;

    }

    private boolean juege(char[] needStr, char[] tmp) {
       return new String(needStr).equals(new String(tmp));
    }
}
