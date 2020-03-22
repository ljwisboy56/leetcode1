package com.example.leetcode1.leetcodecopy1;

/**
 * @author yingru.ljw
 * @date 2020-02-11 00:16
 */
public class 柱状图中最大的矩形 {

    public static void main(String[] args) {

        int[] arr = new int[]{2, 1, 5, 6, 2, 3};
        int res = new 柱状图中最大的矩形().largestRectangleArea(arr);

    }

    /**
     * 模仿水滴节水那个题，本体的核心就是找到这个公式：res = heights[i] * (right_i - left_i -1)
     *
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int n = heights.length;
        int[] leftDp = new int[n];
        int[] rightDp = new int[n];
        leftDp[0] = -1;
        rightDp[n - 1] = n;
        int res = 0;
        for (int i = 1; i < n; i++) {
            //坐标
            int tmp = i - 1;
            while (tmp >= 0 && heights[tmp] >= heights[i]) {
                //坐标被更新成tmp这个坐标的最小坐标值
                tmp = leftDp[tmp];
            }
            leftDp[i] = tmp;
        }
        for (int i = n - 2; i >= 0; i--) {
            int tmp = i + 1;
            while (tmp < n && heights[tmp] >= heights[i]) {
                tmp = rightDp[tmp];
            }
            rightDp[i] = tmp;
        }
        for (int i = 0; i < n; i++) {
            res = Math.max(res, (rightDp[i] - leftDp[i] - 1) * heights[i]);
        }
        return res;
    }


}
