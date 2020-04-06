package com.example.leetcode2.copy2;

/**
 * @author yingru.ljw
 * @date 2020-03-29 22:56
 */
public class 第189题旋转数组 {


    public void rotate(int[] nums, int k) {

        if(nums == null || nums.length == 0){
            return;
        }

        for (int j = 0; j <k ; j++) {
            //记录下最后一个节点
            int tmp = nums[nums.length-1];
            System.arraycopy(nums, 0, nums, 1, nums.length - 1);
            nums[0] = tmp;
        }

    }

}
