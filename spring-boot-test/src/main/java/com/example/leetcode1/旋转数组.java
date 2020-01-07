package com.example.leetcode1;

/**
 * @author yingru.ljw
 * @date 2020-01-06 20:14
 */
public class 旋转数组 {


    /**
     * 先转至矩阵，然后再镜像矩阵
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        //转置矩阵
        this.dransposition(matrix);
        //镜像矩阵
        this.reverse(matrix);
    }

    private void reverse(int[][] matrix) {
        for (int i = 0;i < matrix.length;i++){
            for (int j = 0; j < matrix.length/2;j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - j -1];
                matrix[i][matrix.length - j -1] = tmp;
            }
        }
    }

    private void dransposition(int[][] matrix) {

        for(int i = 0; i < matrix.length;i++){
            for(int j =i;j < matrix.length;j++){
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }
    }

}