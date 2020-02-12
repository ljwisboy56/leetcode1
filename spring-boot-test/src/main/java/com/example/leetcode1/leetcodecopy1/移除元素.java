package com.example.leetcode1.leetcodecopy1;

/**
 * @author yingru.ljw
 * @date 2020-02-02 17:36
 */
public class 移除元素 {

    public static void main(String[] args) {

        int[] arr = new int[]{3,2,2,3};
        int res = new 移除元素().removeElement(arr,3);
        System.out.println(res);
    }


    public int removeElement(int[] nums, int val) {

        if(nums == null || nums.length == 0){
            return 0;
        }

        int index = 0;
        int cur = 0;

        while (cur < nums.length){

            if(nums[cur] == val){
                cur++;
                continue;
            }

            nums[index] = nums[cur];
            index++;
            cur++;
        }

        return index;

    }
}
