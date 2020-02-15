package com.example.leetcode2;

/**
 * @author yingru.ljw
 * @date 2020-02-14 10:31
 */
public class 买卖股票的最佳时机 {

    public static void main(String[] args) {
        int[] arr = new int[]{2,4,1};

        System.out.println(new 买卖股票的最佳时机().maxProfit(arr));

    }
    /**
     * dp[-1][k][0] = dp[i][0][0] = 0;
     * dp[-1][k][1] = dp[i][0][1] = -Integer.max;
     *
     * dp[i][k][0] = max(dp[i-1][k][0]),dp[i-1][k][1] + prieces[i]);
     * dp[i][k][1] = max(dp[i-1][k][1]),dp[i-1][k-1][0] - prieces[i]);
     *
     * 当k=1时候：
     *
     * dp[-1][1][0] = 0;
     * dp[-1][1][1] = -Integer.max;
     *
     * dp[i][1][0] = max(dp[i-1][1][0]),dp[i-1][1][1] + prieces[i]);
     * dp[i][1][1] = max(dp[i-1][1][1]),dp[i-1][0][0] - prieces[i]);
     * 简化：
     * 1：
     * dp[i][1][0] = max(dp[i-1][1][0]),dp[i-1][1][1] + prieces[i]);
     * dp[i][1][1] = max(dp[i-1][1][1]),（dp[i-1][0][0]=0，简化掉） - prieces[i]);
     * 2：
     * dp[i][1][0] = max(dp[i-1][1][0]),dp[i-1][1][1] + prieces[i]);
     * dp[i][1][1] = max(dp[i-1][1][1]),（dp[i-1][0][0]=0，简化掉） - prieces[i]);
     * 3：再把1去掉：
     * dp[i][0] = max(dp[i-1][0]),dp[i-1][1] + prieces[i]);
     * dp[i][1] = max(dp[i-1][1])， - prieces[i]);
     *
     *
     *
     * @param prices
     * @return
     */

    public int maxProfit(int[] prices) {

        if(prices == null || prices.length ==0){
            return 0;
        }

        int max = 0;

        for (int i = 0; i < prices.length;i++){
            for (int j = i +1;j < prices.length;j++){
                max = Math.max(max,prices[j]-prices[i]);
            }
        }
        return max;
    }

    public int maxProfit2(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice){
                minprice = prices[i];
            }
            else if (prices[i] - minprice > maxprofit){
                maxprofit = prices[i] - minprice;
            }
        }
        return maxprofit;
    }

    public int maxProfit3(int[] prices) {


        if(prices == null || prices.length == 0){
            return 0;
        }

        int n = prices.length;

        int[][] dp = new int[n][2];

        dp[0][0] = 0;
        dp[0][1] = -prices[0];


        for (int i = 1; i < n;i++){
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],-prices[i]);
        }

        return dp[n-1][0];

    }


}
