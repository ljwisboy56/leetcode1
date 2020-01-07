package com.example.leetcode1;

import java.util.HashSet;
import java.util.Set;

/**
 * @author yingru.ljw
 * @date 2020-01-05 18:22
 */
public class 有效的数独 {

    Set<Character> set = new HashSet<>();

    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length == 0) {
            return false;
        }

        boolean r1 = judgeRow(board);
        boolean r2 = judgeCol(board);
        boolean r3 = judge99(board);
        if(!r1 || !r2 && !r3){
            return false;
        }
        return true;
    }



    private boolean judge99(char[][] board) {

        for(int i = 1; i <= 9;i ++){
            for(int j = 1; j <= 9;j++){
                if(j % 3==0){
                    break;
                }
                if(board[i-1][j-1] == '.'){
                    continue;
                }
                else {
                    if(set.contains(board[i-1][j-1])){
                        return false;
                    }else {
                        set.add(board[i-1][j-1]);
                    }
                }
            }
            if(i % 3==0){
                set.clear();
            }
        }
        return false;
    }

    /**
     * 将二维数组的所有列存储起来
     * @param board
     * @return
     */
    private boolean judgeCol(char[][] board) {
        for (int i = 0; i < 9; i++){
            for(int j = 0; j < 9;j++){
                if(board[j][i] == '.'){
                    continue;
                }
                else {
                    if(set.contains(board[j][i])){
                        return false;
                    }else {
                        set.add(board[j][i]);
                    }
                }

            }
            set.clear();
        }
        return true;
    }

    private boolean judgeRow(char[][] board) {
        for (int i = 0; i < 9; i++){
            for(int j = 0; j < 9;j++){
                if(board[i][j] == '.'){
                    continue;
                }
                else {
                    if(set.contains(board[i][j])){
                        return false;
                    }else {
                        set.add(board[i][j]);
                    }
                }

            }
            set.clear();
        }
        return true;
    }

}
