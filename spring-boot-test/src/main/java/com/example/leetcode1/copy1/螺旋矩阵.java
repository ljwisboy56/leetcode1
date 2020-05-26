package com.example.leetcode1.copy1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yingru.ljw
 * @date 2020-02-06 21:17
 */
public class 螺旋矩阵 {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();


        //二维矩阵的边界条件校验要牢记
        if(matrix == null || matrix.length == 0){
            return list;
        }

        int up = 0;
        int down = matrix.length-1;
        int left = 0;
        int right = matrix[0].length-1;

        while (true){
            //打印第一行
            for (int i = left;i <= right;i++){
                list.add(matrix[up][i]);
            }
            if(++up > down){
                break;
            }
            //打印最右一列
            for (int i = up; i <= down ; i++) {
                list.add(matrix[i][right]);
            }
            if(--right < left){
                break;
            }
            //向左
            for (int i = right;i >= left;i--){
                list.add(matrix[down][i]);
            }
            if(--down < up){
                break;
            }
            for (int i = down;i >= up;i--){
                list.add(matrix[i][left]);
            }
            if(++left > right){
                break;
            }
        }

        return list;

    }

}
