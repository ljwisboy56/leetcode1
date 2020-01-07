package com.example.leetcode1;

import java.util.*;

/**
 * @author yingru.ljw
 * @date 2020-01-06 22:46
 */
public class 字幕异位分组 {

    public static void main(String[] args) {
        String[] strings = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = new 字幕异位分组().groupAnagrams(strings);
        System.out.println(lists.toString());

    }

    /**
     *
     * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
     * 输出:
     * [
     *   ["ate","eat","tea"],
     *   ["nat","tan"],
     *   ["bat"]
     * ]
     *
     */

    public List<List<String>> groupAnagrams(String[] strs) {

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
