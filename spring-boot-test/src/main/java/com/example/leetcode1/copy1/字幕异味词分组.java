package com.example.leetcode1.copy1;

import java.util.*;

/**
 * @author yingru.ljw
 * @date 2020-02-06 12:40
 */
public class 字幕异味词分组 {

    public static void main(String[] args) {
        List<List<String>>  res = new 字幕异味词分组().groupAnagrams(new String[]{"atb","tab","tan"});
    }

    HashMap<String,List<String>> map = new HashMap<>();

    List<List<String>> res = new ArrayList<>();

    /**
     * 这个做法不行，因为set会去重
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length ==0){
            return res;
        }

        for (String str : strs){
            HashSet<Character> set = new HashSet<>();
            for (char c : str.toCharArray()){
                set.add(c);
            }
            String key = "-";
            for (char t : set){
                key += t;
            }
            if(map.containsKey(key)){
                map.get(key).add(str);
            }else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(key,list);
            }
        }

        for (Map.Entry<String,List<String>> entry : map.entrySet()){
            res.add(entry.getValue());
        }

        return res;

    }

    public List<List<String>> groupAnagrams2(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        for (String str : strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            if(map.containsKey(key)){
                List<String> list = map.get(key);
                list.add(str);
            }else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(key,list);
            }
        }
        return new ArrayList<>(map.values());
    }

}
