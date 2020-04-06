package com.example.leetcode2.copy2;

import java.util.Collections;
import java.util.HashMap;

/**
 * @author yingru.ljw
 * @date 2020-03-28 15:44
 */
public class 第159题至多包含两个不同字符的最长子串 {

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s == null || "".equals(s)){
            return 0;
        }

        int len = s.length();

        if(len <= 2){
            return len;
        }

        int left = 0;
        int right = 0;
        HashMap<Character, Integer> hashmap = new HashMap<>();
        int maxLen = 2;
        while (right < s.length()) {

            if (hashmap.size() <= 2){
                //更新当前字符的坐标
                hashmap.put(s.charAt(right), right);
                right++;
            }

            if (hashmap.size() == 3) {
                int delIdx = Collections.min(hashmap.values());
                hashmap.remove(s.charAt(delIdx));
                left = delIdx + 1;
            }
            maxLen = Math.max(maxLen, right - left);
        }
        return maxLen;
    }

}
