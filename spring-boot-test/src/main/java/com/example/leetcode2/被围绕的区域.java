package com.example.leetcode2;

import java.util.Stack;

/**
 * @author yingru.ljw
 * @date 2020-02-15 12:58
 */
public class 被围绕的区域 {


    /**
     * 解法从边界出发，找出不满足的O然后用#将其替换，然后等图的搜索结束后，将O直接
     * 成X，再将#还原成O
     * @param board
     */

    /**
     *
     * @param board
     */
    public void solve(char[][] board) {
        if(board == null || board.length ==0){
            return;
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean isEdge = i == 0 || j == 0 || i == board.length - 1 || j == board[0].length - 1;
                if(isEdge && board[i][j] == 'O'){
                    dfs2(i,j,board);
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                if(board[i][j]=='#'){
                    board[i][j]='O';

                }
            }

        }
    }



    /**
     * 图的DFS递归
     * @param i
     * @param j
     * @param board
     */
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

    /**
     * 图的dfs非递归，用栈做
     */
    private void dfs2(int i, int j, char[][] board) {

        Stack<Pos> stack = new Stack<>();

        stack.push(new Pos(i,j));

        while (!stack.isEmpty()){





        }



    }

    static public class Pos{
        int i;
        int j;
        Pos(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }




}
