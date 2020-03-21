package com.example.leetcode1.copy2;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author yingru.ljw
 * @date 2020-03-21 16:24
 */
public class 第76题最小覆盖子串 {

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";

        String res = new 第76题最小覆盖子串().minWindow(s,t);
        System.out.println(res);

    }

    public String minWindow(String s, String t) {

        if(s == null || t == null){
            return "";
        }


        if(t.length() > s.length()){
            return "";
        }

        if(t.equals(s)){
            return t;
        }

        HashMap<Character, Integer> targetMap = new HashMap<>();

        HashMap<Character, Integer> window = new HashMap<>();

        int len = Integer.MAX_VALUE;

        int start = 0;

        //先初始化数组
        for (int i = 0;i < t.length();i++){
            targetMap.put(t.charAt(i),targetMap.getOrDefault(t.charAt(i),0)+1);
        }

        int left = 0;
        int right = 0;

        int match = 0;

        while (right <= s.length()-1){

            char c = s.charAt(right);

            if(targetMap.containsKey(c)){
                window.put(c,window.getOrDefault(c,0)+1);
                if(window.get(c).equals(targetMap.get(c))){
                    match++;
                }
            }
            right++;

            while (match == targetMap.size()){
                if(right - left < len){
                    start = left;
                    len = right - left;
                }

                char tmp = s.charAt(left);
                if(targetMap.containsKey(tmp)){
                    int v = window.get(tmp);
                    if(v == 0){
                        window.remove(tmp);
                    }else {
                        //减去一个key值并不会影响window和targetmap的比较
                        window.put(tmp,--v);
                    }
                    if(window.get(tmp) == null || window.get(tmp) < targetMap.get(tmp)){
                        match--;
                    }
                }
                left++;
            }
        }
        return len == Integer.MAX_VALUE?"":s.substring(start,start+len);
    }

}
