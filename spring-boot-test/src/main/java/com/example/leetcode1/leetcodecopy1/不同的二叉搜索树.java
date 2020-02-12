package com.example.leetcode1.leetcodecopy1;

/**
 * @author yingru.ljw
 * @date 2020-02-11 12:28
 */
public class 不同的二叉搜索树 {

    /**
     * G(n)=f(1)+f(2)+f(3)+f(4)+...+f(n)
     *
     * 当i为根节点时，其左子树节点个数为i-1个，右子树节点为n-i，则
     * f(i) = G(i-1)*G(n-i)f(i)=G(i−1)∗G(n−i)
     *
     * 综合两个公式可以得到 卡特兰数 公式
     * G(n) = G(0)*G(n-1)+G(1)*(n-2)+...+G(n-1)*G(0)G(n)=G(0)∗G(n−1)+G(1)∗(n−2)+...+G(n−1)∗G(0)
     *
     * 作者：guanpengchn
     * 链接：https://leetcode-cn.com/problems/unique-binary-search-trees/solution/hua-jie-suan-fa-96-bu-tong-de-er-cha-sou-suo-shu-b/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        //解释里面拿个循环 就是 G(0)*G(n-1)
        for(int i = 2; i < n + 1; i++)
            for(int j = 1; j < i + 1; j++)
                dp[i] += dp[j-1] * dp[i-j];

        return dp[n];
    }
}
