package com.example.leetcode1;

/**
 * @author yingru.ljw
 * @date 2020-01-07 18:17
 */
public class 最后一个单词的长度 {

    public static void main(String[] args) {
        int a = new 最后一个单词的长度().lengthOfLastWord("hello1 ");
        System.out.println(a);


    }

    public int lengthOfLastWord(String s) {



        if(s == null){
            return 0;
        }

        s = s.trim();

        int max = 0;
        int count = 0;
        for(int i = 0; i < s.length();i++){
            count++;
            max = count;
            if(s.charAt(i) == ' '){
                count = 0;
            }
        }
        return count;
    }

}
