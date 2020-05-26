package com.example.leetcode1.copy1;

/**
 * @author yingru.ljw
 * @date 2020-02-06 16:09
 */
public class N皇后 {

    public static void main(String[] args) {

        int res = new N皇后().totalNQueens(8);
        System.out.println(res);


    }

    int[][] qiPan ;

    int res = 0;

    int target = 0;

    //https://www.jianshu.com/p/65c8c60b83b8
    public int totalNQueens(int n) {

        this.target = n;

        qiPan = new int[target][target];

        doTotalNqueens(0);

        return res;

    }

    private void doTotalNqueens(int n) {

        if(n >= target){
            res++;
        }else {
            for (int i = 0; i < target ; i++) {
                qiPan[n][i] = 1;
                if(constraint(qiPan,n,i)){
                    doTotalNqueens(n+1);
                }
                qiPan[n][i] = 0;
            }

        }

    }

    private boolean constraint(int[][] qiPan,int row,int col) {

        //校验列
        for (int i = 0; i < qiPan.length; i++) {
           if(i == row){
               continue;
           }
           if(qiPan[row][i] == 1){
               return false;
           }
        }

        //校验行
        for (int i = 0; i < qiPan.length; i++) {
            if(i == col){
                continue;
            }
            if(qiPan[i][col] == 1){
                return false;
            }
        }

        //校验左对角线
//        for (int i =row-1,j=col-1;i >=0&& j>=0;i--,j--){
//            if(i == row && j == col){
//                continue;
//            }
//
//            if(qiPan[i][j] == 1){
//                return false;
//            }
//        }

        //检查右对接线
//        for (int i =row,j=col;i >=0&& j<target;i--,j++){
//            if(i == row && j == col){
//                continue;
//            }
//            if(qiPan[i][j] == 1){
//                return false;
//            }
//        }
//        return true;
        return true;

    }

}
