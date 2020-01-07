package com.example.leetcode1;


import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author yingru.ljw
 * @date 2020-01-04 21:32
 */
public class 串联所有单词的子串 {


    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0){
            return res;
        }
        HashMap<String, Integer> map = new HashMap<>();
        int one_word = words[0].length();
        int word_num = words.length;
        int all_len = one_word * word_num;
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        for (int i = 0; i < s.length() - all_len + 1; i++) {
            String tmp = s.substring(i, i + all_len);
            HashMap<String, Integer> tmp_map = new HashMap<>();
            for (int j = 0; j < all_len; j += one_word) {
                String w = tmp.substring(j, j + one_word);
                tmp_map.put(w, tmp_map.getOrDefault(w, 0) + 1);
            }
            if (map.equals(tmp_map)) {
                res.add(i);
            }
        }
        return res;
    }


    public static void main(String[] args) {
        String abc = "barfoothefoobarman";
        String[] strings = new String[]{"foo","bar"};
        List<Integer> res = new 串联所有单词的子串().findSubstring(abc,strings);
        System.out.println(res);

        Map<String,String> map = new HashMap<>();
        String c = map.getOrDefault("a","b");
        System.out.println(map);



    }
    CountDownLatch countDownLatch;


    HashSet<Integer> set = new HashSet<>();

    List<String> list = new ArrayList<>();

    Map<String,List<Integer>> hashMap = new ConcurrentHashMap<>();

    public List<Integer> findSubstring2(String str, String[] words) {

        List<Integer> integers = new ArrayList<>();

        if(words == null  || words.length == 0){
            return integers;
        }

        if(str == null || "".equals(str)){
            return integers;
        }

        //首先全排列
        this.quanPaiLie(words);
        int len = words[0].length() * words.length;
        this.spiltStr(str,len);


        for (String ss : list){
            if(hashMap.containsKey(ss)){
                set.addAll(hashMap.get(ss));
            }
        }
        integers.addAll(set);
        return integers;
    }

    private void spiltStr(String str,int len) {


        char[] chars = str.toCharArray();
        int spi = 1;
        if(chars.length/4 != 0){
            spi = chars.length/4;
        }
        countDownLatch = new CountDownLatch(spi);

        for(int j =0;j < chars.length;j++){
            if(j % spi == 0){
                int finalJ = j;
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = finalJ; i <= str.length()-len; i++){
                            String key = str.substring(i,len+i);
                            if(hashMap.containsKey(key)){
                                List<Integer> list = hashMap.get(key);
                                if(list == null){
                                    list = new ArrayList<>();
                                    list.add(i);
                                }else {
                                    list.add(i);
                                }
                            }else {
                                List<Integer> list = new ArrayList<>();
                                list.add(i);
                                hashMap.put(key,list);
                            }
                        }
                        countDownLatch.countDown();
                    }

                }).start();
            }
        }
        try {
            countDownLatch.await(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    private void quanPaiLie(String[] words) {
        doQuanPaiLie(0,words);
    }

    private void doQuanPaiLie(int n, String[] words) {
        if(n >= words.length){
            String key = "";
            for(String s : words){
                key+=s;
            }
            if(!list.contains(key)){
                list.add(key);
            }
        }else {
            for (int i = n; i< words.length;i++){
                swap(words,i,n);
                doQuanPaiLie(n+1,words);
                swap(words,i,n);
            }
        }
    }


    private void swap(String[] words, int i, int n) {
        String tmp = words[i];
        words[i] = words[n];
        words[n] = tmp;
    }


}
