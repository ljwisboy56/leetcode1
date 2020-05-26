package com.example.leetcode1.copy1;

/**
 * @author yingru.ljw
 * @date 2020-02-04 22:50
 */
public class 接雨水 {


    public static void main(String[] args) {
        int[] arr = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        int res = new 接雨水().trap(arr);
        System.out.println(res);
    }

    /**
     * 每个柱子接的水等于左右两边的最大值中娇小的那个与本身的高度差
     *
     * dpleft(i) = max(dpleft(i-1),i))
     *
     *
     *
     * @param height
     * @return
     */
    public int trap(int[] height) {

        if (height == null || height.length == 0) {
            return 0;
        }

        int len = height.length;

        //左边柱子最大值
        int[] dpLeft = new int[len];

        //边界条件
        dpLeft[0] = height[0];
        //状态转移方程
        for (int i = 1; i < len; i++) {
            dpLeft[i] = Math.max(dpLeft[i - 1], height[i]);
        }

        //右边柱子最大值
        int[] dpRight = new int[len];

        //边界条件
        dpRight[len - 1] = height[len - 1];
        //状态转移方程
        for (int i = len - 2; i >= 0; i--) {
            dpRight[i] = Math.max(dpRight[i + 1], height[i]);
        }

        int sum = 0;

        for (int i = 0; i < len; i++) {
            int v = Math.min(dpLeft[i], dpRight[i]) - height[i];
            sum += v;
        }

        return sum;

    }


}
