package com.example.jzof2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.function.Consumer;

/**
 * @author yingru.ljw
 * @date 2019-12-28 23:34
 */
public class 字符串的全排列 {

    HashSet<String> set = new HashSet<>();

    public static void main(String[] args) {

        String abc = "aab";
        new 字符串的全排列().Permutation(abc);

        list.forEach(System.out::println);
    }

    static ArrayList<String> list = new ArrayList<>();

    static ArrayList<Character> characters = new ArrayList<>();

    public ArrayList<String> Permutation(String str) {

        if(str == null){
            return list;
        }

        char[] chars = str.toCharArray();

        doPermutation(0,chars);

        return list;

    }

    private void doPermutation(int n, char[] chars) {

        if(n >= chars.length-1){
            System.out.println(new String(chars));
            return;
        }else {
            for(int i = n;i < chars.length;i++){
                swap(chars,i,n);
//                if(judege(chars)){
//                    continue;
//                }else {
//                }
                doPermutation(n+1, chars);
                swap(chars,i,n);
            }
        }

    }

    private boolean judege(char[] chars) {
        String key = new String(chars);
        if(set.contains(key)){
            return true;
        }else {
            set.add(key);
            return false;
        }

    }

    private boolean constraint(char[] chars,int n) {
      return chars.length <= n;
    }

    private void swap(char[] chars, int i, int n) {
        char tmp = chars[i];
        chars[i] = chars[n];
        chars[n]= tmp;
    }

}
