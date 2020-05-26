package com.example.leetcode2.copy1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yingru.ljw
 * @date 2020-02-22 00:31
 */
public class 单词拆分2 {

    public static void main(String[] args) {

        List<String> wordDict = new ArrayList<>();
        wordDict.add("cat");
        wordDict.add("cats");
        wordDict.add("and");
        wordDict.add("sand");
        wordDict.add("dog");

        List<String> res = new 单词拆分2().wordBreak("catsanddog",wordDict);
        System.out.println(res);
    }


    private Map<String, List<String>> map = new HashMap<>();

    // 分割字符串,返回s的所有可能的分割情况
    public List<String> wordBreak(String s, List<String> wordDict) {
        if(map.containsKey(s)){
            return map.get(s);
        }
        List<String> res = new ArrayList<>();
        // 不分割
        if(wordDict.contains(s)){
            res.add(s);
        }
        // 分割
        for(int i = 1; i < s.length(); i++){
            String str = s.substring(0,i);
            if(wordDict.contains(str)){
                List<String> list = wordBreak(s.substring(i),wordDict);
                // 可以成功分割
                if(list.size() > 0){
                    for(String ss : list){
                        res.add(str+" " + ss);
                    }
                }
            }
        }
        //存住当前字符串s的结果集，有就有，没有就返回空
        map.put(s,res);
        return res;
    }

    int size ;

    List<String> wordDict ;

    List<String> res = new ArrayList<>();

    List<String> list = new ArrayList<>();
    List<String> tmp = new ArrayList<>();

    public List<String> wordBreak2(String s, List<String> wordDict){

        this.wordDict = wordDict;

        int size = s.length();

        dfs(s,0);

        return res;


    }

    private void dfs(String s, int n) {
        if(n >= s.length() || "".equals(s)||map.containsKey(s)){
            String str = "";
            for (int i = 0; i < list.size(); i++) {
                if(i == list.size()-1){
                    str += list.get(i);
                }else {
                    str += list.get(i) + " ";
                }
            }
            tmp = new ArrayList<>(list);
            res.add(str);

        }
        else {
            for (int i = 1; i <= s.length(); i++) {
                String before = s.substring(0,i);
                if(!wordDict.contains(before)){
                    continue;
                }
                list.add(before);
                dfs(s.substring(i),n+1);
                list.remove(list.size()-1);
            }
            map.put(s,new ArrayList<>(tmp));
            tmp.clear();

        }

    }
}
