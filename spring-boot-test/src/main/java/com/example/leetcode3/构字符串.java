package com.example.leetcode3;

import java.util.HashMap;

/**
 * @author yingru.ljw
 * @date 2020-02-26 13:41
 */
public class 构字符串 {


    public boolean isIsomorphic(String s, String t) {

        if(s.length() != t.length()){
            return false;
        }

        HashMap<Character, Character> map = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            if(!map.containsKey(s.charAt(i))){
                if(map.containsValue(t.charAt(i))){
                    return false;
                }
                map.put(s.charAt(i), t.charAt(i));
            }else{
                if(map.get(s.charAt(i))!=t.charAt(i)){
                    return false;
                }
            }
        }

        return true;

    }


}
