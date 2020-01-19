package com.example.leetcode1;

/**
 * @author yingru.ljw
 * @date 2020-01-09 23:00
 */
public class 搜索二维矩阵 {

    /**
     * 二维虚拟数组查找
     * row = index / m;
     * col = index % m;
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {

        if(matrix == null || matrix.length == 0){
            return false;
        }

        int n = matrix.length;

        int m = matrix[0].length;

        int left = 0;

        int right = n * m - 1;

        int pivot;

        while (left <= right) {

            pivot = (left + right) / 2;
            if (matrix[pivot / m][pivot % m] == target) {
                return true;
            } else if ((matrix[pivot / m][pivot % m] > target)) {
                right = pivot - 1;
            } else {
                left = pivot + 1;
            }

        }

        return false;

    }


}
