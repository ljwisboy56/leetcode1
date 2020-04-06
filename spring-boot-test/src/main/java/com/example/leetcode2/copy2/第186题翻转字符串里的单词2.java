package com.example.leetcode2.copy2;

import java.util.LinkedList;
import java.util.List;

/**
 * @author yingru.ljw
 * @date 2020-03-29 15:05
 */
public class 第186题翻转字符串里的单词2 {

    /**
     * 输入: ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
     * 输出: ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]
     */
    private void reverse(char[] s, int start, int end) {
        while (start < end) {
            char tmp = s[start];
            s[start] = s[end];
            s[end] = tmp;
            start++;
            end--;
        }
    }

    public void reverseWords(char[] s) {
        // 两次翻转即可，第一次全局翻转，第二次翻转各个单词
        int len = s.length;
        reverse(s, 0, len - 1);

        int start = 0;
        for (int i = 0; i < len; i++) {
            if (s[i] == ' ') {
                // 翻转前面的单词
                reverse(s, start, i-1);
                start = i + 1;
            }
        }

        // 翻转最后一个单词
        reverse(s, start, len - 1);
    }


}
