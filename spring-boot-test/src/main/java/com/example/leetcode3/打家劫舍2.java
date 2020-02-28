package com.example.leetcode3;

/**
 * @author yingru.ljw
 * @date 2020-02-26 23:58
 */
public class 打家劫舍2 {

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];

        // not consider it is a circle, it is simple:
        // dp[i] = max(dp(i - 2) + nums[i], dp[i - 1])
        // but it is a circle, so we use a trick:
        int[] dp = new int[n];

        // not rob the first horse
        dp[0] = 0; dp[1] = nums[1];
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        int resNotRobFirst = dp[n - 1];

        // not rob the last horse
        dp[0] = nums[0]; dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n - 1; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        int resNotRobLast = dp[n - 2];

        return Math.max(resNotRobFirst, resNotRobLast);

    }

}
