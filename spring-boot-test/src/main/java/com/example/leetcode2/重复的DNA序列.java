package com.example.leetcode2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author yingru.ljw
 * @date 2020-02-18 15:32
 */
public class 重复的DNA序列 {

    public List<String> findRepeatedDnaSequences(String s) {

        /**
         *  Set visited = new HashSet(), res = new HashSet();
         *         for (int i = 0; i + 10 <= s.length(); i++) {
         *             String tmp = s.substring(i, i + 10);
         *             if (visited.contains(tmp)) {
         *                 res.add(tmp);
         *             } else visited.add(tmp);
         *
         *
         *         }
         *         return new ArrayList<>(res);
         *
         */

        HashSet<String> set = new HashSet<>();
        HashSet<String> visited = new HashSet<>();

        for (int i =0; i + 10 < s.length();i++){
            String tmp = s.substring(i,i+10);
            if(visited.contains(tmp)){
               set.add(tmp);
            }else {
                visited.add(tmp);
            }
        }

        return new ArrayList<>(set);
    }


}
