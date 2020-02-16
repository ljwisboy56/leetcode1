package com.example.leetcode1;


import java.util.ArrayList;

/**
 * @author yingru.ljw
 * @date 2019-12-30 17:08
 */
public class 无重复字符的最长子串 {

    int max = 1;

    public int lengthOfLongestSubstring(String s) {
        if( s == null){
            return 0;
        }

        char[] chars = s.toCharArray();

//        doFind(0,chars);

        return max;

    }

    public static void main(String[] args) {

        int res = new 无重复字符的最长子串().lengthOfLongestSubstring2("abcbbccc");
        System.out.println(res);



    }

    public int lengthOfLongestSubstring2(String s){
        if(s == null){
            return 0;
        }

        char[] chars = s.toCharArray();

        ArrayList<Character> list = new ArrayList<>();

        for(int i = 0;i < chars.length;i++){
            list.clear();
            list.add(chars[i]);
            for (int j = i+1;j < chars.length;j++){
                if(list.contains(chars[j])){
                    break;
                }else {
                    list.add(chars[j]);
                }
            }
            max = Math.max(list.size(),max);

        }

        return max;

    }


}
