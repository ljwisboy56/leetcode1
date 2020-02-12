package com.example.leetcode1.leetcodecopy1;

/**
 * @author yingru.ljw
 * @date 2020-02-07 15:24
 */
public class 不同路径2 {

    public static void main(String[] args) {
        int[][] arr = new int[3][3];
        arr[0] = new int[]{0,0,0};
        arr[1] = new int[]{0,1,0};
        arr[2] = new int[]{0,0,0};



        int res = new 不同路径2().uniquePathsWithObstacles(arr);
        System.out.println(res);

    }

    //dp(m,n)= if(dp(m-1,n) != 1) + if(dp(m,n-1)!=1
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        if(obstacleGrid == null || obstacleGrid.length == 0){
            return 0;
        }

        int m = obstacleGrid.length;

        int n= obstacleGrid[0].length;

        int[][] dp = new int[m][n];

        dp[0][0] = obstacleGrid[0][0] == 1 ? 0:1;
        for (int i = 1;i < m;i++){
            dp[i][0] = obstacleGrid[i][0] == 1 ? 0 : dp[i-1][0];
        }

        for (int i = 1;i < n;i++){
            dp[0][i] = obstacleGrid[0][i] == 1 ? 0 : dp[0][i-1];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                 if(obstacleGrid[i][j] == 1){
                     dp[i][j] = 0;
                 }else {
                     dp[i][j] = dp[i-1][j] + dp[i][j-1];
                 }
            }
        }

        return dp[m-1][n-1];

    }
}
