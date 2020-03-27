package com.example.leetcode2.copy2;

/**
 * @author yingru.ljw
 * @date 2020-03-25 14:00
 */
public class 第122题买卖股票的最佳时机2 {

    public int maxProfit(int[] prices) {

        if(prices == null || prices.length == 0){
            return 0;
        }

        int[][] dp = new int[prices.length][2];

        for (int i = 0; i < prices.length; i++) {
            if(i == 0){
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
            }else {
                dp[i][0] =Math.max(dp[i-1][0],dp[i-1][1] + prices[i]);
                dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0] - prices[i]);
            }
        }

        return dp[prices.length-1][0];

    }
}
