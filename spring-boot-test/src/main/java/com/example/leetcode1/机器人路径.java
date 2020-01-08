package com.example.leetcode1;

import com.example.order.In;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * @author yingru.ljw
 * @date 2020-01-08 16:54
 */
public class 机器人路径 {

    public static void main(String[] args) {

        int res = new 机器人路径().uniquePaths2(7,3);
        System.out.println(res);
    }

    /**
     * 动态规划 dp(i,j) = dp(i-1,j) + dp(i,j-1);
     *
     * 边界条件:
     * dp(0,1) = 1;
     * dp(1,0) = 1;
     * dp(1,1) = 2;
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths2(int m, int n) {

        int[][] dp = new int[m][n];

        for (int i = 0; i < n; i++){
            dp[0][i] = 1;
        }
        for (int i = 0; i < m; i++){
            dp[i][0] = 1;
        }

        for (int i = 1;i < m;i++){
            for(int j = 1;j < n;j++){
                dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }

        return dp[m-1][n-1];

    }

    int fm = 0;

    int fn = 0;

    int res = 0;

    public int uniquePaths(int m, int n) {
        fm = m-1;
        fn = n-1;
        doFind(0,0);
        return res;
    }


    HashSet<String> set = new HashSet<>();
    private void doFind(int m, int n) {

        if(n == fn && m == fm){
            res++;
        }else {
            for(int i= 0;i<=1;i++){
                for(int j =0;j <=1;j++){
                    if(j == i){
                        continue;
                    }
                    if(constratnt(m+j,n+i)){
                        doFind(m+j,n+i);
                    }
                }
            }
        }
    }

    private boolean constratnt(int m, int n) {
        if(m <= fm && n <= fn){
            return true;
        }else {
            return false;
        }
    }


}
