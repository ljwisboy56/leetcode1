package com.example.leetcode2;

/**
 * @author yingru.ljw
 * @date 2020-02-18 15:41
 */
public class 买卖股票的最佳时机4 {

    public static void main(String[] args) {

    }

    /**
     * dp[-1][k][0] = dp[i][0][0] = 0
     * dp[-1][k][1] = dp[i][0][1] = -Max;
     *
     *
     * dp[i][k][0] = MAX( dp[i-1][k][0], dp[i-1][k][1] + preices[i]);
     * 为什么要减去-1因为你买入没卖出不算一次交易你懂伐？
     * dp[i][k][1] = MAX(dp[i-1][k][1] + dp[i-1][k-1][1] - preices[i];
     *
     * @param k
     * @param prices
     * @return
     */
    public int maxProfit(int k, int[] prices) {

        if(k > prices.length/2){
            return maxProfit(prices);
        }

        int[][][] dp = new int[prices.length][k+1][2];

        for (int i = 0; i < prices.length; i++) {
            dp[i][0][0] = 0;//至今为止没有交易，收益为0
            dp[i][0][1] = Integer.MIN_VALUE;//交易了0次，但持有股票，不符合规则
        }


        for (int i = 0; i < prices.length; i++) {
            for (int j = 1; j < k+1; j++) {
                if(i == 0){
                    dp[i][k][0] = 0;
                    dp[i][k][1] = -prices[i];
                    continue;
                }
                dp[i][k][0] = Math.max(dp[i-1][j][0],dp[i-1][j][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i-1][j][1],dp[i-1][j-1][0] - prices[i]);
            }

        }

        return dp[prices.length-1][k][0];
    }

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
