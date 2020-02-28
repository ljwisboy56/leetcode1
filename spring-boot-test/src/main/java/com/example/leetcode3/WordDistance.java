package com.example.leetcode3;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author yingru.ljw
 * @date 2020-02-28 18:16
 */
public class WordDistance {

    String[] words = null;

    public WordDistance(String[] words) {
        this.words = words;
    }

    public int shortest(String word1, String word2) {
        return shortestDistance(words,word1,word2);
    }

    public int shortestDistance(String[] words, String word1, String word2) {

        int min = Integer.MAX_VALUE;
        int w1 = 0;
        int w2 = 0;
        boolean tag = false;
        boolean tag1 = false;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                w1 = i;
                tag = true;
            } else if (words[i].equals(word2)) {
                w2 = i;
                tag1 = true;
            }
            if (tag&&tag1) {
                min = Math.min(Math.abs(w1 - w2), min);
            }
        }
        return min;

    }
}
