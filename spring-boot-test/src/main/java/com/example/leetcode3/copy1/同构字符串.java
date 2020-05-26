package com.example.leetcode3.copy1;

import java.util.HashMap;

/**
 * @author yingru.ljw
 * @date 2020-03-02 18:25
 */
public class 同构字符串 {

    public static void main(String[] args) {

        System.out.println(new 同构字符串().isIsomorphic("ab","aa"));

    }

    
    public boolean isIsomorphic(String s, String t) {

        if(s.length() != t.length()){
            return false;
        }

        HashMap<Character,Character> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if(map.get(s.charAt(i)) == null){
                if(map.containsValue(t.charAt(i))){
                    return false;
                }
                map.put(s.charAt(i),t.charAt(i));
            }else {
                Character tmp = map.get(s.charAt(i));
                if(!tmp.equals(t.charAt(i))){
                    return false;
                }
            }
        }
        return true;

    }

}
