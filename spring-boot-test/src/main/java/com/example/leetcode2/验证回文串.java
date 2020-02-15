package com.example.leetcode2;

import java.util.HashSet;

/**
 * @author yingru.ljw
 * @date 2020-02-14 14:01
 */
public class 验证回文串 {

    public static void main(String[] args) {
        boolean res = new 验证回文串().isPalindrome(".G?j!:;;:Gj?!.");
        System.out.println(res);
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

    public boolean isPalindrome(String s) {


        if(s == null || "".equals(s)){
            return true;
        }

        s = s.toLowerCase();
        int len = s.length();
        int p1 = 0;
        int p2 = len-1;
        while (p1 <= p2){
            if(!set.contains(s.charAt(p1)) && set.contains(s.charAt(p2))){
                p1++;
            }else if(!set.contains(s.charAt(p2)) && set.contains(s.charAt(p1))){
                p2--;
            }else if(!set.contains(s.charAt(p1)) && !set.contains(s.charAt(p2))){
                p1++;
                p2--;
            }else {
                if(s.charAt(p1) == s.charAt(p2)){
                    p1++;
                    p2--;
                }else {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isPalindrome2(String s) {


        if(s == null || "".equals(s)){
            return true;
        }

        s = s.toLowerCase();


        StringBuilder stringBuilder = new StringBuilder();
        for (char c : s.toCharArray()){
            if(set.contains(c)){
                stringBuilder.append(c);
            }
        }

        String ss = stringBuilder.toString();

        int len = ss.length();
        int p1 = 0;
        int p2 = len-1;
        while (p1 <= p2){
            if(ss.charAt(p1) == ss.charAt(p2)){
                p1++;
                p2--;
            }else {
                return false;
            }
        }
        return true;
    }

}
