package com.example.leetcode2.copy1;

/**
 * @author yingru.ljw
 * @date 2020-02-22 15:55
 */
public class 翻转字符串里的单词 {

    public static void main(String[] args) {
        String s = "a good   example";
        String res = new 翻转字符串里的单词().reverseWords(s);
        System.out.println(res);


    }


    public String reverseWords(String s) {

        if(s == null || "".equals(s)){
            return "";
        }

        String[] strings = s.trim().split(" ");

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = strings.length-1; i >=0 ; i--) {
            if(strings[i].equals("")){
                continue;
            }
            if(i == 0){
                stringBuilder.append(strings[i]);
            }else {
                stringBuilder.append(strings[i]).append(" ");
            }

        }

        return stringBuilder.toString();

    }

}
