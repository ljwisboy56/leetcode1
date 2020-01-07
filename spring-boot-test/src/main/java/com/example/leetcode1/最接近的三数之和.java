package com.example.leetcode1;

import java.util.Arrays;

/**
 * @author yingru.ljw
 * @date 2020-01-01 16:37
 */
public class 最接近的三数之和 {

    public static void main(String[] args) {
        int res = new 最接近的三数之和().threeSumClosest(new int[]{-3,-2,-5,3,-4},0);
        System.out.println(res);
    }


    public int threeSumClosest(int[] nums, int target) {

        if(nums == null || nums.length == 0){
            return 0;
        }

        int close = Integer.MAX_VALUE;

        int len = nums.length;

        Arrays.sort(nums);

        for(int i =0;i < len;i++){
            int l = i +1;
            int r = len - 1;
            while (l < r){
                int minClose = nums[i] + nums[l] +nums[r];
                int a1 = Math.abs(minClose-target);
                int b1 =  Math.abs(close-target);
                if(a1 < b1){
                    close = minClose;
                }
                if(minClose > target){
                    r--;
                }
                else if(minClose < target){
                    l++;
                }else{
                    return target;
                }
            }
        }
        return close;
    }




}
