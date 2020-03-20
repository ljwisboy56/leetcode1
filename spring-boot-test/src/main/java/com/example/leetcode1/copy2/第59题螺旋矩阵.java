package com.example.leetcode1.copy2;

/**
 * @author yingru.ljw
 * @date 2020-03-19 22:29
 */
public class 第59题螺旋矩阵 {

    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];

        if(n <= 0){
            return res;
        }

        int up = 0;
        int down = n-1;
        int left = 0;
        int right = n-1;

        int count= 0;

        while (true){
            //打印第一行
            for (int i = left;i <= right;i++){
                count ++;
                res[up][i] = count;
            }
            if(++up > down){
                break;
            }
            //打印最右一列
            for (int i = up; i <= down ; i++) {
                count ++;
                res[i][right] = count;
            }
            if(--right < left){
                break;
            }
            //向左
            for (int i = right;i >= left;i--){
                count ++;
                res[down][i] = count;
            }
            if(--down < up){
                break;
            }
            for (int i = down;i >= up;i--){
                count++;
                res[i][left] = count;
            }
            if(++left > right){
                break;
            }
        }

        return res;
    }
}
