package com.example.leetcode1;

/**
 * @author yingru.ljw
 * @date 2020-01-05 17:50
 */
public class 搜索插入位置 {

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,5,6};
        int index = new 搜索插入位置().searchInsert(arr,2);
        System.out.println(index);
    }


    /**
     * 输入: [1,3,5,6], 5
     * 输出: 2
     * <p>
     * 输入: [1,3,5,6], 2
     * 输出: 1
     */
    public int searchInsert(int[] nums, int target) {

        if (nums == null | nums.length == 0) {
            return -1;
        }

        return binarySearchAdd(nums, 0, nums.length-1, target);

    }

    private int binarySearchAdd(int[] nums, int start, int end, int target) {
        //索引记录插入位置
        int index = 0;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] >= target){
                end = mid;
                index = end;
            }else {
                start = mid + 1;
                index = start;
            }
        }


        return nums[end] >= target ? index : ++index;

    }
}
