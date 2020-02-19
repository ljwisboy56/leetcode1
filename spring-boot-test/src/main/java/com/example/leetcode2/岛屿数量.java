package com.example.leetcode2;

/**
 * @author yingru.ljw
 * @date 2020-02-19 10:59
 */
public class 岛屿数量 {

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

    private void dfs(char[][] grid, int n, int m) {

        if(n <0 || m <0 || n >= grid.length || m >= grid[0].length || grid[n][m] == 'O'){
            return;
        }else {
            if(grid[n][m] == '1'){
                grid[n][m] = 'O';
                dfs(grid,n-1,m);
                dfs(grid,n+1,m);
                dfs(grid,n,m-1);
                dfs(grid,n,m+1);
            }
        }
    }

}
