package com.example.leetcode1.copy2;

/**
 * @author yingru.ljw
 * @date 2020-03-22 18:48
 */
public class 第96题不同的二叉搜索树 {


    public static void main(String[] args) {

        System.out.println(new 第96题不同的二叉搜索树().numTrees(3));

    }



    /**
     *
     *       i=1
     * G(n)= ∑G(i−1)⋅G(n−i)
     *       n
     *
     * G(n) = G(0)*G(n-1)+G(1)*(n-2)+...+G(n-1)*G(0)
     */
    public int numTrees(int n) {

        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

//        //第一个for循环就是求多项式的每一项的值，G(0)*G(n-1)
//        //第二个for循环就是把这些值加起来
//
//        for (int i =1; i <= n ; i++) {
//            dp[i] = dp[i-1] * dp[n-i];
//        }
//
//        int sum = 0;
//        for (int i = 0; i < n; i++) {
//            sum += dp[i];
//        }
//        return sum;

        for(int i = 2; i < n + 1; i++)
            for(int j = 1; j < i + 1; j++){
                dp[i] += dp[j-1] * dp[i-j];
            }
        return dp[n];
    }

}
