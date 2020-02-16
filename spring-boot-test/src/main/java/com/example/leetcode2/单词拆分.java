package com.example.leetcode2;

import sun.jvm.hotspot.debugger.Page;

import java.util.*;

/**
 * @author yingru.ljw
 * @date 2020-02-15 19:40
 */
public class 单词拆分 {


    public static void main(String[] args) {
        List<String> wordDict = new ArrayList<>();
//        wordDict.add("a");
//        wordDict.add("aa");
//        wordDict.add("aaa");
//        wordDict.add("aaaa");
//        wordDict.add("aaaaa");
//        wordDict.add("aaaaaa");
//        wordDict.add("aaaaaaa");
//        wordDict.add("aaaaaaaa");
//        wordDict.add("aaaaaaaaa");
//        wordDict.add("aaaaaaaaaa");
        wordDict.add("leet");
        wordDict.add("code");

//        boolean res = new 单词拆分().wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",wordDict);
        boolean res = new 单词拆分().wordBreak("leetcode",wordDict);
        System.out.println(res);

    }

    int[] book = null;

    List<String> wordDict = null;

    public boolean wordBreak(String s, List<String> wordDict) {

//        return word_Break(s, new HashSet(wordDict), 0, new Boolean[s.length()]);

        if(s == null){
            return false;
        }

        book = new int[s.length()];

        this.wordDict = wordDict;

        return dfs(0,s);

    }

    private boolean dfs(int n, String s) {

        if(n >= s.length()){
            return true;
        }else {
            if(book[n] == 1){
                return false;
            }
            for (int i =n; i < s.length();i++){
                //截取分支上的字符串
                if(wordDict.contains(s.substring(n,i+1))){
                    if(dfs(i+1,s)){
                        return true;
                    }
                }
            }
        }
        book[n] = 1;
        return false;

    }

    public boolean word_Break(String s, Set<String> wordDict, int start, Boolean[] memo) {
        if (start == s.length()) {
            return true;
        }
        if (memo[start] != null) {
            return false;
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end))) {
                if(word_Break(s, wordDict, end, memo)){
                   return true;
                }
            }
        }
        return memo[start] = false;
    }

}
