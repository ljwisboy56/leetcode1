package com.example.leetcode1.copy2;

import java.util.Arrays;

/**
 * @author yingru.ljw
 * @date 2020-03-18 14:11
 */
public class 第45题跳跃游戏2 {

    public int jump(int[] nums) {
        if(nums == null || nums.length ==0 ) return 0;
        //定义dp长度
        int len = nums.length;

        //到第i个位置的最短步数
        int[] dp = new int[len];

        for(int i = 1; i < len; i++) {
            //首先到当前的最短步数一定不可能大于当前最大步数
            dp[i] = i;
            //找从前面到当前位置的最短步数
            for(int j = 0; j <= i; j++){
                //位置加上步长nums[j]如果大于i
                //则说明到达当前i的位置的最短步数是dp[j]的步数+1（因为nums[j]就是1）
                if(j + nums[j] >= i) {
                    dp[i] = dp[j] + 1;
                    break;
                }
            }
        }
        return dp[len - 1];
    }

}
