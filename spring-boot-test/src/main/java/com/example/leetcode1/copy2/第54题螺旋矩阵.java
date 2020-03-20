package com.example.leetcode1.copy2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yingru.ljw
 * @date 2020-03-19 12:50
 */
public class 第54题螺旋矩阵 {

    /**
     * 输入:
     * [
     *  [ 1, 2, 3 ],
     *  [ 4, 5, 6 ],
     *  [ 7, 8, 9 ]
     * ]
     * 输出: [1,2,3,6,9,8,7,4,5]
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if(matrix == null || matrix.length ==0){
            return list;
        }

        int up = 0;
        int down = matrix.length-1;
        int left = 0;
        int right = matrix[0].length-1;

        while (true){
            //打印第一行
            for (int i = left; i <= right; i++) {
                list.add(matrix[up][i]);
            }
            up++;
            if(up > down){
                break;
            }
            //打印右边一行
            for (int i = up; i <= down; i++) {
                list.add(matrix[i][right]);
            }
            right--;
            if(right < left){
                break;
            }
            for (int i = right; i >=left; i--) {
                list.add(matrix[down][i]);
            }
            down--;
            if(down < up){
                break;
            }
            for (int i = down; i>= up ; i--) {
                list.add(matrix[i][left]);
            }
            left++;
            if(left > right){
                break;
            }
        }
        return list;
    }

}
