package com.example.leetcode1.copy2;

/**
 * @author yingru.ljw
 * @date 2020-03-05 14:43
 */
public class 搜索旋转排序数组 {

    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2};
        int res = new 搜索旋转排序数组().search(arr,0);
        System.out.println(res);
    }

    /**
     * 输入: nums = [4,5,6,7,0,1,2], target = 0
     * 输出: 4
     */
    public int search(int[] nums, int target) {

        if(nums == null || nums.length==0){
            return -1;
        }

        int left =0;
        int right = nums.length-1;

        while (left <= right){
            int mid = (left + right)/2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid] >= nums[left]){
                if(nums[mid] > target && nums[left] <= target){
                    right = mid-1;
                }else {
                    left = mid+1;
                }
            }else {
                if(nums[mid] < target && nums[right] >= target){
                    left = mid+1;
                }else {
                    right = mid-1;
                }
            }
        }
        return -1;

    }

}
