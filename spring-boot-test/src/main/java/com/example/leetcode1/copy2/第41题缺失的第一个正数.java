package com.example.leetcode1.copy2;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author yingru.ljw
 * @date 2020-03-18 11:14
 */
public class 第41题缺失的第一个正数 {

    public static void main(String[] args) {

        int[] arr = {0};
        System.out.println(new 第41题缺失的第一个正数().firstMissingPositive(arr));
    }

    /**
     * 输入: [3,4,-1,1] [-1,1,3,4]
     * 输出: 2
     */

    public int firstMissingPositive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        //特盘
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
