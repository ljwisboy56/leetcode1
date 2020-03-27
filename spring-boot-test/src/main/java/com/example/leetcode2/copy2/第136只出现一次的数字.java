package com.example.leetcode2.copy2;

/**
 * @author yingru.ljw
 * @date 2020-03-26 01:38
 */
public class 第136只出现一次的数字 {

    public int singleNumber(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int start = nums[0];
        for (int i = 1; i < nums.length; i++) {
            start ^= nums[i];
        }
        return start;

    }

}
