package com.example.leetcode2.copyleetcode2;

/**
 * @author yingru.ljw
 * @date 2020-02-21 14:51
 */
public class 被围绕的区域 {

    public void solve(char[][] board) {
        if(board == null || board.length ==0){
            return;
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean isEdge = i == 0 || j == 0 || i == board.length - 1 || j == board[0].length - 1;
                if(isEdge && board[i][j] == 'O'){
                    dfs(i,j,board);
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                else if(board[i][j]=='#'){
                    board[i][j]='O';

                }
            }

        }
    }

    private void dfs(int i, int j, char[][] board) {

        if(i <0 || j <0 || i >= board.length || j >= board[0].length){
            return;
        }else {
            if(board[i][j] != 'X' && board[i][j] !='#'){
                board[i][j] = '#';
                //向上
                dfs(i-1,j,board);
                //向下
                dfs(i+1,j,board);
                //向左
                dfs(i,j-1,board);
                //向右
                dfs(i,j+1,board);
            }
        }
    }

}
