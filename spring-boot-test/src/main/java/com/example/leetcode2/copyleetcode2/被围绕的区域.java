package com.example.leetcode2.copyleetcode2;

/**
 * @author yingru.ljw
 * @date 2020-02-21 14:51
 */
public class 被围绕的区域 {


    public void solve(char[][] board) {

        if(board == null || board.length == 0){
            return;
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean isEdge = i == 0 || j == 0 || i == board.length - 1 || j == board[0].length - 1;
                if(isEdge && board[i][j] == 'O'){
                    dfs(board,i,j);
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j] == '#'){
                    board[i][j] = 'O';
                }
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }

            }

        }

    }

    private void dfs(char[][] board, int i, int j) {
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length){
           return;
        }else {
            //说明他是和边界相连的点，将其置位#,表示这些是不能被变换的
            if(board[i][j] != 'X' && board[i][j] != '#'){
                board[i][j] = '#';
                dfs(board,i+1,j);
                dfs(board,i-1,j);
                dfs(board,i,j+1);
                dfs(board,i,j-1);
            }
        }

    }

}
