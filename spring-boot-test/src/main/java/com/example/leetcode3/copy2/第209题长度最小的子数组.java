package com.example.leetcode3.copy2;

import java.util.LinkedHashMap;
import java.util.TreeMap;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author yingru.ljw
 * @date 2020-03-30 01:10
 */
public class 第209题长度最小的子数组 {


    public int minSubArrayLen(int s, int[] nums) {
//        LinkedHashMap linkedHashMap = new LinkedHashMap();
////        TreeMap
////        int left = 0;
////        int right = 0;
////
////        int sum = 0;
////        int min = Integer.MAX_VALUE;
////        while (right < nums.length){
////            if(sum + nums[right] < s){
////                sum += nums[right];
////                right++;
////            }else {
////                min = Math.min(min,right-left+1);
////                sum -= nums[left];
////                left++;
////            }
////        }
////        return min == Integer.MAX_VALUE ? 0 : min;
        return 1;
    }

}
