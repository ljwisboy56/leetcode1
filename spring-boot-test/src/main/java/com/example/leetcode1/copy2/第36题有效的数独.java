package com.example.leetcode1.copy2;

import java.util.HashSet;

/**
 * @author yingru.ljw
 * @date 2020-03-17 22:52
 */
public class 第36题有效的数独 {


    HashSet<Character> set = new HashSet<>();

    public boolean isValidSudoku(char[][] board) {

        if (board == null || board.length == 0) {
            return false;
        }

        boolean res = judgeRow(board);

        if (res) {
            res = judgeCol(board);
        }

        if (res) {
            res = judge99(board);
        }

        return res;

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
                        if (board[x + k][y + l] == '.') {
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
        for (int i = 0; i < board[0].length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[j][i] == '.') {
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

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
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
