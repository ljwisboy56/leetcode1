package com.example.leetcode1;

/**
 * @author yingru.ljw
 * @date 2020-01-09 17:19
 */
public class 爬楼梯 {

    public static void main(String[] args) {

        int res  = new 爬楼梯().climbStairs(3);
        System.out.println(res);

    }

    /**
     * 动态规划
     * dp(i) = dp(i-1) + dp(i-2);
     * @param n
     * @return
     */
    public int climbStairs(int n) {

        if(n == 0){
            return 0;
        }

        if(n == 1){
            return 1;
        }

        if(n == 2){
            return 2;
        }

        int[] dp = new int[n+1];

        dp[0] = 0;

        dp[1] = 1;

        dp[2] = 2;

        for (int i=3;i<=n;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];


    }

}
