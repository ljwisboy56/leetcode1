package com.example.leetcode1;

/**
 * @author yingru.ljw
 * @date 2020-01-05 16:06
 */
public class 在排序数组中查找元素的第一个和最后一个位置 {

    public static void main(String[] args) {

        int[] arr = new int[]{5,7,7,10};
        int res = new 在排序数组中查找元素的第一个和最后一个位置().binarySearchLeft(arr,0,arr.length-1,8);
        int res2 = new 在排序数组中查找元素的第一个和最后一个位置().binarySearchRight(arr,0,arr.length-1,8);
//        int[] res3 = new 在排序数组中查找元素的第一个和最后一个位置().searchRange(arr,3);
//        System.out.println(res);
//        System.out.println(res2);
//        System.out.println(res3);
        int res4 = new 在排序数组中查找元素的第一个和最后一个位置().binarySearch(arr,0,arr.length-1,5);
        System.out.println(res4);

    }

    int[] res = new int[]{-1,-1};

    /**
     * 输入: nums = [5,7,7,8,8,10], target = 8
     * 输出: [3,4]
     */
    public int[] searchRange(int[] nums, int target) {

        if(nums == null || nums.length == 0){
            return res;
        }

        int tmpLeft = -1;
        int tmpRight = -1;
        //先搜索左边界
        tmpLeft = binarySearchLeft(nums,0,nums.length-1,target);
        //如果左边界不存在直接返回
        if(tmpLeft == -1){
            return res;
        }
        //再搜索右边界
        tmpRight = binarySearchRight(nums,0,nums.length-1,target);
        if(tmpRight == -1){
            return res;
        }
        res[0] = tmpLeft;
        res[1] = tmpRight;

        return res;

    }

    private int binarySearchRight(int[] nums, int start, int end, int target) {
        //右逼近
        while (start < end){
            int mid = start + (end-start+1)/2 ;
            if(nums[mid] <= target){
                start = mid ;
            }
            if(nums[mid] > target){
                end = mid-1;
            }
        }
        return nums[start] == target ? start : -1;
    }

    private int binarySearchLeft(int[] nums, int start, int end, int target) {
        //左逼近
        while (start < end){
            int mid = start + (end-start)/2;
            if(nums[mid] >= target){
                end = mid;
            }
            if(nums[mid] < target){
                start = mid+1;
            }
        }
        return nums[end] == target ? end : -1;
    }

    /**
     * 二分查找非递归
     */
    private int binarySearch(int[] nums, int start, int end,int target) {

        int mid = (start + end)/2;

        if(nums[mid] == target){
            return mid;
        }

        while (start <= end){
            mid = (start + end)/2;
            if(nums[mid] > target){
                end = mid-1;
            }else if(nums[mid] < target){
                start = mid +1;
            }else {
                return mid;
            }
        }

        return -1;
    }

}
