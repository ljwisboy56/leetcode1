package com.example.leetcode3;

/**
 * @author yingru.ljw
 * @date 2020-02-29 19:00
 */
public class 丑数2 {

    public int nthUglyNumber(int n) {

        int[] dp = new int[n];
        dp[0] = 1;

        int l = 0;

        int m = 0;
        int k = 0;

        for (int i = 1; i < n; i++) {
            int min = min(dp[l] * 2, dp[m] * 3, dp[k] * 5);
            if (min == dp[l] * 2) {
                l++;
            }
            if (min == dp[m] * 3) {
                m++;
            }
            if (min == dp[k] * 5) {
                k++;
            }
            dp[i] = min;
        }
        return dp[dp.length - 1];

    }

    private int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

}
