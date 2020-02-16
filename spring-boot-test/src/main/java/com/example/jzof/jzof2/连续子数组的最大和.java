package com.example.jzof.jzof2;

/**
 * @author yingru.ljw
 * @date 2019-12-29 14:43
 */
public class 连续子数组的最大和 {

    public static void main(String[] args) {
        int[] arr = new int[]{1};
        int res = new 连续子数组的最大和().FindGreatestSumOfSubArray(arr);
        System.out.println(res);


    }


    /**
     * 分析问题：
     * 状态转移方程：dp(i) = max(v(i) + dp(i-1),v(i));
     * 边界条件：dp(0) = v(0);
     */
    public int FindGreatestSumOfSubArray(int[] array) {

        if(array == null || array.length == 0){
            return -1;
        }

        int[] dp = new int[array.length+1];

        dp[0] = array[0];

        if(array.length == 1){
            return dp[0];
        }

        int max = Integer.MIN_VALUE;

        for(int i = 1; i < array.length;i++){
            dp[i] = Math.max(dp[i-1]+array[i],array[i]);
            max = Math.max(max,dp[i]);
        }
        return max;

    }
}
