package com.example.leetcode1.copy2;

/**
 * @author yingru.ljw
 * @date 2020-03-05 11:55
 */
public class 移除元素 {

    /**
     * 给定 nums = [3,2,2,3], val = 3,
     */
    public int removeElement(int[] nums, int val) {

        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != val){
                nums[left] = nums[i];
                left++;
            }
        }
        return left;

    }

}
