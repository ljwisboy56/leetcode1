package com.example.leetcode1.copy2;

import java.util.HashSet;

/**
 * @author yingru.ljw
 * @date 2020-03-04 18:42
 */
public class 无重复字符的最长子串 {

    public int lengthOfLongestSubstring(String s) {
        if(s == null || "".equals(s)){
            return 0;
        }

        int max = 0;
        int left =0;
        int right =0;
        HashSet<Character> set = new HashSet<>();

        while (right < s.length()){
            if(!set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                right++;
                max = Math.max(max,right-left);
            }else {
                set.remove(s.charAt(left));
                left++;
            }
        }

        return max;

    }

}
