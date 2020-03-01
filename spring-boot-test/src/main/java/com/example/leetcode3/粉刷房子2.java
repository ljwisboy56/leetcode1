package com.example.leetcode3;

/**
 * @author yingru.ljw
 * @date 2020-02-29 19:13
 */
public class 粉刷房子2 {


    public int minCostII(int[][] costs) {

        if(costs == null || costs.length == 0){
            return 0;
        }

        int[][] dp = new int[costs.length][costs[0].length];
        for (int i = 0; i < costs[0].length; i++) {
            dp[0][i] = costs[0][i];
        }
        for (int i = 1; i < costs.length; i++) {
            for (int j = 0; j < costs[0].length; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = 0; k < costs[0].length; k++) {
                    if(k != j){
                        dp[i][j] = Math.min(dp[i][j],dp[i-1][k]);
                    }
                }
                dp[i][j] += costs[i][j];
            }
        }
        
        int res =Integer.MAX_VALUE;
        for (int i = 0; i < costs[0].length; i++) {
            res = Math.min(res,dp[costs.length-1][i]);
        }
        return res;

    }

}
