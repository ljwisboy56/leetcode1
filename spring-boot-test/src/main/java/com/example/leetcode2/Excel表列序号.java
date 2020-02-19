package com.example.leetcode2;

/**
 * @author yingru.ljw
 * @date 2020-02-18 12:51
 */
public class Excel表列序号 {

    public static void main(String[] args) {

        int res = new Excel表列序号().titleToNumber("ZY");
        System.out.println(res);


    }

    public int titleToNumber(String s) {

        int res = 0;

        for (int i = s.length() - 1, n = 1; i >= 0; i--, n *= 26) {
            char cur = s.charAt(i);
            int v = ((int) cur +1) % 65;
            v = v * n;
            res = res + v;

        }

        return res;

    }

}
