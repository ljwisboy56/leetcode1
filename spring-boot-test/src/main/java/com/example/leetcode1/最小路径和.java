package com.example.leetcode1;

/**
 * @author yingru.ljw
 * @date 2020-01-08 23:51
 */
public class 最小路径和 {

    public static void main(String[] args) {
        int[][] obstacleGrid = new int[3][3];
        int[] a = new int[]{1,3,1};
        int[] b = new int[]{1,5,1};
        int[] c = new int[]{4,2,1};

        obstacleGrid[0] = a;
        obstacleGrid[1] = b;
        obstacleGrid[2] = c;

        int res = new 最小路径和().minPathSum(obstacleGrid);

        System.out.println(res);


    }

    /**
     *
     * dp(i,j)=max(dp(i-1,j,dp(j-1,i))+1;
     *
     *
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {

        int m = grid.length;

        int n = grid[0].length;

        int[][] dp = new int[m][n];

        dp[0][0] = grid[0][0];

        int tmp = 0;
        for (int i = 0; i < n; i++){
            tmp += grid[0][i];
            dp[0][i] = tmp;
        }

        tmp = 0;
        for (int i = 0; i < m; i++){
            tmp += grid[i][0];
            dp[i][0] = tmp;
        }

        for (int i = 1;i < m;i++){
            for(int j = 1;j < n;j++){
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
            }
        }

        return dp[m-1][n-1];


    }

}
