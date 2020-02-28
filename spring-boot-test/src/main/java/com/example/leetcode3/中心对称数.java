package com.example.leetcode3;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author yingru.ljw
 * @date 2020-02-28 18:49
 */
public class 中心对称数 {

    public static void main(String[] args) {
        boolean res = new 中心对称数().isStrobogrammatic("69");
        System.out.println(res);


    }

    static HashMap<Character,Character> set = new HashMap<>();

    static {
        set.put('6','9');
        set.put('9','6');
        set.put('0','0');
        set.put('1','1');
        set.put('8','9');
    }

    public boolean isStrobogrammatic(String num) {

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = num.length()-1; i >= 0; i--) {
            stringBuilder.append(set.get(num.charAt(i)));
        }

        return num.equals(stringBuilder.toString());

    }
}
