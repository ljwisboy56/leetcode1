package com.example.leetcode1;

/**
 * @author yingru.ljw
 * @date 2020-01-04 20:45
 */
public class 移除元素 {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,2,3};
        int res = new 移除元素().removeElement(arr,2);
        System.out.println(res);

    }


    public int removeElement(int[] nums, int val) {
        int i = 0;
        int j = 0;

        while (j < nums.length){
            if(val == nums[j]){
                j++;
            }else {
                nums[i] = nums[j];
                i++;
                j++;
            }
        }
        return i;

    }


}
