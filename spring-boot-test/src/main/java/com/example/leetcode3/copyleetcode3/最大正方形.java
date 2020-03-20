package com.example.leetcode3.copyleetcode3;

/**
 * @author yingru.ljw
 * @date 2020-03-02 23:14
 */
public class 最大正方形 {


    /**
     * dp(m,n)=
     * @param matrix
     * @return
     */
    /**
     * 没做出来，背下来得了，dp(i,j)表示的是i，j下的当前的正方形的最大边长。
     * @param matrix
     * @return
     */

        public int maximalSquare(char[][] matrix) {

            int rows = matrix.length;
            int cols = rows > 0 ? matrix[0].length : 0;
            int[][] dp = new int[rows + 1][cols + 1];
            int maxsqlen = 0;
            for (int i = 1; i <= rows; i++) {
                for (int j = 1; j <= cols; j++) {
                    if (matrix[i-1][j-1] == '1'){
                        dp[i][j] = min(dp[i][j - 1], dp[i - 1][j], dp[i - 1][j - 1]) + 1;
                        maxsqlen = Math.max(maxsqlen, dp[i][j]);
                    }
                }
            }
            return maxsqlen * maxsqlen;
        }

        private int min(int a,int b,int c){
            return Math.min(Math.min(a,b),c);
        }


}
