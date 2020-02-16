package com.example.leetcode2;

/**
 * @author yingru.ljw
 * @date 2020-02-16 19:08
 */
public class 翻转字符串里的单词 {

    public static void main(String[] args) {
        String res = new 翻转字符串里的单词().reverseWords("  hello world!  ");
        System.out.println(res);

    }

    public String reverseWords(String s) {
        if(s == null || "".equals(s)){
            return "";
        }

        //先把字符串拆分
        String[] strs = s.trim().split(" ");

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = strs.length-1; i >=0; i--) {

            if(i == 0){
                stringBuilder.append(strs[i]);
            }else {
                stringBuilder.append(strs[i]).append(" ");
            }
        }

        return stringBuilder.toString();
    }

    private String reverseStr(String str){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = str.length()-1;i >=0;i--){
            stringBuilder.append(str.charAt(i));
        }
        return stringBuilder.toString();
    }

}
