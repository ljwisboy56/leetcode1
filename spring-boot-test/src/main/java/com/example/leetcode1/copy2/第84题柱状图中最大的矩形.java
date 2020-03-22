package com.example.leetcode1.copy2;

/**
 * @author yingru.ljw
 * @date 2020-03-22 01:00
 */
public class 第84题柱状图中最大的矩形 {


    public int largestRectangleArea(int[] heights) {

        if(heights == null || heights.length == 0){
            return 0;
        }

        int len = heights.length;
        int res = 0;
        for (int i = 0; i < len; i++) {

            // 找左边最后 1 个大于等于 heights[i] 的下标
            int left = i;
            int curHeight = heights[i];
            while (left > 0 && heights[left - 1] >= curHeight) {
                left--;
            }

            // 找右边最后 1 个大于等于 heights[i] 的索引
            int right = i;
            while (right < len - 1 && heights[right + 1] >= curHeight) {
                right++;
            }

            int width = right - left + 1;
            res = Math.max(res, width * curHeight);
        }
        return res;

    }

}
