package com.example.leetcode3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author yingru.ljw
 * @date 2020-02-29 20:37
 */
public class 回文排列2 {

    List<String> res = new ArrayList<>();
    HashSet<String> list = new HashSet<>();

    public List<String> generatePalindromes(String s) {

        if(s == null || "".equals(s)){
            return new ArrayList<>();
        }

        dfs(0,s.toCharArray());

        for(String str : res){
            if(isPalindrome(str)){
                list.add(str);
            }
        }

        return new ArrayList<>(list);

    }

    private void dfs(int n, char[] chars) {

        if(n >= chars.length-1){
            res.add(new String(chars));
            return;
        }else {
            for(int i = n;i < chars.length;i++){
                swap(chars,i,n);
                dfs(n+1, chars);
                swap(chars,i,n);
            }
        }

    }

    private void swap(char[] chars, int i, int n) {
        char tmp = chars[i];
        chars[i] = chars[n];
        chars[n]= tmp;
    }

    public boolean isPalindrome(String s) {


        if(s == null || "".equals(s)){
            return true;
        }
        s = s.toLowerCase();

        StringBuilder stringBuilder = new StringBuilder();
        for (int i =0; i < s.length();i++){
            stringBuilder.append(s.charAt(i));
        }

        String tmp = stringBuilder.toString();

        String reverse = stringBuilder.reverse().toString();

        return tmp.equals(reverse);


    }

}
