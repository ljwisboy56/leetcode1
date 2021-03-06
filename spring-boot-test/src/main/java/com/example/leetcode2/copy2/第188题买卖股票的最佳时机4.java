package com.example.leetcode2.copy2;

/**
 * @author yingru.ljw
 * @date 2020-03-29 22:54
 */
public class 第188题买卖股票的最佳时机4 {

    public int maxProfit(int k, int[] prices) {
        if(k==0) {
            return 0;
        }
        int n = prices.length;
        if(k>prices.length/2) {
            return profit(prices);
        }
        int[][][] dp = new int[n][k+1][2];
        for(int i=0;i<n;i++){
            // base case
            dp[i][0][0] = 0;//至今为止没有交易，收益为0
            dp[i][0][1] = Integer.MIN_VALUE;//交易了0次，但持有股票，不符合规则
            for(int t =1;t<=k;t++){
                // base case
                if(i==0){
                    dp[i][t][0] = 0;//第一天买入t次，当天卖出t次,收入为0
                    dp[i][t][1] = -prices[i];//甭管第一天买多少次，反正最后少卖一次，持有了股票
                    continue;
                }
                dp[i][t][0] = Math.max(dp[i-1][t][0],dp[i-1][t][1]+prices[i]);
                dp[i][t][1] = Math.max(dp[i-1][t][1], dp[i-1][t-1][0]-prices[i]);
            }
        }
        return dp[n-1][k][0];
    }

    private int profit(int[] prices){
        int dp_i_0 = 0;
        int dp_i_1 = Integer.MIN_VALUE;
        int tmp = 0;
        for(int i =0;i<prices.length;i++){
            tmp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, tmp-prices[i]);
        }
        return dp_i_0;
    }

}
