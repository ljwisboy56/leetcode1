package com.example.leetcode3.copy2;

import java.util.HashMap;

/**
 * @author yingru.ljw
 * @date 2020-03-30 00:40
 */
public class 第205题同构字符串 {

    public boolean isIsomorphic(String s, String t) {
        char[] ch1 = s.toCharArray();
        char[] ch2 = t.toCharArray();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if(s.indexOf(ch1[i]) != t.indexOf(ch2[i])){
                return false;
            }
        }
        return true;
    }

    public boolean isIsomorphic2(String s, String t) {
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
