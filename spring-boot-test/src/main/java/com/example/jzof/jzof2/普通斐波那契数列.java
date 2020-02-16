package com.example.jzof.jzof2;

/**
 * @author yingru.ljw
 * @date 2019-12-22 20:46
 */
public class 普通斐波那契数列 {


    public static void main(String[] args) {
        int res = new 普通斐波那契数列().Fibonacci(36);
        System.out.println(res);
    }


    /**
     * 0,1,1,2,3,5
     * 动态规划：
     * dp[i]=dp[i-1] +dp[i-2];
     * @param n
     * @return
     */
    public int Fibonacci(int n) {

        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }

        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;


        for(int i = 2;i <= n;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];

    }


}
