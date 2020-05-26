package com.example.leetcode1.copy1;

/**
 * @author yingru.ljw
 * @date 2020-01-20 00:36
 */
public class 盛水最多的容器 {

    public int maxArea(int[] height) {

        int left = 0;

        int right = height.length-1;

        int max = 0;

        while (left < right){

            max = Math.max((right-left)* Math.min(height[right],height[left]),max);

            if(height[left] <= height[right]){
                left++;
            }else {
                right--;
            }

        }

        return max;

    }

}
