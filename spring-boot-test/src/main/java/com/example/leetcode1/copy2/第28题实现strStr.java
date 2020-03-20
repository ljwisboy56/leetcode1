package com.example.leetcode1.copy2;

/**
 * @author yingru.ljw
 * @date 2020-03-17 00:20
 */
public class 第28题实现strStr {

    public static void main(String[] args) {

        System.out.println(new 第28题实现strStr().strStr("mississippi","pi"));

    }

    /**
     * 输入: haystack = "hello", needle = "ll"
     * 输出: 2
     */
    public int strStr(String haystack, String needle) {

        if(haystack == null){
            return -1;
        }

        if(haystack.equals(needle)){
            return 0;
        }

        if("".equals(haystack.trim())){
            return -1;
        }

        int len = needle.length();

        for (int i = 0; i + len<= haystack.length(); i++) {
            System.out.println(haystack.substring(i,i+len));
            if(haystack.substring(i,i+len).equals(needle)){
                return i;
            }
        }
        return -1;
    }
}
