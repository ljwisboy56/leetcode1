package com.example.leetcode1.copy2;

/**
 * @author yingru.ljw
 * @date 2020-03-22 19:14
 */
public class 第97题交错字符串 {

    /**
     * 输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
     * 输出: true
     * 我们使用dp[i][j]dp[i][j]表示s_{1}s1的前ii个字符和s_{2}s2的前jj个字符是否能构成s_{3}s3的前i+ji+j个字符。
     */
    public boolean isInterleave(String s1, String s2, String s3) {

        if ((s1.length() + s2.length()) != s3.length()) return false;

        boolean[][] dp = new boolean[s2.length() + 1][s1.length() + 1];

        dp[0][0] = true;
        for (int i = 1; i <= s1.length(); i++) {
            dp[0][i] = dp[0][i - 1] && s1.charAt(i - 1) == s3.charAt(i - 1) ? true : false;
        }

        for (int i = 1; i <= s2.length(); i++) {
            dp[i][0] = dp[i - 1][0] && s2.charAt(i - 1) == s3.charAt(i - 1) ? true : false;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = (dp[i][j - 1] && s1.charAt(j - 1) == s3.charAt(i + j - 1)) || (dp[i - 1][j] && s2.charAt(i - 1) == s3.charAt(i + j - 1));
            }
        }
        return dp[s2.length()][s1.length()];
    }

}
