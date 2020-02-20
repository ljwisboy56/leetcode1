package com.example.leetcode2.copyleetcode2;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author yingru.ljw
 * @date 2020-02-20 19:29
 */
public class 验证回文串 {

    static HashSet<Character> set = new HashSet<>();

    static {
        String abc = "abcdefghijklmnopqrstuvwxyz";
        String number = "1234567890";

        char[] strings = abc.toCharArray();
        char[] numbers = number.toCharArray();

        for (char c : strings){
            set.add(c);
        }

        for (char c : numbers){
            set.add(c);
        }

    }


    public boolean isPalindrome(String s) {


        if(s == null || "".equals(s)){
            return true;
        }
        s = s.toLowerCase();

        StringBuilder stringBuilder = new StringBuilder();
        for (int i =0; i < s.length();i++){
            if(set.contains(s.charAt(i))){
                stringBuilder.append(s.charAt(i));
            }
        }

        String tmp = stringBuilder.toString();

        String reverse = stringBuilder.reverse().toString();

        return tmp.equals(reverse);


    }
}
