package com.example.leetcode2.copy2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yingru.ljw
 * @date 2020-03-25 21:39
 */
public class 第131题分割回文串 {

    public static void main(String[] args) {

        List<List<String>> allList = new 第131题分割回文串().partition("aab");
        System.out.println(allList);


    }

    /**
     * 输入: "aab"
     * 输出:
     * [
     *   ["aa","b"],
     *   ["a","a","b"]
     * ]
     */

    List<List<String>> allList = new ArrayList<>();
    List<String> list = new ArrayList<>();
    public List<List<String>> partition(String s) {
        if(s == null || "".equals(s.trim())){
            return allList;
        }

        dfs(0,s);
        return allList;
    }

    private void dfs(int n, String s) {
        if("".equals(s)){
            allList.add(new ArrayList<>(list));
            return;
        }else {
            for (int i = 0; i < s.length() ; i++) {
                String str = s.substring(0,i+1);
                if(judge(str)){
                    list.add(str);
                    dfs(i+1,s.substring(i+1));
                    list.remove(list.size()-1);
                }
            }
        }
    }

    private boolean judge(String str) {
        if(str == null){
            return true;
        }
        StringBuilder stringBuilder = new StringBuilder(str);
        return stringBuilder.toString().equals(stringBuilder.reverse().toString());

    }

}
