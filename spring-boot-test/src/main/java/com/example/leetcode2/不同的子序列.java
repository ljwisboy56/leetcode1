package com.example.leetcode2;

/**
 * @author yingru.ljw
 * @date 2020-02-12 22:58
 */
public class 不同的子序列 {

    public static void main(String[] args) {

        int res = new 不同的子序列().numDistinct("rabbbit","rabbit");
        System.out.println(res);

    }


    /**
     * dp[i][j] 代表 T 前 i 字符串可以由 S j 字符串组成最多个数.
     * 当 S[j] == T[i] , dp[i][j] = dp[i-1][j-1] + dp[i][j-1];
     *
     * 当 S[j] != T[i] , dp[i][j] = dp[i][j-1]
     *
     * 举个例子,如示例的
     *
     * 作者：powcai
     * 链接：https://leetcode-cn.com/problems/distinct-subsequences/solution/dong-tai-gui-hua-by-powcai-5/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @return
     */
    public int numDistinct(String s, String t) {
        if(s == null || t == null){
            return 0;
        }

        if("".equals(s) || "".equals(t)){
            return 0;
        }

        int[][] dp = new int[t.length()+1][s.length()+1];

        for (int i =0;i < s.length();i++){
            dp[0][i] = 1;
        }

        for (int i = 1; i < t.length()+1; i++) {
            for (int j = 1; j < s.length()+1; j++) {
                if(s.charAt(j-1) == t.charAt(i-1)){
                    dp[i][j] = dp[i-1][j-1] + dp[i][j-1];
                }else {
                    dp[i][j] = dp[i][j-1];
                }
            }
        }

        return dp[t.length()][s.length()];
    }


}
