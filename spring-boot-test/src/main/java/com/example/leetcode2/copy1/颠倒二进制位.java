package com.example.leetcode2.copy1;

/**
 * @author yingru.ljw
 * @date 2020-02-24 13:04
 */
public class 颠倒二进制位 {

    public static void main(String[] args) {

        int res = new 颠倒二进制位().reverseBits(8);
        System.out.println(res);

    }

    public int reverseBits(int n) {
        int res =0;
        int i = 32;
        while (i != 0){

            res <<=1;
            res += (n &1);
            n >>>=1;
            i--;

        }
        return res;

    }

    public int reverseBits2(int n) {
        int res =0;
        for (int i = 0,step = 1;i <=31;i++,step*=2){
            if((n & 1)==0){
                res += step;
            }
            n >>>=1;
        }

        System.out.println(binaryToDecimal(res));
        return res;

    }

    public static String binaryToDecimal(int n) {
        int res = 0;
        for (int i = n, step = 1; i > 0;i /= 2, step *= 10) {
            res += i % 2 * step;

        }
        return String.valueOf(res);
    }

}
