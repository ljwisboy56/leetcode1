package com.example.leetcode1;

/**
 * @author yingru.ljw
 * @date 2020-01-07 20:33
 */
public class 螺旋矩阵2 {

    /**
     * 输入: 3
     * 输出:
     * [
     *  [ 1, 2, 3 ],
     *  [ 8, 9, 4 ],
     *  [ 7, 6, 5 ]
     * ]
     *
     */
    public int[][] generateMatrix(int n) {

        int l = 0, r = n - 1, t = 0, b = n - 1;
        int[][] mat = new int[n][n];
        int num = 1, tar = n * n;
        while(num <= tar){
            for(int i = l; i <= r; i++){
                mat[t][i] = num++; // left to right.
            }
            t++;
            for(int i = t; i <= b; i++){
                mat[i][r] = num++; // top to bottom.
            }
            r--;
            for(int i = r; i >= l; i--){
                mat[b][i] = num++; // right to left.
            }
            b--;
            for(int i = b; i >= t; i--){
                mat[i][l] = num++; // bottom to top.
            }
            l++;
        }
        return mat;


    }


}
