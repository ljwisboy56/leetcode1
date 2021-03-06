package com.example.leetcode2.copy2;

/**
 * @author yingru.ljw
 * @date 2020-03-29 23:32
 */
public class 第200题岛屿数量 {

    public int numIslands(char[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1'){
                    res++;
                    dfs(grid,i,j);
                }
            }
        }
        return res;

    }

    private void dfs(char[][] grid, int m, int n) {
        if(m < 0 || n < 0 || m >= grid.length || n >= grid[0].length){
            return;
        }else {
            if(grid[m][n] == '1'){
                grid[m][n] = 'O';
                dfs(grid,m-1,n);
                dfs(grid,m+1,n);
                dfs(grid,m,n-1);
                dfs(grid,m,n+1);
            }
        }
    }
}
