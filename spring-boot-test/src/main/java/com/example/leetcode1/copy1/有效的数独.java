package com.example.leetcode1.copy1;

import java.util.HashSet;

/**
 * @author yingru.ljw
 * @date 2020-02-03 22:09
 */
public class 有效的数独 {

    HashSet<Character> set = new HashSet<>();

    public boolean isValidSudoku(char[][] board) {


        boolean flag = true;

        flag = judgeRow(board);

        if (flag) {
            flag = judgeCol(board);
        }

        if (flag) {
            flag = judge99(board);
        }

        return flag;

    }

    private boolean judge99(char[][] board) {
        int x = 0;
        int y = 0;
        for (int i = 0; i < 3; i++) {
            x = 3 * i;
            for (int j = 0; j < 3; j++) {
                y = 3 * j;
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        if(board[x+k][y+l] == '.'){
                            continue;
                        }
                        if (set.contains(board[x + k][y + l])) {
                            return false;
                        } else {
                            set.add(board[x + k][y + l]);
                        }
                    }
                }
                set.clear();
            }
        }
        return true;

    }

    private boolean judgeCol(char[][] board) {

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(board[j][i] == '.'){
                    continue;
                }
                if (set.contains(board[j][i])) {
                    return false;
                } else {
                    set.add(board[j][i]);
                }
            }
            set.clear();
        }
        return true;

    }

    private boolean judgeRow(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(board[i][j] == '.'){
                    continue;
                }
                if (set.contains(board[i][j])) {
                    return false;
                } else {
                    set.add(board[i][j]);
                }
            }
            set.clear();
        }
        return true;
    }
}
