package com.example.leetcode2.copyleetcode2;

import java.util.Collections;
import java.util.HashMap;

/**
 * @author yingru.ljw
 * @date 2020-02-22 18:01
 */
public class 至多包含两个不同字符的最长子串 {

    public static void main(String[] args) {

        String str = "eceba";

        int res = new 至多包含两个不同字符的最长子串().lengthOfLongestSubstringTwoDistinct(str);

        System.out.println(res);

    }


    public int lengthOfLongestSubstringTwoDistinct(String s) {

        int left = 0;
        int right = 0;
        // hashmap character -> its rightmost position
        // in the sliding window
        HashMap<Character, Integer> hashmap = new HashMap<>();

        int max_len = 2;

        while (right < s.length()) {
            // slidewindow contains less than 3 characters
            if (hashmap.size() < 3){
                hashmap.put(s.charAt(right), right++);
            }

            // slidewindow contains 3 characters
            if (hashmap.size() == 3) {
                // delete the leftmost character
                int del_idx = Collections.min(hashmap.values());
                hashmap.remove(s.charAt(del_idx));
                // move left pointer of the slidewindow
                left = del_idx + 1;
            }

            max_len = Math.max(max_len, right - left);
        }
        return max_len;

    }

}
