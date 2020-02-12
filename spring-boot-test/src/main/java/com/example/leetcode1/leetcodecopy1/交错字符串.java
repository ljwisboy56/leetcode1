package com.example.leetcode1.leetcodecopy1;

/**
 * @author yingru.ljw
 * @date 2020-02-11 21:46
 */
public class 交错字符串 {


    /**
     * 输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
     * 输出: true
     *
     * @param s1
     * @param s2
     * @param s3
     * @return
     */
    public boolean isInterleave(String s1, String s2, String s3) {

        if((s1.length() + s2.length()) != s3.length()) return false;

        boolean[][] dp = new boolean[s2.length() + 1][s1.length() + 1];

        dp[0][0] = true;
        for(int i = 1; i <= s1.length(); i++){
            dp[0][i] = dp[0][i-1]&&s1.charAt(i-1)==s3.charAt(i-1)? true : false;
        }

        for(int i = 1; i <= s2.length(); i++){
            dp[i][0] = dp[i-1][0]&&s2.charAt(i-1)==s3.charAt(i-1)? true : false;
        }

        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                dp[i][j] = (dp[i][j-1] && s1.charAt(j-1) == s3.charAt(i + j-1)) || (dp[i - 1][j] && s2.charAt(i-1) == s3.charAt(i + j-1));
            }
        }
        return dp[s2.length()][s1.length()];

    }

}
