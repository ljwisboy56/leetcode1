package com.example.leetcode2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author yingru.ljw
 * @date 2020-02-18 15:32
 */
public class 重复的DNA序列 {

    /**
     * 题目的意思是编写一个函数来查找子串，这个子串长度为10，在原字符串中出现超过一次。
     * @param s
     * @return
     */
    public List<String> findRepeatedDnaSequences(String s) {

//        HashSet<String> set = new HashSet<>();
//        HashSet<String> visited = new HashSet<>();
//
//        for (int i =0; i + 10 < s.length();i++){
//            String tmp = s.substring(i,i+10);
//            if(visited.contains(tmp)){
//               set.add(tmp);
//            }else {
//                visited.add(tmp);
//            }
//        }


        HashSet<String> set = new HashSet<>();
        HashSet<String> visited = new HashSet<>();
        for (int i =0; i + 10 < s.length();i++){
            String tmp = s.substring(i,i+10);
            if(visited.contains(tmp)){
                set.add(tmp);
            }else {
                visited.add(tmp);
            }
            set.add(tmp);

        }
        return new ArrayList<>(set);
    }


}
