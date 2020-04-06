package com.example.leetcode3.copy2;

/**
 * @author yingru.ljw
 * @date 2020-03-30 19:31
 */
public class 第213题打家劫舍2 {


    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];

        int[] first = new int[nums.length];

        int[] last = new int[nums.length];

        last[0] = 0;
        last[1] = Math.max(last[0],nums[1]);
        for (int i = 2; i < nums.length; i++) {
            last[i] = Math.max(last[i-2] + nums[i],last[i-1]);
        }

        first[0] = nums[0];
        first[1] = Math.max(first[0],nums[1]);

        for (int i = 2; i < nums.length-1; i++) {
            first[i] = Math.max(first[i-2] + nums[i],first[i-1]);
        }

        return Math.max(last[nums.length-1],first[nums.length-2]);

    }

}
