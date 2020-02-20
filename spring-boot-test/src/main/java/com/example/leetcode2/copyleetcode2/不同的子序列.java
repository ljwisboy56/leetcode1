package com.example.leetcode2.copyleetcode2;

/**
 * @author yingru.ljw
 * @date 2020-02-20 00:59
 */
public class 不同的子序列 {


    /**
     * dp(i,j) 表示s的前i个字符，由t的前j个字符组成的最大个数 ；
     * 当s(i) = t(j)的时候，dp(i,j)= dp(i-1,j-1);
     * 当s(i) != t(j)的时候，dp(i,j)= dp(i,j-1);
     *
     *
     */
    public int numDistinct(String s, String t) {

        int[][] dp = new int[s.length()+1][t.length()+1];

        dp[0][0] = 1;

        for (int i = 1; i < s.length(); i++) {
            dp[i][0] = 1;
        }

        for (int i =1;i < s.length();i++){
            for (int j = 1; j < t.length(); j++) {
                if(s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + dp[i][j-1];
                }else {
                    dp[i][j] = dp[i][j-1];
                }

            }
        }

        return dp[s.length()][t.length()];


    }

}
