package com.example.leetcode1;

import java.util.HashSet;

/**
 * @author yingru.ljw
 * @date 2019-12-30 17:50
 */
public class 最长回文子串 {

    public static void main(String[] args) {
        String abc = "babad";

        String res = new 最长回文子串().longestPalindrome(abc);

        System.out.println(res);

    }

    HashSet<String> set = new HashSet<>();


    public String longestPalindrome(String s) {

        if(s == null || "".equals(s)){
            return "";
        }

        int len = s.length();

        int[][] dp = new int[len][len];

        int max =0;

        int start =0;

        int end=0;

        for (int right = 0; right < len; right++) {
            for (int left = 0; left <= right; left++) {
                if(s.charAt(right) == s.charAt(left) && (right - left <=2) || dp[left+1][right-1] == 1){
                    dp[left][right] = 1;
                    set.add(s.substring(left,right+1));
                }
            }
        }

        return s.substring(start,end+1);


    }

    private boolean judge(char[] chars){
        int length = chars.length;

        int start = 0;
        int end = length-1;
        if(length % 2 ==0){
            while (end - start != 1){
                if(chars[start++] == chars[end--]){
                    continue;
                }else {
                    return false;
                }
            }
        }else {
            while (start != end){
                if(chars[start++] == chars[end--]){
                    continue;
                }else {
                    return false;
                }
            }
        }
        return true;
    }

}
