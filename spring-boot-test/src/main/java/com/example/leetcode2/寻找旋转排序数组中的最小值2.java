package com.example.leetcode2;

/**
 * @author yingru.ljw
 * @date 2020-02-17 02:04
 */
public class 寻找旋转排序数组中的最小值2 {

    public int findMin(int[] nums) {
        if(nums == null || nums.length ==0){
            return -1;
        }

        int min = Integer.MAX_VALUE;

        int start = 0;
        int end = nums.length-1;
        int mid = 0;
        while (start <= end){
            mid = start + (end - start)/2;

            if(nums[mid] == nums[start]){
                min = Math.min(min,nums[start]);
                start++;
                continue;
            }

            if(nums[mid] > nums[start]){
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
