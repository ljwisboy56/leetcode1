package com.example.leetcode1.copy2;

/**
 * @author yingru.ljw
 * @date 2020-03-17 20:52
 */
public class 第33题搜索旋转排序数组 {


    /**
     * 输入: nums = [4,5,6,7,0,1,2], target = 0
     * 输出: 4
     */
    public int search(int[] nums, int target) {

        if(nums == null || nums.length==0) return -1;

        int start = 0;
        int end = nums.length-1;

        while (start <= end){
            int mid = start + (end - start)/2;

            if(nums[mid] == target){
                return mid;
            }

            if(nums[mid] >= nums[start]){
                if(target >= nums[start] && nums[mid] > target){
                    end = mid-1;
                }else {
                    start = mid+1;
                }
            }else {
                if(target <= nums[end] && target > nums[mid]){
                    start = mid +1;
                }else {
                    end = mid-1;
                }
            }
        }
        return -1;

    }

}
