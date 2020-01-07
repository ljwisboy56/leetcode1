package com.example.leetcode1;

/**
 * @author yingru.ljw
 * @date 2020-01-05 15:06
 */
public class 搜索旋转排序数组 {

    public static void main(String[] args) {
        int[] arr = new int[]{3,1};
        int index = new 搜索旋转排序数组().search(arr,1);
        System.out.println(index);



    }

    /**
     * 输入: nums = [4,5,6,7,0,1,2], target = 0
     * 输出: 4
     */
    public int search(int[] nums, int target) {

        if(nums == null || nums.length == 0){
            return -1;
        }

        int flag= nums.length-1;
        for(int i = 0; i < nums.length-1;i++){
            if(nums[i] > nums[i+1]){
                flag = i;
            }
        }

        //如果没有旋转则直接二分查找
        if(flag == nums.length - 1){
            return binarySearch(nums,0,nums.length-1,target);
        }else {
            if(target > nums[0]){
                return binarySearch(nums,1,flag,target);
            }else if(target < nums[0]){
                return binarySearch(nums,flag+1,nums.length-1,target);
            }else {
                return 0;
            }
        }


    }

    private int binarySearch(int[] nums, int start, int end,int target) {
        if(start > end){
            return -1;
        }
        //找到中值
        int mid = start + ((end-start)>>1);
        if(nums[mid] == target){
            return mid;
        }else if(nums[mid] > target){
            return binarySearch(nums,start,mid-1,target);
        }else {
            return binarySearch(nums,mid+1,end,target);
        }
    }

}
