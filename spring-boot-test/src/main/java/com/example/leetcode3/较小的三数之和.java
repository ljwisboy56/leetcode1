package com.example.leetcode3;

import java.util.Arrays;

/**
 * @author yingru.ljw
 * @date 2020-02-29 17:05
 */
public class 较小的三数之和 {

    public static void main(String[] args) {
        int[] arr = {-1,1,-1,-1};

        int res = new 较小的三数之和().threeSumSmaller(arr,-1);
        System.out.println(res);
    }


    public int threeSumSmaller(int[] nums, int target) {

        Arrays.sort(nums);

        int count =0;

        for (int i = 0; i < nums.length; i++) {
            
            int newTarget = target - nums[i];

            int p1 = i+1;
            int p2 = nums.length-1;

            while (p1 <= p2){

                if(nums[p1] + nums[p2] < newTarget){
                    count += p2 - p1;
                    p1++;
                }else {
                    p2--;
                }
            }
        }
        return count;
    }


}
