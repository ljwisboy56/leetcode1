package com.example.leetcode1;

/**
 * @author yingru.ljw
 * @date 2020-01-09 20:16
 */
public class 编辑距离 {

    public static void main(String[] args) {

        String a = "ab";
        String b = "abc";

        int res = new 编辑距离().minDistance(a, b);
        System.out.println(res);

    }

    /**
     * if s1[i] == s2[j]:
     * 啥都别做（skip）
     * i, j 同时向前移动
     * else:
     * 三选一：
     * 插入（insert）
     * 删除（delete）
     * 替换（replace）
     * <p>
     * 作者：labuladong
     * 链接：https://leetcode-cn.com/problems/edit-distance/solution/bian-ji-ju-chi-mian-shi-ti-xiang-jie-by-labuladong/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int minDistance(String word1, String word2) {

        int m = word1.length();

        int n = word2.length();

        int[][] dp = new int[m+1][n+1];

        for (int i= 1; i <=m;i++){
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

        return dp[m][n];

    }

    private int min(int a,int b,int c){
        return Math.min(Math.min(a,b),c);
    }


}
