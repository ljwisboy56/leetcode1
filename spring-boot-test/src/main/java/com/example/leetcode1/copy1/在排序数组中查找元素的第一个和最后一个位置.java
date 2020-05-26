package com.example.leetcode1.copy1;

/**
 * @author yingru.ljw
 * @date 2020-02-03 18:33
 */
public class 在排序数组中查找元素的第一个和最后一个位置 {

    public static void main(String[] args) {
        int[] arr= new int[]{0,1,1,1,2,3};
        int res = new 在排序数组中查找元素的第一个和最后一个位置().binarySearchStart(arr,0,arr.length-1,1);
        int res2 = new 在排序数组中查找元素的第一个和最后一个位置().binarySearchEnd(arr,0,arr.length-1,1);
        System.out.println(res);
        System.out.println(res2);



    }

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
