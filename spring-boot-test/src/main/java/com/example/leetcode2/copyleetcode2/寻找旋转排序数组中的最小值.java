package com.example.leetcode2.copyleetcode2;

/**
 * @author yingru.ljw
 * @date 2020-02-22 16:22
 */
public class 寻找旋转排序数组中的最小值 {

    public static void main(String[] args) {

        int[] arr ={2,1};
        System.out.println(new 寻找旋转排序数组中的最小值().findMin(arr));
    }

    /**
     * [4,5,6,7,0,1,2]
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {

        if(nums == null || nums.length ==0){
            return -1;
        }
        int start =0;
        int end = nums.length-1;

        int min = Integer.MAX_VALUE;

        while (start <= end){
            int mid = start + (end - start)/2;
            if(nums[mid] >= nums[start]){
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
