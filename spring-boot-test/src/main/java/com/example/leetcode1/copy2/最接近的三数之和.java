package com.example.leetcode1.copy2;

import java.util.Arrays;

/**
 * @author yingru.ljw
 * @date 2020-03-04 21:16
 */
public class 最接近的三数之和 {

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
                int b1 = Math.abs(target-min);
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
