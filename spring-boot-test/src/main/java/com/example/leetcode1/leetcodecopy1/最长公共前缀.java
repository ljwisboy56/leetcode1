package com.example.leetcode1.leetcodecopy1;

/**
 * @author yingru.ljw
 * @date 2020-01-21 17:22
 */
public class 最长公共前缀 {

    public static void main(String[] args) {
        String abc = "abcd";
        String[] arr = new String[]{"abc","b","abcde"};

        System.out.println(abc.substring(0,abc.length()));
        System.out.println(abc.indexOf("bcdef"));

        String s = new 最长公共前缀().longestCommonPrefix(arr);
        System.out.println(s);

    }


    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++){
//            while (strs[i].indexOf(prefix) != 0) {
            while (!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }

        return prefix;

    }

}
