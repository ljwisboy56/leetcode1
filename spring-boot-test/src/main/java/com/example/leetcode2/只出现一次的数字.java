package com.example.leetcode2;

/**
 * @author yingru.ljw
 * @date 2020-02-15 17:57
 */
public class 只出现一次的数字 {

    public static void main(String[] args) {
        int[] arr = new int[]{10,3,10,4,2,3,2};
        int res = new 只出现一次的数字().singleNumber(arr);

    }


    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;

    }


}
