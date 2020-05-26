package com.example.leetcode3.copy1;

/**
 * @author yingru.ljw
 * @date 2020-03-02 21:48
 */
public class 打家劫舍2 {

    /**
     * 分2种情况讨论：第一种是取第一个不取最后一个，第二种是取最后一个不取第一个。
     * @param nums
     * @return
     */
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
