package com.example.leetcode1.copy1;

/**
 * @author yingru.ljw
 * @date 2020-02-06 20:27
 */
public class 最大子序和 {

    public static void main(String[] args) {
        int[] arr = new int[]{-2,1};
        int res = new 最大子序和().maxSubArray(arr);
        System.out.println(res);

    }


    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE;

        int[] dp = new int[nums.length];

        dp[nums.length-1] = nums[nums.length-1];

        if(nums.length == 1){
            return dp[0];
        }

        res = Math.max(res,dp[nums.length-1]);

        //先记录下当前节点及其以后的最大值
        for (int i = nums.length-2;i >= 0;i--){
            dp[i] = Math.max(dp[i+1]+nums[i],nums[i]);
            res = Math.max(res,dp[i]);
        }

        return res;

    }


//    private void doFind(int n, int[] nums,int sum) {
//
//        if(n >= nums.length){
//            res = Math.max(sum,res);
//        }else {
//            for (int i=n;i < nums.length;i++){
//                //当右面的值加和大于0才有必要继续递归
//                if(dp[i] >0){
//                    sum += nums[i];
//                    doFind(i+1,nums,sum);
//                    sum -= nums[i];
//                }
//            }
//        }
//
//    }
}
