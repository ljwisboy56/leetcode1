package com.example.leetcode2.copy2;

/**
 * @author yingru.ljw
 * @date 2020-03-29 00:56
 */
public class 第168题Excel表列名称 {

    public String convertToTitle(int n) {
        StringBuilder stringBuilder = new StringBuilder();
//        while (n != 0) {
////            n--;//这里稍作处理，因为它是从1开始
//            stringBuilder.append((char)(--n % 26 + 'A'));
//            n /= 26;
//        }
        for (int i = n;i > 0;i /= 26) {
            stringBuilder.append((char)(--i % 26 + 'A'));
        }
        return stringBuilder.reverse().toString();
    }

    public static String binaryToDecimal(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = n;i > 0;i /= 2) {
            stringBuilder.append(i % 2);
        }
        return stringBuilder.reverse().toString();
    }

}
