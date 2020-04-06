package com.example.leetcode2.copy2;

/**
 * @author yingru.ljw
 * @date 2020-03-28 13:18
 */
public class 第154题寻找旋转排序数组中的最小值2 {

    public int findMin(int[] nums) {
        if(nums == null || nums.length ==0){
            return -1;
        }

        int start =0;
        int end = nums.length-1;

        int min = Integer.MAX_VALUE;

        while (start <= end){
            int mid = start + (end - start)/2;
            if(nums[mid] == nums[start]){
                min =  Math.min(nums[start],min);
                start++;
                continue;
            }

            if(nums[mid] > nums[start]){
                min = Math.min(min,nums[start]);
                start = mid+1;
            }else {
                min = Math.min(min,nums[mid]);
                end = mid - 1;
            }
        }
        return min;

    }

}
