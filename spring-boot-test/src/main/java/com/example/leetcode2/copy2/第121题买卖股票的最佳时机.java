package com.example.leetcode2.copy2;

/**
 * @author yingru.ljw
 * @date 2020-03-25 13:40
 */
public class 第121题买卖股票的最佳时机 {


    /**
     * //边界条件
       dp[-1][k][0] = dp[i][0][0] = 0;
     * dp[-1][k][1] = dp[i][0][1] = -Integer.max;（不可能事件）
     *
     * //状态妆业方程
     * dp[i][k][0] = max(dp[i-1][k][0],dp[i-1][k][1] + prices[i]);
     * dp[i][k][1] = max(dp[i-1][k][1],dp[i-1][k-1][0] - prices[i]);
     *
     * 化简
     * dp[i][0] = max(dp[i-1][0],dp[i-1][1] + prices[i]);
     * dp[i][1] = max(dp[i-1][1], - prices[i]);
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length ==0){
            return 0;
        }
        int[][] dp = new int[prices.length][2];
        for (int i = 0; i < dp.length; i++) {
            if(i == 0){
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
            }else {
                dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1] + prices[i]);
                dp[i][1] = Math.max(dp[i-1][1],-prices[i]);
            }
        }
        return dp[prices.length-1][0];
    }

}
