package com.example.leetcode1.leetcodecopy1;

/**
 * @author yingru.ljw
 * @date 2020-02-07 15:53
 */
public class 最小路径和 {

    public static void main(String[] args) {
        int[][] arr = new int[3][3];
        arr[0] = new int[]{1,3,1};
        arr[1] = new int[]{1,5,1};
        arr[2] = new int[]{4,2,1};

        int res = new 最小路径和().minPathSum(arr);
        System.out.println(res);
    }

    /**
     * dp(m,n)=dp(m-1,n),dp(m,n-1) + v(m,n);
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {

        if(grid == null || grid.length ==0){
            return 0;
        }

        int m = grid.length;

        int n = grid[0].length;

        int[][] dp = new int[m][n];

        dp[0][0] = grid[0][0];

        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];

        }

        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i-1] + grid[0][i];

        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]) + grid[i][j];
            }

        }

        return dp[m-1][n-1];

    }

}
