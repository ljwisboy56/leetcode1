package com.example.leetcode1.copy2;

/**
 * @author yingru.ljw
 * @date 2020-03-17 23:48
 */
public class 第38题外观数列 {

    public String countAndSay(int n) {
        String str = "1";
        for (int i = 2; i <= n; i++) {
            str = doSay(str);
        }
        return n == 1 ? "1" : str;
    }

    private String doSay(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        int count = 1;
        for (int i = 0; i < str.length(); i++) {
            while (i < str.length() - 1 && str.charAt(i) == str.charAt(i + 1)) {
                count++;
                i++;
            }
            stringBuilder.append(count).append(str.charAt(i));
            count=1;
        }
        return stringBuilder.toString();
    }

}
