package com.example.leetcode2.copy1;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author yingru.ljw
 * @date 2020-02-20 21:08
 */
public class 单词接龙 {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue =  new LinkedList<>();
        HashSet<String> set = new HashSet<>();
        queue.add(beginWord);
        int layer = 1;
        while (!queue.isEmpty()){
            layer++;
            int size = queue.size();
            while (size > 0){
                size--;
                String cur = queue.poll();
                for (String s : wordList) {
                    if (set.contains(s)) {
                        continue;
                    }
                    if (check(cur, s)) {
                        if (s.equals(endWord)) {
                            return layer;
                        }else {
                            set.add(s);
                            queue.add(s);
                        }
                    }
                }
            }
        }
        return 0;
    }

    private boolean check(String cur, String tmp) {
        int count =0;
        for (int i = 0; i < cur.length(); i++) {
            if(cur.charAt(i) != tmp.charAt(i)){
                count++;
                if(count >1){
                    return false;
                }
            }
        }
        return count==1;
    }

}
