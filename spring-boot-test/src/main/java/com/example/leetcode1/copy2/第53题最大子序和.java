package com.example.leetcode1.copy2;

/**
 * @author yingru.ljw
 * @date 2020-03-19 12:31
 */
public class 第53题最大子序和 {

    /**
     * 输入: [-2,1,-3,4,-1,2,1,-5,4],
     * 输出: 6
     * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
     */
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length ==0){
            return 0;
        }
        int max = Integer.MIN_VALUE;
        //定义dp（i）=max(dp(i-1)+nums[i],nums[i])
        int[] dp = new int[nums.length];
        dp[0] =nums[0];
        max = Math.max(dp[0],max);
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);
            max = Math.max(max,dp[i]);
        }

        return max;
    }

}
