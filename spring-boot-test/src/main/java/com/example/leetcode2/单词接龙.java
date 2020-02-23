package com.example.leetcode2;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author yingru.ljw
 * @date 2020-02-15 01:34
 */
public class 单词接龙 {


    /**
     * 图的BFS比较经典，和树的DFS大体相同的
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Queue<String> queue =  new LinkedBlockingQueue<>();

        boolean[] visited = new boolean[wordList.size()];

        queue.add(beginWord);

        int layer = 1;

        while (!queue.isEmpty()){
            layer++;
            int size = queue.size();
            while (size > 0){
                size--;
                String tmp = queue.poll();
                for (int i =0; i < wordList.size();i++){
                    if(visited[i]){
                        continue;
                    }
                    String cur = wordList.get(i);
                    if(check(cur,tmp)){
                        if(cur.equals(endWord)){
                            return layer;
                        }
                        queue.add(cur);
                        visited[i] = true;

                    }
                }
            }
        }
        return 0;

    }

    private boolean check(String cur, String tmp) {
        int diff = 0;
        for (int i = 0; i < tmp.length(); i++) {
            if(diff > 1){
                return false;
            }
            if(cur.charAt(i) != tmp.charAt(i)){
                diff++;
            }
        }
        return diff == 1;
    }
}
