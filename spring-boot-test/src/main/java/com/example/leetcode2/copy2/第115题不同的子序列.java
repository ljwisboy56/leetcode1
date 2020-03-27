package com.example.leetcode2.copy2;

/**
 * @author yingru.ljw
 * @date 2020-03-23 10:42
 */
public class 第115题不同的子序列 {

    /**
     * 输入: S = "rabbbit", T = "rabbit"
     * 输出: 3
     */
    public int numDistinct(String s, String t) {
        if(s == null || t == null){
            return 0;
        }

        if("".equals(s) || "".equals(t)){
            return 0;
        }

        int[][] dp = new int[t.length()+1][s.length()+1];

        for (int i =0;i < s.length();i++){
            dp[0][i] = 1;
        }

        for (int i = 1; i < t.length()+1; i++) {
            for (int j = 1; j < s.length()+1; j++) {
                if(s.charAt(j-1) == t.charAt(i-1)){
                    dp[i][j] = dp[i-1][j-1] + dp[i][j-1];
                }else {
                    dp[i][j] = dp[i][j-1];
                }
            }
        }

        return dp[t.length()][s.length()];

    }

}
