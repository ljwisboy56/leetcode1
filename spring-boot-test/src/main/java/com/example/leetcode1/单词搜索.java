package com.example.leetcode1;

/**
 * @author yingru.ljw
 * @date 2020-01-11 21:49
 */
public class 单词搜索 {

    public static void main(String[] args) {

        char[][] arr = new char[3][4];
        char[] a = new char[]{'A', 'B', 'C', 'D'};
        char[] b = new char[]{'S', 'F', 'C', 'S'};
        char[] c = new char[]{'A', 'D', 'E', 'E'};

        arr[0] = a;
        arr[1] = b;
        arr[2] = c;
        boolean res = new 单词搜索().exist(arr, "ABCCED");
        System.out.println(res);
    }

//    char[] arr = null;
//
//    boolean res = false;
//
//    public boolean exist(char[][] board, String word) {
//
//        arr = word.toCharArray();
//        return doFind(0, 0, board,0);
//    }
//
//    private boolean doFind(int n, int m, char[][] board,int index) {
//        if(res){
//            return true;
//        }
//        if (n > board.length && m > board[0].length) {
//            return false;
//        } else if(index == arr.length){
//            return true;
//        }
//        else {
//            if(res){
//                return true;
//            }
//            for (int i = 0; i <= 1; i++) {
//                for (int j = 0; j <= 1; j++) {
//                    if (i ==j && i != 0) {
//                        continue;
//                    }
//                    if(constraint(n+i,m+j,n,m,board,index)){
//                        realFind(n+i,m+j,n,m,board,index);
//                    }else {
//                        doFind(n+i,m+j,board,index);
//                    }
//                }
//
//            }
//        }
//        return false;
//    }
//
//    private void realFind(int n, int m,int pren,int prem, char[][] board,int index) {
//
//        if(n > arr.length || m > arr.length){
//            res = false;
//        }else if(index == arr.length-1){
//            res = true;
//        }
//        for (int i=-1;i <= 1;i++){
//            for (int j =-1;j <=1;j++){
//                if(n +i <0 || m +j < 0){
//                    continue;
//                }
//                if(j == 0 && i == 0){
//                    continue;
//                }
//                if(j == i){
//                    continue;
//                }
//                if(n + i == pren){
//                    continue;
//                }
//                if(m + j == prem){
//                    continue;
//                }
//                if(constraint(n+i,m+j,n,m,board,index+1)){
//                    realFind(n+i,m+j,n,m,board,index+1);
//                }
//            }
//        }
//        res = false;
//    }
//
//    private boolean constraint(int n, int m,int pren,int prem, char[][] board,int index) {
//        char cur = board[n][m];
//        char in = arr[index];
//        return cur == in;
//    }


    boolean[][] visited ;

    int[][] d = null;

    String word = null;

    int x ;

    int y ;

    public boolean exist(char[][] board, String word) {
        this.visited = new boolean[board.length][board[0].length];

        this.word = word;

        x = board.length;

        y = board[0].length;

        d = new int[4][2];
        
        int[] r = new int[]{0,1};
        int[] l = new int[]{0,-1};
        int[] u = new int[]{1,0};
        int[] dd = new int[]{-1,0};
        
        d[0] = r;
        d[1] = l;
        d[2] = u;
        d[3] = dd;
        
        for(int i =0; i<x;i++){
            for (int j =0;j < y;j++){
                if(process(i,j,board,0)){
                    return true;
                }
            }
        }

        return false;
    }

    private boolean process(int row, int col, char[][] board, int index) {

        if(index == word.length()-1){
            return board[row][col]==word.charAt(index);
        }
        if(board[row][col] == word.charAt(index)){
            visited[row][col] = true;
            for (int i =0;i<4;i++){
                int newRow = row + d[i][0];
                int newCol = col + d[i][0];
                if(legal(newRow,newCol) && !visited[newRow][newCol] && process(newRow,newCol,board,index+1)){
                    return true;
                }
            }
            visited[row][col] = false;
        }
        return false;
    }

    private boolean legal(int newRow, int newCol) {
        return newRow >=0 && newCol >=0 && newRow <x && newCol <y;
    }

}
