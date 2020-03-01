package com.example.leetcode3;

import java.util.HashSet;

/**
 * @author yingru.ljw
 * @date 2020-02-29 20:28
 */
public class 回文排列 {


    public boolean canPermutePalindrome(String s) {

        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if(set.contains(s.charAt(i))){
                set.remove(s.charAt(i));
            }else {
                set.add(s.charAt(i));
            }
        }

        return set.size() <= 1;

    }

}
