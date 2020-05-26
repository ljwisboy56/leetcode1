package com.example.leetcode2.copy1;

/**
 * @author yingru.ljw
 * @date 2020-02-21 21:14
 */
public class 只出现一次的数字 {

    public int singleNumber(int[] nums) {

        if(nums == null || nums.length == 0){
            return 0;
        }

        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res ^= nums[i];
        }

        return res;

    }

}
