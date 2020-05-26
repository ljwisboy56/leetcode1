package com.example.leetcode1.copy1;

import java.util.HashSet;

/**
 * @author yingru.ljw
 * @date 2020-02-04 22:34
 */
public class 缺失的第一个正数 {

    public static void main(String[] args) {
        int[] arr= new int[]{3,4,-1,1};
        int res = new 缺失的第一个正数().firstMissingPositive(arr);
        System.out.println(res);
    }

    HashSet<Integer> set = new HashSet<>();

    public int firstMissingPositive(int[] nums) {

        if(nums == null || nums.length ==0){
            return 1;
        }

        int max = Integer.MAX_VALUE;
        for (int tmp : nums){
            set.add(tmp);
        }


        for (int i =1;i < max;i++){
            if(!set.contains(i)){
                return i;
            }
        }

        return max +1;


    }


}
