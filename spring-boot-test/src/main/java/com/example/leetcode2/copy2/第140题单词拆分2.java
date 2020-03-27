package com.example.leetcode2.copy2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yingru.ljw
 * @date 2020-03-26 14:53
 */
public class 第140题单词拆分2 {

    private Map<String, List<String>> map = new HashMap<>();

    // 分割字符串,返回s的所有可能的分割情况
    public List<String> wordBreak(String s, List<String> wordDict) {
        return dfs(s,wordDict);
    }

    private List<String> dfs(String s, List<String> wordDict) {
        if(map.containsKey(s)){
            return map.get(s);
        }

        List<String> res = new ArrayList<>();
        if(wordDict.contains(s)){
            res.add(s);
        }
        // 分割
        for(int i = 1; i < s.length(); i++){
            String str = s.substring(0,i);
            if(wordDict.contains(str)){
                List<String> list = dfs(s.substring(i),wordDict);
                // 可以成功分割
                if(list.size() > 0){
                    for(String ss : list){
                        res.add(str+" " + ss);
                    }
                }
            }
        }
        map.put(s,res);
        return res;
    }

}
