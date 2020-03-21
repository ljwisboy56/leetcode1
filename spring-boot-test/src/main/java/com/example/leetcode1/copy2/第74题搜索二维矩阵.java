package com.example.leetcode1.copy2;

/**
 * @author yingru.ljw
 * @date 2020-03-21 15:50
 */
public class 第74题搜索二维矩阵 {

    /**
     * 输入:
     * matrix = [
     * [1,   3,  5,  7],
     * [10, 11, 16, 20],
     * [23, 30, 34, 50]
     * ]
     * target = 3
     * 输出: true
     */
    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix == null || matrix.length == 0) {
            return false;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        int start = 0;
        int end = m * n-1;

        while (start <= end) {
            int mid = (start + end) >>> 1;
            int midRow = mid / n;
            int midCol = mid % n;
            if (matrix[midRow][midCol] == target) {
                return true;
            } else if (matrix[midRow][midCol] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }

}
