package com.example.leetcode2.copy1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yingru.ljw
 * @date 2020-02-21 15:44
 */
public class 分割回文串 {

    public static void main(String[] args) {

        String a = "aab";
        List<List<String>> res = new 分割回文串().partition(a);
        System.out.println(res);


    }

    List<List<String>> res = new LinkedList<>();

    List<String> list = new LinkedList<>();

    int size = 0;

    public List<List<String>> partition(String s) {

        size =s.length();

        dfs(s,0);

        return res;

    }

    private void dfs(String s,int n) {
        if(n >= size || "".equals(s)){
            res.add(new ArrayList<>(list));
            return;
        }else {
            for (int i = 1; i <= s.length(); i++) {
                //截取
                String before = s.substring(0,i);
                if(!judge(before)){
                    continue;
                }
                list.add(before);
                dfs(s.substring(i),n+1);
                list.remove(list.size()-1);
            }
        }

    }

    private boolean judge(String str){
        StringBuilder stringBuilder = new StringBuilder(str);
        String origin = stringBuilder.toString();
        String newStr = stringBuilder.reverse().toString();
        return origin.equals(newStr);

    }
}
