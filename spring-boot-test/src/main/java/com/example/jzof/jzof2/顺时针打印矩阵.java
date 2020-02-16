package com.example.jzof.jzof2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yingru.ljw
 * @date 2019-12-24 22:58
 */
public class 顺时针打印矩阵 {

    public static void main(String[] args) {

        int[][] a = new int[][]{{1,2,5},{3,4,6}};

        List<Integer> list = new 顺时针打印矩阵().printMatrix(a);
        System.out.println(list);


    }

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

        int row = matrix.length;
        int col = matrix[0].length;

        int rowStart = 0;
        int rowEnd = row-1;

        int colStart = 0;
        int colEnd = col-1;

        ArrayList<Integer>  list = doMatrix(matrix,rowStart,rowEnd,colStart,colEnd);

        return list;

    }

    private ArrayList<Integer> doMatrix(int[][] matrix, int rowStart, int rowEnd, int colStart, int colEnd) {

        if(rowEnd < rowStart){
            return list;
        }

        if(colStart > colEnd){
            return list;
        }

        if(rowEnd == rowStart){
            for(int i = colStart;i <= colEnd;i++){
                list.add(matrix[rowEnd][i]);
            }
            return list;
        }

        if(colStart == colEnd){
            for(int i = rowStart;i <= rowEnd;i++){
                list.add(matrix[i][colEnd]);
            }
            return list;
        }

        //打印一行
        for(int i = colStart;i <= colEnd;i++){
            list.add(matrix[rowStart][i]);
        }
        //打印最后一列
        for (int i = rowStart+1;i <= rowEnd;i++){
            list.add(matrix[i][colEnd]);
        }
        //打印最后一行
        for(int i = colEnd-1;i >= colStart;i--){
            list.add(matrix[rowEnd][i]);
        }

        if(rowEnd == rowStart+1){
            return list;
        }

        //打印第一列
        for(int i = rowEnd-1;i >= rowStart+1;i--){
            list.add(matrix[i][colStart]);
        }
        doMatrix(matrix,rowStart+1,rowEnd-1,colStart+1,colEnd-1);

        return list;

    }


}
