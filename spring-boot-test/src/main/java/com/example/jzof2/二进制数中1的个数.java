package com.example.jzof2;

/**
 * @author yingru.ljw
 * @date 2019-12-22 23:36
 */
public class 二进制数中1的个数 {

    /**
     *
     * >>：带符号右移。正数右移高位补0，负数右移高位补1。比如：
     *
     * 4 >> 1，结果是2；-4 >> 1，结果是-2。-2 >> 1，结果是-1。
     *
     * >>>：无符号右移。无论是正数还是负数，高位通通补0。
     *
     * 对于正数而言，>>和>>>没区别。
     *
     * 对于负数而言，-2 >>> 1，结果是2147483647（Integer.MAX_VALUE），-1 >>> 1，结果是2147483647（Integer.MAX_VALUE）。
     *
     * 以下代码可以判断两个数的符号是否相等
     * @param n
     * @return
     */
    public int NumberOf1(int n) {

        int count =0;
        while (n != 0){
            if ((n & 1) ==1){
                count++;
            }
            n >>>= 1 ;
        }
        return count;
    }

}
