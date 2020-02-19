package com.example.leetcode2;

/**
 * @author yingru.ljw
 * @date 2020-02-14 12:24
 */
public class 买卖股票的最佳时机2 {


    /**
     * dp[-1][k][0] = dp[i][0][0] = 0;
     * dp[-1][k][1] = dp[i][0][1] = -Integer.max;
     *
     * dp[i][k][0] = max(dp[i-1][k][0]),dp[i-1][k][1] + prieces[i]);
     * dp[i][k][1] = max(dp[i-1][k][1]),dp[i-1][k-1][0] - prieces[i]);
     *
     * 当k=n时候：
     *
     * dp[i][0] = max(dp[i-1][0]),dp[i-1][1] + prieces[i]);
     * dp[i][1] = max(dp[i-1][1]),dp[i-1][0] - prieces[i]);
     *
     */
    public int maxProfit(int[] prices) {

        if(prices == null || prices.length == 0){
            return 0;
        }

        int n = prices.length;

        int[][] dp = new int[n][2];

        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < n;i++){
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0] - prices[i]);
        }

        return dp[n-1][0];

    }



}
