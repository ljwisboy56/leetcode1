package com.example.leetcode1.copy2;

/**
 * @author yingru.ljw
 * @date 2020-03-18 19:29
 */
public class 第48题旋转图像 {

    public static void main(String[] args) {
        int[][] m = new int[3][3];
        int[] a = {1,2,3};
        int[] b = {4,5,6};
        int[] c = {7,8,9};
        m[0] = a;
        m[1] = b;
        m[2] = c;

        new 第48题旋转图像().rotate(m);
        System.out.println(m);

    }


    public void rotate(int[][] matrix) {

        if(matrix == null || matrix.length ==0){
            return;
        }

        this.t(matrix);

        this.r(matrix);

    }

    private void r(int[][] matrix) {
        for(int[] arr : matrix){
            for (int i = 0; i < arr.length/2; i++) {
                swap(arr,i,arr.length-1-i);
            }
        }
    }

    private void t(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                swap(matrix,i,j);
            }
        }
    }

    private void swap(int[][] martix,int x,int y){
        int tmp = martix[x][y];
        martix[x][y] = martix[y][x];
        martix[y][x] = tmp;
    }

    private static void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
