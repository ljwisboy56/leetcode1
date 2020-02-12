package com.example.leetcode1.leetcodecopy1;

/**
 * @author yingru.ljw
 * @date 2020-02-07 15:04
 */
public class 不同路径 {

    public static void main(String[] args) {

        int res = new 不同路径().uniquePaths(7,3);
        System.out.println(res);


    }

    /**
     * dp(m,n) = dp(m-1,n) + dp(m,n-1);
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {

        int[][] dp = new int[m][n];

        for (int i = 0;i < n;i++){
            dp[0][i] = 1;
        }

        for (int i = 0;i < m ;i++){
            dp[i][0] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }

        return dp[m-1][n-1];

    }


}
