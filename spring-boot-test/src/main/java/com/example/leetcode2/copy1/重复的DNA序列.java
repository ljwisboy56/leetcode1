package com.example.leetcode2.copy1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author yingru.ljw
 * @date 2020-02-24 01:09
 */
public class 重复的DNA序列 {

    public List<String> findRepeatedDnaSequences(String s) {

        HashSet<String> visted = new HashSet<>();

        HashSet<String> res = new HashSet<>();

        for (int i = 0; i+10<=s.length(); i++) {
            String str = s.substring(i,i+10);
            if(visted.contains(str)){
                res.add(str);
            }else {
                visted.add(str);
            }
        }

        return new ArrayList<>(res);


    }

}
