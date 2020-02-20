package com.example.leetcode2.copyleetcode2;

/**
 * @author yingru.ljw
 * @date 2020-02-20 18:00
 */
public class 买卖股票的最佳时机2 {


    /**
     *
     * dp[-1][k][0] = dp[i][0][0] = 0;
     * dp[-1][k][1] = dp[i][0][1] = -Max(表示一种不可能的状态);
     *
     * dp[i][k][0] = dp[i-1][k][0],dp[i-1][k][1] + preices[i];
     * dp[i][k][1] = dp[i-1][k][1],dp[i-1][k-1][0] - preices[i];
     *
     * 当k=无穷次交易
     *
     * dp[i][k][0] = dp[i-1][k][0],dp[i-1][k][1] + preices[i];
     * dp[i][k][1] = dp[i-1][k][1],dp[i-1][k][0] - preices[i];
     *
     * dp[-1][0] = dp[i][0] = 0;
     * dp[-1][1] = dp[i][1] = -Max(表示一种不可能的状态);
     *
     * dp[i][0] = dp[i-1][0],dp[i-1][1] + preices[i];
     * dp[i][1] = dp[i-1][0],dp[i-1][1] - preices[i];
     *
     *
     *
     * @param prices
     * @return
     */
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
