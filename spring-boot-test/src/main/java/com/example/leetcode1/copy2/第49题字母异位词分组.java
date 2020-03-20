package com.example.leetcode1.copy2;

import java.util.*;

/**
 * @author yingru.ljw
 * @date 2020-03-18 20:08
 */
public class 第49题字母异位词分组 {

    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0){
            return new ArrayList<>();
        }
        HashMap<String,List<String>> map = new HashMap<>();
        for(String str : strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            if(map.containsKey(key)){
                List<String> list = map.get(key);
                list.add(str);
                map.put(key,list);
            }else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(key,list);
            }
        }
        return new ArrayList<>(map.values());
    }


}
