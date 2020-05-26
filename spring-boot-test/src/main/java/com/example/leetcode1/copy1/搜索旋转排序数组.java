package com.example.leetcode1.copy1;

/**
 * @author yingru.ljw
 * @date 2020-02-03 13:46
 */
public class 搜索旋转排序数组 {


    public static void main(String[] args) {
        int[] array = new int[]{2,3,4,5,6,7,1};
        int index = new 搜索旋转排序数组().search(array,1);
        System.out.println(index);



    }
    /**
     * 分段利用二分查找
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            //前半部分有序,注意此处用小于等于
            if (nums[start] <= nums[mid]) {
                //target在前半部分有序可以用二分查找找
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
        return -1;

    }

}
