package com.example.leetcode2;

/**
 * @author yingru.ljw
 * @date 2020-02-14 13:21
 */
public class 买卖股票的最佳时机3 {


    /**
     * dp[i][k][0] = dp[i-1][k][0] , dp[i-1][k][1] + preices[i];
     * dp[i][k][1] = dp[i-1][k][1] , dp[i-1][k-1][0] - preices[i];
     *
     * 边界条件:
     * dp[-1][k][0] = dp[i][0][0] = 0;
     * dp[-1][k][1] = dp[i][0][1] = -负无穷
     *
     * 当k=2；
     * dp[i][2][0] = dp[i-1][2][0] , dp[i-1][2][1] + preices[i];
     * dp[i][2][1] = dp[i-1][2][1] , dp[i-1][1][0] - preices[i];
     * dp[-1][2][0] = dp[i][0][0] = 0;
     * dp[-1][2][1] = dp[i][0][1] = -负无穷;
     *
     */
    public int maxProfit(int[] prices) {

        if(prices == null || prices.length ==0){
            return 0;
        }

        int n = prices.length;

        /**
         * 为什么k=3
         */
        int[][][] dp = new int[n][3][2];

        for (int i = 0; i < n; i++) {
            for (int k = 0; k <=2 ; k++){
                if (i - 1 == -1) {
                    /* 处理 base case */
                    dp[i][k][0] = 0;
                    dp[i][k][1] = -prices[i];
                    continue;
                }
                dp[i][k][0] = Math.max(dp[i-1][k][0],dp[i-1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i-1][k][1],dp[i-1][k-1][0] - prices[i]);
            }
        }
        return dp[n-1][2][0];

    }

}
