package com.example.jzof.jzof2;

/**
 * @author yingru.ljw
 * @date 2019-12-22 21:16
 */
public class 青蛙跳台阶 {


    /**
     * 转化成背包问题：有2个东西，价值分别为1，2
     * 有容量为100的背包，问有多少种取法；
     * 对于第n个台阶，当前最多有多少种取法
     * F(n)= F(n-1) + F（n-2);
     *
     * 1 2 3 5
     *
     *
     * @param target
     * @return
     */
    public int JumpFloor(int target) {
        if(target == 1){
            return 1;
        }
        if(target == 2){
            return 2;
        }

        int dp[] = new int[target+1];
        dp[1] = 1;
        dp[2] = 2;
        for( int i = 2;i <= target;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[target];
    }
}
