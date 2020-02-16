package com.example.jzof.jzof2;

/**
 * @author yingru.ljw
 * @date 2019-12-22 21:31
 */
public class 变态跳台阶 {

    public static void main(String[] args) {
        int res = new 变态跳台阶().JumpFloorII(3);
        System.out.println(res);
    }

    /**
     * 动态转移方程：dp[i] = d[i-1] + dp[i-2] + ... + dp[0]
     * 边界条件：dp[0] = 1
     *
     *
     * @param target
     * @return
     */
    public int JumpFloorII(int target) {

        if(target == 1){
            return 1;
        }
        if(target ==2){
            return 2;
        }

        int[] dp = new int[target+1];
        dp[1] =1;
        dp[2] =2;

        for(int i = 2;i <= target;i++){
            for(int j = 1;j < i;j++) {
                dp[i] += dp[j];
            }
        }

        return dp[target];
    }

}
