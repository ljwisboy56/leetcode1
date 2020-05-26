package com.example.leetcode2.copy1;

/**
 * @author yingru.ljw
 * @date 2020-02-23 01:35
 */
public class 寻找峰值 {

    public static void main(String[] args) {
        int res = new 寻找峰值().findPeakElement(new int[]{3,2,1});
        System.out.println(res);

    }


    public int findPeakElement(int[] nums) {

        if(nums == null || nums.length ==0){
            return -1;
        }

        int start =0;
        int end = nums.length-1;

        while (start < end){

            int mid = start + (end-start)/2;
            if(nums[mid] > nums[mid+1]){
                end = mid;
            }else {
                start = mid + 1;
            }

        }

        return start;
    }

}
