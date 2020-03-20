package com.example.leetcode1.copy2;

import java.util.Collections;
import java.util.HashSet;

/**
 * @author yingru.ljw
 * @date 2020-03-03 19:32
 */
public class 最长回文子串 {

    public static void main(String[] args) {
        String res = new 最长回文子串().longestPalindrome("babad");
        System.out.println(res);

    }


    HashSet<String> set = new HashSet<>();
    public String longestPalindrome(String s) {
        if(s == null || "".equals(s)){
            return "";
        }

        int len = s.length();

        int[][] dp = new int[len][len];

        for (int right = 0; right < len; right++) {
            for (int left = 0; left <= right; left++) {
                if (s.charAt(left) == s.charAt(right) && (right - left <= 2 || dp[left + 1][right - 1] ==1)) {
                    dp[left][right] = 1;
                    set.add(s.substring(left,right+1));
                }
            }
        }

        String res = "";
        for(String ss : set){
            if(ss.length() > res.length()){
                res = ss;
            }
        }
        return res;
    }

}
