package com.example.leetcode2.copy2;

/**
 * @author yingru.ljw
 * @date 2020-03-28 17:28
 */
public class 第162题寻找峰值 {


    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length ==0){
            return -1;
        }
        int start =0;
        int end = nums.length-1;
        while (start < end){
            int mid = (start + end)>>>1;
            if(nums[mid] > nums[mid+1]){
                end = mid;
            }else {
                start = mid + 1;
            }
        }
        return start;
    }


}
