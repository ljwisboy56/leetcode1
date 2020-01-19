package com.example.leetcode1;

import java.util.Arrays;

/**
 * @author yingru.ljw
 * @date 2020-01-12 20:59
 */
public class 搜索旋转排序数组2 {

    public static void main(String[] args) {
        int[] arr = new int[]{2,4,4,4,5,6,7};
        boolean res = new 搜索旋转排序数组2().search(arr,7);
        System.out.println(res);

        int[] ress = Arrays.copyOfRange(arr,0,1);
        System.out.println(ress);

    }

    /**
     * ( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。
     * @param nums
     * @param target
     * @return
     */
    public boolean search(int[] nums, int target) {

        if(nums == null || nums.length == 0){
            return false;
        }

        //首先找到数组的节点
        int end = -1;
        for(int i = 0; i < nums.length-1;i++){
            if(nums[i] > nums[i+1]){
                end = i;
                break;
            }
        }

        boolean res = binarySearch(Arrays.copyOfRange(nums,0,end+1),target);
        if(!res){
            res = binarySearch(Arrays.copyOfRange(nums,end+1,nums.length),target);
        }

        return res;
    }

    private boolean binarySearch(int[] nums,int target){

        int left = 0;
        int right = nums.length-1;

        while (left <= right){
            int mid = left + (right - left)/2;
            if(nums[mid] == target){
                return true;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return false;
    }


}
