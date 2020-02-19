package com.example.leetcode2;

/**
 * @author yingru.ljw
 * @date 2020-02-18 20:02
 */
public class 旋转数组 {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        new 旋转数组().rotate(arr, 3);

    }

    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return;
        }

        for (int j = 0;j < k;j++){
            int tmp = nums[nums.length - 1];
            for (int i = nums.length - 2; i >= 0; i--) {
                //所有元素向后串一位
                nums[i + 1] = nums[i];
            }
            nums[0] = tmp;
        }
//        System.out.println(nums);

    }
}

