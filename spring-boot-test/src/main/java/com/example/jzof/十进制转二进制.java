package com.example.jzof;

/**
 * @author yingru.ljw
 * @date 2020-02-18 21:07
 */
public class 十进制转二进制 {

    public static void main(String[] args) {

        int res= 1;

        for (int i =0;i < 5;i++){
            res <<= 1;
            System.out.println(res);
        }

    }

    /**
     * 除余方法
     * @param n
     * @return
     */
    public static String binaryToDecimal(int n) {
        int res = 0;
        for (int i = n, step = 1; i > 0;i /= 2, step *= 10) {
            res += i % 2 * step;

        }
        return String.valueOf(res);
    }

    public static String binaryToDecima2(int n) {
        int res = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 31;i >= 0;i--) {
            stringBuilder.append(n >>> i & 1);
        }
        return stringBuilder.toString();
    }



}
