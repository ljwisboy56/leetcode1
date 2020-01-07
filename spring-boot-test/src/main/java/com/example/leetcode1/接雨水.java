package com.example.leetcode1;

/**
 * @author yingru.ljw
 * @date 2020-01-06 17:35
 */
public class 接雨水 {


    /**
     *
     *
     * 此题最关键的一点是发现
     * 每个柱子接到的雨水等于这个柱子左右两边最大值中较小者减去柱子本身的高度 ，所有的解法都是围绕着这个来的。
     */

    public int trap(int[] height) {

        if(height == null || height.length == 0){
            return 0;
        }

        int res = 0;

        //左边动态规划表
        int[] leftDp = new int[height.length];

        leftDp[0] = height[0];

        //右边动态规划表
        int[] rightDp = new int[height.length];

        rightDp[height.length-1] = height[height.length-1];

        //dp(i)=max(dp(i-1),dp(i))
        for(int i = 1; i < height.length;i++){
            leftDp[i] = Math.max(leftDp[i-1],height[i]);
        }

        //dp(i)=max(dp(i+1),dp(i))
        for(int i = height.length-2; i >= 0;i--){
            rightDp[i] = Math.max(rightDp[i+1],height[i]);
        }

        for(int i = 1;i < height.length-1;i++){
            res += Math.min(leftDp[i],rightDp[i]) - height[i];
        }

        return res;


    }



}
