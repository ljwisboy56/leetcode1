package com.example.leetcode2;

/**
 * @author yingru.ljw
 * @date 2020-02-17 16:13
 */
public class 寻找峰值 {

    /**
     * 输入: nums = [1,2,3,1]
     * 输出: 2
     * 解释: 3 是峰值元素，你的函数应该返回其索引 2。
     */
    public int findPeakElement(int[] nums) {

        int mid = 0;

        int start = 0;

        int end = nums.length-1;

        while (start < end){
            mid = start + (end-start)/2;
            if(nums[mid] > nums[mid+1]){
                end = mid;
            }else {
                start = mid +1;
            }
        }

        return start;

    }

}
