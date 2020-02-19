package com.example.leetcode2;

/**
 * @author yingru.ljw
 * @date 2020-02-19 01:12
 */
public class 打家劫舍 {

    public static void main(String[] args) {

        int res = new 打家劫舍().rob(new int[]{2,1,1,2});
        System.out.println(res);

    }


    /**
     * dp(i) = dp(i-2)+nums[i],dp(i-1)
     * @param nums
     * @return
     */
    public int rob(int[] nums) {

        if(nums == null || nums.length ==0){
            return 0;
        }

        int[] dp = new int[nums.length];

        if(nums.length == 1){
            return nums[1];
        }

        if(nums.length == 2){
            return Math.max(nums[1],nums[0]);
        }


        dp[1] = Math.max(nums[1],nums[0]);

        for (int i = 0; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-2]+nums[i],dp[i-1]);
        }

        return dp[nums.length-1];
    }
}
