package com.example.leetcode1.copy2;

/**
 * @author yingru.ljw
 * @date 2020-03-17 21:57
 */
public class 第34题在排序数组中查找元素的第一个和最后一个位置 {

    /**
     * 输入: nums = [5,7,7,8,8,10], target = 8
     * 输出: [3,4]
     */
    public int[] searchRange(int[] nums, int target) {

        int[] res= new int[]{-1,-1};

        if(nums == null || nums.length ==0){
            return res;
        }

        int start = binarySearchStart(nums,0,nums.length-1,target);

        if(start == -1){
            return res;
        }


        int end = binarySearchEnd(nums,0,nums.length-1,target);
        res[0] = start;
        res[1] = end;

        return res;

    }

    private int binarySearchEnd(int[] nums, int start, int end,int target) {

        int mid = -1;
        while (start < end){
            mid = start + (end - start+1)/2;
            if(nums[mid] <= target){
                start = mid;
            }else {
                end = mid-1;
            }

        }

        return nums[start] == target ? start : -1;


    }

    private int binarySearchStart(int[] nums, int start, int end,int target) {

        int mid = -1;
        while (start < end){
            mid = start + (end-start)/2;
            if(nums[mid] >= target){
                end = mid;
            }else {
                start = mid +1;
            }
        }
        return nums[end] == target ? end : -1;
    }
}
