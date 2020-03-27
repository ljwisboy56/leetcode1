package com.example.leetcode2.copy2;

import java.util.HashSet;

/**
 * @author yingru.ljw
 * @date 2020-03-25 14:18
 */
public class 第125题验证回文串 {

    public static void main(String[] args) {
        System.out.println(new 第125题验证回文串().isPalindrome("A man, a plan, a canal: Panama"));


    }

    static HashSet<Character> set = new HashSet<>();

    static {
        String s1 = "1234567890";
        String s2 = "abcdefghijklmnopqrstuvwxyz";
        for (char cc : s1.toCharArray()){
            set.add(cc);
        }
        for (char cc : s2.toCharArray()){
            set.add(cc);
        }
    }

    /**
     * 输入: "A man, a plan, a canal: Panama"
     * 输出: true
     */
    public boolean isPalindrome(String s) {

        if(s == null || "".equals(s.trim())){
            return true;
        }

        s = s.toLowerCase();
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < s.length();i++){
            if(set.contains(s.charAt(i))){
                stringBuilder.append(s.charAt(i));
            }
        }

        return stringBuilder.toString().equals(stringBuilder.reverse().toString());

    }

}
