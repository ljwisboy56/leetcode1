package com.example.leetcode2.copy1;

/**
 * @author yingru.ljw
 * @date 2020-02-20 14:31
 */
public class 买卖股票的最佳时机 {

    /**
     *
     * dp[-1][k][0] = dp[i][0][0] = 0;
     * dp[-1][k][1] = dp[i][0][1] = -Max;

     * dp[i][k][0] = dp[i-1][k][0],dp[i-1][k][1]+prices(i);
     * dp[i][k][1] = dp[i-1][k][1],dp[i-1][k-1][0]-prices(i);
     *
     * k == 1;
     *
     * dp[-1][1][0] = 0;
     * dp[i][0][0] = 0;
     * dp[-1][1][1] = -Max;
     *
     * dp[i][0] = dp[i-1][0],dp[i-1][1] + prices(i);
     * dp[i][1] = dp[i-1][1],- prices(i);
     *
     *
     */
    public int maxProfit(int[] prices) {

        if(prices == null || prices.length ==0){
            return 0;
        }

        int[][] dp = new int[prices.length][2];

        for (int i = 0; i < prices.length; i++) {
            if(i == 0){
                dp[0][0] = 0;
                dp[0][1] = -prices[i];
            }else {
                dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1] + prices[i]);
                dp[i][1] = Math.max(dp[i-1][1],- prices[i]);
            }

        }

        return dp[prices.length-1][0];


    }
}
