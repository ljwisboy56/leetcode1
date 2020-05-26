package com.example.leetcode1.copy1;


import java.util.Arrays;

/**
 * @author yingru.ljw
 * @date 2020-02-01 21:11
 */
public class 最接近的三数之和 {

    public static void main(String[] args) {
        int[] arr = new int[]{-3,-2,-5,3,-4};
        int res = new 最接近的三数之和().threeSumClosest(arr,-1);
        System.out.println(res);
    }

    int min = Integer.MAX_VALUE;

    public int threeSumClosest(int[] nums, int target) {

        doFindResult(target,nums);

        return min;

    }

    private void doFindResult(int target, int[] nums) {

        if(nums == null || nums.length == 0){
            return;
        }

        int len = nums.length;

        Arrays.sort(nums);

        for (int i=0;i < nums.length;i++){

            int left = i+1;

            int right = len-1;

            while (left < right){
               int tmp = nums[i] + nums[left] + nums[right];
               int a1 = Math.abs(tmp-target);
               int b1 = Math.abs(min-target);
               if(a1 < b1){
                   min = tmp;
               }

               if(tmp > target){
                   right--;
               }else if(tmp < target){
                   left++;
               }else {
                   min  = target;
                   return;
               }

            }
        }
    }
}
