package com.example.jzof;

import java.util.ArrayList;

/**
 * @author yingru.ljw
 * @date 2019-11-30 22:51
 */
public class printMatrix {

    ArrayList<Integer> list = new ArrayList<>();

    /**
     * 1  2  3  4
     * 5  6  7  8
     * 9  10 11 12
     * 13 14 15 16
     *
     * @param matrix
     * @return
     */
    public ArrayList<Integer> printMatrix(int [][] matrix) {

        //左右→坐标
        int lr = 0;
        //左下↓坐标
        int ld = 0;
        //右上↑坐标
        int ru = matrix.length-1;
        //右左←坐标
        int rl = matrix[0].length-1;

        //左上和右下的坐标同时移动，剥圈打印
        while (lr <= rl && ld <= ru){
            printEdge(matrix,lr++,ld++,ru--,rl--);
        }
        return list;
    }

    /**
     * 打印一圈矩阵
     * @param matrix 二维矩阵
     */
    private void printEdge(int[][] matrix, int lr, int ld, int ru, int rl) {

        //如果最后只剩下一行的情况，则打印该行
        if(ld == ru){
            for(int i = lr;i <= rl;i++){
                list.add(matrix[ld][i]);
            }
        }
        //如果最后只剩下一列的情况，则打印该列
        else if(lr == rl){
            for(int i=ld;i<= ru;i++){
                list.add(matrix[i][lr]);
            }
        }

        //遍历打印剥圈
        else {
            //用2个临时变量，来做指针
            int curLr = lr;
            int curLd = ld;
            //→打印打到头
            while (curLr != rl){
                list.add(matrix[ld][curLr]);
                curLr++;
            }
            //↓打印打到底
            while (curLd != ru){
                list.add(matrix[curLd][rl]);
                curLd++;
            }
            //←打印打到头
            while (curLr != lr){
                list.add(matrix[ru][curLr]);
                curLr--;
            }
            //↑打印到顶
            while (curLd != ld){
                list.add(matrix[curLd][lr]);
                curLd++;
            }

        }

    }
}
