package com.example.leetcode2.copy2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yingru.ljw
 * @date 2020-03-26 01:57
 */
public class 第139题单词拆分 {

    public static void main(String[] args) {

        String[] strings = {"cats","dog","sand","and","cat"};

        List<String> list = new ArrayList<>();
        list.addAll(Arrays.asList(strings));

        System.out.println(new 第139题单词拆分().wordBreak("catsandog",list));

    }

    int[] visited ;

    List<String> wordDict = new ArrayList<>();

    public boolean wordBreak(String s, List<String> wordDict) {

        if(s == null){
            return false;
        }
        visited = new int[s.length()];
        this.wordDict = wordDict;
        return dfs(0,s);

    }

    private boolean dfs(int n, String s) {
        if("".equals(s)){
            return true;
        }else {
            if(visited[n] == 1){
                return false;
            }
            for (int i = 0; i < s.length(); i++) {
                String str = s.substring(0,i+1);
                if(!wordDict.contains(str)){
                    continue;
                }
                if(dfs(i+1,s.substring(i+1))){
                    return true;
                }
            }
        }
        visited[n] =1;
        return false;
    }

}
