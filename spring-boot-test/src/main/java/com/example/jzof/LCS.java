package com.example.jzof;

/**
 * @author yingru.ljw
 * @date 2019-12-12 21:32
 */
public class LCS {


    /**
     * 给定两个字符串，求解这两个字符串的最长公共子序列（Longest Common Sequence）。比如字符串1：BDCABA；字符串2：ABCBDAB
     *
     * 则这两个字符串的最长公共子序列长度为4，最长公共子序列是：BCBA
     *
     * 转移方程：
     * L（xn,yn)标识在x的n和y的n的字符处的最大子序列是多少
     * 子问题：
     * if(xn=yn),那么L（xn,yn)=L(x(n-1),y(n-1))+1;
     * if(xn!=yn),那么L（xn，yn）=min{L（x（n-1）,y(n)),L(x(n),y(n-1))};
     * x=0,L(0,y)=0;
     * y=0,L(x,0)=0;
     */
    public int lcs(String str1,String str2){
        int[][] dp = new int[str1.length()][str2.length()];
        //初始化边界条件
        for(int i = 0;i < str2.length();i++){
            dp[0][i] = 0;
        }

        for(int j =0;j < str1.length();j++){
            dp[j][0]=0;
        }

        int max = 0;

        for(int i =1;i<str1.length();i++){
            for(int j = 1;j<str2.length();j++){
                if(str1.charAt(i) == str2.charAt(j)){
                    dp[i][j]=dp[i-1][j-1]+1;
                    max = Math.max(max,dp[i][j]);
                }else {
                    dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1]);
                    max = Math.max(max,dp[i][j]);
                }
            }
        }
        return max;
    }

}
