package com.example.leetcode1.copy1;

import java.util.HashSet;

/**
 * @author yingru.ljw
 * @date 2020-01-18 20:40
 */
public class 无重复字符的最长子串 {

    /**
     * 滑动窗口：
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {

        int max = 0;

        int n = s.length();

        int left = 0;
        int right = 0;
        HashSet<Character> set = new HashSet<>();

        while (left <n && right <n){
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
