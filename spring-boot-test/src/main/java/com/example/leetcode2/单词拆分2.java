package com.example.leetcode2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author yingru.ljw
 * @date 2020-02-15 21:31
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

    List<String> wordDict = null;

    List<String> res = new ArrayList<>();

    List<String> tmp = new ArrayList<>();

    HashMap<Integer,List<String>> map = new HashMap<>();

    public List<String> wordBreak(String s, List<String> wordDict) {

        if(s == null){
            return res;
        }

        this.wordDict = wordDict;

        dfs(0,s);

        return res;
    }

    /**
     *
     * [pine apple pen apple, pine applepen pine applepen, pineapple pineapple]
     * [pine apple pen apple,pineapple pen apple,pine applepen apple]
     *
     * @param n
     * @param s
     */
    private void dfs(int n, String s) {
        if(n >= s.length()){
            StringBuilder stringBuilder = new StringBuilder();
            for (String str:tmp){
                stringBuilder.append(str);
            }
            String r = stringBuilder.toString();
            r= r.trim();
            res.add(r);
        }else if(map.containsKey(n)){
            List<String> ts = map.get(n);
            List<String> newTmp = new ArrayList<>(tmp);
            newTmp.addAll(ts);
            StringBuilder stringBuilder = new StringBuilder();
            for (String str:newTmp){
                stringBuilder.append(str);
            }
            String r = stringBuilder.toString();
            r= r.trim();
            map.put(n,newTmp);
            res.add(r);
        }else {
            for (int i =n; i < s.length();i++){
                String str = s.substring(n,i+1);
                tmp.add(str);
                tmp.add(" ");
                //截取分支上的字符串
                if(wordDict.contains(str)){
                    dfs(i+1,s);
                }
                tmp.remove(tmp.size()-1);
                tmp.remove(tmp.size()-1);
            }
        }
        map.put(n,tmp);

    }

}
