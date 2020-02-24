package com.example.leetcode2.copyleetcode2;

/**
 * @author yingru.ljw
 * @date 2020-02-24 12:51
 */
public class 旋转数组 {

    public void rotate(int[] nums, int k) {

        if(nums == null || nums.length == 0){
            return;
        }

        for(int j=0;j < k;j++){
            int tmp = nums[nums.length-1];
            System.arraycopy(nums, 0, nums, 1, nums.length - 1);
            nums[0] = tmp;
        }
    }

}
