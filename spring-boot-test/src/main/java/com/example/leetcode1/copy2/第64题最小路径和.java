package com.example.leetcode1.copy2;

/**
 * @author yingru.ljw
 * @date 2020-03-19 23:33
 */
public class 第64题最小路径和 {


    public int minPathSum(int[][] grid) {
        if(grid == null || grid[0].length == 0){
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        int sum = 0;
        for (int i = 0; i < m; i++) {
            sum += grid[i][0];
            dp[i][0] = sum;
        }

        sum = 0;
        for (int i = 0; i < n; i++) {
            sum += grid[0][i];
            dp[0][i] = sum;
        }

        //dp(i,j) = min(dp[i-1][j],dp[i][j-1])+grid[i][j];
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
            }
        }

        return dp[m-1][n-1];
    }


}
