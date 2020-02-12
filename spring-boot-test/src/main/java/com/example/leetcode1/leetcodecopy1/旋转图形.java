package com.example.leetcode1.leetcodecopy1;

/**
 * @author yingru.ljw
 * @date 2020-02-06 12:14
 */
public class 旋转图形 {

    public static void main(String[] args) {
        int[][] arr = new int[3][3];

        arr[0] = new int[]{1,2,3};
        arr[1] = new int[]{4,5,6};
        arr[2] = new int[]{7,8,9};

       new 旋转图形().tMatrix(arr);
//       new 旋转图形().mirrorMatrix(arr);
        System.out.println(arr);


    }



    public void rotate(int[][] matrix) {

        if(matrix == null){
            return;
        }

        this.tMatrix(matrix);

        this.mirrorMatrix(matrix);


    }

    private void mirrorMatrix(int[][] matrix) {

        for (int i =0;i < matrix.length;i++){
            for (int j =i;j < matrix[0].length/2;j++){
              swap2(matrix,i,j,matrix[0].length-1-j);
            }
        }


    }

    private void tMatrix(int[][] matrix) {

        for (int i = 0;i < matrix.length;i++){
            for (int j =0;j < matrix[0].length;j++){
                swap(matrix,i,j);
            }
        }

    }

    private void swap(int[][] matrix,int n,int m){
        int tmp  = matrix[n][m];
        matrix[n][m] = matrix[m][n];
        matrix[m][n] = tmp;

    }

    private void swap2(int[][] matrix,int row,int n,int m){
        int tmp  = matrix[row][m];
        matrix[row][m] = matrix[row][n];
        matrix[row][n] = tmp;

    }

}
