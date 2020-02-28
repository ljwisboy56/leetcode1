package com.example.leetcode3;

/**
 * @author yingru.ljw
 * @date 2020-02-28 11:26
 */
public class 二的幂 {

    public boolean isPowerOfTwo(int n) {

        for (int i = 0; i <= n; i++) {
            if(Math.pow(2,i) < n){
                continue;
            }else if(Math.pow(2, i) == n){
                return true;
            }else {
                return false;
            }
        }
        return false;
    }

    /**
     * 若 n = 2^xn=2
     * x
     *   且 xx 为自然数（即 nn 为 22 的幂），则一定满足以下条件：
     * 恒有 n & (n - 1) == 0，这是因为：
     * nn 二进制最高位为 11，其余所有位为 00；
     * n - 1n−1 二进制最高位为 00，其余所有位为 11；
     * 一定满足 n > 0。
     *
     */
    public boolean isPowerOfTwo2(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

}
