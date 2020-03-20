package com.example.leetcode1.copy2;

/**
 * @author yingru.ljw
 * @date 2020-03-04 19:55
 */
public class 盛最多水的容器 {

    public int maxArea(int[] height) {

        int max = 0;

        int left = 0;
        int right = height.length-1;

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
