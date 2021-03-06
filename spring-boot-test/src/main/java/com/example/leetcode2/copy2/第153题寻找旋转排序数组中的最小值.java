package com.example.leetcode2.copy2;

/**
 * @author yingru.ljw
 * @date 2020-03-27 16:39
 */
public class 第153题寻找旋转排序数组中的最小值 {

    public int findMin(int[] nums) {
        if(nums == null || nums.length ==0){
            return -1;
        }
        int min = Integer.MAX_VALUE;
        int start = 0;
        int end = nums.length-1;
        while (start <= end){
            int mid = (start + end)>>>1;
            if(nums[mid] >= nums[start]){
                min = Math.min(min,nums[start]);
                start = mid+1;
            }else {
                min = Math.min(min,nums[mid]);
                end = mid-1;
            }
        }
        return min;
    }

}
