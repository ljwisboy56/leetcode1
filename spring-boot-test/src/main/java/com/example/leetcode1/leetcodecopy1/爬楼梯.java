package com.example.leetcode1.leetcodecopy1;

/**
 * @author yingru.ljw
 * @date 2020-02-08 01:51
 */
public class 爬楼梯 {

    public static void main(String[] args) {
        int res = new 爬楼梯().climbStairs(4);
        System.out.println(res);

    }



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

        dp[1] = 1;
        dp[2] = 2;


        for (int i = 3; i <=n;i++){
            dp[i] = dp[i-2] + dp[i-1];
        }

        return dp[n];

    }

}
