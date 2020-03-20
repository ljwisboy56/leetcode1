package com.example.leetcode1.copy2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yingru.ljw
 * @date 2020-03-04 20:09
 */
public class 罗马转整数 {
    static Map<Character, Integer> map = new HashMap<>();

    static {
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }

    public int romanToInt(String s) {

        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            int cur = map.get(s.charAt(i));
            int next =0;
            if(i < s.length()-1){
                next = map.get(s.charAt(i+1));
            }
            res += cur < next ? -cur:cur;
        }
        return res;

    }

}
