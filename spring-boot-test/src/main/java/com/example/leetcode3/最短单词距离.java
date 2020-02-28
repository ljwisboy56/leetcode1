package com.example.leetcode3;

import java.util.*;

/**
 * @author yingru.ljw
 * @date 2020-02-28 17:45
 */
public class 最短单词距离 {

    public static void main(String[] args) {

        String[] wods = {"practice", "makes", "perfect", "coding", "makes"};
        int res = new 最短单词距离().shortestDistance(wods,"coding","practice");
        System.out.println(res);

    }

    /**
     * ["a","a","b","b"]
     * "a"
     */

    public int shortestDistance(String[] words, String word1, String word2) {

        HashMap<String, LinkedList<Integer>> hashMap = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if(hashMap.containsKey(words[i])){
                LinkedList<Integer> queue = hashMap.get(words[i]);
                queue.add(i);
                hashMap.put(words[i],queue);
            }else {
                LinkedList<Integer> queue = new LinkedList<>();
                queue.add(i);
                hashMap.put(words[i],queue);

            }
        }

        LinkedList<Integer> queue1 = hashMap.get(word1);
        LinkedList<Integer> queue2 = hashMap.get(word2);

        int min = Integer.MAX_VALUE;

        for (Integer value : queue1) {
            for (Integer integer : queue2) {
                min = Math.min(Math.abs(value-integer),min);
            }
        }
        return min;
    }

}
