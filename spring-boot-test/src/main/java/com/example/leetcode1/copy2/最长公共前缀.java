package com.example.leetcode1.copy2;

/**
 * @author yingru.ljw
 * @date 2020-03-04 20:19
 */
public class 最长公共前缀 {

    public static void main(String[] args) {

        String[] ss = {"flower", "flow", "flight"};
        String res = new 最长公共前缀().longestCommonPrefix(ss);
        System.out.println(res);

    }

    public String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0) {
            return "";
        }

        String res = strs[0];
        for (String str : strs) {
            res = help(res, str);
        }
        return res;

    }

    private String help(String res, String str) {
        String result = "";
        for (int i = 0; i < str.length() && i < res.length(); i++) {
            if (str.charAt(i) == res.charAt(i)) {
                result += str.charAt(i);
            } else {
                break;
            }
        }
        return result;
    }

}
