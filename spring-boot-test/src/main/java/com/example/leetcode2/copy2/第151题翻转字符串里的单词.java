package com.example.leetcode2.copy2;

/**
 * @author yingru.ljw
 * @date 2020-03-27 16:01
 */
public class 第151题翻转字符串里的单词 {

    public static void main(String[] args) {
        System.out.println(new 第151题翻转字符串里的单词().reverseWords("a good   example"));

    }


    /**
     * 示例 1：
     *
     * 输入: "the sky is blue"
     * 输出: "blue is sky the"
     *
     */
    public String reverseWords(String s) {
        if(s == null || "".equals(s)){
            return "";
        }

        String[] strings = s.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = strings.length-1;i >=0;i--){
            if("".equals(strings[i])){
                continue;
            }
            stringBuilder.append(strings[i]).append(" ");
        }
        return stringBuilder.toString().trim();
    }




}
