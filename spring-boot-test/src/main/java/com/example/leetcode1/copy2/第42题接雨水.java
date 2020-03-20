package com.example.leetcode1.copy2;

/**
 * @author yingru.ljw
 * @date 2020-03-18 11:44
 */
public class 第42题接雨水 {

    public static void main(String[] args) {
        int res = new 第42题接雨水().trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
        System.out.println(res);
    }

    /**
     * dp(i) = Min(left(i),right(i))-dp(i)
     * @param height
     * @return
     */
    public int trap(int[] height) {

        if (height == null || height.length == 0) return 0;

        int len = height.length;

        int[] dpLeft = new int[len];
        dpLeft[0] = height[0];
        for (int i = 1; i < len; i++) {
            dpLeft[i] = Math.max(dpLeft[i-1],height[i]);
        }

        int[] dpRight = new int[len];
        dpRight[len-1] = height[len-1];
        for (int i = len-2; i >= 0; i--) {
            dpRight[i] =Math.max(dpRight[i+1],height[i]);
        }

        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += Math.min(dpLeft[i],dpRight[i])-height[i];
        }
        return sum;
    }
}
