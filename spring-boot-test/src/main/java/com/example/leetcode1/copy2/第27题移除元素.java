package com.example.leetcode1.copy2;

/**
 * @author yingru.ljw
 * @date 2020-03-17 00:13
 */
public class 第27题移除元素 {
    public static void main(String[] args) {
        int[] ar = {3,2,2,3};
        System.out.println(new 第27题移除元素().removeElement(ar,3));

    }

    public int removeElement(int[] nums, int val) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != val){
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }

}
