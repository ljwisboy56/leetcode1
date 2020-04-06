package com.example.leetcode2.copy2;

/**
 * @author yingru.ljw
 * @date 2020-03-28 16:19
 */
public class 第161题相隔为1的编辑距离 {


    public boolean isOneEditDistance(String s, String t) {
        //状态转移方程：dp(i,j)表示s的前i个字符，由t的前j个字符表示的编辑距离步数
        int[][] dp = new int[s.length()+1][t.length()+1];

        dp[0][0] = 0;
        //初始化
        for (int i = 0; i <= s.length(); i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= t.length(); i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if(s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    dp[i][j] = min(
                            dp[i][j-1]+1,//增
                            dp[i-1][j]+1,//删
                            dp[i-1][j-1]+1//改
                    );
                }
            }
        }
        return dp[s.length()][t.length()] == 1;
    }

    private int min(int a,int b,int c){
        return Math.min(a,Math.min(b,c));
    }


}
