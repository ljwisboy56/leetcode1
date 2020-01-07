package com.example.leetcode1;

/**
 * @author yingru.ljw
 * @date 2020-01-06 23:43
 */
public class 最大子序列和 {

    public static void main(String[] args) {


        int[] arr = new int[]{-1,-2};

        int res = new 最大子序列和().maxSubArray(arr);

        System.out.println(res);
    }

    /**
     *
     * 动态规划：
     * dp(i) = max(dp(i-1)+i,i)
     *
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {

        if(nums == null || nums.length == 0){
            return 0;
        }

        int[] dp = new int[nums.length];

        dp[0] = nums[0];

        int max = dp[0];
        for (int i = 1; i < nums.length;i++){
            dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);
            max = Math.max(dp[i],max);
        }

        return max;
    }


}
