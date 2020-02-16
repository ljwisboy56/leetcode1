package com.example.leetcode2;

/**
 * @author yingru.ljw
 * @date 2020-02-16 19:37
 */
public class 乘积最大子序列 {

    public static void main(String[] args) {

        int[] arr = new int[]{-2,3,-4};
        int res = new 乘积最大子序列().maxProduct(arr);
        System.out.println(res);



    }


    public int maxProduct(int[] nums) {

        if(nums == null){
            return 0;
        }

        int[] dp = new int[nums.length];

        dp[0] = nums[0];

        int max = dp[0];

        for (int i = 1;i < nums.length;i++){
            dp[i] = Math.max(dp[i-1]*nums[i],nums[i]);
            max = Math.max(max,dp[i]);
        }

        return max;

    }

}
