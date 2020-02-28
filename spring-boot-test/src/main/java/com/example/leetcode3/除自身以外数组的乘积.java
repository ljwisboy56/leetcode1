package com.example.leetcode3;

/**
 * @author yingru.ljw
 * @date 2020-02-28 12:57
 */
public class 除自身以外数组的乘积 {

    /**
     * 输入: [1,2,3,4]
     * 输出: [24,12,8,6]
     */
    public int[] productExceptSelf(int[] nums) {

        int length = nums.length;

        int[] left = new int[length];
        int[] right = new int[length];

        int[] answer = new int[length];

        left[0] = 1;
        for (int i = 1; i < length; i++) {
            left[i] = nums[i - 1] * left[i - 1];
        }

        right[length - 1] = 1;
        for (int i = length - 2; i >= 0; i--) {
            right[i] = nums[i + 1] * right[i + 1];
        }

        for (int i = 0; i < length; i++) {
            answer[i] = left[i] * right[i];
        }

        return answer;


    }
}
