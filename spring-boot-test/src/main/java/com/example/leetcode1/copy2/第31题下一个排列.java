package com.example.leetcode1.copy2;

/**
 * @author yingru.ljw
 * @date 2020-03-17 19:35
 */
public class 第31题下一个排列 {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        reverse(arr,0,4);
        System.out.println(arr);
    }

    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int first = -1;
        for (int i = nums.length-2;i >=0; i--) {
            if(nums[i] < nums[i+1]){
                first = i;
                break;
            }
        }
        if (first == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }

        int second = -1;
        for(int i = nums.length-1;i >=0;i--){
            if(nums[i] > nums[first]){
                second = i;
                break;
            }
        }

        swap(nums,first,second);
        reverse(nums,first+1,nums.length-1);

    }

    private static void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i++, j--);
        }
    }


    private static void swap(int[] nums, int i, int i1) {
        int tmp = nums[i];
        nums[i] = nums[i1];
        nums[i1] = tmp;
    }

}
