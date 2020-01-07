package com.example.leetcode1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yingru.ljw
 * @date 2020-01-07 00:11
 */
public class 顺时针打印矩阵 {

    /**
     * 输入:
     * [
     *  [ 1, 2, 3 ],
     *  [ 4, 5, 6 ],
     *  [ 7, 8, 9 ]
     * ]
     * @param matrix
     * @return
     */
    List<Integer> list = new ArrayList<>();

    public List<Integer> spiralOrder(int[][] matrix) {

        int lr = 0;
        int ud = 0;
        int rl = matrix.length;
        int du = matrix[0].length;

        doPrint(lr,ud,rl,du,matrix);

        return list;

    }

    private void doPrint(int lr, int ud, int rl, int du,int[][] matrix) {

        if(lr > rl){
            return;
        }

        if(ud > du){
            return;
        }

        if(lr == rl){
            for (int i = ud; i <= du;i++){
                list.add(matrix[lr][i]);
            }
        }

        if(du == ud){
            for (int i = lr; i <= rl;i++){
                list.add(matrix[i][du]);
            }
        }

        //打印第一行
        for(int i = lr; i <= rl;i++){
            list.add(matrix[ud][i]);
        }

        //打印最右列
        for(int i = ud+1; i <= du;i++){
            list.add(matrix[i][lr]);
        }

        //打印最后一行
        for(int i = rl-1; i >= lr;i--){
            list.add(matrix[du][i]);
        }

        if(ud +1 == du ){
            return;
        }

        for (int i = du-1; i >= ud +1 ;i--){
            list.add(matrix[i][lr]);
        }

        doPrint(lr+1,ud+1,rl-1,du+1,matrix);

    }


}
