package com.example.leetcode3;

/**
 * @author yingru.ljw
 * @date 2020-03-01 17:22
 */
public class 栅栏涂色 {

    /**
     *
     * 第一个栏杆有k种办法：
     * 第二个栏杆有k*k种办法：
     * 第三个栏杆：第三种颜色有两种情况，与3相同和与3不同 1.如果3和2相同，那么3不能与1相同，
     * 所以可以染的颜色就为（k*k）*(k-1) 2.如果3和2不同，在不与3相同的前提下，染色方案为k*（k-1）
     * dp(i,k) =
     * @param n
     * @param k
     * @return
     */
    public int numWays(int n, int k) {

        if(n == 0 || k == 0){ return 0;
        };

        if(n == 1) {
            return k;
        }

        int[] dp = new int[n];

        dp[0] = k;

        dp[1] = k * k;

        for (int i = 2; i < n; i++) {
            dp[i] = dp[k-1]*(k-1) + dp[k-2] * (k-1);
        }

        return dp[n-1];
    }

}
