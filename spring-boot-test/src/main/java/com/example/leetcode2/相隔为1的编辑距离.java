package com.example.leetcode2;

/**
 * @author yingru.ljw
 * @date 2020-02-17 15:27
 */
public class 相隔为1的编辑距离 {

    public static void main(String[] args) {

        boolean res = new 相隔为1的编辑距离().isOneEditDistance("ab","abc");
        System.out.println(res);

    }

    /**
     * if(s(i) == t(j)){
     *     continue;
     * }else{
     *     min(
     *     增、删、改
     *     )
     * }
     */
    public boolean isOneEditDistance(String word1, String word2) {

        int m = word1.length();

        int n = word2.length();

        int[][] dp = new int[m+1][n+1];

        for (int  i= 1; i <=m;i++){
            dp[i][0] =  i;
        }

        for (int  i= 1; i <=n;i++){
            dp[0][i] =  i;
        }

        for (int i =1;i <=m;i++){
            for (int j = 1; j <= n; j++) {
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    dp[i][j] = min(dp[i-1][j]+1,dp[i][j-1]+1,dp[i-1][j-1]+1);
                }
            }
        }

        return dp[m][n] == 1;
    }

    private int min(int a,int b,int c){
        return Math.min(Math.min(a,b),c);
    }

}
