package com.example.leetcode2.copy2;

/**
 * @author yingru.ljw
 * @date 2020-03-29 23:03
 */
public class 第190题颠倒二进制位 {

    public int reverseBits(int n) {
        int res =0;
        int i = 32;
        while (i != 0){
            res <<=1;
            res += (n & 1);
            n >>>=1;
            i--;
        }
        return res;

    }
}
