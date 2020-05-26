package com.example.leetcode2.copy1;

/**
 * @author yingru.ljw
 * @date 2020-02-24 12:22
 */
public class 买卖股票的最佳时机4 {

    /**
     *
     * dp[-1][k][0] =0;
     * dp[i][0][0] = 0;
     *
     * dp[-1][k][1] = Integer.MIN_VALUE;
     * dp[i][0][1] = Integer.MIN_VALUE;
     *
     * dp[i][k][0] = Math.max(dp[i-1][k][0], dp[i-1][k][1] + prices[i]);
     * dp[i][k][1] = Math.max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i]);
     *
     *
     *
     * @param k
     * @param prices
     * @return
     */
    public int maxProfit(int k, int[] prices) {

        //有了上一题 k = 2 的铺垫，这题应该和上一题的第一个解法没啥区别。但是出现了一个超内存的错误，原来是传入的 k 值会非常大，dp 数组太大了。现在想想，交易次数 k 最多有多大呢？
        //
        //一次交易由买入和卖出构成，至少需要两天。所以说有效的限制 k 应该不超过 n/2，如果超过，就没有约束作用了，相当于 k = +infinity。这种情况是之前解决过的。
        //

        if(k > prices.length/2){
            return maxProfit(prices);
        }


        int[][][] dp = new int[prices.length][k+1][2];

        for (int i = 0; i < prices.length; i++) {
            dp[i][0][0] = 0;//至今为止没有交易，收益为0
            dp[i][0][1] = Integer.MIN_VALUE;//交易了0次，但持有股票，不符合规则
        }

        for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j <= k; j++) {
                if(i == 0){
                    dp[i][j][0] = 0;
                    dp[i][j][1] = -prices[i];
                }else {
                    dp[i][j][0] = Math.max(dp[i-1][j][0], dp[i-1][j][1] + prices[i]);
                    dp[i][j][1] = Math.max(dp[i-1][j][1], dp[i-1][j-1][0] - prices[i]);
                }
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
