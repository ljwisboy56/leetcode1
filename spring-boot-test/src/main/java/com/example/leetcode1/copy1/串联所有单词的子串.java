package com.example.leetcode1.copy1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author yingru.ljw
 * @date 2020-02-02 19:23
 */
public class 串联所有单词的子串 {


    public static void main(String[] args) {
        List<Integer> res = new 串联所有单词的子串().findSubstring("wordgoodgoodgoodbestword",new String[]{"word","good","best","good"});

        System.out.println(res);

    }

    HashSet<String> hashSet = new HashSet<>();

    List<Integer> res = new ArrayList<>();

    public List<Integer> findSubstring(String s, String[] words) {

        if(s == null){
            return res;
        }

        if(words == null || words.length ==0){
            return res;
        }

        this.initHashSet(0,words);

        int len = words[0].length() * words.length;

        for (int i=0;i<= s.length()-len;i++){
            String tmp = s.substring(i,i+len);
            if(hashSet.contains(tmp)){
                res.add(i);
            }
        }

        return res;

    }

    private void initHashSet(int n,String[] words) {

        if(n >= words.length){
            StringBuilder stringBuilder = new StringBuilder();
            for (String str : words){
                stringBuilder.append(str);
            }
            hashSet.add(stringBuilder.toString());
        }else {
            for (int i =n;i < words.length;i++){
                swap(words,i,n);
                initHashSet(n+1,words);
                swap(words,i,n);
            }
        }
    }


    private static void swap(String[] arr,int i,int j){
        String tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
