package com.example.leetcode2.copyleetcode2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yingru.ljw
 * @date 2020-02-21 21:56
 */
public class 单词拆分 {

    public static void main(String[] args) {

        List<String> wordDict = new ArrayList<>();
        wordDict.add("aaaa");
        wordDict.add("aaa");

        boolean res = new 单词拆分().wordBreak("aaaaaaa",wordDict);
        System.out.println(res);


    }

    int[] visited ;

    public boolean wordBreak(String s, List<String> wordDict) {

        if(s == null){
            return false;
        }

        visited = new int[s.length()];

        return dfs(0,s,wordDict);

    }

    private boolean dfs(int n, String s,List<String> wordDict) {

        if(n == s.length()){
            return true;
        }else{
            if(visited[n] == 1){
                return false;
            }
            for (int i = n; i < s.length(); i++) {
                String cur = s.substring(n,i+1);
                if(!wordDict.contains(cur)){
                    continue;
                }
                if(dfs(i+1,s,wordDict)){
                    return true;
                }
            }
        }
        visited[n] = 1;
        return false;
    }

}
