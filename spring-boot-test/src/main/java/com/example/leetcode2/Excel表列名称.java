package com.example.leetcode2;

import java.util.HashMap;

/**
 * @author yingru.ljw
 * @date 2020-02-18 01:44
 */
public class Excel表列名称 {

    public static void main(String[] args) {
        String res = new Excel表列名称().convertToTitle(26);
        System.out.println(res);
    }


    /**
     * 这题就是标准的26进制转换，
     * @param n
     * @return
     */
    public String convertToTitle(int n) {

        StringBuilder stringBuilder = new StringBuilder();
//        while (n != 0) {
//            n --;//这里稍作处理，因为它是从1开始
//            stringBuilder.append((char)(n % 26 + 'A'));
//            n /= 26;
//        }
        for (int i = n; i > 0 ; i /= 26) {
            //此处要减去个1
            i--;
            char tmp = (char) ((i)% 26+ 'A');
            stringBuilder.append(tmp);
        }
        return stringBuilder.reverse().toString();

    }

    /**
     * 下面是二进制
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

}
