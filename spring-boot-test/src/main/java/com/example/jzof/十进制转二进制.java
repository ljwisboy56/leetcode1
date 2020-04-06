package com.example.jzof;

/**
 * @author yingru.ljw
 * @date 2020-02-18 21:07
 */
public class 十进制转二进制 {

    public static void main(String[] args) {

        System.out.println(binaryToDecimal(4));


    }

    /**
     * 除余方法
     * @param n
     * @return
     */
    public static String binaryToDecimal(int n) {
        int res = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = n;i > 0;i /= 2) {
            stringBuilder.append(i % 2);
        }
        return stringBuilder.reverse().toString();
    }

    public static String binaryToDecima2(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 31;i >= 0;i--) {
            stringBuilder.append(n >>> i & 1);
        }
        return stringBuilder.toString();
    }



}
