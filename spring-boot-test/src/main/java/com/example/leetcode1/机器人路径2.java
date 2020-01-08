package com.example.leetcode1;

/**
 * @author yingru.ljw
 * @date 2020-01-08 22:06
 */
public class 机器人路径2 {

    public static void main(String[] args) {
        int[][] obstacleGrid = new int[3][3];
        int[] a = new int[]{0,0,0};
        int[] b = new int[]{0,1,0};
        int[] c = new int[]{0,0,0};
        obstacleGrid[0] = a;
        obstacleGrid[1] = b;
        obstacleGrid[2] = c;

        int res = new 机器人路径2().uniquePathsWithObstacles(obstacleGrid);

        System.out.println(res);


    }

    /**
     * 动态规划
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];

        if(obstacleGrid[0][0] == 1){
            return 0;
        }

        //边界条件
        dp[0][0] =1;

        //初始最上面行
        for(int i =1;i < obstacleGrid[0].length;i++){
            dp[0][i] = obstacleGrid[0][i] == 1 ? 0 :dp[0][i-1];
        }

        //初始最左侧列
        for(int i =1;i < obstacleGrid.length;i++){
            dp[i][0] = obstacleGrid[i][0] == 1 ? 0 :dp[i-1][0];
        }

        //初始化dp表
        for (int i =1; i < obstacleGrid.length;i++){
            for(int j = 1; i < obstacleGrid[0].length ;i++){
                dp[i][j] = obstacleGrid[i][j] == 1 ? 0 : dp[i][j-1] + dp[i-1][j];
            }

        }

        return dp[obstacleGrid.length-1][obstacleGrid[0].length-1];

    }


}
