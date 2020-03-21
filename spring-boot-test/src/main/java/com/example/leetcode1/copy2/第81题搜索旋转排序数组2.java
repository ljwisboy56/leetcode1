package com.example.leetcode1.copy2;

/**
 * @author yingru.ljw
 * @date 2020-03-21 23:35
 */
public class 第81题搜索旋转排序数组2 {

    /**
     * 输入: nums = [2,5,6,0,0,1,2], target = 0
     * 输出: true
     */
    public boolean search(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return false;
        }

        int start = 0;
        int end = nums.length-1;

        while (start <= end){
            int  mid = start + (end - start) / 2;

            if(nums[mid] == target){
                return true;
            }
            //这块是重点
            if(nums[start] == nums[mid]){
                start++;
                continue;
            }
            if(nums[start] <= nums[mid]){
                if(target < nums[mid] && nums[start] <= target){
                    end = mid-1;
                }else {
                    start = mid+1;
                }
            }else {
                if(target > nums[mid] && target <= nums[end]){
                    start = mid+1;
                }else {
                    end = mid-1;
                }
            }
        }
        return false;
    }

}
