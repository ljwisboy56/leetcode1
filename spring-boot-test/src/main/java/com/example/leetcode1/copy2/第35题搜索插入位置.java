package com.example.leetcode1.copy2;

/**
 * @author yingru.ljw
 * @date 2020-03-17 22:16
 */
public class 第35题搜索插入位置 {


    public int searchInsert(int[] nums, int target) {

        if(nums == null || nums.length == 0){
            return 0;
        }

        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == target){
                return i;
            }else if(nums[i] < target){
                index++;
            }else {
                break;
            }
        }
        return index;

    }

}
