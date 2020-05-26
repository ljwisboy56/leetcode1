package com.example.leetcode1.copy1;

/**
 * @author yingru.ljw
 * @date 2020-02-03 16:03
 */
public class 搜索旋转排序数组2 {

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,1,1,1};

        boolean res = new 搜索旋转排序数组2().search(arr,3);
        System.out.println(res);


    }

    public boolean search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return true;
            }
            //这块是重点
            if(nums[start] == nums[mid]){
                start++;
                continue;
            }
            //前半部分有序,注意此处用小于等于
            if (nums[start] <= nums[mid]) {
                //target在前半部分
                if (target >= nums[start] && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target <= nums[end] && target > nums[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }

        }
        return false;
    }

}
