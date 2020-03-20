package com.example.leetcode1.copy2;

/**
 * @author yingru.ljw
 * @date 2020-03-19 23:13
 */
public class 第62题不同路径 {

    public int uniquePaths(int m, int n) {
        
        int[][] dp = new int[n][m];

        for (int i = 0; i < m; i++) {
            dp[0][i] = 1;
        }

        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[n-1][m-1];

    }


}
