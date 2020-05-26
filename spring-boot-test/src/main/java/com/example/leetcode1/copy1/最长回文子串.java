package com.example.leetcode1.copy1;

/**
 * @author yingru.ljw
 * @date 2020-01-19 22:40
 */
public class 最长回文子串 {
    public static void main(String[] args) {

        String a = "babad";
        String res = new 最长回文子串().longestPalindrome(a);
        System.out.println(res);

    }

    /**
     * dp(i,j) = dp(i+1,j-1) && s(i)==s(j)是不是相等
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {

        if (s == null) {
            return null;
        }

        if ("".equals(s)) {
            return s;
        }


        int len = s.length();

        int[][] dp = new int[len][len];

        int fs = 0;

        int fe = 1;

        //先判断一下2个数的场景
        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
            if (i < len - 1) {
                if (s.charAt(i) == s.charAt(i + 1)) {
                    dp[i][i + 1] = 1;
                    fs = i;
                    fe = 2;
                }
            }
        }

        //然后再处理3个数的场景
        for (int l = 3; l <= len; l++) {
            for (int i = 0; i + l - 1 < len; i++) {
                //终点坐标
                int j = i + l - 1;

                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1] == 1) {
                    dp[i][j] = 1;
                    fs = i;
                    fe = l;
                }
            }
        }

        return s.substring(fs, fe+fs);
    }

}
