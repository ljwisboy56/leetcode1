package com.example.leetcode2.copy2;

/**
 * @author yingru.ljw
 * @date 2020-03-25 22:29
 */
public class 第132题分割回文串2 {

    public int minCut(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = -1;

        for(int i = 1; i <= n; i++){
            dp[i] = i;
            for(int j = 0; j < i; j++){
                if(isPal(s.substring(j, i))){
                    dp[i] = Math.min(dp[j] + 1, dp[i]);
                }
            }
        }
        return dp[n];
    }

    boolean isPal(String s){
        int left = 0, right = s.length() - 1;
        while(left < right){
            if(s.charAt(left++) != s.charAt(right--)){
                return false;
            }
        }
        return true;
    }



}
