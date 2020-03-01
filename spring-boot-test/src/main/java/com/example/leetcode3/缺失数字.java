package com.example.leetcode3;

import java.util.Arrays;

/**
 * @author yingru.ljw
 * @date 2020-02-29 20:52
 */
public class 缺失数字 {

    public static void main(String[] args) {
        int[] arr = {0,1};
        System.out.println(new 缺失数字().missingNumber(arr));


    }


    public int missingNumber(int[] nums) {

        if(nums == null || nums.length == 0){
            return 0;
        }

        int min = nums[0];
        for(int tmp :nums){
            min = Math.min(tmp,min);
        }

        int max = nums.length;

        int[] bucket = new int[max-min+1];

        Arrays.fill(bucket,0);

        for(int tmp : nums){
            bucket[tmp-min]++;
        }

        for (int i = 0; i < bucket.length; i++) {
            if(bucket[i] == 0){
                return i;
            }

        }

        return 0;
    }

}
